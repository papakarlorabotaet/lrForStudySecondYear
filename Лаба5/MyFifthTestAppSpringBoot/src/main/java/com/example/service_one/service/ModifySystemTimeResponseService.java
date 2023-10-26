package com.example.service_one.service;

import com.example.service_one.model.Response;
import com.example.service_one.service.Interface.ModifyResponseService;
import com.example.service_one.util.DateTimeUtil;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Qualifier("ModifySystemTimeResponseService")
public class ModifySystemTimeResponseService implements ModifyResponseService {
    @Override
    public Response modify(Response response) {
        response.setSystemTime(DateTimeUtil.getCustomFormatFormat().format(new Date()));
        return response;
    }
}
