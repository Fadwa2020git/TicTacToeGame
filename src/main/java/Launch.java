package main.java;

import java.util.Scanner;

public class Launch {

    public static void main(String[] args) {
        Game game = new Game();
        Player player1 = new Player();
        Player player2 = new Player();
        Scanner entry;
        char choice;
        int line, column;

        //Asking the player to choose his mark
        System.out.println("Welcome to Tic Tac Toe\n Please enter your choice between X and O");
        //Repeating the process until the user chooses either x or o
        do {
            entry = new Scanner(System.in);
            choice = entry.nextLine().charAt(0);
        } while (entry.nextLine().charAt(0) !='x' && entry.nextLine().charAt(0) != 'o');
        player1.setContent(choice);
        game.setCurrentPlayer(player1);
        if (choice == 'x')
            player2.setContent('o');
        else if (choice == 'o')
            player2.setContent('x');
        //Playing the game : loop that goes on until the board is full or there's a winner
        do {
            System.out.println("Current Board Layout :");
            game.printBoard();
            //Place mark in an empty cell
            do {
                System.out.println("Player " + game.getCurrentPlayer().getContent() + " please choose a cell in which you play\n" +
                        "Please enter the line then the column whithin the bounds >=0 and <=2");
                line = entry.nextInt()-1;
                column = entry.nextInt()-1;
            } while (!game.fillCellContent(line, column));
            //Change players
            game.switchPlayer();
        } while (!game.isBoardFull() && !game.isWin());
        if (game.isBoardFull() && !game.isWin()) {
            System.out.println("No Winner");
        }
        if (game.isWin()) {
            game.switchPlayer();
            System.out.println("Congrats Player " + game.getCurrentPlayer().getContent());
        }
        entry.close();
        System.out.println("End of the Game, thanks for playing");
    }

}
