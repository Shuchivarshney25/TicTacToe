package LLDQuestions.tictactoe;

public class Board {

   private static final int SIZE =3;
   private PlayerSign[][] board;

    public Board() {
        board = new PlayerSign[SIZE][SIZE];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int row = 0; row <SIZE ; row++) {
            for (int col = 0; col <SIZE ; col++) {
                board[row][col] = null;
            }
        }
    }

    public boolean makeMove(int row, int col, PlayerSign playerSign){
        if(isValidMove(row, col) && board[row][col] == null){
            board[row][col] = playerSign;
            return true;
        }
        return false;
    }

    private boolean isValidMove(int row, int col) {
        return row >=0 && row<SIZE  && col>=0 && col<SIZE;
    }

    public boolean isBoardFull(){
        for (int row = 0; row <SIZE ; row++) {
            for (int col = 0; col <SIZE; col++) {
                  if(board[row][col] == null){
                      return false;
                  }
            }
        }
        return true;
    }


    public boolean checkWin(PlayerSign sign) {
        // Check rows
        for (int row = 0; row < SIZE; row++) {
            boolean rowWin = true;
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] != sign) {
                    rowWin = false;
                    break;
                }
            }
            if (rowWin) {
                return true;
            }
        }

        // Check columns
        for (int col = 0; col < SIZE; col++) {
            boolean colWin = true;
            for (int row = 0; row < SIZE; row++) {
                if (board[row][col] != sign) {
                    colWin = false;
                    break;
                }
            }
            if (colWin) {
                return true;
            }
        }

        // Check diagonals
        boolean diagonalWin = true;
        for (int i = 0; i < SIZE; i++) {
            if (board[i][i] != sign) {
                diagonalWin = false;
                break;
            }
        }
        if (diagonalWin) {
            return true;
        }

        diagonalWin = true;
        for (int i = 0; i < SIZE; i++) {
            if (board[i][SIZE - 1 - i] != sign) {
                diagonalWin = false;
                break;
            }
        }
        if (diagonalWin) {
            return true;
        }

        return false;
    }


    public void printBoard() {
        System.out.println("-------------");
        for (int row = 0; row < SIZE; row++) {
            System.out.print("| ");
            for (int col = 0; col < SIZE; col++) {
                PlayerSign sign = board[row][col];
                if (sign == null) {
                    System.out.print("- | ");
                } else {
                    System.out.print(sign + " | ");
                }
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

}
