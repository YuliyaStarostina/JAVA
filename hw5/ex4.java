// На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга.
// Шаг 1: Создание шахматной доски
// Сначала нам нужно создать шахматную доску размером 8x8, 
// на которой будем расставлять ферзей. Для этого мы можем использовать двумерный массив.
package hw5;

public class ex4 {
    public static void main(String[] args) {
        char[][] board = new char[8][8];
        // Шаг 2: Заполнение доски пустыми клетками
        // Для начала все клетки на доске должны быть пустыми.
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = '-';
            }
        }
        solveQueens(board, 0);
        printBoard(board);
    }

    // Шаг 3: Расставление ферзей
    // Теперь мы можем начать расставлять ферзей на доске. Мы будем использовать
    // метод "ход конём", чтобы расположить ферзей на разных рядах и столбцах, где
    // они не будут бить друг друга.
    // - Берем начальную координату (0, 0) и располагаем на ней ферзя.
    // - Для каждого ферзя на следующем ряду ищем все возможные клетки, которые не
    // имеют угрозу по вертикалям, горизонталям и диагоналям от уже расположенных
    // ферзей. Делаем это с помощью метода "ход конём".
    // - Если находим свободную клетку, располагаем на ней ферзя и переходим к
    // следующему ряду. Если свободных клеток не осталось, то возвращаемся к
    // предыдущему ряду и ищем новую свободную клетку.
    // - Если мы успеваем разместить всех ферзей на доске, то выводим ее на экран.
   
    public static boolean solveQueens(char[][] board, int row) {
        // если мы размещаем последнего ферзя на доске - решение найдено!
        if (row == 8) {
            return true;
        }

        // поиск клеток, куда можно поставить ферзя на текущем ряду
        for (int col = 0; col < 8; col++) {
            if (isSafe(board, row, col)) {
                // располагаем ферзя на клетке (row, col)
                board[row][col] = 'Q';

                // рекурсивный вызов для следующего ряда
                if (solveQueens(board, row + 1)) {
                    return true;
                }
                // если следующий ряд не может быть решен - возвращаемся к предыдущему и ищем
                // другую клетку для размещения ферзя
                board[row][col] = '-';
            }
        }

        // если ни одна из клеток не подошла - решение не найдено
        return false;
    }

    // Шаг 4: Проверка безопасности клеток
    // Метод "isSafe" проверяет, можно ли установить ферзя на клетку (row, col),
    // не создавая угроз на вертикалях, горизонталях и диагоналях от других ферзей
    // на доске.
    public static boolean isSafe(char[][] board, int row, int col) {
        // проверяем вертикали и горизонтали
        for (int i = 0; i < 8; i++) {
            if (board[row][i] == 'Q' || board[i][col] == 'Q') {
                return false;
            }
        }

        // проверяем диагонали
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        for (int i = row, j = col; i >= 0 && j < 8; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    // Шаг 5: Вывод доски на экран
    // Если все ферзи успешно размещены на доске, то мы можем ее вывести на экран.
    /**
     * @param board
     */
    public static void printBoard(char[][] board) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
// Шаг 6: Запуск программы

// Теперь мы можем вызвать функцию "solveQueens" с пустой доской и начальным
// рядом 0.
// Если функция возвращает true, то мы можем вывести доску на экран.
