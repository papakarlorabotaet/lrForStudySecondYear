package ru.fishev.MySecondTestAppSpringBoot.service;

import org.springframework.stereotype.Service;
import ru.fishev.MySecondTestAppSpringBoot.model.Response;

@Service
public interface ModifyResponseService {
    Response modify(Response response);
}
