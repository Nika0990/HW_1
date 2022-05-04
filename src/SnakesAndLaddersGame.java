import java.util.Objects;

public class SnakesAndLaddersGame {
    private final static int MAX_PLAYERS = 5;
    private final static int LAST_SQUARE = 100;

    private Die die;
    private GameBoard board;
    private Player[] players = new Player [MAX_PLAYERS];
    private int countPlayers = 0;
    private String[] takenNames = new String[MAX_PLAYERS];
    private Colors[] takenColors = new Colors[MAX_PLAYERS];

    public SnakesAndLaddersGame(int min, int max){
        this.die = new Die(max, min);
    }
    public SnakesAndLaddersGame(){
        this.die = new Die();
    }

    private void addPlayer(String name, Colors color){
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
        GameBoard gameBoard = new GameBoard();
        while(true) {
            String[] input = new String[4];
            String stringInput = Main.scanner.nextLine();
            input = stringInput.split(" ");
            if (input[0].equals("end")) {
                if (countPlayers < 2) {
                    System.out.println("Cannot start the game, there are less than two players!");
                    continue;
                }
                else return;
            }
            if (input[1].equals("player")) {
                Colors color = null; //check
                switch (input[3]) {
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
                addPlayer(input[2], color);
            }
            if (input[1].equals("ladder")) {
                int len = Integer.parseInt(input[2]);
                int squareNumber = Integer.parseInt(input[3]);
                gameBoard.addLadder(len, squareNumber);
            }
            if (input[1].equals("snake")) {
                int len = Integer.parseInt(input[2]);
                int squareNumber = Integer.parseInt(input[3]);
                gameBoard.addSnake(len, squareNumber);
            }
        }

        }


    public String start(){
        int move;
        while(true){
            for(int i = 0;i<countPlayers;i++){
                move = Die.roll();
                if(move + players[i].getPieceLocation() == LAST_SQUARE){
                    return players[i].getPlayerName();
                }
                else if ((move + players[i].getPieceLocation())<1) {
                    players[i].setPieceLocation(1);
                }
                else if ((move + players[i].getPieceLocation())>LAST_SQUARE) {
                    int back = move + players[i].getPieceLocation() - LAST_SQUARE;
                    players[i].setPieceLocation(LAST_SQUARE - back);
                }


            }


        }

    }

}
