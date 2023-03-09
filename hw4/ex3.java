package hw4;
// Найдите сумму всех элементов LinkedList, сохраняя все элементы в списке. Используйте итератор

import java.util.LinkedList;
import java.util.Random;
import java.util.Iterator;

public class ex3 {
    public static void main(String[] args) {
        //создаем список LinkedList и добавляем значения
        LinkedList<Integer> myList = new LinkedList<>();
        Random random = new Random();
        for (int i = 0; i < 15; i++) {
            myList.add(random.nextInt(1, 15));}
         {
            System.out.print("Сгенерированный список: ");
            System.out.println(myList);
            System.out.println();
            
            // сщздаем итератор для списка LinkedList
            Iterator<Integer>iterator = myList.iterator();
            // объявляем переменную для хранения суммы
            int sum = 0;
            //итерируемся по списку и добавляем значения к сумме
            while (iterator.hasNext()) {
                sum += iterator.next();
                
            }
            System.out.println("Сумма элементов списка: " + sum);
        }
        
        }
        
    }
    