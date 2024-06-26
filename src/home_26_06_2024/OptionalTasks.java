package home_26_06_2024;

import java.util.Optional;

public class OptionalTasks {
    public static void main(String[] args) {
        String str = "abc";
        Optional<String> optionalString = Optional.of(str);
        System.out.println(task1("Hey"));
        System.out.println(task2(optionalString));
        System.out.println(task3(Optional.empty()));
        System.out.println(task4(optionalString));
        System.out.print("task 5: "); task5(optionalString);
        System.out.println(task6(Optional.empty()));
        System.out.println(task7(optionalString));
        System.out.println(task8(Optional.empty()));
    }

    // Напишите метод, который принимает строку и возвращает Optional<String>.
    // Если строка равна null, верните пустой Optional, в противном случае верните Optional с этой строкой.
    public static Optional<String> task1(String s) {
        return Optional.ofNullable(s);
    }

    // Напишите метод, который принимает Optional<String> и возвращает строку. Если значение присутствует,
    // верните его, в противном случае верните строку "default".
    public static String task2(Optional<String> opt) {
        return opt.orElse("default");
    }

    // Напишите метод, который принимает Optional<String> и возвращает Optional<Integer>,
    // представляющий длину строки. Если строка отсутствует, верните пустой Optional.
    public static Optional<Integer> task3(Optional<String> otpStr) {
        return otpStr.map(str -> str.length());
    }

    // Напишите метод, который принимает Optional<String> и возвращает тот же Optional,
    // но только если строка не пуста (не содержит пробелов). Если строка пуста или отсутствует,
    // верните пустой Optional.
    public static Optional<String> task4(Optional<String> optStr) {
        return optStr.filter(str-> !str.isEmpty());
    }

    // Напишите метод, который принимает Optional<String> и выводит строку на консоль, если значение присутствует.
    public static void task5(Optional<String> optStr) {
        optStr.ifPresent(str -> System.out.println(str));
    }

    // Напишите метод, который принимает Optional<String> и возвращает строку. Если значение присутствует,
    // верните его, в противном случае верните результат вызова метода, который возвращает строку "generated".
    public static String task6(Optional<String> optStr) {
        return optStr.orElse(generated());
    }

    public static String generated() {
        return "generated";
    }

    // Напишите метод, который принимает Optional<String> и возвращает Optional<Integer>,
    // представляющий длину строки. Если строка отсутствует, верните пустой Optional. Воспользуйтесь методом flatMap.
    public static Optional<Integer> task7(Optional<String> optStr) {
        return optStr.flatMap(str -> Optional.of(str.length()));
    }

    // Напишите метод, который принимает Optional<String> и возвращает строку.
    // Если значение отсутствует, выбросите IllegalArgumentException с сообщением "Value not present".
    public static String task8(Optional<String> optStr) {
        return optStr.orElseThrow(() -> new IllegalArgumentException("Value not present"));
    }
}

