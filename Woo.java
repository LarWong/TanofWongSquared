public class Woo{
    // Player setup
    private static PlayerGrid Grid0, Grid1;
    private static Ship[] Player0Ships, Player1Ships;

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

    public static void main(String[] args){
	newRound();
	/* Debugging */
	System.out.println(Grid0);
	System.out.println(Grid1);
	for (Ship s: Player0Ships) {
	    System.out.println(s);
	}
	for (Ship s: Player1Ships) {
	    System.out.println(s);
	}
	// prompt each player to specify ship location
	// start game
	// ship movement
	// ability and shooting
	// field updates
	// repeat
    }
}
