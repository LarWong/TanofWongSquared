public class ShipTestDriver {
    public static void main (String [] args) {
	Ship submarine = new Submarine();
	System.out.println(submarine.getHealth());
	Ship[] Ships = new Ship[5];
	Ships[0] = submarine;
	System.out.println(Ships[0].getHealth());
	
    }
}
