package ru.fishev.MySecondTestAppSpringBoot.service;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.fishev.MySecondTestAppSpringBoot.model.Request;
import ru.fishev.MySecondTestAppSpringBoot.model.System;

@Service
@Qualifier("SystemName")

public class ModifySystemNameRequestService implements ModifyRequestService {


    @Override

    public void modify(Request request) {
        request.setSystemName(System.SERVICE);

        HttpEntity<Request> httpEntity = new HttpEntity<>(request);

        new RestTemplate().exchange("http://localhost:8084/feedback",
                HttpMethod.POST,
                httpEntity,
                new ParameterizedTypeReference<>() {
                });

    }
}
