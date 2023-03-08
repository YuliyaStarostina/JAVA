// =====================================
// 2. Пусть дан произвольный список целых чисел, удалить из него четные числа.
// =====================================

package hw3;

import java.util.Arrays;
import java.util.Scanner;

public class ex2 {
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        System.out.print("Введите количество элементов массива: ");
        int n = scanner.nextInt();
        int[] newArr = new int[n];
        System.out.println("Введите элементы массива: ");
        for (int i = 0; i < n; i++) {
            newArr[i] = scanner.nextInt();
        }
        System.out.println("Исходный массив: " + Arrays.toString(newArr));
        // сортируем массив
        int[] filterArr = Arrays.stream(newArr).filter(i -> i % 2 != 0).toArray();
        System.out.println("Полученный массив: " + Arrays.toString(filterArr));
    }
}