package 0716;

import java.util.Scanner;

public class TicTacToe5x5 {
    public static final int SIZE = 5;
    public static char[][] board = new char[SIZE][SIZE];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        initBoard();
        System.out.println("=== 5x5 井字遊戲 ===");
        printBoard();

        char currentPlayer = 'X';
        while (true) {
            int row = -1, col = -1;

            while (true) {
                System.out.print("請玩家 " + currentPlayer + " 輸入 row col (0-4): ");
                if (!scanner.hasNextInt()) {
                    scanner.next(); // 清除非整數輸入
                    System.out.println("輸入錯誤，請重新輸入整數座標！");
                    continue;
                }

                row = scanner.nextInt();
                if (!scanner.hasNextInt()) {
                    scanner.next();
                    System.out.println("輸入錯誤，請重新輸入整數座標！");
                    continue;
                }
                col = scanner.nextInt();

                if (row < 0 || row >= SIZE || col < 0 || col >= SIZE) {
                    System.out.println("座標超出範圍，請重新輸入！");
                } else if (board[row][col] != '.') {
                    System.out.println("該位置已被佔用，請重新輸入！");
                } else {
                    break;
                }
            }

            board[row][col] = currentPlayer;
            System.out.println("玩家 " + currentPlayer + " 在位置 (" + row + ", " + col + ") 放置棋子");
            printBoard();

            if (checkWin(currentPlayer)) {
                System.out.println("玩家 " + currentPlayer + " 獲勝！");
                break;
            } else if (isDraw()) {
                System.out.println("平手！");
                break;
            }

            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }

        scanner.close();
    }

    public static void initBoard() {
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                board[i][j] = '.';
    }

    public static void printBoard() {
        System.out.print("  ");
        for (int i = 0; i < SIZE; i++)
            System.out.print(i + " ");
        System.out.println();

        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean checkWin(char player) {
       
        for (int i = 0; i < SIZE; i++) {
            boolean win = true;
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] != player)
                    win = false;
            }
            if (win) return true;
        }

       
        for (int j = 0; j < SIZE; j++) {
            boolean win = true;
            for (int i = 0; i < SIZE; i++) {
                if (board[i][j] != player)
                    win = false;
            }
            if (win) return true;
        }

       
        boolean win = true;
        for (int i = 0; i < SIZE; i++) {
            if (board[i][i] != player)
                win = false;
        }
        if (win) return true;

       
        win = true;
        for (int i = 0; i < SIZE; i++) {
            if (board[i][SIZE - 1 - i] != player)
                win = false;
        }
        return win;
    }

    public static boolean isDraw() {
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                if (board[i][j] == '.')
                    return false;
        return true;
    }
}

