package com.example.service_one.service;

import com.example.service_one.exception.UnsupertCodeException;
import com.example.service_one.model.Request;
import com.example.service_one.service.Interface.UnsupportedCodeService;
import org.springframework.stereotype.Service;

import java.util.Objects;
@Service
public class RequestUnsatedException implements UnsupportedCodeService {

    @Override
    public void isCode(Request request) throws UnsupertCodeException {
        if (Objects.equals(request.getUid(),"123")){
            throw new UnsupertCodeException("значение UID не должно быть = 123");
        }
    }
}
