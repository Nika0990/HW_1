public class Player {
    private String playerName;
    private GamePiece piece;

    /**
     * This constructor sets the name of the player
     * and creates a new piece for the player
     * according to the chosen color
     *
     * @param playerName
     * @param color
     */
    public Player(String playerName, Colors color){
        this.playerName = playerName;
        this.piece = new GamePiece(color);
    }

    /**
     *
     * @return the name of the player
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     * This method sets the name of the player
     *
     * @param playerName
     */
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    /**
     *
     * @return the current location
     * of the game piece which
     * belongs to this player
     */
    public int getPieceLocation() {
        return piece.getCurrentLocation();
    }

    /**
     *This method helps us to set the location of the
     * game piece which belongs to this player
     *
     * @param currentLocation
     */
    public void setPieceLocation(int currentLocation) {
        piece.setCurrentLocation(currentLocation);
    }

    /**
     *
     * @return the color of the game
     * piece which belongs to this player
     */
    public Colors getPieceColor() {
        return piece.getColor();
    }

    /**
     *This method helps us to set the color
     * of the game piece which belongs to
     * this player
     *
     * @param color
     */
    public void setPieceColor(Colors color) {
        piece.setColor(color);
    }
}
