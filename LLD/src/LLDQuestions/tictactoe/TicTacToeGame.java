package LLDQuestions.tictactoe;

public class TicTacToeGame {

    private Player player1;
    private Player player2;

    public Board getBoard() {
        return board;
    }

    private Board board;
    private Player currentPlayer;


    public Player getCurrentPlayer() {
        return currentPlayer;
    }


    public TicTacToeGame(String player1Name, String player2Name, PlayerSign player1Sign, PlayerSign player2Sign) {
        player1 = new Player(player1Name, player1Sign);
        player2 = new Player(player2Name, player2Sign);
        currentPlayer = player1;
        board = new Board();
    }

    public void startGame(int row , int col){
        if(board.makeMove(row,col,currentPlayer.getPlayerSign())){
            board.printBoard();
            if(board.checkWin(currentPlayer.getPlayerSign())){
                System.out.println("Player "+currentPlayer.getPlayerName() + "wins ..!!");
                gameReset();
            }else if(board.isBoardFull()){
                System.out.println("match is tie");
                gameReset();
            }else {
                  if(currentPlayer == player1){
                      currentPlayer = player2;
                  }else {
                      currentPlayer = player1;
                  }
            }
        }else {
            System.out.println("Invalid move. Please try again ..!!");
        }
    }

    private void gameReset(){
        board = new Board();
        currentPlayer = player1;
    }



}
