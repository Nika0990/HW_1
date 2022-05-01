public class Die {
  private int min;
  private int max;

    Die(int max,int min){
        this.min = min;
        this.max = max;
    }
    Die(){
        this(6,1);
    }
    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }
}
