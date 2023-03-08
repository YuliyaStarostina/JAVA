package hw1;
//реализовать простой калькулятор
import java.util.Scanner;
import java.util.logging.*;
import java.io.IOException;
 
public class ex3 {
    static Scanner scanner = new Scanner(System.in);
    //Метод main() - должен считывать 2 числа (с помощью getInt()), 
    // считать операцию (с помощью getOperation(), передать все методу calc() и вывести на экран результат.
 
    public static void main(String[] args) throws IOException {
        Logger logger = Logger.getLogger(ex4.class.getName());
        FileHandler fh = new FileHandler("logTask3.xml");
        logger.addHandler(fh);
        XMLFormatter xml = new XMLFormatter();
        fh.setFormatter(xml);
        logger.info("Calcul");
        int num1 = getInt();
        int num2 = getInt();
        char operation = getOperation();
        int result = calc(num1,num2,operation);
        System.out.println("Результат операции: "+result);
    }
 
    public static int getInt(){     //Метод int getInt() - должен считывать с консоли целое число и возвращать его
        System.out.println("Введите число:");
        int num;
        if(scanner.hasNextInt()){
            num = scanner.nextInt();
        } else {
            System.out.println("Вы допустили ошибку при вводе числа. Попробуйте еще раз.");
            scanner.next();//рекурсия
            num = getInt();
        }
        return num;
    }
 //Метод char getOperation() - 
//  должен считывать с консоли какое-то значение и возвращать символ с операцией (+, -, * или /)
    public static char getOperation(){
        System.out.println("Введите операцию:");
        char operation;
        if(scanner.hasNext()){
            operation = scanner.next().charAt(0);
        } else {
            System.out.println("Вы допустили ошибку при вводе операции. Попробуйте еще раз.");
            scanner.next();//рекурсия
            operation = getOperation();
        }
        return operation;
    }
 //Метод int calc(int num1, int num2, char operation) - 
//  должен выполнять над числами num1 и num2 арифметическую операцию, заданную operation.
    public static int calc(int num1, int num2, char operation){
        int result;
        switch (operation){
            case '+':
                result = num1+num2;
                break;
            case '-':
                result = num1-num2;
                break;
            case '*':
                result = num1*num2;
                break;
            case '/':
                result = num1/num2;
                break;
            default:
                System.out.println("Операция не распознана. Повторите ввод.");
                result = calc(num1, num2, getOperation());//рекурсия
        }
        return result;
    }
            
}