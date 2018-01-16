public abstract class Ship{
    private boolean isAlive, recharging;
    protected double health;
    protected int attack, defense, movement, size, abCtr, roundLastUsed;
    protected int[][] coords;
    protected String symbol;
    protected String name;

    public Ship(){
	isAlive = true;
    }

    public boolean alive(){
	return isAlive;
    }
    
    public String getName(){
	return name;
    }

    public String getSymbol(){
      return symbol;
    }

    public double getHealth(){
	return health;
    }

    public int getAttack(){
	return attack;
    }

    public int getDefense(){
	return defense;
    }

    public int getMovement(){
	return movement;
    }

    public int getSize(){
	return size;
    }

    public int[][] getLocation(){
	return coords;
    }

<<<<<<< HEAD
    public abstract void setLocation(int[][] coords);
    
=======
    public boolean setLocation(int[][] loc){
      for (int r = 0; r < size; r++){
        for (int c = 0; c < 2; c++){
          coords[r][c] =loc[r][c];
        }
      }
      return true;

    }
>>>>>>> cc3afe038f9260951c8ce28c9fe43200f9828f9e

    public abstract void ability();

    public int shoot(Ship opponent){
	int damage = (int)(((Math.random() * 5) + attack) - opponent.getDefense());
	if ( damage < 0 )
	    damage = 0;
	opponent.updateHealth(damage);
	return damage;
    }

    public void updateHealth(int damage){
	health = health - damage;
	if (health <= 0)
	    isAlive = false;
    }
    
}
