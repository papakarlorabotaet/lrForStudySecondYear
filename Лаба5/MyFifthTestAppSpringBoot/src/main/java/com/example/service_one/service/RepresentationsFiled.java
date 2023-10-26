package com.example.service_one.service;

import com.example.service_one.Enum.Codes;
import com.example.service_one.Enum.ErrorCodes;
import com.example.service_one.Enum.ErrorMessages;
import com.example.service_one.exception.UnsupertCodeException;
import com.example.service_one.exception.ValidationFailedException;
import com.example.service_one.model.Request;
import com.example.service_one.model.Response;
import com.example.service_one.service.Interface.*;
import com.example.service_one.util.DateTimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.Date;

@Service
@Slf4j
public class RepresentationsFiled implements ResponseException {
    private final ValidationService validationService;
    private final UnsupportedCodeService unsupportedCodeService;
    private final ModifyRequestService modifyRequestService;
    private final ModifyResponseService modifyResponseService;
    private final AnnualBonusService annualBonusService;

    @Autowired
    public RepresentationsFiled(ValidationService validationService,
                        UnsupportedCodeService unsupportedCodeService,
                        @Qualifier("ModifySystemTimeResponseService") ModifyResponseService modifyResponseService,
                        @Qualifier("SystemName") ModifyRequestService modifyRequestService,
                        AnnualBonusService annualBonusService) {
        this.validationService = validationService;
        this.unsupportedCodeService = unsupportedCodeService;
        this.modifyRequestService = modifyRequestService;
        this.modifyResponseService = modifyResponseService;
        this.annualBonusService = annualBonusService;
    }

    @Override
    public ResponseEntity<Response> ResponseExceptions(Request request, BindingResult bindingResult) {

        Response response = Response.builder()
                .uid(request.getUid())
                .operationUid(request.getOperationUid())
                .systemTime(DateTimeUtil.getCustomFormatFormat().format(new Date()))
                .code(Codes.SUCCESS)
                .annualBonus(annualBonusService.calculate(request.getPosition(), request.getSalary(), request.getBonus(), request.getWorkDays()))
                .errorCode(ErrorCodes.EMPTY)
                .errorMassage(ErrorMessages.EMPTY)
                .build();

        try{
            validationService.isValid(bindingResult);
            unsupportedCodeService.isCode(request);
        }catch (ValidationFailedException e) {
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.VALIDATION_EXCEPTION);
            response.setErrorMassage(ErrorMessages.VALIDATION);
            log.error(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }catch (UnsupertCodeException e){
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.UNSUPPORTED_EXCEPTION);
            response.setErrorMassage(ErrorMessages.UNSUPPORTED);
            log.error(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.I_AM_A_TEAPOT);
        }
        catch (Exception e){
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.UNKNOWN_EXCEPTION);
            response.setErrorMassage(ErrorMessages.UNKNOWN);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        log.info("response:{}", response);

        modifyRequestService.modify(request);

        modifyResponseService.modify(response);

        return new ResponseEntity<>(modifyResponseService.modify(response), HttpStatus.OK);

    }
}
