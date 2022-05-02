public class GameBoard {
    private final static int BOARD_SIZE = 100;
    private Square gameBoard[] = new Square[BOARD_SIZE];
    private Snake snakes[] = new Snake [50];
    private Ladder ladders[] = new Ladder [50];
    private int numberOfSnakes = 0;
    private int numberOfLadders = 0;
    public GameBoard(){
        for(int i = 0; i< BOARD_SIZE; i++){
            gameBoard[i] = new Square(i+1);
        }
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
            numberOfSnakes++;
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
            numberOfLadders++;
        }
    }
}
