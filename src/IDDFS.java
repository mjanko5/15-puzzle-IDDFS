/*
 * Matt Jankowski
 * AI (CS 411) Hw 4
 * 15 puzzle BFS - BFS Class
 * To God be the Glory
 */

import java.util.ArrayList;
import java.util.Arrays;

public class IDDFS {
    private int goal[] = new int[]{
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0};
    private ArrayList<Node> frontier = new ArrayList<>();  //gray nodes
    private ArrayList<Node> explored = new ArrayList<>();  //black nodes
    private long starting_time;
    public static int nodeCount = 0; //total number of nodes created

    public IDDFS(int[] initial_board) {
        starting_time = System.currentTimeMillis();//get time at start of run

        Node root = new Node(initial_board, null, '#');   //create root (direction = '#')
        if (matchesGoal(root)) return; //if matches - good!

        enqueue(root); //put into frontier

        //Breadth First Search:
        while (frontier.size() > 0) { //in our case this will always be true
            // (unless all possible configurations are exhausted, which is collosal
            while (System.currentTimeMillis() - starting_time < 30000) { //while 30 sec have not yet arrived
                Node u = dequeue(); //remove from frontier
                explored.add(u);    //put into explored

                for (Node v : generateChildren(u)) {
                    if (!inExplored(v) && !inFrontier(v)) {  //white (prevents going back to the same node)
                        if (matchesGoal(v)) return; //if found, succeed, & end game
                        enqueue(v); //put into frontier
                    }
                }
            }
            //30 seconds have passed:
            System.out.println("Solution not found after 30 sec."); //(there might be one, but deeper down the tree.)
            return;
        }
        //Empty Frontier: no solution exists.
        System.out.println("Solution not found. No solution exists."); //this will never happen in this program.
    }

    //put Node into frontier
    public void enqueue(Node node) {
        frontier.add(node);
    }

    //remove Node from frontier
    public Node dequeue() {
        Node node = frontier.get(0);
        frontier.remove(0);
        return node; //node at index 0
    }

    //generate all children of the parent
    //2 min -> if blank is in corner    3 -> if blank is on side    4 max -> if blank within
    //TRANSITION FUNCTION
    public ArrayList<Node> generateChildren(Node parent) {
        Node U = parent.moveUp();
        Node D = parent.moveDown();
        Node L = parent.moveLeft();
        Node R = parent.moveRight();

        ArrayList<Node> children = new ArrayList<>(4);
        //Add the created nodes to the arrayList (as long as they're not null)
        if (U != null) children.add(U);
        if (D != null) children.add(D);
        if (L != null) children.add(L);
        if (R != null) children.add(R);

        return children;
    }

    //print success messages
    public void success(Node solutionNode) {
        printMoves(solutionNode);
        printNumNodes(solutionNode);
        printTime();
        printMemory();
    }

    //return true if node is in frontier list (by comparing int[])
    public boolean inFrontier(Node node) {
        for (Node n : frontier) {
            if (Arrays.equals(n.getBoard(), node.getBoard())) return true;
        }
        return false;
    }

    //return true if node is in explored list (by comparing int[])
    public boolean inExplored(Node node) {
        for (Node n : explored) {
            if (Arrays.equals(n.getBoard(), node.getBoard())) return true;
        }
        return false;
    }

    //check if the board matches goal, if so, success and return true!
    public boolean matchesGoal(Node v) {
        if (Arrays.equals(v.getBoard(), goal)) {
            success(v);
            return true;
        }
        return false;
    }

    //calculate and print move sequence
    public void printMoves(Node node) {
        String moves = "";
        while (node.getDirection() != '#') { //while not root node
            moves = Character.toString(node.getDirection()).concat(moves); //add direction of node
            node = node.getParent(); //update
        }
        System.out.println("Moves: " + moves);
    }

    //print how many nodes were expanded (created)
    public void printNumNodes(Node node) {
        System.out.println("Number of Nodes expanded: " + nodeCount);
    }

    //calculate and print the time taken to run program
    public void printTime() {
        long ending_time = System.currentTimeMillis(); //record time at end of run
        float total_seconds = (float) (ending_time - starting_time) / 1000; //get difference between start and end.
        System.out.println("Time Taken: " + total_seconds + " s"); //print result
    }

    //calculate and print runtime of program
    //referenced memory usage documentation at: https://www.vogella.com/tutorials/JavaPerformance/article.html
    public void printMemory() {
        Runtime runtime = Runtime.getRuntime();
        runtime.gc(); //garbage collector frees up space
        long memory = runtime.totalMemory() - runtime.freeMemory(); //calculate memory
        System.out.println("Memory Used: " + memory / 1024L + " kB");
    }

}


