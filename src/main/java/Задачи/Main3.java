package Задачи;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Инициализация объекта Scanner для чтения ввода
        int n = scanner.nextInt(); // Чтение количества карт
        int[] a = new int[n]; // Инициализация массива для последовательности ковбоя Джо
        int[] b = new int[n]; // Инициализация массива для выигрышной последовательности
        // Заполнение массива a значениями из ввода
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        // Заполнение массива b значениями из ввода
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }
        int l = 0, r = n - 1;
        // Находим первое место, где последовательности a и b различны
        while (l < n && a[l] == b[l]) {
            l++;
        }
        // Находим последнее место, где последовательности a и b различны
        while (r >= 0 && a[r] == b[r]) {
            r--;
        }
        // Если не найдено различий или они исчезли (l > r)
        if (l > r) {
            System.out.println("YES");
            return;
        }
        // Сортировка подмассива a от индекса l до индекса r (включительно)
        java.util.Arrays.sort(a, l, r + 1);
        // После сортировки, проверяем, совпадает ли a с b на всех позициях
        for (int i = 0; i < n; i++) {
            if (a[i] != b[i]) {
                System.out.println("NO"); // Если нет, выводим "NO" и завершаем выполнение
                return;
            }
        }
        // Если проверка прошла успешно, выводим "YES"
        System.out.println("YES");
    }
}