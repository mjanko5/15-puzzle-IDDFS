/*
 * Matt Jankowski
 * AI (CS 411) Hw 5
 * 15 puzzle IDDFS - Node Class
 * To God be the Glory
 */

public class Node {
    private Node parent; //each node has a parent except root
    private int[] board = new int[16];
    private int depth;
    private int childCount = 0;
    private char direction;
    private int nodeID;

    public Node(int[] in_board, Node in_parent, char in_direction) {
        parent = in_parent;

        if (parent == null) {
            depth = 0; //root
        } else {
            depth = parent.depth + 1;
            parent.childCount++;
        }
        board = in_board;
        direction = in_direction; //slide move to get to this node from previous node
        nodeID = DLS.nodeCount++;

        //Uncomment for debugging:
/*
        try {
            System.out.println("Creating a new node.\t\t" + direction + "\t\t" + depth + "\t\t" + nodeID + "\t\t" + parent.nodeID);
        } catch (NullPointerException e) {
            System.out.println("Creating a new node.\t\t" + direction + "\t\t" + depth + "\t\t" + nodeID + "\t\tNIL");
        }
        printBoard();
*/

    }

    //getters:
    public int getChildCount() {
        return childCount;
    }

    public int getDepth() {
        return depth;
    }

    public int getNodeID() {
        return nodeID;
    }

    public int[] getBoard() {
        return board;
    }

    public Node getParent() {
        return parent;
    }

    public char getDirection() {
        return direction;
    }

    //return index of 0 on board.
    public int get0Position(int[] pattern) {
        for (int i = 0; i < 16; i++) {
            if (pattern[i] == 0) {
                return i; //should find 0 somewhere in array
            }
        }
        return -1; //if this happens: something went wrong
    }

    //move 0 left if possible
    public Node moveLeft() {
        int[] pattern = board.clone(); //new board
        if (pattern[0] == 0 || pattern[4] == 0 || pattern[8] == 0 || pattern[12] == 0) {
            //System.out.println("Cannot move left! Blank is in left column.");
            return null;
        } else { //move left
            int zeroPosition = get0Position(pattern);
            pattern[zeroPosition] = pattern[zeroPosition - 1]; //swap (slide)
            pattern[zeroPosition - 1] = 0;
            return new Node(pattern, this, 'L'); //create new node
        }
    }

    //move 0 right if possible
    public Node moveRight() {
        int[] pattern = board.clone(); //new board
        if (pattern[3] == 0 || pattern[7] == 0 || pattern[11] == 0 || pattern[15] == 0) {
            //System.out.println("Cannot move right! Blank is in right column.");
            return null;
        } else { //move right
            int zeroPosition = get0Position(pattern);
            pattern[zeroPosition] = pattern[zeroPosition + 1]; //swap (slide)
            pattern[zeroPosition + 1] = 0;
            return new Node(pattern, this, 'R'); //create new node
        }
    }

    //move 0 up if possible
    public Node moveUp() {
        int[] pattern = board.clone(); //new board
        if (pattern[0] == 0 || pattern[1] == 0 || pattern[2] == 0 || pattern[3] == 0) {
            //System.out.println("Cannot move up! Blank is in top row.");
            return null;
        } else { //move up
            int zeroPosition = get0Position(pattern);
            pattern[zeroPosition] = pattern[zeroPosition - 4]; //swap (slide)
            pattern[zeroPosition - 4] = 0;
            return new Node(pattern, this, 'U'); //create new node
        }
    }

    //move 0 down if possible
    public Node moveDown() {
        int[] pattern = board.clone(); //new board
        if (pattern[12] == 0 || pattern[13] == 0 || pattern[14] == 0 || pattern[15] == 0) {
            //System.out.println("Cannot move down! Blank is in bottom row.");
            return null;
        } else { //move down
            int zeroPosition = get0Position(pattern);
            pattern[zeroPosition] = pattern[zeroPosition + 4]; //swap (slide)
            pattern[zeroPosition + 4] = 0;
            return new Node(pattern, this, 'D'); //create new node
        }
    }

    //print data about the node
    public void printNodeData() {
        System.out.println("   depth = " + this.depth);
        try {
            Functions.printArray("   parent board", this.parent.board);
        } catch (NullPointerException e) {
            System.out.println("   parent board = This is the root and there is no parent.");
        }
        //Functions.printArray("   board", this.board);
        printBoard();

    }

    //print just the board
    public void printBoard() {
        for (int i = 0; i < 16; i++) {
            if (i % 4 == 3) { //if last character
                System.out.print("\t" + this.board[i] + "\n");
            } else {
                System.out.print("\t" + this.board[i]);
            }
        }
    }

}