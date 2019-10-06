/*
 * Matt Jankowski
 * AI (CS 411) Hw 5
 * 15 puzzle IDDFS - IDDFS Class
 * To God be the Glory
 */

//IDDFS => "Iterative Deepening Depth First Search".
public class IDDFS{

    private double infinity = Double.POSITIVE_INFINITY;

    public IDDFS(int[] initial_board) {
        for (int limit = 0; limit < infinity; limit++){
            //System.out.println("LIMIT: " + limit);
            new DLS(initial_board, limit); //conduct DLS on increasing limit levels
        }
    }

}