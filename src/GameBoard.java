public class GameBoard {
    private final static int BOARD_SIZE = 100;

    private final Square [] gameBoard = new Square[BOARD_SIZE];
    private final Snake []snakes = new Snake [BOARD_SIZE];
    private final Ladder [] ladders = new Ladder [BOARD_SIZE];
    private int numberOfSnakes = 0;
    private int numberOfLadders = 0;

    public GameBoard(){
        for(int i = 0; i< BOARD_SIZE; i++){
            gameBoard[i] = new Square(i+1);
        }
    }
    public Square getSquare(int i){
        return  gameBoard[i];
    }
    public void addSnake(int length, int head){
        if(head<=0 || head > BOARD_SIZE) {
            System.out.println("The square is not within the board's boundaries!");
        }
        else if(head == BOARD_SIZE){
            System.out.println("You cannot add a snake in the last square!");
        }
        else if ((head - length) <= 0){
            System.out.println("The snake is too long!");
        }
        else if (gameBoard[head-1].isSnakeHead()){
            System.out.println("This square contains a head of a snake!");
        }
        else if (gameBoard[head-1].isLadderBottom()){
            System.out.println("This square already contains a bottom of a ladder!");
        }
        else {
            snakes[numberOfSnakes] = new Snake(length, head);
            gameBoard[head-1].setSnakeHead(true);
            ++numberOfSnakes;
            gameBoard[head].setSnakeHead(true);
        }

    }

    public void addLadder(int length, int bottom){
        if(bottom<=0 || bottom > BOARD_SIZE) {
            System.out.println("The square is not within the board's boundaries!");
        }
        else if ((bottom + length) >= BOARD_SIZE){
            System.out.println("The ladder is too long!");
        }
        else if (gameBoard[bottom-1].isLadderBottom()){
            System.out.println("This square already contains a bottom of a ladder!");
        }
        else if (gameBoard[bottom-1].isSnakeHead()){
            System.out.println("This square contains a head of a snake!");
        }
        else{
            ladders[numberOfLadders] = new Ladder(length, bottom);
            gameBoard[bottom-1].setLadderBottom(true);
            ++numberOfLadders;
            gameBoard[bottom].setLadderBottom(true);
        }
    }
    public Snake getSnake(int head){
        for(int i = 0;i<numberOfSnakes;i++){
            if(head == snakes[i].getHead()){
                return snakes[i];
            }
        }
        return null;
    }
    public Ladder getLadder(int bottom){
        for(int i = 0;i<numberOfLadders;i++){
            if(bottom == ladders[i].getBottom()){
                return ladders[i];
            }
        }
        return null;
    }
    public boolean isSnake(int i){
    return gameBoard[i].isSnakeHead();
    }
    public boolean isLadder(int i){
        return gameBoard[i].isLadderBottom();
    }
}
