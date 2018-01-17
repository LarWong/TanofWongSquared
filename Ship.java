public abstract class Ship{
  private boolean isAlive = false;
  protected double health;
  protected int attack, defense, movement, size;
  protected int[][] coords;
  protected String symbol;
  protected String name;


  public boolean alive(){
    return isAlive;
  }

  public void setAlive(){
    for (int r = 0; r < coords.length; r++){
      for (int c = 0; c < 2; c++){
        coords[r][c] = -1;
      }
    }
    isAlive = true;
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


  public int shoot(){
    int damage = (int)(Math.random() * 2 * attack);
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
