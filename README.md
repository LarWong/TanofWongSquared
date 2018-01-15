# TanofWongSquared
# Stefan Tan, Larry Wong, Richard Wong
Repo of the project, by the project, and for the project

# General Description
  Our project is a modified version of Battleship. It follows all the rules to regular Battleship with some additions. These additions are: each ship has stats and special abilities, ship movement, a bigger playing field, and modifications to the playing field throughout the game. Each player will control their fleet in order to sink the opponents's ships.
  
  Each player will receive a 15x15 grid to place their vessels. The vessels are Aircraft Carrier, Battleship, Destroyer, Submarine, and Cruiser. They will only recieve one of each type of vessel. This will be all done in the PlayerGrid class and the abstract class Ship and the subclasses of Ship.
  
  Once the everything is set up and both players are ready to play, each player will be prompted to either shoot a number of shots based on the number of their remaining ship or use their ability of a ship. Each player will be able to "markup" a grid to place shot locations (hit or miss). Players are allowed to move their ship for a distance based on their The game is over once all ships on one player’s grid have all sunk.
  
# Description of Classes
## * Woo Class  
- the driver of the whole project. It is in charge of running the codes from the other classes. Compile and run this class.
## * PlayerGrid Class 
- this class is in charge of making both the grid for the playing field for both players and also the grid that allows both players to keep track of their shots by marking up the grid.
## * Ship Class and its subclasses (AircraftCarrier, Battleship, Destroyer, Submarine, and Cruiser) 
- contains the stats of each ship as well as the abilities for each type of ship. 

# How to run this program
Once you have cloned this repo, you can run this program through the following terminal commands:
- $ *javac Woo.java*
- $ *java Woo*

Once you have entered these commands, the program should begin and you are prompted with a greeting. If this has not occured, then something is wrong with your cloned repo or your terminal commands. Follow the prompts that appear in the terminal to make enjoy our project to the full extent.


