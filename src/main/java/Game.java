package main.java;

public class Game {
    private char[][] board;
    private Player currentPlayer;

    public Game() {
        this.initializeBoard();
    }

    public char[][] getBoard() {
        return board;
    }

    public void setBoard(char[][] board) {
        this.board = board;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void initializeBoard() {
        this.board = new char[3][3];
        for (int line=0;line<3;line++) {
            for (int column=0; column<3; column++) {
                this.board[line][column] = '-';
            }
        }
    }

    public void printBoard() {
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

    public void switchPlayer() {
        if (this.currentPlayer.getContent() == 'x')
            this.currentPlayer.setContent('o');
        else if (this.currentPlayer.getContent() == 'o')
            this.currentPlayer.setContent('x');
    }

    public boolean isWin() {
        if (isLineTriple() ||
                isColumnTriple() ||
                isDiagonalTriple())
            return true;
        return false;
    }

    public boolean isLineTriple() {
        boolean tripleValues = false;
        char cellContent;
        for (int line=0;line<3;line++) {
            cellContent = board[line][0];
            if (cellContent != '-') {
                tripleValues = true;
                for (int column = 1; column < 3; column++) {
                    if (board[line][column] != cellContent)
                        tripleValues = false;
                }
                if (tripleValues)
                    return tripleValues;
            }
        }
        return false;
    }

    public boolean isColumnTriple() {
        boolean tripleValues = false;
        char cellContent;
        for (int column=0;column<3;column++) {
            cellContent = board[0][column];
            if (cellContent != '-') {
                tripleValues = true;
                for (int line = 1; line < 3; line++) {
                    if (board[line][column] != cellContent)
                        tripleValues = false;
                }
                if (tripleValues)
                    return tripleValues;
            }
        }
        return false;
    }

    public boolean isDiagonalTriple() {
        boolean tripleValues = false;
        char cellContent = board[0][0];
        tripleValues = true;
        if (board[1][1] != cellContent || board[2][2] != cellContent)
            tripleValues = false;
        if (tripleValues)
            return tripleValues;
        cellContent = board[0][2];
        tripleValues = true;
        if (board[1][1] != cellContent || board[2][0] != cellContent)
            tripleValues = false;
        return tripleValues;
    }

    public boolean fillCellContent(int line, int column) {
        if (line>=0 && line<=2 && column>=0 && column<=2) {
            board[line][column] = currentPlayer.getContent();
            return true;
        }
        return false;
    }

    public boolean isBoardFull() {
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
}

