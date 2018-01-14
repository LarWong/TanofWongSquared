public class PlayerGrid{

  private int[][] field = new int[15][15];
  private int[][] markup = new int[15][15];
  private String _columns = "\t    01 02 03 04 05 06 07 08 09 10 11 12 13 14 15\n";
  private String[] _rows =
  {"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15"};

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
/***
public static boolean placeShip(Ship ship, int[] coords, String direction) {

}
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
