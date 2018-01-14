public class Woo{
    
    // Player setup
    private static PlayerGrid Grid0, Grid1;
    private static Ship[] Player0Ships, Player1Ships;

    // Keep track of current grid
    private static PlayerGrid currPlayerGrid;
    private static Ship[] currPlayerShips;
    
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

    private static void promptShipPlacement(String player){
	if (player == "player0") {
	    currPlayerGrid = Grid0;
	    currPlayerShips = Player0Ships;
	}
	else {
	    currPlayerGrid = Grid1;
	    currPlayerShips = Player0Ships;
	}
	//if player0, use player0 grid and ships
	//else if player1, use player1 grid and ships
    }
    
    public static void main(String[] args){
	newRound();
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
	promptShipPlacement("Player0");
	/* Debugging
	for (Ship s: currPlayerShips) {
	    System.out.println(s);
	}
	*/
	
	promptShipPlacement("Player1");

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
