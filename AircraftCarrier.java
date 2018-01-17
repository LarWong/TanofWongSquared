public class AircraftCarrier extends Ship
{

    /*=============================================
      default constructor
      pre:  instance vars are declared
      post: initializes instance vars.
      =============================================*/
    public AircraftCarrier()
    {
	super();
	health = 150;
	attack = 40;
	defense = 10;
	movement = 4;
	size = 5;
	coords = new int[5][2];
	symbol = "A";
	name = "AircraftCarrier";
  
    }
}
