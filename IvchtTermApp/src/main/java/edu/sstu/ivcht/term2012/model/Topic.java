package edu.sstu.ivcht.term2012.model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Класс описывающий сущность "Тема форума"
 */
public class Topic {

    //                      Поля

    /**
     * Уникальный идентификатор
     */
    private int id;
    /**
     * Название темы
     */
    private String subject;
    /**
     * Описание темы
     */
    private String description;
    /**
     * Дата создания
     */
    private Date createDate;

    private static SimpleDateFormat simpleDateFormatDateFormat = new SimpleDateFormat("dd.MM.yyyy");

    //                      Конструкторы

    /**
     * Пустой конструктор
     */
    public Topic() {
    }

    /**
     * Конструктор с полями без уник. идентификатора
     * @param subject Название темы
     * @param description Описание темы
     * @param createDate Дата создания темы
     */
    public Topic(String subject, String description, Date createDate) {
        this.subject = subject;
        this.description = description;
        this.createDate = createDate;
    }

    /**
     * Конструктор с полями без уник. идентификатора
     * @param id Уникальный идентификатор
     * @param subject Название темы
     * @param description Описание темы
     * @param createDate Дата создания темы
     */
    public Topic(int id, String subject, String description, Date createDate) {
        this.id = id;
        this.subject = subject;
        this.description = description;
        this.createDate = createDate;
    }


    //                      Геттеры и Сеттеры

    /**
     * Получение значения уникального идентификатора
     * @return Уникальный идентификатор
     */
    public int getId() {
        return id;
    }

    /**
     * Задание название темы
     * @param subject Название темы
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * Получение названия темы
     * @return Название темы
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Задание описания темы
     * @param description Описание темы
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Получение описания темы
     * @return Описание темы
     */
    public String getDescription() {
        return description;
    }

    /**
     * Задание даты создания темы
     * @param createDate Дата создания темы
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * Получение даты создания темы
     * @return Дата создания темы
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * Получение даты создания темы в классическом формате
     * @return Дата создания темы
     */
    public String getFormattedDate() {
        return simpleDateFormatDateFormat.format(createDate);
    }
}
