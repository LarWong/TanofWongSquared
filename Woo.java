public class Woo{
    // Player setup
    PlayerGrid Grid0 = new PlayerGrid();
    PlayerGrid Grid1 = new PlayerGrid();
	
    Ship[] Player0Ships = new Ship[5];
    Player0Ships[0] = new AircraftCarrier();
    Player0Ships[1] = new Battleship();
    Player0Ships[2] = new Cruiser();
    Player0Ships[3] = new Destroyer();
    Player0Ships[4] = new Submarine();
        
    Ship[] Player1Ships = new Ship[5];
    Player1Ships[0] = new AircraftCarrier();
    Player1Ships[1] = new Battleship();
    Player1Ships[2] = new Cruiser();
    Player1Ships[3] = new Destroyer();
    Player1Ships[4] = new Submarine();

    public static void main(String[] args){
	// prompt each player to specify ship location
	// start game
	// ship movement
	// ability and shooting
	// field updates
	// repeat
    }
}
