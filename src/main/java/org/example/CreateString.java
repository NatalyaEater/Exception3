package org.example;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;


import static org.example.ControlDataBase.emptyInputData;
import static org.example.ControlDataBase.fullInputFIO;

public class CreateString{
    public static String createString(String data) throws Exception {

        ArrayList<String> currentPeople = new ArrayList<>(Arrays.asList(data.split(" ")));
        while (currentPeople.contains("")) {
            currentPeople.remove("");
        }

        String[] fio = new String[3];
        int counter = 0;
        DateFormat pattern = new SimpleDateFormat("dd.MM.yyyy");
        String dataB = null;
        String numberPhone = null;
        String gender = null;

        for (String item : currentPeople) {
            if ((item.equals("f") || item.equals("m"))) {
                gender = item;
            } else if (item.matches("([+]*)\\d+")) {
                numberPhone = item;
            } else if (item.matches("[a-zA-Zа-яА-Я]+")
                    || (item.matches("([a-zA-Zа-яА-Я]+)(-)([a-zA-Zа-яА-Я]+)"))) {
                if (counter < 3) {
                    fio[counter] = item;
                    counter++;
                }
            } else {
                try {
                    pattern.parse(item);
                    LocalDate.parse(item, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
                    dataB = item;
                }
                catch (DateTimeParseException e) {
                    throw new Exception("некорректная дата: " + item);
                } catch (ParseException e) {
                    throw new Exception("неизвестный формат данных: " + item);
                }

            }
        }

        emptyInputData(data, "день рождения в формате (dd.mm.yyyy)"); //
        emptyInputData(numberPhone, "Телефон (число)");
        emptyInputData(gender, "пол (f/m)");
        fullInputFIO(fio, counter);

        return String.join(" ", fio[0], fio[1], fio[2], dataB, numberPhone, gender);
    }

}

