package LLDQuestions.tictactoe;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Player 1's name: ");
        String player1Name = scanner.nextLine();
        System.out.println("Enter Player 2's name: ");
        String player2Name = scanner.nextLine();

        System.out.println(player1Name + ", choose your sign (X/O): ");
        PlayerSign player1Sign = getSignChoice(scanner);
        PlayerSign player2Sign = (player1Sign == PlayerSign.X) ? PlayerSign.O : PlayerSign.X;

        TicTacToeGame game = new TicTacToeGame(player1Name, player2Name, player1Sign, player2Sign);
        int row, col;
        while (true) {
            System.out.println(game.getCurrentPlayer().getPlayerName() + "'s turn");
            System.out.println("Enter row (0-2): ");
            row = scanner.nextInt();
            System.out.println("Enter column (0-2): ");
            col = scanner.nextInt();

            game.startGame(row, col);

            System.out.println("Play again? (Y/N)");
            String playAgain = scanner.next();
            if (!playAgain.equalsIgnoreCase("Y")) {
                break;
            }
        }
        scanner.close();
    }

    private static PlayerSign getSignChoice(Scanner scanner) {
        while (true) {
            String choice = scanner.next().toUpperCase();
            if (choice.equals("X")) {
                return PlayerSign.X;
            } else if (choice.equals("O")) {
                return PlayerSign.O;
            } else {
                System.out.println("Invalid choice. Please choose either X or O: ");
            }
        }
    }
}
