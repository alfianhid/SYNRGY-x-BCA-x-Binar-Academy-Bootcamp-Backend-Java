package com.bcaxbinar.app.bangundatar;

import com.bcaxbinar.app.helper.DaftarMenu;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PersegiPanjang {

  private static final String LINE = "---------------------------------------";
  private static final String OBYEK = "Persegi Panjang";

  public static void main() throws InterruptedException, IOException {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);
    String panjang;
    String lebar;

    System.out.println(LINE);
    System.out.println("Anda memilih " + OBYEK);
    System.out.println(LINE);
    System.out.print("Masukkan panjang : ");
    panjang = br.readLine();
    System.out.print("Masukkan lebar : ");
    lebar = br.readLine();

    System.out.println("Processing...");
    Thread.sleep(1000);

    checkValueAndCalculate(panjang, lebar);

    DaftarMenu.menuKembali();
  }

  private static void calculateLuas(String panjang, String lebar) {
    double luas = Double.parseDouble(panjang) * Double.parseDouble(lebar);
    System.out.println("Luas dari " + OBYEK + " adalah " + luas);
  }

  private static void checkValueAndCalculate(String panjang, String lebar)
    throws IOException, InterruptedException {
    if (panjang.isEmpty()) {
      System.out.println("Maaf, Anda belum memasukkan panjang. Coba lagi, ya!");
      PersegiPanjang.main();
    } else if (lebar.isEmpty()) {
      System.out.println("Maaf, Anda belum memasukkan lebar. Coba lagi, ya!");
      PersegiPanjang.main();
    } else if (Double.parseDouble(panjang) == 0 || Double.parseDouble(panjang) < 0) {
      System.out.println(
        "Panjang seharusnya tidak sama dengan atau kurang dari 0 (nol)!"
      );
      PersegiPanjang.main();
    } else if (Double.parseDouble(lebar) == 0 || Double.parseDouble(lebar) < 0) {
      System.out.println("Lebar seharusnya tidak sama dengan atau kurang dari 0 (nol)!");
      PersegiPanjang.main();
    } else {
      calculateLuas(panjang, lebar);
    }
  }

  private PersegiPanjang() {
    // constructor
  }
}
