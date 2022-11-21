package com.bcaxbinar.app.service.calculation;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class CalculateFreq {
    public static List<Integer> readNumbers(String filepath) throws IOException {
        File f = new File(filepath);
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);

        String delimiter = ";";
        String regexPattern = "^Kelas\\D+$";
        String line;
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
            br.close();
        }

        return listOfNumbers;
    }

    public static SortedMap<Integer, Integer> frequency (List<Integer> numbers) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int count;

        for (int number : numbers) {
            if (map.containsKey(number)) {
                count = map.get(number) + 1;
            } else {
                count = 1;
            }
            map.put(number, count);
        }

        return map;
    }

    public static String calculateFreq(List<Integer> numbers) {
        SortedMap<Integer, Integer> map = frequency(numbers);
        StringBuilder result = new StringBuilder("Berikut Hasil Pengolahan Nilai :\n" +
                "\n" +
                "Nilai | Frekuensi\n");

        Set<Integer> setOfFreq = map.keySet();
        for (Integer number : setOfFreq) {
            result.append(number).append(" | ").append(map.get(number)).append("\n");
        }

        return result.toString();
    }

    private CalculateFreq() { /* this constructor is empty because unused */ }
}
