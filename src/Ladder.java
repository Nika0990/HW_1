public class Ladder {
    private int length;
    private int bottom;

    public Ladder(int top, int bottom){
        this.length = top;

        this.bottom = bottom;

    }

    public int getBottom() {
        return bottom;
    }

    public void setBottom(int bottom) {
        this.bottom = bottom;
    }

    public int getTop() {
        return length;
    }

    public void setTop(int top) {
        this.length = top;
    }
}
