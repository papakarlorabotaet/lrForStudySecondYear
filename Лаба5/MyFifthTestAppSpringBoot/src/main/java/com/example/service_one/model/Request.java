package com.example.service_one.model;

import com.example.service_one.Enum.Positions;
import com.example.service_one.Enum.Systems;
import com.example.service_one.util.DateTimeUtil;
import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Request {
    /***
     *Уникальный идентификатор сообщение
     */
    @NotBlank(message = "Uid  не может быть пустым ")
    @Size(max = 3, message = "uid должен быть < 32 символов")
    private String uid;
    /***
     *Уникальный идентификатор операции
     */
    @NotBlank(message = "operationUid не может быть пустым")
    @Size(max = 32, message = "operationUid должен быть < 32 символов")
    private String operationUid;
    /***
     *Имя системы отправителя
     */
    private Systems systemName;
    /***
     *Время создания сообщения
     */
    private String systemTime;
    /***
     *Наименование ресурса
     */
    private String source;
    /***
     *Позиция человека в штате
     */
    private Positions position;
    /***
     * заработная плата человека
     */
    private double salary;
    /***
     * бонусная надбавка
     */
    private double bonus;
    /***
     * фактически отрабонных дней
     */
    private int workDays;
    /***
     *Уникальный идентификатор коммуникации
     */
    @Min(value = 1, message = "communicationId не может быть меньше 1")
    @Max(value = 100000, message = "communicationId не может быть больше 100000")
    private int communicationId;
    /***
     *Уникальный идентификатор шаблона
     */
    private int templateId;
    /***
     *Код продукта
     */
    private int productCode;
    /***
     *Смс код
     */
    private int smsCode;


    public void setSystemTime(String systemTime) {
        if (systemTime.isEmpty()){
            this.systemTime = DateTimeUtil.getCustomFormatFormat().format(new Date());
        }else {
            this.systemTime=systemTime;
        }
    }

}
