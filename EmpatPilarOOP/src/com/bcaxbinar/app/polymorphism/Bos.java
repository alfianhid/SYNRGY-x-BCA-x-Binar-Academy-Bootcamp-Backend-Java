package com.bcaxbinar.app.polymorphism;

public class Bos {
    public void tampilSemuaKaryawan(Karyawan k){

        System.out.println(k.getDataKaryawan());

        if(k instanceof KaryawanTetap){
            System.out.println("Perlu digaji nih!");
        } else{
            System.out.println("Tidak mendapat gaji :(");
        }
    }
}
