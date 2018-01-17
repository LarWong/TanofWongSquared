import java.io.*;
import java.util.*;
import cs1.Keyboard;

public class Woo{

  // INSTANCE VARIABLES
  private static PlayerGrid Grid0, Grid1;
  private static String[] shipNames = {"AircraftCarrier","Battleship","Cruiser","Destroyer","Submarine"};
  private static int rounds = 1;


  // Reinitializes instance variables

  //takes in user input for coordinates
  public static int[] inputCoords(String shipName){

    int[] coordinates = new int[2];

    System.out.println("Please provide starting coordinates for " + shipName);
    System.out.println("Please enter a number from 0-14");

    System.out.println("Enter the row number (0-14):");
    coordinates[0] = Keyboard.readInt();

    while (coordinates[0] > 14 || coordinates[0] < 0) {
      System.out.println("INVALID ROW NUMBER");
      coordinates[0] = Keyboard.readInt();
    }

    System.out.println("Enter the column number (0-14):");
    coordinates[1] = Keyboard.readInt();

    while (coordinates[1] > 14 || coordinates[1] < 0) {
      System.out.println("INVALID COLUMN NUMBER");
      coordinates[1] = Keyboard.readInt();
    }
    return coordinates;
  }

  //takes in user inputs for direction
  public static String inputDirection(String shipName){
    String orientation = "";

    while (!(orientation.equals("North") || orientation.equals("South") || orientation.equals("East") || orientation.equals("West"))) {
      System.out.println("Please provide the orientation of the " + shipName );
      System.out.println("Where the body is pointing : (North, South, East or West): ");
      orientation = Keyboard.readString();
      if (!(orientation.equals("North") || orientation.equals("South") || orientation.equals("East") || orientation.equals("West"))) {
        System.out.println("INVALID ORIENTATION");
      }
    }
    return orientation;
  }

  // SHIP PLACEMENT
  public static void promptShipPlacement(PlayerGrid current, String shipName){

    boolean canDo = false;


    while (!canDo){
      int[] z = inputCoords(shipName);
      String q = inputDirection(shipName);
      current.setAlive(shipName);
      canDo = current.setLocation(shipName,z,q);
    }

  } // end promptShipPlacement

  public static void promptWhichShip(PlayerGrid current) {
    String shipName = "";
    System.out.println("Please specify which ship you would like to move: ");
    shipName = Keyboard.readString();
    while (!(shipName.equals("AircraftCarrier") || shipName.equals("Battleship") || shipName.equals("Cruiser") || shipName.equals("Destroyer") || shipName.equals("Submarine"))) {
      System.out.println("INVALID SHIP NAME");
      System.out.println("Please specify which ship you would like to move: ");
      shipName = Keyboard.readString();
    }
    promptShipPlacement(current, shipName);
  }

  //to clear screen for next player
  public static void promptPlayerSwitch() {

    // State that player's turn has been completed
    System.out.println("Your turn has ended");

    System.out.print("Enter any key to confirm this is the next player");
    String happy = Keyboard.readString();
    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
  }

  //basic information for the user
  public static void tutorial() {
    System.out.println("\n~~~~~~~~~~~~~~~~~~TUTORIAL~~~~~~~~~~~~~~~~~~");
    System.out.println("Welcome to Battleship Warfare!");
    System.out.println("Here are some info and rules before you start:\n");
    System.out.println("1. The battlefield will be represented by a 15x15 array. The sea will be represented by a \"~\" and the types of ship which are the Aircraft Carrier, Battleship, Destroyer, Cruiser, and Submarine will be represented by \"A\", \"B\", \"D\", \"C\", and \"S\" respectively.\n");
    System.out.println("2. You will be told if your shots hit. If a ship dies, its body occupied the land, represented by an X.");
    System.out.println("Now onto the types of ship:\n");
    System.out.println("The Aircraft Carrier will be the an very important asset to lead you to victory. Although it is vulnerable and large target, it could find a row with one or more of your enemy's vessels. USE IT WISELY!\n");
    System.out.println("The Battleship although slow, makes up for it with its incredible defense. And if it is not enough, then guess what you increase your defense even more.\n");
    System.out.println("The Destroyer is a small ship and it may seem weak but don't let that fool you. It can change the impact of the game by firing twice one round but only once!\n");
    System.out.println("The Cruiser is a known as a \"jack of all trades\" but when needed it can increase its attack!\n");
    System.out.println("The Submarine is the \"glass cannon\" of your fleet. It hits hard but can't take that much in return. Make sure you protect it as it will be very costly if it is sunk!\n");
    System.out.println("AND OF COURSE NO CHEATING! THAT IS ALL! HAVE FUN AND GOOD LUCK!\n");
  }

//main loop
  public static void main(String[] args){
    //setup phase
    System.out.println("What is Player0's name?");
    String n0 = Keyboard.readString();
    System.out.println("\n\n");

    System.out.println("What is Player1's name?");
    String n1 = Keyboard.readString();
    System.out.println("\n\n\n\n");

    PlayerGrid Grid0 = new PlayerGrid(n0);
    PlayerGrid Grid1 = new PlayerGrid(n1);

    tutorial();

    //set up ships
    System.out.println(n0 + " Please setup your board");

    Grid0.setHasCoords();

    //loop thorugh all ships
    for (String shipName: shipNames) {
    Grid0.setAlive(shipName);
    promptShipPlacement(Grid0, shipName);
    System.out.println(Grid0);
    }

    Grid0.printShips();
    System.out.println(Grid0);

    promptPlayerSwitch();

    System.out.println(n1 + " Please setup your board");

    Grid1.setHasCoords();

    //loop thorugh all ships
    for (String shipName: shipNames) {
    Grid1.setAlive(shipName);
    promptShipPlacement(Grid1, shipName);
    System.out.println(Grid1);
    }
    Grid1.printShips();
    System.out.println(Grid1);

    promptPlayerSwitch();


    //main loop: Ship info > move ship if possible > print grid > shoot > switch and repeat

    while (Grid0.isAlive() && Grid1.isAlive()) {


      Grid0.printShips();
      //every 3 rounds player get a chance to move ships
      if (rounds % 3 == 0){
        promptWhichShip(Grid0);
      }
      System.out.println(Grid0);
      int[][] g0 = Grid0.salvo();
      Grid1.hitsOrMiss(g0);
      promptPlayerSwitch();


      Grid1.printShips();
      if (rounds % 3 == 0){
        promptWhichShip(Grid1);
      }
      System.out.println(Grid1);
      int[][] g1 = Grid1.salvo();
      Grid0.hitsOrMiss(g1);
      promptPlayerSwitch();

      rounds++;
    }

    if (Grid0.isAlive()){
      System.out.println("Winner: " + n0);
    }else{
      System.out.println("Winner: " + n1);
    }

  }

}
