package com.bcaxbinar.app.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ErrorPage implements Menu {
    private static final String LINE = "---------------------------------------";
    private static final InputStreamReader isr = new InputStreamReader(System.in);
    private static final BufferedReader br = new BufferedReader(isr);

    @Override
    public void showBody() {
        System.out.println(LINE);
        System.out.println("ERROR 404 NOT FOUND. File tidak ditemukan!");
        System.out.println("1. Kembali ke menu utama");
        System.out.println("0. Exit");
        System.out.println(LINE);

        try {
            System.out.print("Masukkan nomor menu : ");
            String menuNumber = br.readLine();

            if (menuNumber.isEmpty()) {
                System.out.println("Maaf, Anda belum memasukkan nomor menu. Coba lagi, ya!");
                showBody();
            } else {
                switch (menuNumber) {
                    case "1":
                        MainMenu mm = new MainMenu();
                        mm.main();
                        break;
                    case "0":
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Maaf, masukan nomor menu yang sesuai. Coba lagi, ya!");
                        showBody();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void showHeader() { /* this method is empty because unused */ }
    @Override
    public void backToMain() { /* this method is empty because unused */ }
    @Override
    public void checkFile(String filepath) { /* this method is empty because unused */ }
    public ErrorPage() { /* this constructor is empty because unused */ }
}
