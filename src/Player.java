public class Player {
    private String playerName;
    private GamePiece piece;
    public Player(String playerName, Colors color){
        this.playerName = playerName;
        this.piece = new GamePiece(color);
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getPieceLocation() {
        return piece.getCurrentLocation();
    }

    public void setPieceLocation(int currentLocation) {
        piece.setCurrentLocation(currentLocation);
    }
}
