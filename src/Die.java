public class Die {
  private static int min;
  private static int max;

    /**
     * This constructor sets
     * the minimum and the maximum
     * values for the die
     *
     * @param max
     * @param min
     */
    public Die(int max,int min){
        this.min = min;
        this.max = max;
    }

    /**
     * If we did not receive the values
     * of minimum and maximum from the
     * user his constructor sets their
     * values to 1 and 6
     */
    public Die(){
        this(6,1);
    }

    /**
     *
     * @return the random value
     * which we received from the die
     */
    public static int roll(){
        int random = Main.rnd.nextInt(max-min+1);
        return random+min;
    }
}
