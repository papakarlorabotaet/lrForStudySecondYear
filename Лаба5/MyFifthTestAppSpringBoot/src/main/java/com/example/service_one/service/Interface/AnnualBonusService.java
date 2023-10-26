package com.example.service_one.service.Interface;

import com.example.service_one.Enum.Positions;
import org.springframework.stereotype.Service;

@Service
public interface AnnualBonusService {
    double calculate(Positions positions, double salary, double bonus,int workDays);
}
