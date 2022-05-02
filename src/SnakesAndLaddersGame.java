public class SnakesAndLaddersGame {
    private Die die;
    private GameBoard board;
    public SnakesAndLaddersGame(int min, int max){
        this.die = new Die(max, min);
    }
    public SnakesAndLaddersGame(){
        this.die = new Die();
    }

    public void initializeGame(){
        GameBoard gameBoard = new GameBoard();
    }
}
