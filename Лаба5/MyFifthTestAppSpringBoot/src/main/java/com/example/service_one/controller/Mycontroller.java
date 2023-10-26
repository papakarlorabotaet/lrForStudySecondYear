package com.example.service_one.controller;

import com.example.service_one.Enum.Codes;
import com.example.service_one.Enum.ErrorCodes;
import com.example.service_one.Enum.ErrorMessages;
import com.example.service_one.model.Request;
import com.example.service_one.model.Response;
import com.example.service_one.service.Interface.*;
import com.example.service_one.util.DateTimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Date;
@Slf4j
@RestController
public class Mycontroller {

    private final ResponseException responseException;

    @Autowired
    public Mycontroller( ResponseException responseException) {
        this.responseException = responseException;
    }

    @PostMapping(value = "/feedback")
    public void feedback(@Valid @RequestBody Request request, BindingResult bindingResult) {
        log.info("request:{}",request);
        responseException.ResponseExceptions(request,bindingResult);

    }
}
