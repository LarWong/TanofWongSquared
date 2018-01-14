public class Battleship extends Ship
{

    /*=============================================
      default constructor
      pre:  instance vars are declared
      post: initializes instance vars.
      =============================================*/
    public Battleship()
    {
	super();
	health = 125;
	attack = 50;
	defense = 40;
	movement = 4;
	size = 4;
  symbol = "B";
    }

    public void ability(){
	System.out.println("The Battleship increases defense");
	// Requires implementation
    }
}
