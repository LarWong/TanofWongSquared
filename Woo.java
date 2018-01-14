import java.io.*;
import java.util.*;
import cs1.Keyboard;

public class Woo{

    // INSTANCE VARIABLES
    private static PlayerGrid Grid0, Grid1 = new PlayerGrid();
    private static Ship[] Player0Ships, Player1Ships;

    private static String currPlayer;
    private static PlayerGrid currPlayerGrid;
    private static Ship[] currPlayerShips;

    private static InputStreamReader isr;
    private static BufferedReader in;

    // DEFAULLT CONSTRUCTOR
    public Woo() {
	isr = new InputStreamReader( System.in );
	in = new BufferedReader( isr );
	newRound();
    }

    // ROUND SETUP COMPONENTS
    // Instantiates and binds new empty grids
    private static void makeNewGrids(){
	Grid0 = new PlayerGrid();
	Grid1 = new PlayerGrid();
    }

    // Instantiates one set of ships
    private static Ship[] generateShips(){
	Ship[] ships = new Ship[5];
	ships[0] = new AircraftCarrier();
	ships[1] = new Battleship();
	ships[2] = new Cruiser();
	ships[3] = new Destroyer();
	ships[4] = new Submarine();
	return ships;
    }

    // Binds instance variable
    private static void makeNewShips(){
	Player0Ships = generateShips();
	Player1Ships = generateShips();
    }

    // Reinitializes instance variables
    private static void newRound(){
	makeNewGrids();
	makeNewShips();
    }

    // SHIP PLACEMENT
    private static void promptShipPlacement(String player, PlayerGrid playerC){
	currPlayer = player;
	if (currPlayer == "player0") {
	    currPlayerGrid = Grid0;
	    currPlayerShips = Player0Ships;
	}
	else {
	    currPlayerGrid = Grid1;
	    currPlayerShips = Player1Ships;
	}

	for (Ship s: currPlayerShips) {
      //used to determine if step is completed
      boolean next = false;
	    // Coordinates
	    int[] coordinates = new int[2];


	    try {
        while (next == false ||
        (coordinates[0] > 15 || coordinates[1] > 15)){
          System.out.print("Please provide starting coordinates for " + s + ": ");
          System.out.println("Please enter a number from 1-15");
          System.out.println("Enter the row number (1-15):");
		      coordinates[0] = Keyboard.readInt();
          System.out.println("Enter the column number (1-15):");
		      coordinates[1] = Keyboard.readInt();
          next = true;
        }
	    }
	    catch ( IOException e ) {
        System.out.println("Please enter a number from 1-15");
      }

      next = false;
	    // Orientation (Rotation)
	    String orientation = "";

	    try {
        while (next == false &&
        (orientation != "North" || orientation != "South" || orientation != "East" || orientation != "West")){
          System.out.print("Please provide the orientation of the " + s + "(North, South, East or West): ");
          orientation = Keyboard.readString();
          next = true;
        }

	    }
	    catch ( IOException e ) {
        System.out.println("Please enter a cardinal direction");
    }
    playerC.setLocation(s,coordinates,orientation);

}
    }

    private static void promptPlayerSwitch() {

    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

	// State that player's turn has been completed
	System.out.println("Your turn has ended");
	if (currPlayer == "player0") {
	    currPlayer = "player1";
	}
	else {
	    currPlayer = "player0";
	}

	// Prompt yes or no if players have switched
	System.out.print("Enter any key to confirm this is " + currPlayer);
	try {
	    in.readLine();
	}
	catch ( IOException e ) { };
    }

    public static void main(String[] args){
	Woo game = new Woo();
	/* Debugging
	   System.out.println(Grid0);
	   System.out.println(Grid1);
	   for (Ship s: Player0Ships) {
	   System.out.println(s);
	   }
	   for (Ship s: Player1Ships) {
	   System.out.println(s);
	   }
	*/

	// prompt each player to specify ship location
	// **requires implementation
	game.promptShipPlacement("player0");
	/* Debugging
	for (Ship s: currPlayerShips) {
	    System.out.println(s);
	}
	*/
	game.promptShipPlacement("player1");

	// start game
	// isAlive has not been implemented yet
	/*
	while (Grid0.isAlive() && Grid1.isAlive()) {
	    // ship movement
	    // ability and shooting
	    // field updates
	    // repeat
	}
	*/
    }
}
