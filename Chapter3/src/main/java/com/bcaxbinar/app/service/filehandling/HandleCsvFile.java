package com.bcaxbinar.app.service.filehandling;

import java.io.File;

public class HandleCsvFile implements FileHandler {
    File file;
    @Override
    public void readFile(String filepath) {
        try{
            file = new File(filepath);

            System.out.println("Reading and processing the file.....");
            Thread.sleep(4000);

            if (file.canRead()) {
                System.out.println("File has been read and processed successfully!");
            } else {
                System.out.println("Error when reading and processing the file!");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void generateFile(String filepath, String number) { /* this method is empty because unused */ }
}