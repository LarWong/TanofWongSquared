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
    }

    public void ability(){
	System.out.println("Returns a row number with one or more opponent vessels");
	// Requires implementation
    }	    	 
}
