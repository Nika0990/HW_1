public class GamePiece {
    public enum Colors {RED,BLUE,GREEN,YELLOW,ORANGE};
    private Colors color;
    private int currentLocation;
    public GamePiece(Colors color){
        currentLocation = 1;
        this.color = color;

    }
    public int getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(int currentLocation) {
        this.currentLocation = currentLocation;
    }

    public Colors getColor() {
        return color;
    }

    public void setColor(Colors color) {
        this.color = color;
    }
}
