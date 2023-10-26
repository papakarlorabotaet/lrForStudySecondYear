package com.example.service_one.service.Interface;

import com.example.service_one.exception.UnsupertCodeException;
import com.example.service_one.model.Request;
import org.springframework.stereotype.Service;

@Service
public interface UnsupportedCodeService {
    void isCode(Request request) throws UnsupertCodeException;
}
