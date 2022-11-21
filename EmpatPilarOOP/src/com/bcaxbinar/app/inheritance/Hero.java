package com.bcaxbinar.app.inheritance;

public class Hero {
    public String name;
    public int health;

    public void getDamage() {
        this.health -= 100;
    }

    public void showInfo() {
        System.out.println("name : " + this.name);
        System.out.println("health : " + this.health);
    }
}
