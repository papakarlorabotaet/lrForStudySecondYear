package ru.fishev.MySecondTestAppSpringBoot.service;

import org.springframework.stereotype.Service;
import ru.fishev.MySecondTestAppSpringBoot.model.Request;
import ru.fishev.MySecondTestAppSpringBoot.model.Response;

import java.text.ParseException;

@Service
public interface FormattedService {
    void modifyTime(Request request, Response response) throws ParseException;
}
