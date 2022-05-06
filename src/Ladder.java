public class Ladder {
    private int length;
    private int bottom;

    /**
     *  This constructor receives the two
     *  parameters and sets the values
     *  of bottom and length
     * @param length
     * @param bottom
     */
    public Ladder(int length, int bottom){
        this.length = length;

        this.bottom = bottom;

    }

    /**
     *
     * @return the coordinate
     * of the square which
     * contains the bottom
     * of the ladder
     */
    public int getBottom() {
        return bottom;
    }

    /**
     *
     * @return the length
     * of the ladder
     */
    public int getLength() {
        return length;
    }

}
