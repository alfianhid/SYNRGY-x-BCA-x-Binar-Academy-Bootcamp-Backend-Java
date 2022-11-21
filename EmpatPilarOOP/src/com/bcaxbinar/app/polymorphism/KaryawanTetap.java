package com.bcaxbinar.app.polymorphism;

public class KaryawanTetap extends Karyawan implements Gaji {
    private int gaji;

    public KaryawanTetap(String nama,int gaji) {
        this.nama = nama;
        this.gaji = gaji;
    }

    public int getGaji() {
        return gaji;
    }

    public void setGaji(int gaji) {
        this.gaji = gaji;
    }

    @Override
    public int getTotalGaji() {
        return (int)(gaji + 0.05 * gaji);
    }

    @Override
    public String getDataKaryawan(){
        String info = super.getDataKaryawan()+"\n";
        info += "Menjadi Karyawan tetap dengan gaji " + gaji;
        return info;
    }
}
