package com.cornez.lab2ex1;

public class CookieMonster {

    private boolean isHungry;

    public CookieMonster(){
        isHungry = true;
    }
    public void getFull(){
        isHungry = false;
    }
    public void getHungry(){
        isHungry = true;
    }
    public boolean getStatus(){
        return isHungry;
    }
}
