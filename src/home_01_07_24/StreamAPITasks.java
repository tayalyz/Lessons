package home_01_07_24;

import java.util.*;
import java.util.stream.Collectors;

public class StreamAPITasks {
    public static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    public static class Product {
        private String name;
        private int price;

        public Product(String name, int price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public int getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return "Product{" +
                    "name='" + name + '\'' +
                    ", price=" + price +
                    '}';
        }
    }

    public static void main(String[] args) {
        Person person1 = new Person("Ivan", 8);
        Person person2 = new Person("Ivan", 18);
        Person person3 = new Person("Ivan", 19);
        Person person4 = new Person("Ivan", 500);
        Person person5 = new Person("Ivan", 18);

        Product product1 = new Product("iphone 15", 100);
        Product product2 = new Product("iphone 15 pro", 200);
        Product product3 = new Product("iphone 15 pro max", 300);

        List<String> list = Arrays.asList("ASD", "ASD1", "123", "234", "2D", "ASD");
        List<Integer> integerList = Arrays.asList(1, 2, 3, 3, 5, 4, 4);
        List<String> stringList = List.of("aaaa", "bbbbA", "bbbbA", "Accccc", "A", "jgyj", ",A");
        List<Person> personList = Arrays.asList(person1, person2, person3, person4, person5);
        List<Product> productList = Arrays.asList(product1, product2, product3);

        task1(list);
        task2(integerList);
        task3(personList);
        task4(stringList);
        task5(integerList);
        task6(stringList);
        task7(integerList);
        task8(stringList);
        task9(stringList);
        task10(productList);
    }

    // Задача 1: Дан список строк, отфильтруйте те, которые содержат хотя бы одну цифру, и преобразуйте их в нижний регистр.
    public static void task1(List<String> list) {
        List<String> res = list.stream()
                .filter(a-> a.matches(".*\\d+.*"))
                .map(String::toLowerCase)
                .collect(Collectors.toList());

        System.out.println(res);
    }

    //Задача 2: Дан список целых чисел, найдите все уникальные числа и отсортируйте их в порядке убывания.
    public static void task2(List<Integer> list) {
        List<Integer> res = list.stream()
                .distinct()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());

        System.out.println(res);
    }

    //Задача 3: Дан список объектов Person (с полями name и age), отфильтруйте тех, чей возраст больше 18 лет, и отсортируйте их по имени.
    public static void task3(List<Person> list) {
        List<Person> res = list.stream()
                .filter(p -> p.getAge() > 18)
                .sorted(Comparator.comparing(Person::getName))
                .collect(Collectors.toList());

        System.out.println(res);
    }

    //Задача 4: Дан список строк, найдите все строки, начинающиеся с буквы "A" и преобразуйте их в строку, объединенную через запятую.
    public static void task4(List<String> list) {
        String res = list.stream()
                .filter(s -> s.startsWith("A"))
                .collect(Collectors.joining(", "));

        System.out.println(res);
    }

    //Задача 5: Дан список целых чисел, найдите произведение всех чисел, которые являются четными.
    public static void task5(List<Integer> list) {
        int res = list.stream()
                .mapToInt(Integer::intValue)
                .filter(i -> i % 2 == 0)
                .reduce(1, (s1, s2) -> s1 * s2);

        System.out.println(res);
    }

    //Задача 6: Дан список строк, найдите длину самой длинной строки.
    public static void task6(List<String> list) {
        int res = list.stream()
                .max(Comparator.comparing(String::length))
                .orElse("Список пуст")
                .length();

        System.out.println(res);
    }

    //Задача 7: Дан список целых чисел, отфильтруйте те, которые больше среднего значения всех чисел в списке.
    public static void task7(List<Integer> list) {
        OptionalDouble opt = list.stream()
                .mapToInt(Integer::intValue)
                .average();

        List<Integer> integerList = list.stream()
                .filter(integer -> integer > (opt.isPresent() ? opt.getAsDouble() : 0d))
                .collect(Collectors.toList());

        System.out.println(integerList);
    }

    //Задача 8: Дан список строк, создайте мапу, где ключами будут первые буквы строк, а значениями - списки строк, начинающихся с этих букв.
    public static void task8(List<String> list) {
        Map<Character, List<String>> groupedStrings = list.stream()
                .collect(Collectors.groupingBy(i-> i.charAt(0), Collectors.toList()));

        System.out.println(groupedStrings);
        System.out.println("Группировка строк по первой букве:");
        groupedStrings.forEach((key, value) -> System.out.println(key + ": " + value));
    }

    //Задача 9: Дан список строк, подсчитайте, сколько раз каждая строка встречается в списке.
    public static void task9(List<String> list) {
        Map<String, Long> map = list.stream()
                .collect(Collectors.groupingBy(String::toString, Collectors.counting()));

        System.out.println(map);
    }

    //Задача 10: Дан список объектов Product (с полями name и price), найдите самый дорогой продукт.
    public static void task10(List<Product> list) {
        Product product1 = list.stream()
                .max(Comparator.comparing(Product::getPrice))
                .orElse(null); // v2

        System.out.println(product1);
    }
}
