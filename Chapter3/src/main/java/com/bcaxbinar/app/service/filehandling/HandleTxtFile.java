package com.bcaxbinar.app.service.filehandling;

import com.bcaxbinar.app.service.calculation.CalculateFreq;
import com.bcaxbinar.app.service.calculation.CalculateMean;
import com.bcaxbinar.app.service.calculation.CalculateMedian;
import com.bcaxbinar.app.service.calculation.CalculateMode;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class HandleTxtFile implements FileHandler {
    String path = "data/output.txt";
    File file = new File(path);
    FileWriter fw = new FileWriter(file);
    BufferedWriter bw = new BufferedWriter(fw);
    List<Integer> returnedNumbers;
    List<Double> returnedValues;
    private final String OUTPUT = "Successfully writing to the specified folder! Check your file in ";
    private String result;
    private String meanResult;
    private String medianResult;
    private String modeResult;

    @Override
    public void generateFile(String filepath, String number) throws IOException {
        try {
            switch (number) {
                case "1":
                    optionNumber1(filepath);
                    break;
                case "2":
                    optionNumber2(filepath);
                    break;
                case "3":
                    optionNumber3(filepath);
                    break;
                default:
                    System.out.println("Maaf, masukan nomor menu yang sesuai. Coba lagi, ya!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void optionNumber1(String filepath) throws IOException {
        returnedNumbers = CalculateFreq.readNumbers(filepath);
        result = CalculateFreq.calculateFreq(returnedNumbers);

        bw.write(result);
        bw.flush();

        if (bw == null) {
            bw.close();
            fw.close();
        }

        System.out.println(OUTPUT + path);
    }

    public void optionNumber2(String filepath) throws IOException {
        returnedValues = CalculateMean.readNumbers(filepath);
        meanResult = CalculateMean.calculate(returnedValues);

        returnedNumbers = CalculateMedian.readNumbers(filepath);
        medianResult = CalculateMedian.calculate(returnedNumbers);

        returnedNumbers = CalculateMode.readNumbers(filepath);
        modeResult = CalculateMode.calculate(returnedNumbers);

        bw.write(meanResult);
        bw.write(medianResult);
        bw.write(modeResult);
        bw.flush();

        if (bw == null) {
            bw.close();
            fw.close();
        }

        System.out.println(OUTPUT + path);
    }

    public void optionNumber3(String filepath) throws IOException {
        returnedNumbers = CalculateFreq.readNumbers(filepath);
        result = CalculateFreq.calculateFreq(returnedNumbers);

        returnedValues = CalculateMean.readNumbers(filepath);
        meanResult = CalculateMean.calculate(returnedValues);

        returnedNumbers = CalculateMedian.readNumbers(filepath);
        medianResult = CalculateMedian.calculate(returnedNumbers);

        returnedNumbers = CalculateMode.readNumbers(filepath);
        modeResult = CalculateMode.calculate(returnedNumbers);

        bw.write(result);
        bw.newLine();
        bw.write(meanResult);
        bw.write(medianResult);
        bw.write(modeResult);
        bw.flush();

        if (bw == null) {
            bw.close();
            fw.close();
        }

        System.out.println(OUTPUT + path);
    }

    // constructor
    public HandleTxtFile() throws IOException { /* this constructor is empty because unused */ }

    @Override
    public void readFile(String filepath) { /* this method is empty because unused */ }

}
