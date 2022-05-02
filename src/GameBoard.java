public class GameBoard {
    private final static int BOARD_SIZE = 100;
    private Square gameBoard[] = new Square[BOARD_SIZE];
    private Snake snakes[] = new Snake [50];
    private Ladder ladders[] = new Ladder [50];
    private int numberOfSnakes = 0;
    private int numberOfLadders = 0;
    public GameBoard(){
        for(int i = 0; i<BOARD_SIZE; i++){
            gameBoard[i] = new Square(i);
        }
    }
    public void addSnake(int tail, int head){
        snakes [numberOfSnakes] = new Snake(tail, head);
        gameBoard [head].setSnakeHead(true);
        gameBoard [tail].setSnakeTail(true);
        numberOfSnakes++;
    }
    public void addLadder(int top, int bottom){
        ladders [numberOfLadders] = new Ladder(top, bottom);
        gameBoard [bottom].setLadderBottom(true);
        gameBoard [top].setLadderTop(true);
        numberOfLadders++;
    }
}
