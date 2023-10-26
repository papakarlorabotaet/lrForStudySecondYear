package ru.fishev.MySecondTestAppSpringBoot.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.fishev.MySecondTestAppSpringBoot.model.Request;
import ru.fishev.MySecondTestAppSpringBoot.model.Response;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@Service
public class ModifyFormattedServiceTime implements FormattedService{
    @Override
    public void modifyTime(Request request, Response response) throws ParseException {
        String systemTimeRequest = request.getSystemTime();
        String systemTimeResponse = response.getSystemTime();

        SimpleDateFormat format = new SimpleDateFormat("mm:ss.SSS");
        Date date1 = format.parse(systemTimeRequest);
        Date date2 = format.parse(systemTimeResponse);

        long time = date2.getTime() - date1.getTime();

        log.info("Different time from request to response" + time);
    }
}
