package work_26_06_2024;

import java.util.Optional;

public class MyOptional {

    /*
        Создание Optional
           - Optional.empty() - пустой
           - Optional.of() - с не пустым значением
           - Optional.ofNullable() - с возможным null значением

        Основные методы:
            - isPresent() проверяет содержится ли значение в Optional (true\false)
            - ifPresent() выполняет действие, если значение есть
            - orElse() Возвращает значение, если оно присутствует, иначе значение по умолчанию
            - orElseGet() Возвращает значение, если оно присутствует, иначе вызывает предоставленный Supplier и возвращает его результат
            - orElseThrow() Возвращает значение, если оно присутствует, иначе выбрасывает исключение

            - map() применяет функцию к значению, если оно присутствует и возвращает Optional с результатом
            - flatMap() похож на map() но используется, когда функция возвращает Optional

            - filter() возвращает тот же Optional, если значение соответствует условию, иначе пустой Optional
    * */
    public static void main(String[] args) {
        //isPresent() ifPresent()
        Optional<String> opt = Optional.of("Hello");
        Optional<String> optEmpty = Optional.empty();
        if (opt.isPresent()) {
            System.out.println("Пишем значение " + opt.get());
        }

        opt.ifPresent(value -> System.out.println("Пишем значение " + value));

        // orElse()  orElseGet()
        String value = opt.orElse("Любое значение, если в 'opt' ничего нет");
        String valueEmpty = optEmpty.orElse("Любое значение, если в 'opt' ничего нет");

        String valueSupplier = opt.orElseGet(() -> {
            String a = "Любое значение ";
            String b = ", если в 'opt' ничего нет";
            return a + b;
        });

        // orElseThrow()
        String valueEx = opt.orElseThrow(() -> new RuntimeException("ошибка"));

        // map() flatMap()
        Optional<Integer> length = opt.map(val -> val.length());
        Optional<Integer> lengthFlatMap = opt.flatMap(strValue -> Optional.of(strValue.length()));

        // filter()
        Optional<String> filtered = opt.filter(strValue -> strValue.startsWith("H"));
    }


}
