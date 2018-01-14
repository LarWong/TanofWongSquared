public class Cruiser extends Ship
{

    /*=============================================
      default constructor
      pre:  instance vars are declared
      post: initializes instance vars.
      =============================================*/
    public Cruiser()
    {
	super();
	health = 100;
	attack = 50;
	defense = 20;
	movement = 5;
	size = 3;
    }

    public void ability(){
	System.out.println("The Cruiser increases its attack");
    }
}
