public class GamePiece {

    private Colors color;
    private int currentLocation;

    /**
     * This constructor sets the color
     * and coordinates of the game piece
     *
     * @param color
     */
    public GamePiece(Colors color){
        currentLocation = 1;
        this.color = color;

    }

    /**
     *
     * @return currentLocation
     * (the current location of the game piece)
     */
    public int getCurrentLocation() {
        return currentLocation;
    }

    /**
     * This method helps us to set
     * the location of the game piece
     *
     * @param currentLocation
     */
    public void setCurrentLocation(int currentLocation) {
        this.currentLocation = currentLocation;
    }

    /**
     *
     * @return the color
     * of the game piece
     */
    public Colors getColor() {
        return color;
    }

    /**
     * This method helps us to set
     * the color of the game piece
     *
     * @param color
     */
    public void setColor(Colors color) {
        this.color = color;
    }
}
