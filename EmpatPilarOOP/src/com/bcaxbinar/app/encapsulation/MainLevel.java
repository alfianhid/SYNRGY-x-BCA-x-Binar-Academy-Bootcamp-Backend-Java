package com.bcaxbinar.app.encapsulation;

public class MainLevel {
    public static void main(String args[]){
        // Inisialisasi dari class Hero
        Hero hero = new Hero();

        // Menampilkan level hero berdasarkan access modifier
        hero.displayDefault();
        hero.displayPublic();
        //hero.displayPrivate();
        hero.displayProtected();
    }
}
