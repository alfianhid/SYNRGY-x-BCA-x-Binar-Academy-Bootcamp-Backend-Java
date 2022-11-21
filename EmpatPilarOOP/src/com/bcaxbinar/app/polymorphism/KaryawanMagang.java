package com.bcaxbinar.app.polymorphism;

public class KaryawanMagang extends Karyawan {
    private int durasiMagang;

    public KaryawanMagang(String nama,int durasiMagang) {
        this.nama = nama;
        this.durasiMagang = durasiMagang;
    }

    public int getDurasiMagang() {
        return durasiMagang;
    }

    public void setDurasiMagang(int durasiMagang) {
        this.durasiMagang = durasiMagang;
    }

    @Override
    public String getDataKaryawan(){
        String info = super.getDataKaryawan()+"\n";
        info += "Menjadi Karyawan magang selama " + durasiMagang + " bulan";
        return info;
    }
}
