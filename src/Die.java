public class Die {
  private static int min;
  private static int max;

    public Die(int max,int min){
        this.min = min;
        this.max = max;
    }
    public Die(){
        this(6,1);
    }
    public static int roll(){
        int random = Main.rnd.nextInt(max-min+1);
        return random+min;
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
