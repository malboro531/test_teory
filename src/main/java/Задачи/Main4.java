package Задачи;

import java.util.ArrayList;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args)
    {
        // Инициализируем объект Scanner для считывания данных с консоли
        Scanner scanner = new Scanner(System.in);
        // Считываем необходимую сумму
        int n = scanner.nextInt();
        // Считываем количество различных номиналов купюр
        int m = scanner.nextInt();
        // Создаем массив для хранения номиналов купюр
        int[] bills = new int[m];
        // Заполняем массив номиналами купюр
        for (int i = 0; i < m; i++)
        {
            bills[i] = scanner.nextInt();
        }
        // Создаем список для хранения выбранных ковбоем купюр
        ArrayList<Integer> result = new ArrayList<>();
        // Пытаемся подобрать купюры, чтобы составить необходимую сумму
        if (!robBank(n, bills, result, 0))
        {
            // Если подобрать купюры не удалось, выводим -1
            System.out.println("-1");
        }
        else
        {
            // Выводим количество выбранных купюр
            System.out.println(result.size());
            // Выводим номиналы выбранных купюр
            for (int bill : result)
            {
                System.out.print(bill + " ");
            }
        }
    }
    // Рекурсивный метод для попытки подбора купюр
    private static boolean robBank(int n, int[] bills, ArrayList<Integer> result, int currentIndex)
    {
        // Если требуемая сумма равна 0, то купюры подобраны успешно
        if (n == 0)
        {
            return true;
        }
        // Если все номиналы рассмотрены и сумма не собрана, возвращаем false
        if (currentIndex >= bills.length)
        {
            return false;
        }
        // Пробуем взять одну купюру текущего номинала
        if (n >= bills[currentIndex] && robBank(n - bills[currentIndex], bills, result, currentIndex + 1))
        {
            // Добавляем этот номинал в результат
            result.add(bills[currentIndex]);
            return true;
        }
        // Пробуем взять две купюры текущего номинала
        if (n >= 2 * bills[currentIndex] && robBank(n - 2 * bills[currentIndex], bills, result, currentIndex + 1))
        {
            // Добавляем этот номинал дважды в результат
            result.add(bills[currentIndex]);
            result.add(bills[currentIndex]);
            return true;
        }
        // Если текущий номинал не подходит, переходим к следующему без изменений
        return robBank(n, bills, result, currentIndex + 1);
    }

}
