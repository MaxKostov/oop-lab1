package oop.lab1.task2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileReader {

    public static String readFileIntoString(String path) throws FileNotFoundException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new java.io.FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append(" ");
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
