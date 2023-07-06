package org.example;
import java.io.IOException;

public class Exception extends RuntimeException {

    public Exception(String message) {
        super("Ошибка данных: " + message);
    }

}