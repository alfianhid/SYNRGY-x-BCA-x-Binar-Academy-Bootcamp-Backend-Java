package com.bcaxbinar.app.bangunruang;

import com.bcaxbinar.app.helper.DaftarMenu;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tabung {

  private static final String LINE = "---------------------------------------";
  private static final double PI = 3.14;
  private static final String OBYEK = "Tabung";

  public static void main() throws InterruptedException, IOException {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);
    String radius;
    String tinggi;

    System.out.println(LINE);
    System.out.println("Anda memilih " + OBYEK);
    System.out.println(LINE);
    System.out.print("Masukkan jari-jari : ");
    radius = br.readLine();
    System.out.print("Masukkan tinggi : ");
    tinggi = br.readLine();

    System.out.println("Processing...");
    Thread.sleep(1000);

    checkValueAndCalculate(radius, tinggi);

    DaftarMenu.menuKembali();
  }

  private static void calculateVolume(String radius, String tinggi) {
    double luasAlas = PI * Double.parseDouble(radius) * Double.parseDouble(radius);
    System.out.println("Luas Alas dari " + OBYEK + " adalah " + luasAlas);
    System.out.println(LINE);
    double volume = luasAlas * Double.parseDouble(tinggi);
    System.out.println("Volume dari " + OBYEK + " adalah " + volume);
  }

  private static void checkValueAndCalculate(String radius, String tinggi)
    throws IOException, InterruptedException {
    if (radius.isEmpty()) {
      System.out.println("Maaf, Anda belum memasukkan radius. Coba lagi, ya!");
      Tabung.main();
    } else if (tinggi.isEmpty()) {
      System.out.println("Maaf, Anda belum memasukkan tinggi. Coba lagi, ya!");
      Tabung.main();
    } else if (Double.parseDouble(radius) == 0 || Double.parseDouble(radius) < 0) {
      System.out.println(
        "Panjang seharusnya tidak sama dengan atau kurang dari 0 (nol)!"
      );
      Tabung.main();
    } else if (Double.parseDouble(tinggi) == 0 || Double.parseDouble(tinggi) < 0) {
      System.out.println("Tinggi seharusnya tidak sama dengan atau kurang dari 0 (nol)!");
      Tabung.main();
    } else {
      calculateVolume(radius, tinggi);
    }
  }

  private Tabung() {
    // constructor
  }
}
