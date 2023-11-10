package Задачи;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Инициализируем объект Scanner для чтения ввода
        String s = scanner.nextLine(); // Читаем строку
        int[] counts = new int[26]; // Инициализируем массив для подсчета букв (для всех букв латинского алфавита)
        // Проходимся по строке s и увеличиваем счетчик для каждой буквы
        for (char c : s.toCharArray()) {
            counts[c - 'a']++; // Индекс в массиве counts зависит от ASCII-кода символа
        }
        // Инициализируем result максимальным значением, чтобы потом найти минимальное количество вхождений буквы
        int result = Integer.MAX_VALUE;
        // Для каждой буквы слова "sheriff" находим минимальное количество вхождений в строку s
        result = Math.min(result, counts['s' - 'a']); // Проверяем букву 's'
        result = Math.min(result, counts['h' - 'a']); // Проверяем букву 'h'
        result = Math.min(result, counts['e' - 'a']); // Проверяем букву 'e'
        result = Math.min(result, counts['r' - 'a']); // Проверяем букву 'r'
        result = Math.min(result, counts['i' - 'a']); // Проверяем букву 'i'
        result = Math.min(result, counts['f' - 'a'] / 2); // Проверяем букву 'f', которая встречается в слове "sheriff" два раза
        System.out.println(result); // Выводим результат - сколько раз можно составить слово "sheriff" из букв строки s
    }
}