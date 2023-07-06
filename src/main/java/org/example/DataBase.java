package org.example;

import java.util.Scanner;

import static org.example.CreateString.createString;
import static org.example.WriteDataBase.writeLineFile;
import static org.example.ControlDataBase.*;

public class DataBase {

    public static void main(String[] args) {

        String path = "C:\\Users\\Eater\\Desktop\\lp\\java\\"; // database

        System.out.println("введите данные через пробел): \n "
                + " \"Фамилия Имя Отчество, дату рождения (dd.mm.yyyy), номер телефона(цифры), пол(f/m)\"");
        Scanner scanner = new Scanner(System.in);
        recordPersonalData(scanner.nextLine(), path);

    }
    public static void recordPersonalData(String data, String path) {
        checkInputData(data);
        String currentData = createString(data);
        writeLineFile(currentData, path);
    }

    public static void checkInputData(String dataPeople) {
        emptyStringException(dataPeople) ;
        countInputException(dataPeople);
    }

}
