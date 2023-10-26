package com.example.service_one.model;

import com.example.service_one.Enum.Codes;
import com.example.service_one.Enum.ErrorCodes;
import com.example.service_one.Enum.ErrorMessages;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class Response {
    /***
     * Уникальный идентификатор сообщение
     */
    private String uid;
    /***
     * Уникальный идентификатор операции
     */
    private String operationUid;
    /***
     * Время создания сообщения
     */
    private String systemTime;
    /***
     * код выполнения
     */
    private Codes code;
    /***
     * годовая надбавка
     */
    private double annualBonus;
    /***
     * код ошибки
     */
    private ErrorCodes errorCode;
    /***
     * сообщение ошибки
     */
    private ErrorMessages errorMassage;
}
