public class Submarine extends Ship
{

    /*=============================================
      default constructor
      pre:  instance vars are declared
      post: initializes instance vars.
      =============================================*/
    public Submarine()
    {
	super();
	health = 50;
	attack = 60;
	defense = 5;
	movement = 6;
	size = 3;
  symbol = "S";
    }

    public void ability(){
	System.out.println("No abilities");
	// Requires implementation
    }
}
