package courses.Java_PRO.task_2;

import courses.Java_PRO.task_2.enums.Employee;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionService {

    public void run() {

        task1(List.of(12, 8, 9, 12, 8, 9, 0, 81));

        task2(List.of(5, 2, 10, 9, 4, 3, 10, 1, 13));

        task3(List.of(5, 2, 10, 9, 4, 3, 10, 1, 13));

        List<Employee> employees = List.of(new Employee("Max", 25, JobTitle.MANAGER),
                new Employee("Alex", 29, JobTitle.MANAGER),
                new Employee("Pavel", 35, JobTitle.ENGINEER),
                new Employee("Ella", 27, JobTitle.ENGINEER),
                new Employee("Lisa", 51, JobTitle.SUPERVISOR),
                new Employee("Sasha", 32, JobTitle.ENGINEER),
                new Employee("Kirill", 22, JobTitle.ENGINEER),
                new Employee("Vladimir", 41, JobTitle.ENGINEER));

        task4(employees);

        task5(employees);

        task6(List.of("Hello", "world!", "This", "is", "Thelongestwordintheworld"));

        task7("set of words set of words set of words set of words i've gone crazy a a a a a a aa");

        task8(List.of("Bela", "Alex", "longword", "anevenlongerword"));

        String[] array = {
                "apple banana orange grape pear",
                "red blue green yellow purple",
                "dog cat bird fish rabbit",
                "first second third fourth fifth",
                "monday tuesday wednesday thursday friday"
        };

        task9(array);
    }


    private void task1 (List<Integer> list) {
        System.out.println("Реализуйте удаление из листа всех дубликатов." + "\nИсходные данные:" + list);
        // Какой вариант лучше/правильнее?
        System.out.println(new LinkedHashSet<>(list));
        System.out.println(list.stream().distinct().toList());
        System.out.println("\n/////////////////////////////////////////////////////////////////////////////////////////// \n");
    }

    private void task2 (List<Integer> list) {
        System.out.println("Найдите в списке целых чисел 3-е наибольшее число." + "\nИсходные данные:" + list);
        int thirdLargest = list.stream()
                .sorted(Comparator.reverseOrder())
                .skip(2)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("List is too small"));

        System.out.println("Вывод: " + thirdLargest);
        System.out.println("\n/////////////////////////////////////////////////////////////////////////////////////////// \n");
    }

    private void task3 (List<Integer> list) {
        System.out.println("Найдите в списке целых чисел 3-е наибольшее «уникальное» число." + "\nИсходные данные:" + list);
        int thirdLargestUnique = list.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(2)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("List is too small"));

        System.out.println("Вывод: " + thirdLargestUnique);
        System.out.println("\n/////////////////////////////////////////////////////////////////////////////////////////// \n");
    }

    private void task4 (List<Employee> employees) {
        System.out.println("Имеется список объектов типа Сотрудник (имя, возраст, должность), " +
                "необходимо получить список имен 3 самых старших сотрудников с должностью «Инженер», в порядке убывания возраста." + "\nИсходные данные:" + employees);
        System.out.println("Вывод: ");
        employees.stream()
                .filter(a -> a.getJobTitle().equals(JobTitle.ENGINEER))
                .sorted(Comparator.comparing(Employee::getAge).reversed())
                .map(Employee::getName)
                .limit(3)
                .toList().forEach(System.out::println);

        System.out.println("\n/////////////////////////////////////////////////////////////////////////////////////////// \n");
    }

    private void task5 (List<Employee> employees) {
        System.out.println("Имеется список объектов типа Сотрудник (имя, возраст, должность), " +
                "посчитайте средний возраст сотрудников с должностью «Инженер»." + "\nИсходные данные:" + employees);
        double averageAge = employees.stream()
                .filter(x -> x.getJobTitle().equals(JobTitle.ENGINEER))
                .mapToDouble(Employee::getAge)
                .average()
                .orElseThrow(NoSuchElementException::new);

        System.out.println("Вывод: " + averageAge);
        System.out.println("\n/////////////////////////////////////////////////////////////////////////////////////////// \n");
    }

    private void task6 (List<String> list) {
        System.out.println("Найдите в списке слов самое длинное." + "\nИсходные данные:" + list);
        String longestWord = list.stream()
                .max(Comparator.comparingInt(String::length))
                .orElse("");

        System.out.println("Вывод: " + longestWord);

        System.out.println("\n/////////////////////////////////////////////////////////////////////////////////////////// \n");
    }

    private void task7 (String words) {
        System.out.println("Имеется строка с набором слов в нижнем регистре, разделенных пробелом. Постройте хеш-мапу, " +
                "в которой будут хранится пары: слово - сколько раз оно встречается во входной строке" + "\nИсходные данные:" + words);
        Map<String, Long> map = Stream.of(words.split(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println("Вывод: " + map);
        System.out.println("\n/////////////////////////////////////////////////////////////////////////////////////////// \n");
    }

    private void task8 (List<String> list) {
        System.out.println("Отпечатайте в консоль строки из списка в порядке увеличения длины слова, если слова имеют одинаковую длину, " +
                "то должен быть сохранен алфавитный порядок" + "\nИсходные данные:" + list);

        System.out.println("Вывод: ");
        list.stream()
                .sorted(Comparator.comparing(String::length)
                        .thenComparing(Comparator.naturalOrder()))
                .forEach(System.out::println);

        System.out.println("\n/////////////////////////////////////////////////////////////////////////////////////////// \n");
    }

    private void task9 (String[] array) {
        System.out.println("Имеется массив строк, в каждой из которых лежит набор из 5 строк, разделенных пробелом, " +
                "найдите среди всех слов самое длинное, если таких слов несколько, получите любое из них" + "\nИсходные данные:");
        Arrays.stream(array).forEach(System.out::println);
        String longestWord = Arrays.stream(array)
                .flatMap(s -> Arrays.stream(s.split(" ")))
                .max(Comparator.comparing(String::length))
                .orElse("");

        System.out.println("Вывод: " + longestWord);

        System.out.println("\n/////////////////////////////////////////////////////////////////////////////////////////// \n");
    }
}
