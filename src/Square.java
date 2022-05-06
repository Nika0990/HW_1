/**
 *
 */
public class Square {
    private int coordinate;
    private boolean isSnakeHead;
    private boolean isLadderBottom;

    /**
     *This constructor sets
     * the coordinate of the square
     *
     * @param coordinate
     */
    public Square (int coordinate){
         this.coordinate = coordinate;
         isSnakeHead = false;
         isLadderBottom = false;

     }

    /**
     *
     * @return isSnakeHead
     * (true if the square contains
     * a snake head, otherwise
     * returns false)
     */
    public boolean isSnakeHead() {
        return isSnakeHead;
    }

    /**
     *This method sets the value of snake head
     *
     * @param snakeHead
     */
    public void setSnakeHead(boolean snakeHead) {
        isSnakeHead = snakeHead;
    }

    /**
     *
     * @return isLadderBottom
     * (true if the square contains
     * a ladder bottom, otherwise
     * returns false)
     */
    public boolean isLadderBottom() {
        return isLadderBottom;
    }

    /**
     *This method sets the value of ladder bottom
     *
     * @param ladderBottom
     */
    public void setLadderBottom(boolean ladderBottom) {
        isLadderBottom = ladderBottom;
    }
}
