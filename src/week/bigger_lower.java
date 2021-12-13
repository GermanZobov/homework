package week;

import java.util.Arrays;
import java.util.Scanner;

public class bigger_lower
{
    public static void main(String[] args)
    {
        int min;
        int temp_min;
        int max;
        int temp_max;
        int x = 0;

        StringBuilder log = new StringBuilder();
        log.append("[");
        Scanner input = new Scanner(System.in);
        System.out.println("min:");
        if (input.hasNextInt()) { min = input.nextInt(); }
        else {
            min = 0;
            System.out.println("min is set to 0");
            input.nextLine();
        }
        System.out.println("max:");
        if (input.hasNextInt()) { max = input.nextInt(); } else {
            max = 100;
            System.out.println("max is set to 100");
            input.nextLine();
        }
        if (min == max || min < 0 || max < 0 || min > max || max > 100) { throw new IllegalArgumentException(); }
        int unknown = rand(min, max);
        System.out.println("PLAY");
        //input.nextLine();
        temp_max = max + 1;
        temp_min = min - 1;
        int l = 0;
        while (true) {
           // l++;
            if(input.hasNextInt()) {x = input.nextInt();} else {System.out.println("Введите число!"); log.append((input.next())+", ");input.nextLine(); continue; }
            if (x >= temp_max) {
                System.out.println("Уже было");
                log.append(x + ", ");
                continue;
            }
            if (x <= temp_min) {
                System.out.println("Уже было");
                log.append(x + ", ");
                continue;
            }
            if (x < temp_max && x > unknown) { temp_max = x; }
            if (x > temp_min && x < unknown) { temp_min = x; }
            if (x < unknown) {
                System.out.println("больше");
                log.append(x + ", ");
                continue;
            } else if (x > unknown) {
                System.out.println("меньше");
                log.append(x + ", ");
                continue;
            } else {
                System.out.println("угадано");
                log.append(x + "]");
                break;
            }
        }
        System.out.println(log.toString());
    }

    private static int rand(int min, int max)
    {
        //int unknown = (int) Math.random() * ((max-min)+min);
        return (int) ((Math.random() * ((max - min) + 1)) + min);
    }
}
//[Переслано от iva n]
//Напишите игровую JAVA – программу, которая отгадывает число по принципу – «больше – меньше»:
//
//программа должна загадать произвольное число в диапазоне от 0 до 100.
//
//Функция rand. Описание:
//
//int rand ( [int min, int max] )
//
//Например, если вам нужно случайное число между 5 и 15 (включительно), вызовите rand (5, 15).
//
//Замечание: При вызове без параметров min и max, возвращает псевдослучайное целое в диапазоне от 0 до RAND_MAX.
//
//пользователю предлагается попробовать угадать число путем последовательного ввода чисел из диапазона ограниченного сначала числами 0 и 100,
// а при дальнейших попытках – с учетом ранее введенных чисел. Программа должна анализировать ввод на любые ошибочные действия пользователя.
//
//На экране должно отображаться предыдущие попытки, диапазон, в котором находится искомое число и результат предыдущего действия пользователя.
//
//При совпадении чисел – программа должна сообщить об этом пользователю и вывести всю статистику по действиям пользователя.