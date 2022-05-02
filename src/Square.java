public class Square {
    private int coordinate;
    private boolean isSnakeHead;
    private boolean isLadderBottom;
    private boolean isSnakeTail;
    private boolean isLadderTop;
    public Square (int coordinate){
         this.coordinate = coordinate;
         isSnakeHead = false;
         isLadderBottom = false;

     }
    public int getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(int coordinate) {
        this.coordinate = coordinate;
    }

    public boolean isSnakeHead() {
        return isSnakeHead;
    }

    public void setSnakeHead(boolean snakeHead) {
        isSnakeHead = snakeHead;
    }

    public boolean isLadderBottom() {
        return isLadderBottom;
    }

    public void setLadderBottom(boolean ladderBottom) {
        isLadderBottom = ladderBottom;
    }

    public boolean isSnakeTail() {
        return isSnakeTail;
    }

    public void setSnakeTail(boolean snakeTail) {
        isSnakeTail = snakeTail;
    }

    public boolean isLadderTop() {
        return isLadderTop;
    }

    public void setLadderTop(boolean ladderTop) {
        isLadderTop = ladderTop;
    }
}
