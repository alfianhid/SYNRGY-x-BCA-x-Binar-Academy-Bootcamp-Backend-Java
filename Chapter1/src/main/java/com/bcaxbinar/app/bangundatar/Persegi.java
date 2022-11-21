package com.bcaxbinar.app.bangundatar;

import com.bcaxbinar.app.helper.DaftarMenu;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Persegi {

  private static final String LINE = "---------------------------------------";
  private static final String OBYEK = "Persegi";

  public static void main() throws InterruptedException, IOException {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);
    String sisi;

    System.out.println(LINE);
    System.out.println("Anda memilih " + OBYEK);
    System.out.println(LINE);
    System.out.print("Masukkan sisi : ");
    sisi = br.readLine();

    System.out.println("Processing...");
    Thread.sleep(1000);

    checkValueAndCalculate(sisi);

    DaftarMenu.menuKembali();
  }

  private static void calculateLuas(String sisi) {
    double luas = Double.parseDouble(sisi) * Double.parseDouble(sisi);
    System.out.println("Luas dari " + OBYEK + " adalah " + luas);
  }

  private static void checkValueAndCalculate(String sisi)
    throws IOException, InterruptedException {
    if (sisi.isEmpty()) {
      System.out.println("Maaf, Anda belum memasukkan sisi. Coba lagi, ya!");
      Persegi.main();
    } else if (Double.parseDouble(sisi) == 0 || Double.parseDouble(sisi) < 0) {
      System.out.println("Sisi seharusnya tidak sama dengan atau kurang dari 0 (nol)!");
      Persegi.main();
    } else {
      calculateLuas(sisi);
    }
  }

  private Persegi() {
    // constructor
  }
}
