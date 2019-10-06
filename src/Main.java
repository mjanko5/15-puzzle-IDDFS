/*
 * Matt Jankowski
 * AI (CS 411) Hw 5
 * 15 puzzle IDDFS - Main Class
 * To God be the Glory
 */

public class Main {

    public static long startingTime;

    public static void main(String[] args) {
        startingTime = System.currentTimeMillis();//get time at start of run
        //System.out.println("Starting 15 puzzle.");

        int initialBoard[] = new int[]{1, 0, 2, 4, 5, 7, 3, 8, 9, 6, 11, 12, 13, 10, 14, 15
        };

        //    ^^^ REPLACE INPUT HERE

        new IDDFS(initialBoard); //run IDDFS
    }
}