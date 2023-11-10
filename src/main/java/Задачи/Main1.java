package Задачи;

import java.util.Scanner; // Импортируем Scanner для чтения ввода

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Создаем объект Scanner для чтения ввода
        int n = scanner.nextInt(); // Читаем количество револьверов в магазине
        int s = scanner.nextInt(); // Читаем количество долларов у ковбоя Джо
        int maxAffordablePrice = 0; // Инициализируем переменную, которая будет хранить максимальную стоимость револьвера, который ковбой Джо может себе позволить
        // Проходимся по списку цен револьверов
        for (int i = 0; i < n; i++) {
            int price = scanner.nextInt(); // Читаем цену очередного револьвера
            // Проверяем, меньше ли или равна цена количеству долларов у Джо и больше ли она текущей максимальной стоимости
            if (price <= s && price > maxAffordablePrice) {
                maxAffordablePrice = price; // Обновляем максимальную стоимость
            }
        }
        System.out.println(maxAffordablePrice); // Выводим результат
    }
}