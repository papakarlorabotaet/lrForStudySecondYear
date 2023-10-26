package com.example.service_one.service;

import com.example.service_one.Enum.Positions;
import com.example.service_one.service.Interface.AnnualBonusService;
import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.Calendar;
import java.util.Date;

@Service
public class AnnualBonusServiceImpl implements AnnualBonusService {
    @Override
    public double calculate(Positions positions, double salary, double bonus, int workDays) {
        Date date = new Date();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);


        return calculateSalary(positions,year,salary,bonus,workDays);
    }
    public static int calculateDaysInYear(int year, Positions positions) {
        Year currentYear = Year.of(year);
        int daysToYear,
                salary = 0;

        if (currentYear.isLeap()) {
            daysToYear =  366; // Високосный год: 366 дней
        } else {
            daysToYear =  365; // Невисокосный год: 365 дней
        }

        if (positions.isManager()){
            salary = daysToYear / 4;
        }else {
            salary = daysToYear;
        }
        return salary;

    }

    private static double calculateSalary(Positions positions, int year, double salary, double bonus, int workDays){
            return  (salary * bonus * calculateDaysInYear(year, positions) * positions.getPositionCoefficient() / workDays);
    }
}
