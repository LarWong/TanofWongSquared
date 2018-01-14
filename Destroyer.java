public class Destroyer extends Ship
{

    /*=============================================
      default constructor
      pre:  instance vars are declared
      post: initializes instance vars.
      =============================================*/
    public Destroyer()
    {
	super();
	health = 60;
	attack = 30;
	defense = 30;
	movement = 8;
	size = 2;
  coords = new int[2][2];
  symbol = "D";
  name = "Destroyer";
    }

    public void ability(){
	System.out.println("The destroyer can shoot twice once every game");
	// Requires implementation
    }
}
