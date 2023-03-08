class TestClass {
    public static void main(String[] args) {
        // добавление значений в StringBuilder
        StringBuilder sb = new StringBuilder("The ");
        sb.append("Java ");
        sb.append("Tutorial ");
        System.out.println(sb);
        // вывод: учебник по Java
        // вставляем указанную строку этой строкой в ​​указанной позиции
        sb.insert(8, " StringBuilder ");
        System.out.println(sb);
        // output: Учебник Java StringBuilder
        // заменяем строку из указанных startIndex и endIndex
        sb.replace(4, 4, "Good");
        System.out.println(sb);
        // вывод: учебник по стилю GoodJava StringBuilder
        // удалить строку из указанных startIndex и endIndex
        sb.delete(0, 4);
        System.out.println(sb);
        // вывод: GoodJava StringBuilder Tutorial
        // отменить строку
        sb.reverse();
        System.out.println(sb);
        // вывод: lairotuT redliuBgnirtS avaJdooG
        // вернуть текущую емкость
        StringBuilder nsb = new StringBuilder();
        System.out.println(nsb.capacity());
        // output: 16, емкость по умолчанию 16
        nsb.append("The Java Tutorial ");
        System.out.println(nsb.capacity());
        // вывод: 34, (oldcapacity * 2) +2, (16 * 2) +2
    }
}


// Метод append() StringBuilder
// Основными операциями в StringBuilder являются метод append, 
// который перегружен, чтобы принимать данные любого типа. 
// Добавления String становятся все более дорогими, поскольку строки становятся длиннее и требуется больше памяти. 
// Например:
// class TestClass{
//     public static void main (String[] args) {
//       String str = "";
//       for (int i = 0; i < 100; i++) {
//         str += ", " + i;
//       }
//       System.out.println(str);
//     }
//   }