package com.bcaxbinar.app.view;

import com.bcaxbinar.app.service.filehandling.HandleCsvFile;
import com.bcaxbinar.app.service.filehandling.HandleTxtFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainMenu implements Menu {
    private static final String LINE = "---------------------------------------";
    private static final String CSV_FILE_PATH = "data/data_sekolah.csv";
    private static final InputStreamReader isr = new InputStreamReader(System.in);
    private static final BufferedReader br = new BufferedReader(isr);
    HandleCsvFile hcf = new HandleCsvFile();
    ErrorPage ep = new ErrorPage();
    public void main() {
        showHeader();
        checkFile(CSV_FILE_PATH);
        showBody();
    }

    @Override
    public void showHeader() {
        try {
            System.out.println(LINE);
            System.out.println(" APLIKASI PENGOLAH DATA NILAI SISWA ");
            System.out.println(LINE);
            System.out.println("Petunjuk penggunaan aplikasi:");
            System.out.println("Letakkan file CSV dengan nama data_sekolah.csv dalam folder /data.");
            System.out.println("Jika data tidak ada, maka nanti akan tampil pesan error di aplikasi.");
            System.out.println(LINE);
            System.out.println("Processing.....");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void checkFile(String filepath) {
        File csvfile = new File(filepath);

        if (csvfile.exists()){
            showBody();
        } else {
            ep.showBody();
        }
    }

    @Override
    public void showBody() {
        System.out.println(LINE);
        System.out.println("Silakan pilih menu:");
        System.out.println("1. Generate file TXT untuk mengelompokkan data");
        System.out.println("2. Generate file TXT untuk menampilkan mean, median, modus");
        System.out.println("3. Generate keduanya");
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
                    case "2":
                    case "3":
                        System.out.println(LINE);
                        hcf.readFile(CSV_FILE_PATH);
                        HandleTxtFile htf = new HandleTxtFile();
                        htf.generateFile(CSV_FILE_PATH, menuNumber);
                        backToMain();
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
    public void backToMain() {
        try {
            System.out.println(LINE);
            System.out.print("Tekan Enter untuk kembali ke menu utama");
            br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        showBody();
    }

    public MainMenu() throws IOException { /* this constructor is empty because unused */ }
}
