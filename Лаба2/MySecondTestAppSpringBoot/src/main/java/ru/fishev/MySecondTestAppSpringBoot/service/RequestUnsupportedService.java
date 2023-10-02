package ru.fishev.MySecondTestAppSpringBoot.service;

import org.springframework.stereotype.Service;
import ru.fishev.MySecondTestAppSpringBoot.exception.UnsupportedCodeException;
import ru.fishev.MySecondTestAppSpringBoot.model.Request;

import java.util.Objects;

@Service
public class RequestUnsupportedService implements UnsupportedService{

    @Override
    public void isSupported(Request request) throws UnsupportedCodeException {
        if(request.getUid().equals("123")){
            throw new UnsupportedCodeException();
        }
    }
}
