package com.bcaxbinar.app.abstraction;

public abstract class Hewan {
    private String nama;

    abstract String jenisHewan();

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}
