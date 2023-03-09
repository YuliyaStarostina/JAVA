package hw4;

// Пусть дан LinkedList с несколькими элементами. 
// Реализуйте метод, который вернет “перевернутый” список. Постараться не обращаться к листу по индексам.
import java.util.LinkedList;
import java.util.Random;

public class ex1 {
    public static void main(String[] args) {
        LinkedList<Integer> myList = new LinkedList<>();
        Random random = new Random();
        for (int i = 0; i < 15; i++) {
            myList.add(random.nextInt(1, 15));
        }
        System.out.print("Сгенерированный список: ");
        System.out.println(myList);
        System.out.println();
        System.out.print("Перевернутый список: ");
        System.out.println(turnOver(myList));
    }

    static LinkedList<Integer> turnOver(LinkedList<Integer> inputList) {
        LinkedList<Integer> turnedList = new LinkedList<>();
        for (int i = 0; i < inputList.size(); i++) {
            int item = inputList.get(i);
            turnedList.addFirst(item);
        }
        return turnedList;
    }

}
