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

    public String getName(){
	return name;
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

    public void setLocation(int[][] loc){
      for (int r = 0; r < size; r++){
        for (int c = 0; c < 2; c++){
          coords[r][c] =loc[r][c];
        }
      }

    }

    public abstract void ability();

    public void updateHealth(int damage){
	health = health - damage;
    }

}
