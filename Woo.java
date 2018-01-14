import java.io.*;
import java.util.*;

public class Woo{
    
    // INSTANCE VARIABLES
    private static PlayerGrid Grid0, Grid1;
    private static Ship[] Player0Ships, Player1Ships;

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
    private static void promptShipPlacement(String player){
	if (player == "player0") {
	    currPlayerGrid = Grid0;
	    currPlayerShips = Player0Ships;
	}
	else {
	    currPlayerGrid = Grid1;
	    currPlayerShips = Player1Ships;
	}

	for (Ship s: currPlayerShips) {
	    // Coordinates
	    String coordinates = "";
	    System.out.print("Please provide starting coordinates for " + s + ": ");

	    try {
		coordinates = in.readLine();
	    }
	    catch ( IOException e ) { }

	    // Orientation (Rotation)
	    String orientation = "";
	    System.out.print("Please provide the orientation of the " + s + ": ");

	    try {
		orientation = in.readLine();
	    }
	    catch ( IOException e ) { }
	}
	promptPlayerSwitch();
    }

    private static void promptPlayerSwitch() {
	// Clear console?
	// State that player's turn has been completed
	// Prompt yes or no if players have switched
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
