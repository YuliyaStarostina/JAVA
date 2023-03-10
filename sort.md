<!-- Сортировка слияния в Java -->

# Алгоритм

Сортировка слияния — это алгоритм «разделяй и властвуй», в котором мы сначала делим проблему на подпроблемы. Когда решения для подпроблем будут готовы, мы объединим их вместе, чтобы получить окончательное решение проблемы.

Алгоритм можно охарактеризовать как следующий двухшаговой процесс.

Разделите:

* На этом этапе мы делим входной массив на две половины, точка поворота является средней точкой массива. Этот шаг выполняется рекурсивно для всех половинных массивов до тех пор, пока не останется больше половинных массивов для деления.

* Завоевание: На этом этапе мы сортируем и объединяем разделенные массивы снизу вверх и получаем отсортированный массив.

Mассив рекурсивно делится на две половины, пока размер не станет равным 1. Как только размер становится равным 1, процессы слияния вступают в действие и начинают слияние массивов при сортировке:
https://github.com/YuliyaStarostina/JAVA/blob/main/hw3/1.jpg



# Реализация

Для реализации, Мы напишем используем функцию mergeSort, которая принимает на входе массиве и его длину в качестве параметров. Это будет рекурсивная функция, поэтому нам нужны базовые и рекурсивные условия.

Базовое условие проверяет, равна ли длина массива 1, и если да, то он просто вернется. В остальных случаях рекурсивный вызов будет выполнен.

Для рекурсивного случая мы получаем средний индекс и создаем два временных массива arrays l[] and r[]. Затем функция mergeSort вызывается рекурсивно для обоих подмассивов:


public static void mergeSort(int[] a, int n) {
    
    if (n < 2) {
        return;
    }
    int mid = n / 2;
    int[] l = new int[mid];
    int[] r = new int[n - mid];

    for (int i = 0; i < mid; i++) {
        l[i] = a[i];
    }
    for (int i = mid; i < n; i++) {
        r[i - mid] = a[i];
    }
    mergeSort(l, mid);
    mergeSort(r, n - mid);

    merge(a, l, r, mid, n - mid);
}

Функция merge сравнивает элементы обоих подмассивов один за другим и помещает меньший элемент во входной массив.
Когда мы достигаем конца одного из подмассивов, остальные элементы из другого массива копируются во входной массив, тем самым давая нам окончательный отсортированный массив:

public static void merge(
  
  int[] a, int[] l, int[] r, int left, int right) {
    
    int i = 0, j = 0, k = 0;
    while (i < left && j < right) {
        if (l[i] <= r[j]) {
            a[k++] = l[i++];
        }
        else {
            a[k++] = r[j++];
        }
    }
    while (i < left) {
        a[k++] = l[i++];
    }
    while (j < right) {
        a[k++] = r[j++];
    }
}
​
Модульный тест для программы:

@Test
public void positiveTest() {

    int[] actual = { 5, 1, 6, 2, 3, 4 };
    int[] expected = { 1, 2, 3, 4, 5, 6 };
    MergeSort.mergeSort(actual, actual.length);
    assertArrayEquals(expected, actual);
}
