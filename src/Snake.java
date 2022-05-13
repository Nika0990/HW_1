/**
 *  Snake element of the game. Leads player from its head down to its tail.
 */
public class Snake {
    private int  length;
    private int head;

    /**
     * This constructor receives the two
     * parameters and sets the values
     * of head and length
     *
     * @param length length of the snake
     * @param head location of the snakes head
     */
    public Snake(int length, int head){
        this.length = length;
        this.head = head;

    }

    /**
     *
     * @return the coordinate
     * of the square which
     * contains the head
     * of the snake
     */
    public int getHead() {
        return head;
    }

    /**
     *
     * @return the length
     *      of the snake
     */
    public int getLength() {
        return length;
    }


}
