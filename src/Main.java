
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static Random rnd;       // Note: Do not change this line.
    public static Scanner scanner;  // Note: Do not change this line.
    public static void main(String[] args) throws IOException {

        rnd = new Random(42);

        //Die dieTest = new Die(8,-5);
       // System.out.println(dieTest.roll());
       // System.out.println(dieTest.roll());

/*
        int head = 8;
        int head2 = 9;
        int len = 5;

        GameBoard gb = new GameBoard();
        gb.addSnake(len,head);

        Snake snk = gb.getSnake(head);
        System.out.println("head " + snk.getHead());
        System.out.println("snk len " + snk.getLength());
        System.out.println("sqr snk " + gb.getSquare(head-1).isSnakeHead() + " i = " + gb.getSquare(head-1).getCoordinate());


        int ld_len = 6;
        int bottom = 9;
        int bottom2 = 9;
        gb.addLadder(ld_len, bottom);
        gb.addLadder(ld_len, bottom2);

        gb.addSnake(len,head2);
        Ladder ldr = gb.getLadder(bottom);
        System.out.println("bottom " + ldr.getBottom());
        System.out.println("ldr len " + ldr.getLength());
        System.out.println("sqr ldr " + gb.getSquare(bottom-1).isLadderBottom() + " i = " + gb.getSquare(bottom-1).getCoordinate());
*/

        SnakesAndLaddersGame gm = new SnakesAndLaddersGame();
        gm.addPlayer("John",Colors.BLUE);
        gm.addPlayer("Jill",Colors.BLUE);
        gm.addPlayer("Korra",Colors.RED);
        gm.addPlayer("Phill",Colors.GREEN);
        gm.addPlayer("Gigi",Colors.ORANGE);
        gm.addPlayer("Gob",Colors.YELLOW);
        gm.addPlayer("Huhu",Colors.RED);


        String winner = gm.start();

/*
        System.out.println(gm.players[0].getPlayerName());
        gm.players[0].setPieceLocation(5);
        gm.players[3].setPieceLocation(66);
        System.out.println(gm.players[0].getPieceLocation());
        System.out.println(gm.players[3].getPieceLocation());

 */
    }
}



/*
public class Main {
    public static Random rnd;       // Note: Do not change this line.
    public static Scanner scanner;  // Note: Do not change this line.
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\snika\\Desktop\\HW1_input.txt";
        scanner = new Scanner(new File(path));
        int numberOfGames = scanner.nextInt();

        for (int i = 1; i <= numberOfGames; i++) {
            int seed = scanner.nextInt();
            rnd = new Random(seed);
            scanner.nextLine();
            String lowerBoundString = scanner.nextLine();

            SnakesAndLaddersGame game;

            if (lowerBoundString.equals("NONE")) {
                game = new SnakesAndLaddersGame();
            } else {
                int lowerBound = Integer.parseInt(lowerBoundString);
                int upperBound = scanner.nextInt();
                scanner.nextLine();
                game = new SnakesAndLaddersGame(lowerBound, upperBound);
            }

            System.out.println("Game number " + i + " starts.");

            game.initializeGame();
            String winner = game.start();
            System.out.println("\n" + winner + " has won the game!");
            System.out.println("Game number " + i + " ended.");
            System.out.println("\n********************************************************************************\n");
        }
        System.out.println("All games are over.");

        // Test two dice
        Die die1 = new Die();
        Die die2 = new Die(21, 3);
    }
 }
 */

