package com.bcaxbinar.app.bangundatar;

import com.bcaxbinar.app.helper.DaftarMenu;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lingkaran {

  private static final String LINE = "---------------------------------------";
  private static final double PI = 3.14;
  private static final String OBYEK = "Lingkaran";

  public static void main() throws InterruptedException, IOException {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);
    String radius;

    System.out.println(LINE);
    System.out.println("Anda memilih " + OBYEK);
    System.out.println(LINE);
    System.out.print("Masukkan jari-jari : ");
    radius = br.readLine();

    System.out.println("Processing...");
    Thread.sleep(1000);

    checkValueAndCalculate(radius);

    DaftarMenu.menuKembali();
  }

  private static void calculateLuas(String radius) {
    double luas = PI * Double.parseDouble(radius) * Double.parseDouble(radius);
    System.out.println("Luas dari " + OBYEK + " adalah " + luas);
  }

  private static void checkValueAndCalculate(String radius)
    throws IOException, InterruptedException {
    if (radius.isEmpty()) {
      System.out.println("Maaf, Anda belum memasukkan jari-jari. Coba lagi, ya!");
      Lingkaran.main();
    } else if (Double.parseDouble(radius) == 0 || Double.parseDouble(radius) < 0) {
      System.out.println(
        "Jari-jari seharusnya tidak sama dengan atau kurang dari 0 (nol)!"
      );
      Lingkaran.main();
    } else {
      calculateLuas(radius);
    }
  }

  private Lingkaran() {
    // constructor
  }
}
