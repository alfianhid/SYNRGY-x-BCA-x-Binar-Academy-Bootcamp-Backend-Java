package com.bcaxbinar.app.service.calculation;

import org.decimal4j.util.DoubleRounder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CalculateMedian {
    public static List<Integer> readNumbers(String filepath) throws IOException {
        File f = new File(filepath);
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);

        String delimiter = ";";
        String regexPattern = "^Kelas\\D+$";
        String line = null;
        String[] arrayOfStr;
        ArrayList<Integer> listOfNumbers = new ArrayList<>();

        try {
            while ((line = br.readLine()) != null) {
                arrayOfStr = line.split(delimiter);

                for (String str : arrayOfStr) {
                    if (!str.matches(regexPattern)) {
                        listOfNumbers.add(Integer.parseInt(str));
                    }
                }
            }
        } finally {
            if (line == null) {
                br.close();
                fr.close();
            }
        }

        return listOfNumbers;
    }
    public static String calculate(List<Integer> numbers) {
        int centerIndex = numbers.size() / 2;
        double median;

        if (numbers.size()%2 == 0) { // centerIndex => even
            median = (numbers.get(centerIndex-1) + numbers.get(centerIndex)) / 2f;
        } else { // centerIndex => odd
            median = numbers.get(centerIndex);
        }

        return "\nMedian : " + DoubleRounder.round(median, 1);
    }

    private CalculateMedian() {}
}
