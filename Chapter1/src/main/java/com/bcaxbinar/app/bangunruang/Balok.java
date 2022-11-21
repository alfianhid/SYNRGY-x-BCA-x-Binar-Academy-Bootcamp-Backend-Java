package com.bcaxbinar.app.bangunruang;

import com.bcaxbinar.app.helper.DaftarMenu;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Balok {

  private static final String LINE = "---------------------------------------";
  private static final String OBYEK = "Balok";

  public static void main() throws InterruptedException, IOException {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);
    String panjang;
    String lebar;
    String tinggi;

    System.out.println(LINE);
    System.out.println("Anda memilih " + OBYEK);
    System.out.println(LINE);
    System.out.print("Masukkan panjang : ");
    panjang = br.readLine();
    System.out.print("Masukkan lebar : ");
    lebar = br.readLine();
    System.out.print("Masukkan tinggi : ");
    tinggi = br.readLine();

    System.out.println("Processing...");
    Thread.sleep(1000);

    checkValueAndCalculate(panjang, lebar, tinggi);

    DaftarMenu.menuKembali();
  }

  private static void calculateVolume(String panjang, String lebar, String tinggi) {
    double volume =
      Double.parseDouble(panjang) *
      Double.parseDouble(lebar) *
      Double.parseDouble(tinggi);
    System.out.println("Volume dari " + OBYEK + " adalah " + volume);
  }

  private static void checkValueAndCalculate(String panjang, String lebar, String tinggi)
    throws IOException, InterruptedException {
    if (panjang.isEmpty()) {
      System.out.println("Maaf, Anda belum memasukkan panjang. Coba lagi, ya!");
      Balok.main();
    } else if (lebar.isEmpty()) {
      System.out.println("Maaf, Anda belum memasukkan lebar. Coba lagi, ya!");
      Balok.main();
    } else if (tinggi.isEmpty()) {
      System.out.println("Maaf, Anda belum memasukkan tinggi. Coba lagi, ya!");
      Balok.main();
    } else if (Double.parseDouble(panjang) == 0 || Double.parseDouble(panjang) < 0) {
      System.out.println(
        "Panjang seharusnya tidak sama dengan atau kurang dari 0 (nol)!"
      );
      Balok.main();
    } else if (Double.parseDouble(lebar) == 0 || Double.parseDouble(lebar) < 0) {
      System.out.println("Lebar seharusnya tidak sama dengan atau kurang dari 0 (nol)!");
      Balok.main();
    } else if (Double.parseDouble(tinggi) == 0 || Double.parseDouble(tinggi) < 0) {
      System.out.println("Tinggi seharusnya tidak sama dengan atau kurang dari 0 (nol)!");
      Balok.main();
    } else {
      calculateVolume(panjang, lebar, tinggi);
    }
  }

  private Balok() {
    // constructor
  }
}
