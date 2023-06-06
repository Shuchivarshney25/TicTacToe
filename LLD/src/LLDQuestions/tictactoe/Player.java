package LLDQuestions.tictactoe;

public class Player {

    private String playerName;
    private PlayerSign playerSign;

    public Player(String playerName, PlayerSign playerSign) {
        this.playerName = playerName;
        this.playerSign = playerSign;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public PlayerSign getPlayerSign() {
        return playerSign;
    }

    public void setPlayerSign(PlayerSign playerSign) {
        this.playerSign = playerSign;
    }

}
