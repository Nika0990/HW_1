public class Player {
    private String playerName;
    private GamePiece piece;
    Player(String playerName, GamePiece.Colors color){
        this.playerName = playerName;
        this.piece = new GamePiece(color);
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
}
