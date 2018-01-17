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

  //  public abstract void setLocation(int[][] coords);

  public boolean setLocation(int[][] loc){
    for (int r = 0; r < size; r++){
      for (int c = 0; c < 2; c++){
        coords[r][c] =loc[r][c];
      }
    }
    return true;

  }

  public abstract void ability();

  public int shoot(){
    int damage = (int)(Math.random() * 5 * attack);
    if ( damage < 0 )
      damage = 0;
    return damage;
  }

  public void updateHealth(int damage){
    health = health - (damage - defense);
    if (health <= 0)
      isAlive = false;
  }

}
