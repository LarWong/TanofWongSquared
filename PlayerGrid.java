public class PlayerGrid{

  private int[][] field = new int[15][15];
  private int[][] markup = new int[15][15];
  private String _columns = "\t    01 02 03 04 05 06 07 08 09 10 11 12 13 14 15\n";
  private String[] _rows =
  {"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15"};
  private int[][] restrictedArea = new int[20][20];
  private boolean hasRestrictions = false;
  private boolean placement = false;

  private String name = "";

  private Ship[] ships = new Ship[5];
  private boolean hasCoords = false;
  private Ship currentShip;

  public PlayerGrid(String n) {
    ships[0] = new AircraftCarrier();
    ships[1] = new Battleship();
    ships[2] = new Cruiser();
    ships[3] = new Destroyer();
    ships[4] = new Submarine();

    name = n;
    /* Debugging
    System.out.println(n);
    for (Ship s: ships) {
    System.out.println(s);
  }
  */
}

public  String toString(){
  int ctr = 0;
  String s = "The Markup Grid: \n" + _columns;

  for (int[] x : markup){
    s += "\t" + _rows[ctr];
    for (int y : x){
      s += "  ~";
    }
    ctr += 1;
    s+= "\n";
  }

  s+= "\nYour Playing Field\n";

  ctr = 0;
  s += _columns;

  for (int x = 0; x < 15; x++){
    s += "\t" + _rows[ctr];

    for (int y = 0; y < 15; y++){

      checkingShips:
      if (hasCoords == true){
        for (Ship vessel : ships){
          int[][] placingSymbols = vessel.getLocation();
          for (int row = 0; row < placingSymbols.length; row++){
            if (vessel.alive() && placingSymbols[row][0] == x && placingSymbols[row][1] == y){
              s += "  " + vessel.getSymbol();
              placement = true;
              break checkingShips;
            }
          }
        }
      }

      checkingRestricted:
      if (hasRestrictions == true){
        for (int[] restricted : restrictedArea){
          if (restricted[0] == x && restricted[1] == y){
            s += "  X";
            break checkingRestricted;
          }
        }
      }

      if (placement == false){
        s += "  ~";
      }
      placement = false;
    }
    ctr += 1;
    s+= "\n";
  }

  return s;
}

public boolean checkArea(int[] coord){

  if (!(coord[0] < 16 && coord[1] < 16 &&
  coord[0] >= 0 && coord[1] >= 0))
  {
    return false;
  }

  for (Ship x : ships){
    int[][] shipCoords = x.getLocation();
    for (int[] loc : shipCoords){
      if (loc[0] == coord[0] && loc[1] == coord[1]){
        return false;
      }

    }
  }

  if (restrictedArea.length > 0 ){
    for (int[] x : restrictedArea)
    {
      if (x[0] == coord[0] && x[1] == coord[1]){
        return false;
      }
    }
  }

  return true;
}

public boolean setLocation(String shipName, int[] coord, String direction) {
  for (Ship s: ships) {
    if (s.getName().equals(shipName)){
      currentShip = s;
    }
  }
  for (int v: coord) {
    System.out.println(v);
  }
  int[][] setHere = new int[currentShip.getSize()][2];
  int[] newCoords = new int[2];
  //checking if ship is placed on a restricted area
  if (checkArea(coord) == false){
    return false;
  }
  for (int x = 0; x < currentShip.getSize(); x++){
    if (direction.equals("North")){
      newCoords[0] = coord[0] - x;
      newCoords[1] = coord[1];
      if (checkArea(newCoords) == true){
        setHere[x][0] = newCoords[0];
        setHere[x][1] = newCoords[1];
      }else{
        return false;
      }
    }
    if (direction.equals("South")){
      newCoords[0] = coord[0] + x;
      newCoords[1] = coord[1];
      if (checkArea(newCoords) == true){
        setHere[x][0] = newCoords[0];
        setHere[x][1] = newCoords[1];
      }else{
        return false;
      }
    }
    if (direction.equals("East")){
      newCoords[0] = coord[0];
      newCoords[1] = coord[1] + x;
      if (checkArea(newCoords) == true){
        setHere[x][0] = newCoords[0];
        setHere[x][1] = newCoords[1];
      }else{
        return false;
      }
    }
    if (direction.equals("West")){
      newCoords[0] = coord[0];
      newCoords[1] = coord[1] - x;
      if (checkArea(newCoords) == true){
        setHere[x][0] = newCoords[0];
        setHere[x][1] = newCoords[1];
      }else{
        return false;
      }
    }
  }
  for (int v: newCoords) {
    System.out.println(v);
  }
  return currentShip.setLocation(setHere);

}

    public boolean isAlive(){
	for (Ship s : ships) {
	    if (s.alive() == false)
		return false;
	}
	return true;
    }

    public Ship[] getShips(){
	return ships;
    }
    
/**
public static String printField;
public static String printMarkup;
public static void markMiss;
public static void markClear;
public static void update;
***/

public static void main (String [] args){
  PlayerGrid q = new PlayerGrid("Cool");
  System.out.println(q);



}

}
