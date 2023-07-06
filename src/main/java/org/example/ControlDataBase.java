package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class ControlDataBase {
    public static void emptyStringException(String dataPeople) {
        if (dataPeople.isEmpty()) {
            System.out.println("Пустые строки вводить нельзя!");
        }
    }
    public static void countInputException(String dataPeople) throws Exception {

        ArrayList<String> currentPeople = new ArrayList<>(Arrays.asList(dataPeople.split(" ")));
        while (currentPeople.contains("")) {
            currentPeople.remove("");
        }

        if (currentPeople.size() > 6) {
            System.out.println("Ошибка: избыток данных");
        } else if (currentPeople.size() < 6) {
            System.out.println("Ошибка: данных недостаточно");
        }
    }

    public static void emptyInputData(String item, String description) {
        if (item.isEmpty()) {
            System.out.println("в данных отсутствует: " + description);
            throw new Exception("в данных отсутствует: " + description);
        }
    }
    public static void fullInputFIO(String[] item, int count) {
        if (count < item.length) {
            throw new Exception("неполные данные ФИО: " + String.join(" ", item[0], item[1], item[2]));
        }
    }

}