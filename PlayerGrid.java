import cs1.Keyboard;

public class PlayerGrid{

  //INSTANCE VARIABLES
  private int[][] field = new int[15][15];
  private String _columns = "\t    00 01 02 03 04 05 06 07 08 09 10 11 12 13 14\n";
  private String[] _rows =
  {"00","01","02","03","04","05","06","07","08","09","10","11","12","13","14"};

  private boolean placement = false;

  private String name = "";

  private Ship[] ships = new Ship[5];
  private boolean hasCoords = false;
  private Ship currentShip;

  //constructor
  public PlayerGrid(String n) {
    ships[0] = new AircraftCarrier();
    ships[1] = new Battleship();
    ships[2] = new Cruiser();
    ships[3] = new Destroyer();
    ships[4] = new Submarine();

    name = n;
  }
  //see if a ship is alive
  public void setAlive(String shipName){
    for (Ship vessel : ships){
      if (vessel.getName().equals(shipName)){
        vessel.setAlive();
      }
    }
  }

  //if a ship has manually set coordinates
  public void setHasCoords(){
    hasCoords = true;
  }

  //override toString
  public  String toString(){

    int ctr = 0;
    String s = "";
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
              if (vessel.getPlaced() == true && placingSymbols[row][0] == x && placingSymbols[row][1] == y){
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
    System.out.println("It's " + name + "'s turn:");
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

  //Calculate hot or miss
  public void hitsOrMiss(int[][] salvo){

    System.out.println("Your shots: ");
    for (int[] x : salvo){
      if (x[0] != -1){
      System.out.println("[" + x[0] + "," + x[1] + "]");
      }
    }

    for (Ship x : ships){
      if (x.alive()){
        int[][] shipCoords = x.getLocation();

        for (int r = 0; r < shipCoords.length; r++){
          for (int c = 0; c < salvo.length; c++){

          if (shipCoords[r][0] == salvo[c][0] && shipCoords[r][1] == salvo[c][1]){
            System.out.println("It's a hit at: [" + shipCoords[r][0] + "," + shipCoords[r][1] + "]");
              x.updateHealth(salvo[c][2]);
          }
        }
      }

      }
    }
  }

 //print ship location and health
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

      System.out.println("\nStatus:\nAlive?:");
      System.out.println(z.alive());

      System.out.println("\nHealth:");
      System.out.println(z.getHealth());

      System.out.println("\n-----------------------------");

    }
  }

  //check if a ship can be placed here
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

//setting a ship's location
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

    currentShip.placed();
    return currentShip.setLocation(setHere);

  }

//checks if game continues
  public boolean isAlive(){
    for (Ship s : ships) {
      if (s.alive() == true)
      return true;
    }
    return false;
  }

//returns a copy of all ships
  public Ship[] getShips(){
    return ships;
  }

//main method
  public static void main (String [] args){
  }

}
