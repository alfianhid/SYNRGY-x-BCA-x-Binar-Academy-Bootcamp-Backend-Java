package com.bcaxbinar.app.polymorphism;

public class MainKaryawan {
    public static void main(String[] args) {
        Bos boss = new Bos();

        KaryawanTetap kt = new KaryawanTetap("Alfian", 800);
        boss.tampilSemuaKaryawan(kt);

        KaryawanMagang km = new KaryawanMagang("Hidayat",6);
        boss.tampilSemuaKaryawan(km);
    }
}
