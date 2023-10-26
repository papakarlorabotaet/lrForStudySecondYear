package com.example.service_one.service.Interface;

import com.example.service_one.model.Request;
import com.example.service_one.model.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
@Service
public interface ResponseException {
    ResponseEntity<Response> ResponseExceptions(Request request, BindingResult bindingResult);
}
