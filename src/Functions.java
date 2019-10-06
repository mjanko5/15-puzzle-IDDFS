/*
 * Matt Jankowski
 * AI (CS 411) Hw 5
 * 15 puzzle IDDFS - Functions Class
 * To God be the Glory
 */


import java.util.ArrayList;

public class Functions {

    public static void printArray(String name, int[] array) {
        System.out.print(name + " = [");
        for (int i = 0; i < 16; i++) {
            if (i == 15) { //if last character, print without space
                System.out.print(array[i]);
            } else {
                System.out.print(array[i] + " ");
            }
        }
        System.out.println("]");
    }

    public static void printBoard(int[] array) {
        for (int i = 0; i < 16; i++) {
            if (i % 4 == 3) { //if last character
                System.out.print("\t" + array[i] + "\n");
            } else {
                System.out.print("\t" + array[i]);
            }
        }
    }

    public static void printNodeList(String name, ArrayList<Node> arraylist) {
        System.out.print(name + " = [ ");
        for (Node node : arraylist) {
            System.out.print(node.getNodeID() + " ");
        }
        System.out.println("]");
    }

}
