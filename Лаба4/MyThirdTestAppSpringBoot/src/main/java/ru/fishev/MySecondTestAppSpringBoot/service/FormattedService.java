package ru.fishev.MySecondTestAppSpringBoot.service;

import ru.fishev.MySecondTestAppSpringBoot.model.Request;
import ru.fishev.MySecondTestAppSpringBoot.model.Response;

import java.text.ParseException;

public interface FormattedService {
    void modifyTime(Request request, Response response) throws ParseException;
}
