package com.epam.mjc.io;

import java.io.File;
import java.io.FileInputStream;


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

        String name = "";
        Integer age = 0;
        String email = "";
        Long phone = 0L;

        try {

            name = arrOfText[0].substring(6);
            age = Integer.parseInt(arrOfText[1].substring(5));
            email = arrOfText[2].substring(7);
            phone =  Long.valueOf(Integer.parseInt(arrOfText[3].substring(7)));

        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
        }

        return new Profile(name, age, email, phone);
        
    }
}
