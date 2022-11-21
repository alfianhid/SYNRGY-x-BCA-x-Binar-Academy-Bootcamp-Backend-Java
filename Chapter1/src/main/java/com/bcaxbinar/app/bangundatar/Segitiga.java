package com.bcaxbinar.app.bangundatar;

import com.bcaxbinar.app.helper.DaftarMenu;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Segitiga {

  private static final String LINE = "---------------------------------------";
  private static final double HALF = 0.5;
  private static final String OBYEK = "Segitiga";

  public static void main() throws InterruptedException, IOException {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);
    String alas;
    String tinggi;

    System.out.println(LINE);
    System.out.println("Anda memilih " + OBYEK);
    System.out.println(LINE);
    System.out.print("Masukkan alas : ");
    alas = br.readLine();
    System.out.print("Masukkan tinggi : ");
    tinggi = br.readLine();

    System.out.println("Processing...");
    Thread.sleep(1000);

    checkValueAndCalculate(alas, tinggi);

    DaftarMenu.menuKembali();
  }

  private static void calculateLuas(String alas, String tinggi) {
    double luas = HALF * Double.parseDouble(alas) * Double.parseDouble(tinggi);
    System.out.println("Luas dari " + OBYEK + " adalah " + luas);
  }

  private static void checkValueAndCalculate(String alas, String tinggi)
    throws IOException, InterruptedException {
    if (alas.isEmpty()) {
      System.out.println("Maaf, Anda belum memasukkan alas. Coba lagi, ya!");
      Segitiga.main();
    } else if (tinggi.isEmpty()) {
      System.out.println("Maaf, Anda belum memasukkan tinggi. Coba lagi, ya!");
      Segitiga.main();
    } else if (Double.parseDouble(alas) == 0 || Double.parseDouble(alas) < 0) {
      System.out.println("Alas seharusnya tidak sama dengan atau kurang dari 0 (nol)!");
      Segitiga.main();
    } else if (Double.parseDouble(tinggi) == 0 || Double.parseDouble(tinggi) < 0) {
      System.out.println("Tinggi seharusnya tidak sama dengan atau kurang dari 0 (nol)!");
      Segitiga.main();
    } else {
      calculateLuas(alas, tinggi);
    }
  }

  private Segitiga() {
    // constructor
  }
}
