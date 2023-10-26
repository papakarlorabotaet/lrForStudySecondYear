package com.example.service_one.service.Interface;

import com.example.service_one.model.Response;
import org.springframework.stereotype.Service;

@Service
public interface ModifyResponseService {
    Response modify(Response response);
}
