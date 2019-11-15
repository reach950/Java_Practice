package com.example.data_structure_and_algorithm;

import java.util.HashSet;
import java.util.Set;

public class SudokuSolver {
    Set<String> s = new HashSet<>();

    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        new SudokuSolver().solveSudoku(board);
        for (int i = 0; i < 9; i++) {
            System.out.println();
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j]);
            }
        }
    }

    public void solveSudoku(char[][] board) {
//        initBoard(board);
//        helper(board);
        solve(board);
    }

    private boolean helper(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (!s.contains(c + "row" + i) && !s.contains(c + "column" + j) && !s.contains(c + "block" + i / 3 + j / 3)) {
                            board[i][j] = c;
                            s.add(c + "row" + i);
                            s.add(c + "column" + j);
                            s.add(c + "block" + i / 3 + j / 3);

                            if (helper(board)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                                s.remove(c + "row" + i);
                                s.remove(c + "column" + j);
                                s.remove(c + "block" + i / 3 + j / 3);
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private void initBoard(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char number = board[i][j];
                if (number != '.') {
                    s.add(number + "row" + i);
                    s.add(number + "column" + j);
                    s.add(number + "block" + i / 3 + j / 3);
                }
            }
        }
    }

    private boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;
                            if (solve(board)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int column, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] != '.' && board[row][i] == c) {
                return false;
            }
            if (board[i][column] != '.' && board[i][column] == c) {
                return false;
            }
            if (board[3 * (row / 3) + i / 3][3 * (column / 3) + i % 3] != '.' && board[3 * (row / 3) + i / 3][3 * (column / 3) + i % 3] == c) {
                return false;
            }
        }
        return true;
    }
}
