import java.util.Objects;

public class SnakesAndLaddersGame {
    private final static int MAX_PLAYERS = 5;
    private final static int LAST_SQUARE = 100;

    private Die die;
    private GameBoard gameBoard = new GameBoard();
    public Player[] players = new Player [MAX_PLAYERS];
    private int countPlayers = 0;
    private String[] takenNames = new String[MAX_PLAYERS];
    private Colors[] takenColors = new Colors[MAX_PLAYERS];


    public SnakesAndLaddersGame(int min, int max){
        this.die = new Die(max, min);
    }
    public SnakesAndLaddersGame(){
        this.die = new Die();
    }

    public void addPlayer(String name, Colors color){
        if(countPlayers == 5) {
            System.out.println("The maximal number of players is five!");
            return;
        }
        for(int i = 0; i < MAX_PLAYERS; i++) {
            for(int j = 0; j < MAX_PLAYERS; j++) {
                if(Objects.equals(name, takenNames[i]) && color == takenColors[j]) {
                    System.out.println("The name and the color are already taken!");
                    return;
                }
                if(Objects.equals(name, takenNames[i])) {
                    System.out.println("The name is already taken!");
                    return;
                }
                if(color == takenColors[j]) {
                    System.out.println("The color is already taken!");
                    return;
                }
            }
        }
        players[countPlayers] = new Player(name, color);
        takenNames[countPlayers] = name;
        takenColors[countPlayers] = color;
        countPlayers++;
    }
    public void initializeGame(){
        System.out.println("Initializing the game...");
        while(true) {
            String[] input = new String[4]; //check
            String stringInput = Main.scanner.nextLine();
            input = stringInput.split(" ");
            if (stringInput.equals("end")) {
                if (countPlayers < 2) {
                    System.out.println("Cannot start the game, there are less than two players!");
                    continue;
                }
                else return;
            }
            if (input[1].equals("player")) {
                Colors color = stringToColor(input[3]);
                addPlayer(input[2], color);
            }
            else if (input[1].equals("ladder")) {
                int len = Integer.parseInt(input[2]);
                int squareNumber = Integer.parseInt(input[3]);
                gameBoard.addLadder(len, squareNumber);
            }
            else if (input[1].equals("snake")) {
                int len = Integer.parseInt(input[2]);
                int squareNumber = Integer.parseInt(input[3]);
               gameBoard.addSnake(len, squareNumber);
            }
        }

        }

    private Colors stringToColor(String colorName){
        Colors color = null;
        switch (colorName) {
            case "red":
                color = Colors.RED;
                break;
            case "yellow":
                color = Colors.YELLOW;
                break;
            case "green":
                color = Colors.GREEN;
                break;
            case "blue":
                color = Colors.BLUE;
                break;
            case "orange":
                color = Colors.ORANGE;
                break;
        }
        return color;
    }

    private void printPlayersPositions(){
        System.out.println("\n" + "Players positions on the board:");
        for(int i = 0; i < countPlayers; i++)
        {
            System.out.println(players[i].getPlayerName() + " is in square number " + players[i].getPieceLocation());
        }
    }
    private void printPath(int before, int after){
        System.out.println("The path to the next square: " + before +
                " -> " + after);
    }

    public String start(){
        boolean previousMove = false;
        int move = 0;
        int movesCounter = 1;
        while(true){
            System.out.println("------------------------- Round number "
                    + movesCounter + " -------------------------");
            movesCounter++;
            for(int i = 0; i < countPlayers; i++){
                if(!previousMove)
                {
                    int roll = Die.roll();
                    move = roll + players[i].getPieceLocation();
                    System.out.print(players[i].getPlayerName() + " rolled " + roll +". " );
                }
                else {
                    previousMove = false;
                }
                if(move  == LAST_SQUARE){
                    printPath(players[i].getPieceLocation(), LAST_SQUARE);
                    players[i].setPieceLocation(move);
                    printPlayersPositions();
                    return players[i].getPlayerName();
                }
                else if (move > LAST_SQUARE) {
                    int back = move - LAST_SQUARE;
                    move = LAST_SQUARE - back;
                    printPath(players[i].getPieceLocation(), LAST_SQUARE - back);
                    players[i].setPieceLocation(move);
                //    previousMove = true;
                //    i--;
                }
                else if(gameBoard.isLadder(move-1)){
                   Ladder ladder = gameBoard.getLadder(move);
                   int len = ladder.getLength();
                    move = move + len;
                    players[i].setPieceLocation(move);
                    previousMove = true;
                    i--;
                }
                else if(gameBoard.isSnake(move-1)){
                    Snake snake = gameBoard.getSnake(move);
                    int len = snake.getLength();
                    move = move - len;
                    players[i].setPieceLocation(move);
                    previousMove = true;
                    i--;
                }
                else if ((move )<1) {
                    printPath(players[i].getPieceLocation(), 1);
                    players[i].setPieceLocation(1);
                }
                else if(move < LAST_SQUARE && move > 1) {
                    printPath(players[i].getPieceLocation(), move);
                    players[i].setPieceLocation(move);
                }
            }
            printPlayersPositions();
        }
    }
}
