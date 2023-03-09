package hw4;

// Реализуйте очередь с помощью LinkedList со следующими методами: 
// enqueue() - помещает элемент в конец очереди, 
// dequeue() - возвращает первый элемент из очереди и удаляет его, 
// first() - возвращает первый элемент из очереди, не удаляя.
import java.util.*;
import java.util.Scanner;

public class ex2 {
    public static void main(String[] args) {
        Queue<Integer> myQueue = new LinkedList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            myQueue.add(random.nextInt(1, 10));
        }
        System.out.print("Сгенерированная очередь: ");
        System.out.println(myQueue);

        try (Scanner iScanner = new Scanner(System.in)) {
            System.out.println("Введите целое число: ");
            int num = iScanner.nextInt();

            System.out.printf("Добавляем элемент %s в конец очереди: ", num);
            System.out.println(enqueue(myQueue, num));
        }
        System.out.printf("Первый элемент в очереди - %s\n", dequeue(myQueue));
        System.out.print("Удаляем этот элемент из очереди: ");
        System.out.println(myQueue);

        System.out.printf("Первый элемент в очереди - %s\n", first(myQueue));
        System.out.print("Проверяем очередь: ");
        System.out.println(myQueue);

    }

    static Queue<Integer> enqueue(Queue<Integer> inputQueue, int number) {
        inputQueue.add(number);
        return inputQueue;
    }

    static String dequeue(Queue<Integer> inputQueue) {
        if (inputQueue.size() > 0) {
            String firstEl = inputQueue.peek().toString();
            inputQueue.remove();
            return firstEl;
        } else {
            return "Очередь пуста";
        }
    }

    static int first(Queue<Integer> inputQueue) {
        return inputQueue.element();
    }

}
