import java.util.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
public class PhoneBook {

    // Объявляем HashMap для хранения телефонной книги.
    // Ключ - имя, значение - HashSet для хранения номеров телефонов.
    private HashMap<String, HashSet<String>> phoneBook;

    // Конструктор по умолчанию инициализирует телефонную книгу.
    public PhoneBook() {
        phoneBook = new HashMap<>();
    }

    // Метод add() добавляет новую запись в телефонную книгу.
    // Если имя уже существует, то добавляется новый номер телефона.
    public void add(String name, String phone) {
        // Проверяем, существует ли уже имя в телефонной книге.
        if (!phoneBook.containsKey(name)) {
            // Если нет, то добавляем новое имя с пустым HashSet для номеров телефонов.
            phoneBook.put(name, new HashSet<>());
        }
        // Добавляем номер телефона в HashSet для данного имени.
        phoneBook.get(name).add(phone);
    }

    // Метод printPhoneBook() выводит содержимое телефонной книги,
    // отсортированное по убыванию числа телефонов.
    public void printPhoneBook() {
        // Преобразуем набор записей entrySet() в список sortedEntries,
        // чтобы отсортировать его с помощью компаратора.
        List<Map.Entry<String, HashSet<String>>> sortedEntries = new ArrayList<>(phoneBook.entrySet());

        // Определяем компаратор для сортировки записей по убыванию числа телефонов.
        // Компаратор сравнивает размеры HashSet для номеров телефонов (getValue().size())
        // и сортирует их в порядке убывания.
        final Comparator<Map.Entry<String, HashSet<String>>> comparator = new Comparator<Map.Entry<String, HashSet<String>>>() {
            @Override
            public int compare(final Map.Entry<String, HashSet<String>> o1, final Map.Entry<String, HashSet<String>> o2) {
                return o2.getValue().size() - o1.getValue().size();
            }
        };

        // Сортируем список записей sortedEntries с помощью компаратора.
        sortedEntries.sort(comparator);

        // Выводим отсортированные записи с помощью цикла for-each.
        for (Map.Entry<String, HashSet<String>> entry : sortedEntries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    // Точка входа в программу.
    public static void main(String[] args) {
        // Создаем экземпляр телефонной книги.
        PhoneBook phoneBook = new PhoneBook();

        // Добавляем записи в телефонную книгу.
        phoneBook.add("Ekaterina", "123456");
        phoneBook.add("Juliya", "789456");
        phoneBook.add("Mike", "999999");
        phoneBook.add("Emma", "222222");
        phoneBook.add("Emma", "333333");

        // Выводим содержимое телефонной книги.
        phoneBook.printPhoneBook();
    }
}

