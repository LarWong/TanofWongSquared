public class PlayerGrid{

    private int[][] field;
    private int[][] markup;

    public static String toString(){
	String s =
	    "\t01 02 03 04 05 06 07 08 09 10 11 12 13 14 15 16 17 18 19 20\n";
	int ctr = 1;
	
	for (int[] x : field){
	    s += "  " + ctr + " "; 
	    for (int y : x){
		s += " ~";
	    }
	    s += " \t";
	    for (
	}


    }






}
