package work_08_07_24;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Exception {
    // Создайте метод, который делит два числа. Если второе число равно нулю,
    // выбрасывайте исключение ArithmeticException и обрабатывайте его в методе main, выводя сообщение об ошибке.

    public static void main(String[] args) {
        try {
            System.out.println(task(1, 2));
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e);
        }

        try {
            task2(19);
        } catch (InvalidAgeException e) {
            e.printStackTrace();
        }

        try {
            task3("");
        } catch (NumberFormatException e) {
            System.out.println("Некорректный формат числа" + e);
            e.printStackTrace();
        } catch (NullPointerException e) {
            System.out.println("ошибка");
            e.printStackTrace();
        }
    }

    public static double task(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Деление на 0");
        }
        return (double) a / b;
    }

    // Создайте пользовательское исключение InvalidAgeException, которое выбрасывается,
    // если возраст пользователя меньше 18 лет. Создайте метод, который проверяет возраст и выбрасывает это исключение,
    // если возраст некорректный.
    public static void task2(int age) {
        if (age < 18) {
            throw new InvalidAgeException("возраст пользователя меньше 18 лет");
        }
    }

    // Напишите метод, который читает целое число из строки.
    // Обрабатывайте исключения NumberFormatException и NullPointerException.
    public static int task3(String s) {
        if (s == null) {
            throw new NullPointerException("строка не должна быть null");
        }
        return Integer.parseInt(s);
    }

    // Создайте метод, который читает целые числа из файла с использованием класса Scanner.
    // Обрабатывайте возможные исключения FileNotFoundException и InputMismatchException.
    // Используйте блок finally для закрытия Scanner, и внутри блока finally используйте вложенный try
    // для обработки возможных исключений при закрытии ресурса.
    public static void task4(String fileName) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(fileName));
            while (scanner.hasNext()) {
                try {
                    int number  = scanner.nextInt();
                    System.out.println("число:" + number);
                } catch (InputMismatchException e) {
                    System.out.println("Некорректный формат числа");
                    e.printStackTrace();
                }

            }
        } catch (FileNotFoundException e) {
            System.out.println("файл не найден");
            e.printStackTrace();
        } finally {
            try {
                scanner.close();
            } catch (java.lang.Exception e) {
                System.out.println("Ошибка при закрытии сканера");
                e.printStackTrace();
            }
        }
    }
}
