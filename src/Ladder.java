public class Ladder {
    private int length;
    private int bottom;

    public Ladder(int length, int bottom){
        this.length = length;

        this.bottom = bottom;

    }

    public int getBottom() {
        return bottom;
    }

    public void setBottom(int bottom) {
        this.bottom = bottom;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
