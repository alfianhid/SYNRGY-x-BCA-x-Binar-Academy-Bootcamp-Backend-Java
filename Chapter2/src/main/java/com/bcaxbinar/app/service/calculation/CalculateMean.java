package com.bcaxbinar.app.service.calculation;

import org.decimal4j.util.DoubleRounder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CalculateMean {
    public static List<Double> readNumbers(String filepath) throws IOException {
        File f = new File(filepath);
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);

        String delimiter = ";";
        String regexPattern = "^Kelas\\D+$";
        String line;
        String[] arrayOfStr;
        ArrayList<Double> listOfNumbers = new ArrayList<>();

        try {
            while ((line = br.readLine()) != null) {
                arrayOfStr = line.split(delimiter);

                for (String str : arrayOfStr) {
                    if (!str.matches(regexPattern)) {
                        listOfNumbers.add(Double.parseDouble(str));
                    }
                }
            }
        } finally {
            br.close();
        }

        return listOfNumbers;
    }

    public static String calculate(List<Double> nums) {
        double sum = 0;
        for (Double num : nums) {
            sum += num;
        }

        return "Berikut Hasil Pengolahan Nilai :\n" +
                "\n" +
                "Berikut hasil sebaran data nilai \n" +
                "Mean : " + DoubleRounder.round(sum/nums.size(), 2);
    }

    private CalculateMean() {}
}