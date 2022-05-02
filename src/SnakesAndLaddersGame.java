public class SnakesAndLaddersGame {
    private final static int MAX_PLAYERS = 5;

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
                if(name == takenNames[i] && color == takenColors[j]) {
                    System.out.println("The name and the color are already taken!");
                    return;
                }
                if(name == takenNames[i]) {
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
        return;
    }

    public void initializeGame(){
        GameBoard gameBoard = new GameBoard();
    }

    public String start(){

        return "Winners Name";
    }

}
