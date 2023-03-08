
package hw3;

//Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее арифм  из этого списка.

import java.util.Arrays;

public class ex3 {
    public static void main(String args[]) {
        int[] sortArr = { 10, 1, 2, 12, -2, 19, 4, 0 };
        int[] result = mergeSort(sortArr);
        System.out.println("Исходный список: " + Arrays.toString(sortArr));
        // System.out.println("Отсортированный список: " + Arrays.toString(result));
        System.out.println("Минимальное значение списка: " + result[0]);
        System.out.println("Максимальное значение списка: " + result[result.length - 1]);
        System.out.println("Среднее арифметическое: " + (double) Arrays.stream(result).sum() / result.length);
    }

    public static int[] mergeSort(int[] sortArr) {
        int[] buffer1 = Arrays.copyOf(sortArr, sortArr.length);
        int[] buffer2 = new int[sortArr.length];
        int[] result = mergeSortInner(buffer1, buffer2, 0, sortArr.length);
        return result;
    }

    public static int[] mergeSortInner(int[] buffer1, int[] buffer2, int startIndex, int endIndex) {
        if (startIndex >= endIndex - 1) {
            return buffer1;
        }

        // уже отсортирован
        int middle = startIndex + (endIndex - startIndex) / 2;
        int[] sorted1 = mergeSortInner(buffer1, buffer2, startIndex, middle);
        int[] sorted2 = mergeSortInner(buffer1, buffer2, middle, endIndex);

        // слияние
        int index1 = startIndex;
        int index2 = middle;
        int destIndex = startIndex;
        int[] result = sorted1 == buffer1 ? buffer2 : buffer1;
        while (index1 < middle && index2 < endIndex) {
            result[destIndex++] = sorted1[index1] < sorted2[index2]
                    ? sorted1[index1++]
                    : sorted2[index2++];
        }
        while (index1 < middle) {
            result[destIndex++] = sorted1[index1++];
        }
        while (index2 < endIndex) {
            result[destIndex++] = sorted2[index2++];
        }
        return result;
    }

}
