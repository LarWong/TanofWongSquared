public class PlayerGrid{

  private int[][] field = new int[15][15];
  private int[][] markup = new int[15][15];
  private String _columns = "\t    01 02 03 04 05 06 07 08 09 10 11 12 13 14 15\n";
  private String[] _rows =
  {"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15"};
  private List<List<Integer>> restrictedArea = new Arraylist<List<Integer>>();

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

  public static boolean checkArea(int[] coord){

    if (!(coord[0] < 15 && coord[1] < 15 &&
        coord[0] >= 0 && coord[1] >= 0))
        {
          return false;
        }

    if (restrictedArea.size() > 0 &&){
      for (List<Integer> x : restrictedArea)
      {
        if (x.get(0) == coord[0] && x.get(1) == coord[1]){
          return false;
        }
      }
    }

    return true
  }

  public static boolean setLocation(Ship ship, int[] coord, String direction) {
    int[][] setHere = new int[ship.getSize()][2];
    //checking if ship os placed on a restricted area
    if (checkArea(coord) == false){
      return false;
    }
    for (int x = 0; x < ship.getSize(); x++){
      if (direction == "North"){
          int[] newCoords = {coord[0]-x , coord[1]};
          if (checkArea(NewCoords) == true){
            setHere[x][0] = newCoords[0];
            setHere[x][1] = newCoords[1];
          }else{
            return false
          }
          }
      if (direction == "South"){
          int[] newCoords = {coord[0]+x , coord[1]};
          if (checkArea(NewCoords) == true){
            setHere[x][0] = newCoords[0];
            setHere[x][1] = newCoords[1];
          }else{
            return false
          }
      }
      if (direction == "East"){
          int[] newCoords = {coord[0] , coord[1] + x};
          if (checkArea(NewCoords) == true){
            setHere[x][0] = newCoords[0];
            setHere[x][1] = newCoords[1];
          }else{
            return false
          }
      }
      if (direction == "North"){
          int[] newCoords = {coord[0] , coord[1] - x};
          if (checkArea(NewCoords) == true){
            setHere[x][0] = newCoords[0];
            setHere[x][1] = newCoords[1];
          }else{
            return false
          }
      }
    }
        ship.setLocation(setHere);

    }
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
