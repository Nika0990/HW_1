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
            for (int j = 0; j < MAX_PLAYERS; j++) {
                if (Objects.equals(name, takenNames[i]) && color == takenColors[j]) {
                    System.out.println("The name and the color are already taken!");
                    return;
                }
            }
        }
        for(int i = 0; i < MAX_PLAYERS; i++) {
            for (int j = 0; j < MAX_PLAYERS; j++) {
                if (Objects.equals(name, takenNames[i])) {
                    System.out.println("The name is already taken!");
                    return;
                }
                if (color == takenColors[j]) {
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
                else {
                    arrangePlayers();
                    return;
                }
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

    private int compareNames(String name1, String name2) {
        for (int i = 0; i < name1.length() && i < name2.length(); i++) {
            if ((int) name1.charAt(i) == (int) name2.charAt(i)) {
                continue;
            } else {
                return (int) name1.charAt(i) - (int) name2.charAt(i);
            }
        }
        if (name1.length() != name2.length()) {
            return (name1.length() - name2.length());
        }
        return 0;
    }

    private void swapPlayers(int index1, int index2){
        String namePlaceHolder = players[index1].getPlayerName();
        Colors colorPlaceHolder = players[index1].getPieceColor();

        players[index1].setPlayerName(players[index2].getPlayerName());
        players[index1].setPieceColor(players[index2].getPieceColor());

        players[index2].setPlayerName(namePlaceHolder);
        players[index2].setPieceColor(colorPlaceHolder);
    }

    private void arrangePlayers(){
        for(int i = 0; i < countPlayers; i++) {
            for(int j = 0; j < countPlayers - i - 1; j++) {
                int order = compareNames(players[j].getPlayerName(), players[j+1].getPlayerName());
                if (order > 0) {
                    swapPlayers(j, j+1);
                }
            }
        }
    }

    private int checkIfSnakeOrLadder(int location, int i){
        int newLocation = location;
        if(gameBoard.isLadder(location-1)) {
            Ladder ladder = gameBoard.getLadder(location);
            int len = ladder.getLength();
            newLocation = location + len;
        }
        if(gameBoard.isSnake(location-1)) {
            Snake snake = gameBoard.getSnake(location);
            int len = snake.getLength();
            newLocation = location - len;
        }
        return newLocation;
    }

    public String start() {
        int move = 0;
        int movesCounter = 1;
        while(true) {
            System.out.println("------------------------- Round number "
                    + movesCounter + " -------------------------");
            movesCounter++;
            for(int i = 0; i < countPlayers; i++){
                int roll = Die.roll();
                move = roll + players[i].getPieceLocation();

                System.out.print(players[i].getPlayerName() + " rolled " + roll +". " );
                System.out.print("The path to the next square: " + players[i].getPieceLocation());

                if (move > LAST_SQUARE) {
                    int back = move - LAST_SQUARE;
                    move = LAST_SQUARE - back;
                    players[i].setPieceLocation(move);
                    System.out.print(" -> " + players[i].getPieceLocation());
                }
                else if (move < 1) {
                    move = 1;
                    players[i].setPieceLocation(move);
                    System.out.print(" -> " + players[i].getPieceLocation());
                }
                else if(move < LAST_SQUARE && move >= 1) {
                    players[i].setPieceLocation(move);
                    System.out.print(" -> " + players[i].getPieceLocation());
                }
                else if(move  == LAST_SQUARE){
                    players[i].setPieceLocation(move);
                    System.out.println(" -> " + players[i].getPieceLocation());
                    printPlayersPositions();
                    return players[i].getPlayerName();
                }

                while ( gameBoard.isLadder(move-1) || gameBoard.isSnake(move-1) ){
                    move = checkIfSnakeOrLadder(move, i);
                    players[i].setPieceLocation(move);
                    System.out.print(" -> " + players[i].getPieceLocation());
                    if(players[i].getPieceLocation() == LAST_SQUARE) {
                        System.out.println();
                        printPlayersPositions();
                        return players[i].getPlayerName();
                    }
                }
                System.out.println();
            }
            printPlayersPositions();
        }
    }

}
