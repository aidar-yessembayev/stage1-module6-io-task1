package com.epam.mjc.io;

import java.io.File;


public class FileReader {

    public Profile getDataFromFile(File file) {
        // 1. Reading file data into string
        String textFromFile = "";

        try (FileInputStream in = new FileInputStream(file.getPath())) {

            int ch;
            while ((ch = in.read()) != -1) {
                textFromFile += (char) ch;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // 2. Parse this string for key-value pairs
        String[] arrOfText = textFromFile.split("\n", 4);

        return new Profile(
                arrOfText[0].substring(6),
                Integer.parseInt(arrOfText[1].substring(5)),
                arrOfText[2].substring(7),
                Long.parseLong(arrOfText[3].substring(7))
        );
    }
}
