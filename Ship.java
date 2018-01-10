public abstract class Ship{
    private boolean isAlive, recharging;
    protected double health;
    protected int attack, defense, movement, size, abCtr, roundLastUsed;
    protected int[][] coords;

    public Ship(){
	isAlive = true;
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

    public abstract void ability();

    public void updateHealth(int damage){
	health = health - damage;
    }

}

	
	
    
