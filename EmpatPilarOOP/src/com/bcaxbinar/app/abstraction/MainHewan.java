package com.bcaxbinar.app.abstraction;

public class MainHewan {
    public static void main(String[] args) {
        BadakJawa badak1 = new BadakJawa();

        badak1.setNama("Rhino");
        badak1.setWarna("Abu-Abu");

        System.out.println("Nama = " + badak1.getNama());
        System.out.println("Warna = " + badak1.getWarna());
        System.out.println("Jenis Hewan = " + badak1.jenisHewan());
        System.out.println("Sisa hewan = " + badak1.sisaPopulasiHewan());
        System.out.println("Dilestarikan di = " + badak1.dilestarikanDi());
    }
}
