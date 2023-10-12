package ru.fishev.MySecondTestAppSpringBoot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.fishev.MySecondTestAppSpringBoot.exception.UnsupportedCodeException;
import ru.fishev.MySecondTestAppSpringBoot.exception.ValidationFailedException;
import ru.fishev.MySecondTestAppSpringBoot.model.*;
import ru.fishev.MySecondTestAppSpringBoot.service.*;

import javax.validation.Valid;

import ru.fishev.MySecondTestAppSpringBoot.util.DateTimeUtil;

import java.text.ParseException;
import java.util.Date;

@RestController
@Slf4j
public class MyController {

    private final ValidationService validationService;
    private final UnsupportedService unsupportedService;

    private final ModifySystemTimeResponseService modifySystemTimeResponseService;

    private final FormattedService formattedService;

    @Autowired
    public MyController(ValidationService validationService,
                        UnsupportedService unsupportedService,
                        @Qualifier("ModifySystemTimeResponseService") ModifySystemTimeResponseService modifySystemTimeResponseService,
                        FormattedService formattedService) {

        this.validationService = validationService;
        this.unsupportedService = unsupportedService;
        this.modifySystemTimeResponseService = modifySystemTimeResponseService;
        this.formattedService = formattedService;
    }

    @PostMapping(value = "/feedback")
    public ResponseEntity<Response> feedback(@Valid @RequestBody Request request, BindingResult bindingResult) throws ParseException {

        log.info("request: {}", request);

        Response response = Response.builder()
                .uid(request.getUid())
                .operationUid(request.getOperationUid())
                .systemTime(DateTimeUtil.getCustomFormat().format(new Date()))
                .code(Codes.SUCCESS)
                .errorCode(ErrorCodes.EMPTY)
                .errorMessage(ErrorMessages.EMPTY)
                .build();

        try {
            validationService.isValid(bindingResult);
            unsupportedService.isSupported(request);
        } catch (ValidationFailedException e) {
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.VALIDATION_EXCEPTION);
            response.setErrorMessage(ErrorMessages.VALIDATION);
            log.error(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } catch (UnsupportedCodeException e) {
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.UNSUPPORTED_EXCEPTION);
            response.setErrorMessage(ErrorMessages.UNSUPPORTED);
            log.error(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.IM_USED);
        } catch (Exception e) {
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.UNKNOWN_EXCEPTION);
            response.setErrorMessage(ErrorMessages.UNKNOWN);
            log.error(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        log.info("Response: {}", response);


        formattedService.modifyTime(request, response);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
