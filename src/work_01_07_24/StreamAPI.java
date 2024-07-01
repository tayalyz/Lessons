package work_01_07_24;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class StreamAPI {


    public static void main(String[] args) {


        /*
            Stream API
            1) коллекции, массивы, файлы
            2) два вида операция: Промежуточные и конечные
                - Промежуточные:
                    filter, map, flatmap, skip, limit, sorted, distinct
                - Конечные:
                    forEach, collect, reduce, count, findFirst, findAny, allMatch, anyMatch, noneMatch
            3) промежуточные операции не выполняются пока не вызвана конечная

        * */
    }

    /*
     * 1) Дан список строк, отфильтруйте те,
     *  которые имеют длину больше 3 символов, и преобразуйте их в верхний регистр.
     *
     * 2) Дан список целых чисел, найдите среднее значение чисел, которые больше 10.
     * 3) Дан список строк, найдите самую длинную строку. Если таких несколько, выберите первую.
     * */
    public static void ex() {

        task1();
    }

    private static void task1() {
        //        List<String> list = List.of("a", "b"); //не мутабельный
//        List<String> list = Arrays.asList("a", "b"); // мутабельный
        List<String> list = Arrays.asList("aaaa", "b", "ccccc", "dddddd", "eee", "ff", "g", "hhhhhhhhhhhhhhhh");
        List<String> result = list.stream()
                .filter(v -> v.length() > 3)
                .map(e -> e.toUpperCase())
                .collect(Collectors.toList());

        System.out.println(result);
    }


    public static void task2(List<Integer> list) {
        OptionalDouble od = list.stream()
                .filter(v -> v > 10)
                .mapToInt(v -> v)
                .average();

        // Тернарный оператор: условия ? первый результат : второй результат
        System.out.println(od.isPresent() ? od.getAsDouble() : "Нет результата");
    }

    public static void task3(List<String> list) {
        //  Arrays.asList("aaaa", "b", "ccccc", "dddddd", "eee", "ff", "g", "hhhhhhhhhhhhhhhh");
        String result = list.stream()
                .reduce((s1, s2) -> s1.length() >= s2.length() ? s1 : s2)
                .orElse("Массив пуст");
        System.out.println(result);
    }
}
