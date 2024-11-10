package com.webuyanycar.test;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

public class Utilities {

    public static String readFile(String filePath)  {
        File file = new File(filePath);
        String data = null;
        try {
            data = FileUtils.readFileToString(file, "UTF-8");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return data;
    }

    public static ArrayList<String> readFileLineByLine(String filePath) {
        ArrayList<String> fileData = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(filePath));
            while (scanner.hasNextLine()) {
                fileData.add(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return fileData;

    }

    public  static Properties readProperties(String filePath){
        FileReader reader= null;
        try {
            reader = new FileReader(filePath);
            Properties p=new Properties();
            p.load(reader);
            return  p;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
