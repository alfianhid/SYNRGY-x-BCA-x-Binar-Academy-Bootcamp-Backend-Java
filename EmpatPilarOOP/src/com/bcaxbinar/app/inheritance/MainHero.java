package com.bcaxbinar.app.inheritance;

public class MainHero {
    public static void main(String[] args)
    {
        Support support1 = new Support();

        support1.name = "iSupportYou";
        support1.health = 100;

        // mage terkena damage
        support1.getDamage();

        // mage melakukan healing
        support1.healing();

        // menampilkan informasi mage
        support1.showInfo();
    }
}
