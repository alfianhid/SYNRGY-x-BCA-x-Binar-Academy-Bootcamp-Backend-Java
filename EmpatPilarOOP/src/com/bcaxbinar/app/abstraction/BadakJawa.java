package com.bcaxbinar.app.abstraction;

public class BadakJawa extends Hewan implements InfoHewan {
    private String warna;

    public String getWarna() {
        return warna;
    }

    public void setWarna(String warna) {
        this.warna = warna;
    }

    public BadakJawa() {
    }

    @Override
    public String jenisHewan() {
        return "Herbivora";
    }

    @Override
    public int sisaPopulasiHewan() {
        return 50;
    }

    @Override
    public String dilestarikanDi() {
        return "Taman Nasional Ujung Kulon";
    }
}
