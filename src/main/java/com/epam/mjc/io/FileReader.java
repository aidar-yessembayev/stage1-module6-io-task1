package com.epam.mjc.io;

import java.io.File;
import java.io.FileInputStream;


public class FileReader {

    public Profile getDataFromFile(File file) {
        
        // 1. Reading file data into string
        StringBuilder textFromFile = new StringBuilder();

        try (FileInputStream in = new FileInputStream(file.getPath())) {

            int ch;
            while ((ch = in.read()) != -1) {
                textFromFile.append((char) ch);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // 2. Parse this string for key-value pairs
        String[] arrOfText = textFromFile.toString().split("\n", 4);

        String name = "";
        Integer age = 0;
        String email = "";
        Long phone = 0L;

        try {

            name = arrOfText[0].substring(6);
            age = Integer.parseInt(arrOfText[1].substring(5));
            email = arrOfText[2].substring(7);
            phone =  Long.parseLong(arrOfText[3].substring(7, arrOfText[3].length() - 1));

        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
        }

        return new Profile(name, age, email, phone);
        
    }
}
