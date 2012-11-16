package edu.sstu.ivcht.term2012.service;

public class WelcomeServiceBaseImpl implements WelcomeService{
    public String getWelcomeMessage() {
        //call Dao level if need
        return "Добро пожаловать на страницу приветствия учебного проекта. Эта страница предназначена только для проверки работоспособности";
    }
}
