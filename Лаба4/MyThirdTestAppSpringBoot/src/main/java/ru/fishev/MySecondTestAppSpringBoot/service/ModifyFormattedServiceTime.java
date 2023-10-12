package ru.fishev.MySecondTestAppSpringBoot.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.fishev.MySecondTestAppSpringBoot.model.Request;
import ru.fishev.MySecondTestAppSpringBoot.model.Response;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@Slf4j

public class ModifyFormattedServiceTime implements FormattedService {
    @Override
    public void modifyTime(Request request, Response response) throws ParseException {
        String sysTimeRequest = request.getSystemTime();
        String sysTimeResponse = response.getSystemTime();

        SimpleDateFormat format = new SimpleDateFormat("mmmm");

        Date dateRequest = format.parse(sysTimeRequest);
        Date dateResponse = format.parse(sysTimeResponse);

        long diffBetweenRequestAndResult = dateResponse.getTime() - dateRequest.getTime();
        log.info("Diff between request and result: " + diffBetweenRequestAndResult);


    }
}
