import cs1.Keyboard;

public class PlayerGrid{

  private int[][] field = new int[15][15];
  private int[][] markup = new int[15][15];
  private int[][] launches;
  private boolean hasLaunches = false;
  private String _columns = "\t    00 01 02 03 04 05 06 07 08 09 10 11 12 13 14\n";
  private String[] _rows =
  {"00","01","02","03","04","05","06","07","08","09","10","11","12","13","14"};

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
  }
  public void setAlive(String shipName){
    for (Ship vessel : ships){
      if (vessel.getName().equals(shipName)){
        vessel.setAlive();
      }
    }
  }

  public void setHasCoords(){
    hasCoords = true;
  }

  public  String toString(){
    int ctr = 0;
    String s = "The Markup Grid: \n" + _columns;

    for (int x = 0; x < 15; x++){
      s += "\t" + _rows[ctr];

      for (int y = 0; y < 15; y++){


        if (hasLaunches == true){



          for (int t = 0; t < launches.length; t++){


                if (launches[t][0] == x && launches[t][1] == y && launches[t][3] == -2){

                  s += "O"; //its a hit
                  placement = true;

                }else if (launches[t][0] == x && launches[t][1] == y){

                  s+= "X"; //its a miss
                  placement = true;

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

    placement = false;

    s+= "\nYour Playing Field\n";

    ctr = 0;
    s += _columns;

    for (int x = 0; x < 15; x++){
      s += "\t" + _rows[ctr];

      for (int y = 0; y < 15; y++){


        if (hasCoords == true){

          checkingShips:
          for (Ship vessel : ships){
            int[][] placingSymbols = vessel.getLocation();
            for (int row = 0; row < placingSymbols.length; row++){
              if (vessel.alive() == true && placingSymbols[row][0] == x && placingSymbols[row][1] == y){
                s += "  " + vessel.getSymbol();
                placement = true;
                break checkingShips;
              }
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

  //ships shooting
  public int[][] salvo(){

    int[][] salvo = new int[5][3];

    for (int r = 0; r < salvo.length; r++){
      for (int c = 0; c < 3; c ++){
        salvo[r][c] = -1;
      }
    }

    for (int shipNum = 0; shipNum < 5; shipNum++) {
      // Coordinates
      if (ships[shipNum].alive()){
        System.out.println(ships[shipNum].getName() + " is ready to fire!");
        System.out.println("Please enter a number from 0-14");

        System.out.println("Enter the row number (0-14):");
        salvo[shipNum][0] = Keyboard.readInt();

        while (salvo[shipNum][0] > 14 || salvo[shipNum][0] < 0) {
          System.out.println("INVALID ROW NUMBER");
          System.out.println("Enter the row number (0-14):");
          salvo[shipNum][0] = Keyboard.readInt();

        }

        System.out.println("Enter the column number (0-14):");
        salvo[shipNum][1] = Keyboard.readInt();

        while (salvo[shipNum][1] == - 1 || salvo[shipNum][1] > 14 || salvo[shipNum][1] < 0) {
          System.out.println("INVALID COLUMN NUMBER");
          System.out.println("Enter the column number (0-14):");
          salvo[shipNum][1] = Keyboard.readInt();


        }

        salvo[shipNum][2] = ships[shipNum].shoot();
        System.out.println("\n\n");
      }
    }

    return salvo;

  }

  public void hitsOrMiss(int[][] salvo){


    int alive = 0;

    for (int[] r : salvo){
      if (r[0] != -1 && r[1] != -1){
        alive++;
      }
    }

    int[][] shots = new int[alive][3];

    for (int r = 0; r < alive; r++){
      for (int c = 0; c < 3; c++){
        if (salvo[r][2] != -1){
          shots[r][c] = salvo[r][c];
      }
      }
    }

    for (Ship x : ships){
      if (x.alive()){
        int[][] shipCoords = x.getLocation();
        for (int r = 0; r < alive; r++){
          if (shipCoords[r][0] == shots[r][0] && shipCoords[r][1] == shots[r][1]){
              x.updateHealth(shots[r][2]);
              shots[r][2] = -2;
          }
        }

      }
    }
    hasLaunches = true;

    // for (int[] f : shots){
    //   for (int ds : f){
    //     System.out.println(ds);
    //   }
    // }

    launches = shots;
  }


  public void printShips(){
    for (Ship z : ships){
      System.out.println("-----------------------------\n");
      System.out.println(z.getName());
      System.out.println("Coordinates:");

      int[][] qwe = z.getLocation();
      for(int[] x : qwe){
        System.out.print("[ ");
        for(int y : x){
          System.out.print(y + " ");
        }
        System.out.print("]");
      }
      System.out.println("\nHealth:");
      System.out.println(z.getHealth());

      System.out.println("\n-----------------------------");

    }
  }

  public boolean checkArea(int[] coord){

    if (!(
    coord[0] < 15 && coord[1] < 15 &&
    coord[0] >= 0 && coord[1] >= 0))
    {

      return false;
    }

    for (Ship x : ships){
      if (x.alive()){
        int[][] shipCoords = x.getLocation();
        for (int[] loc : shipCoords){
          if (loc[0] == coord[0] && loc[1] == coord[1]){
            System.out.println("\nINVALID PLACEMENT (space occupied)");
            return false;
          }

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


    int[][] setHere = new int[currentShip.getSize()][2];
    int[] newCoords = new int[2];
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


    return currentShip.setLocation(setHere);

  }

  public boolean isAlive(){
    for (Ship s : ships) {
      if (s.alive() == true)
      return true;
    }
    return false;
  }

  public Ship[] getShips(){
    return ships;
  }


  public static void main (String [] args){
    PlayerGrid q = new PlayerGrid("Cool");
    System.out.println(q);
    q.printShips();




  }

}
