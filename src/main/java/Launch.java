package main.java;

import java.util.Scanner;

public class Launch {
    public static Player currentPlayer = new Player();

    public static void main(String[] args) {
        Player person = new Player();
        Player program = new Player();
        char choice;
        char[][] board = new char[3][3];
        System.out.println("Welcome to Tic Tac Toe\n Please enter your choice between X and O");
        Scanner entry = new Scanner(System.in);
        choice = entry.nextLine().charAt(0);
        person.setContent(choice);
        if (choice == 'x')
            program.setContent('o');
        else if (choice == 'o')
            program.setContent('x');
        initializeBoard(board);
        printBoard(board);
    }

    public static void initializeBoard(char[][] board) {
        for (int line=0;line<3;line++) {
            for (int column=0; column<3; column++) {
                board[line][column] = '-';
            }
        }
    }

    public static void printBoard(char[][] board) {
        System.out.println("-------------");
        for (int line=0;line<3;line++) {
            System.out.print("| ");
            for (int column=0; column<3; column++) {
                System.out.print(board[line][column] + " |");
                System.out.print(" ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    public static void switchPlayer() {
        if (currentPlayer.getContent() == 'x')
            currentPlayer.setContent('o');
        else if (currentPlayer.getContent() == 'o')
            currentPlayer.setContent('x');
    }

    public boolean isFull(char[][] board) {
        for (int line=0;line<3;line++) {
            for (int column=0; column<3; column++) {
                if (board[line][column] == '\0'
                        || board[line][column] == ' '
                        || board[line][column] == '-')
                    return false;
            }
        }
        return true;
    }

    public static char[][] fillContent(char[][] board, int line, int column) throws Exception {
        try {
            if (line>=3 || line<0 || column>=3 || column<0)
                throw new Exception();
            board[line][column] = currentPlayer.getContent();
        } catch (Exception e) {
            System.out.println("Value out of bounds");
        }
        return board;
    }

    public boolean isLineTriple(char[][] board) {
        boolean tripleValues = false;
        char cellContent;
        for (int line=0;line<3;line++) {
            cellContent = board[line][0];
            tripleValues = true;
            for (int column=1; column<3; column++) {
                if (board[line][column] != cellContent)
                    tripleValues = false;
            }
            if (tripleValues)
                return tripleValues;
        }
        return tripleValues;
    }

    public boolean isColumnTriple(char[][] board) {
        boolean tripleValues = false;
        return tripleValues;
    }

    public boolean isDiagonalTriple(char[][] board) {
        boolean tripleValues = false;
        return tripleValues;
    }

}
