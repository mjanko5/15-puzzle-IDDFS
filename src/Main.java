/*
 * Matt Jankowski
 * AI (CS 411) Hw 4
 * 15 puzzle BFS - Main Class
 * To God be the Glory
 */

public class Main {

    public static void main(String[] args) {
        System.out.println("Starting 15 puzzle.");

        int initialBoard[] = new int[]{
               // 1, 6, 3, 4, 5, 2, 0, 8, 9, 10, 7, 11, 13, 14, 15, 12
               //   5, 5, 5, 5, 5, 5, 0, 5, 5, 5, 5, 5, 5, 5, 5, 5
                //1, 0, 3, 4, 5, 2, 6, 8, 9, 10, 7, 11, 13, 14, 15, 12
               // 1, 2, 3, 4, 5, 6, 8, 0, 9, 11, 7, 12, 13, 10, 14, 15
               // 1, 0, 2, 4, 5, 7, 3, 8, 9, 6, 11, 12, 13, 10, 14, 15
                1, 2, 0, 4, 6, 7, 3, 8, 5, 9, 10, 12, 13, 14, 11, 15
                //1, 3, 4, 8, 5, 2, 0, 6, 9, 10, 7, 11, 13, 14, 15, 12  //PROBLEM WITH THIS ONE!
        };

        //    ^^^ REPLACE INPUT HERE

//        new DLS(initialBoard, 2);
        new IDDFS(initialBoard);

    }
}

