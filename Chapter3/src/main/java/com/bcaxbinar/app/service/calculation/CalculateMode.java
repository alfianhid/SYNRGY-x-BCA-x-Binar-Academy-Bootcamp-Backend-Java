package com.bcaxbinar.app.service.calculation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class CalculateMode {
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
        TreeMap<Integer,Integer> map = new TreeMap<>();
        int maxValue = 0;
        int maxCount = 0;
        int count;

        for (int number : numbers) {
            if (map.containsKey(number)) {
                count = map.get(number) + 1;
            } else {
                count = 1;
            }
            map.put(number, count);

            if (count > maxCount) {
                maxValue = number;
                maxCount = count;
            }
        }

        return "\nModus : " + maxValue;
    }

    private CalculateMode() {}
}
