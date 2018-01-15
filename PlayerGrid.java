public class PlayerGrid{

  private int[][] field = new int[15][15];
  private int[][] markup = new int[15][15];
  private String _columns = "\t    01 02 03 04 05 06 07 08 09 10 11 12 13 14 15\n";
  private String[] _rows =
  {"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15"};
  private int[][] restrictedArea = new int[20][20];

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

    for (int[] x : field){
      s += "\t" + _rows[ctr];
      for (int y : x){
        s += "  ~";
      }
      ctr += 1;
      s+= "\n";
    }

    return s;
  }

  public boolean checkArea(int[] coord, Ship[] playerShips){

    if (!(coord[0] < 15 && coord[1] < 15 &&
        coord[0] >= 0 && coord[1] >= 0))
        {
          return false;
        }

    for (Ship x : playerShips){
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

  public boolean setLocation(Ship ship, int[] coord, String direction, Ship[] playerShips) {
    int[][] setHere = new int[ship.getSize()][2];
    int[] newCoords = new int[2];
    //checking if ship os placed on a restricted area
    if (checkArea(coord,playerShips) == false){
      return false;
    }
    for (int x = 0; x < ship.getSize(); x++){
      if (direction == "North"){
          newCoords[0] = coord[0] - x;
	  newCoords[1] = coord[1];
          if (checkArea(newCoords,playerShips) == true){
            setHere[x][0] = newCoords[0];
            setHere[x][1] = newCoords[1];
          }else{
            return false;
          }
          }
      if (direction == "South"){
          newCoords[0] = coord[0] + x;
	  newCoords[1] = coord[1];
          if (checkArea(newCoords,playerShips) == true){
            setHere[x][0] = newCoords[0];
            setHere[x][1] = newCoords[1];
          }else{
            return false;
          }
      }
      if (direction == "East"){
          newCoords[0] = coord[0];
	  newCoords[1] = coord[1] + x;
          if (checkArea(newCoords,playerShips) == true){
            setHere[x][0] = newCoords[0];
            setHere[x][1] = newCoords[1];
          }else{
            return false;
          }
      }
      if (direction == "West"){
          newCoords[0] = coord[0];
	  newCoords[1] = coord[1] - x;
          if (checkArea(newCoords,playerShips) == true){
            setHere[x][0] = newCoords[0];
            setHere[x][1] = newCoords[1];
          }else{
            return false;
          }
      }
    }
        return ship.setLocation(setHere);

    }

    /**
    public static String printField;
    public static String printMarkup;
    public static void markMiss;
    public static void markClear;
    public static void update;
    ***/

    public static void main (String [] args){
      PlayerGrid q = new PlayerGrid();
      System.out.println(q);



    }

  }
