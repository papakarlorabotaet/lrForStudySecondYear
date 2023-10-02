package ru.fishev.MySecondTestAppSpringBoot.service;

import org.springframework.stereotype.Service;
import ru.fishev.MySecondTestAppSpringBoot.exception.UnsupportedCodeException;
import ru.fishev.MySecondTestAppSpringBoot.model.Request;

@Service
public interface UnsupportedService {
    void isSupported(Request request) throws UnsupportedCodeException;
}
