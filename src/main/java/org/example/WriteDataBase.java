package org.example;

import java.io.*;


public class WriteDataBase {

    public static void writeLineFile(String data, String patch) {
        String[] currentPeople = data.split(" ");
        String pathFile = patch + currentPeople[0];
        try (FileWriter writer = new FileWriter(pathFile, true)) {
            writer.write(data + "\n");

        } catch (IOException e) {
            System.out.println("ошибка записи данных: указанный путь не существует. " + e.getClass().getSimpleName());
            e.printStackTrace();
        }
    }
}
