package bnc.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by astotal on 17.06.17.
 */
public class ConsoleHelper {

    public static final String INTRO_MESSAGE = "Приветствую в игре Быки и Коровы.\n" +
            "Пусть игра и известна, но лишний раз напомнить правила стоит.\n" +
            "Мною загадано четырёхзначное число и ваша задача за меньшее число попыток угадать, какое число я загадал.\n" +
            "Чтобы облегчить задачу, в игре есть для вас подсказки:\n" +
            "1. Быки - это количество цифр, значение и положение которых совпадает с загаданным мною числом.\n" +
            "2. Коровы - количество цифр, которые присутствуют в загаданном числе, но не совпадают по месту расположения.\n" +
            "Надеюсь вам понравится!\n" +
            "Итак начнём. Я загадал число, попробуй угадать какое ;Р";

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static void writeMessage(String message, Object... args) {
        System.out.printf(message.concat("\n"), args);
    }

    public static String readString() {
        while (true) {
            try {
                return reader.readLine();
            } catch (IOException ignored) {
                writeMessage("Произошла ошибка при вводе текста. Попробуйте еще раз.");
            }
        }
    }

    public static String readValidInt() {
        while (true) {
            try {
                String s = readString();
                if (s.equalsIgnoreCase("exit")) {
                    System.exit(0);
                }

                int value = Integer.parseInt(s);
                if (value < 1000 || value > 10000) {
                    writeMessage("Ну я же просил четырёхзначное же =(");
                    continue;
                }
                return s;
            } catch (NumberFormatException ignored) {
                writeMessage("Произошла ошибка при вводе числа. Попробуйте еще раз.");
            }
        }
    }

}
