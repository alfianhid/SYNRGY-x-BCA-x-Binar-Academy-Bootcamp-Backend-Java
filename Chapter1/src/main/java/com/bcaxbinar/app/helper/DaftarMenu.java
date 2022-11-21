package com.bcaxbinar.app.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DaftarMenu {

  private static final String LINE = "---------------------------------------";

  public static void main() {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);
    String menuNumber;

    System.out.println(LINE);
    System.out.println(" Kalkulator Penghitung Luas dan Volume ");
    System.out.println(LINE);
    System.out.println("Daftar Nomor Menu");
    System.out.println("1. Hitung Luas Bidang");
    System.out.println("2. Hitung Volume");
    System.out.println("0. Tutup Aplikasi");
    System.out.println(LINE);

    try {
      System.out.print("Masukkan nomor menu : ");
      menuNumber = br.readLine();

      if (menuNumber.isEmpty()) {
        System.out.println("Maaf, Anda belum memasukkan nomor menu. Coba lagi, ya!");
        main();
      } else {
        switch (menuNumber) {
          case "1":
            BangunDatar.main();
            break;
          case "2":
            BangunRuang.main();
            break;
          case "0":
            System.exit(0);
          default:
            System.out.println("Maaf, masukan nomor menu yang sesuai. Coba lagi, ya!");
            main();
        }
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public static void menuKembali() throws IOException {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);

    System.out.println(LINE);
    System.out.print("Tekan Enter untuk kembali ke menu utama");
    br.readLine();
    main();
  }

  private DaftarMenu() {
    // constructor
  }
}
