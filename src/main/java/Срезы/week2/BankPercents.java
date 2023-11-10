package Срезы.week2;

import java.math.BigInteger;

public class BankPercents {

    // дробная часть, необходимо увеличить для повышения точности
    static long multiplier = 1000;

    // 2%
    static long divider = 50;

    public static void main(String[] args) {

        long deposit = 100000 * multiplier; // 1000.00 $

        for (int year = 1; year <= 5; year++) {
            deposit += deposit/divider;
            log(year, deposit);
        }
    }

    public static void log(int year, long deposit) {
        long amount = deposit/multiplier;
        System.out.println("За " + year + " год, на вашем счету появилась " + amount + " сумма центов");
    }
}