/*
 * Matt Jankowski
 * AI (CS 411) Hw 4
 * 15 puzzle BFS - Main Class
 * To God be the Glory
 */

public class Main {

    public static void main(String[] args) {
        //System.out.println("Starting 15 puzzle.");

        int initialBoard[] = new int[]{
                1, 0, 3, 4, 5, 2, 6, 8, 9, 10, 7, 11, 13, 14, 15, 12
        };

        //    ^^^ REPLACE INPUT HERE

        new IDDFS(initialBoard);  //run BFS
    }
}

