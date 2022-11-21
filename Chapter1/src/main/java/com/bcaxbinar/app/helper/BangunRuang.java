package com.bcaxbinar.app.helper;

import com.bcaxbinar.app.bangunruang.Balok;
import com.bcaxbinar.app.bangunruang.Kubus;
import com.bcaxbinar.app.bangunruang.Tabung;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BangunRuang {

  private static final String LINE = "---------------------------------------";

  public static void main() {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);
    String menuNumber;

    try {
      System.out.println(LINE);
      System.out.println(" Pilih bangun ruang yang akan dihitung ");
      System.out.println(LINE);
      System.out.println("1. Kubus");
      System.out.println("2. Balok");
      System.out.println("3. Tabung");
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
            Kubus.main();
            break;
          case "2":
            Balok.main();
            break;
          case "3":
            Tabung.main();
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

  private BangunRuang() {
    // constructor
  }
}
