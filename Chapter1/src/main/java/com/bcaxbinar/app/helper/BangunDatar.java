package com.bcaxbinar.app.helper;

import com.bcaxbinar.app.bangundatar.Lingkaran;
import com.bcaxbinar.app.bangundatar.Persegi;
import com.bcaxbinar.app.bangundatar.PersegiPanjang;
import com.bcaxbinar.app.bangundatar.Segitiga;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BangunDatar {

  private static final String LINE = "---------------------------------------";

  public static void main() {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);
    String menuNumber;

    try {
      System.out.println(LINE);
      System.out.println(" Pilih bangun datar yang akan dihitung ");
      System.out.println(LINE);
      System.out.println("1. Persegi");
      System.out.println("2. Lingkaran");
      System.out.println("3. Segitiga");
      System.out.println("4. Persegi Panjang");
      System.out.println("0. Kembali ke menu sebelumnya");
      System.out.println(LINE);
      System.out.print("Masukkan nomor menu : ");
      menuNumber = br.readLine();

      if (menuNumber.isEmpty()) {
        System.out.println("Maaf, Anda belum memasukkan nomor menu. Coba lagi, ya!");
        main();
      } else {
        switch (menuNumber) {
          case "1":
            Persegi.main();
            break;
          case "2":
            Lingkaran.main();
            break;
          case "3":
            Segitiga.main();
            break;
          case "4":
            PersegiPanjang.main();
            break;
          case "0":
            DaftarMenu.main();
            break;
          default:
            System.out.println("Maaf, masukan nomor menu yang sesuai. Coba lagi, ya!");
            main();
        }
      }
    } catch (IOException | InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

  private BangunDatar() {
    // constructor
  }
}
