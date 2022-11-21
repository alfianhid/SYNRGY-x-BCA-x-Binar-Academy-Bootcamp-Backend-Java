package com.bcaxbinar.app.inheritance;

public class Support extends Hero {
    public void healing() {
        // mengakses attribute health yang diwariskan dari class Hero
        this.health += 20;
    }
}
