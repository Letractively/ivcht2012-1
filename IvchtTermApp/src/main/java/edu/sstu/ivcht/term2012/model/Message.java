package edu.sstu.ivcht.term2012.model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Класс, описывающий сужность "Сообщение в теме"
 */
public class Message {

    //Поля
    /**
     * Уникальный идентификатор
     */
    private int id;
    /**
     * Название темы
     */
    private int topicID;
    /**
     * Описание темы
     */
    private String contents;
    /**
     * Дата создания
     */
    private Date createDate;

    private static SimpleDateFormat simpleDateFormatDateFormat = new SimpleDateFormat("dd.MM.yyyy");

    //Конструктор
    public Message() {
    }
    /**
     * Конструктор с полями с уник. идентификатором
     * @param id Уникальный идентификатор
     * @param contents содержимое сообщения
     * @param createDate Дата создания сообщения
     * @param topicID Уникальный идентификатор темы
     */
    public Message(int id, String contents, Date createDate, int topicID) {
        this.id = id;
        this.contents = contents;
        this.createDate = createDate;
        this.topicID = topicID;
    }

    public Message(String contents, Date createDate, int topicID) {
        this.contents = contents;
        this.createDate = createDate;
        this.topicID = topicID;
    }

    //Геттеры и Сеттеры

    public int getId() {
        return id;
    }

    public int getTopicID() {
        return topicID;
    }


    /**
     * Задание описания темы
     * @param contents Описание темы
     */
    public void setContents(String contents) {
        this.contents = contents;
    }

    /**
     * Получение описания темы
     * @return Описание темы
     */
    public String getContents() {
        return contents;
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
