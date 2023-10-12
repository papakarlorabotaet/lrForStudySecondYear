package ru.fishev.MySecondTestAppSpringBoot.service;


import org.springframework.stereotype.Service;
import ru.fishev.MySecondTestAppSpringBoot.model.Request;

@Service

public interface ModifyRequestService {
    void modify(Request request);
}
