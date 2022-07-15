package com.interview.graph.pathTraversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class WaterFlow_02<dx> {
    /**
     * Problem Description
     * <p>
     * Given an N x M matrix A of non-negative integers representing the height of each unit cell in a continent, the "Blue lake" touches the left and top edges of the matrix and the "Red lake" touches the right and bottom edges.
     * <p>
     * Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.
     * <p>
     * Find the number of cells from where water can flow to both the Blue and Red lake.
     * <p>
     * <p>
     * <p>
     * Problem Constraints
     * 1 <= M, N <= 1000
     * <p>
     * 1 <= A[i][j] <= 109
     * <p>
     * <p>
     * <p>
     * Input Format
     * First and only argument is a 2D matrix A.
     * <p>
     * <p>
     * <p>
     * Output Format
     * Return an integer denoting the number of cells from where water can flow to both the Blue and Red lake.
     * <p>
     * <p>
     * <p>
     * Example Input
     * Input 1:
     * <p>
     * A = [
     * [1, 2, 2, 3, 5]
     * [3, 2, 3, 4, 4]
     * [2, 4, 5, 3, 1]
     * [6, 7, 1, 4, 5]
     * [5, 1, 1, 2, 4]
     * ]
     * Input 2:
     * <p>
     * A = [
     * [2, 2]
     * [2, 2]
     * ]
     * <p>
     * <p>
     * Example Output
     * Output 1:
     * <p>
     * 7
     * Output 2:
     * <p>
     * 4
     * <p>
     * <p>
     * Example Explanation
     * Explanation 1:
     * <p>
     * Blue Lake ~   ~   ~   ~   ~
     * ~  1   2   2   3  (5) *
     * ~  3   2   3  (4) (4) *
     * ~  2   4  (5)  3   1  *
     * ~ (6) (7)  1   4   5  *
     * ~ (5)  1   1   2   4  *
     * *   *   *   *   * Red Lake
     * Water can flow to both lakes from the cells denoted in parentheses.
     * <p>
     * Explanation 2:
     * <p>
     * Water can flow from all cells.
     * <p>
     * Logic : Its a multisource traversal problem
     * We will create a queue, where will will keep all the blue lake merging values,
     * and then from there we will try to go to the red lake, to find the common cells value
     * which will go in both blue and red
     */

    class Pair {
        int i;
        int j;

        Pair(int i, int j) {
            this.i = i;
            this.j = j;

        }
    }

    public int solve(ArrayList<ArrayList<Integer>> A) {
        int row = A.size();
        int column = A.get(0).size();

        if (row == 0) {
            // since there is now row we will return
            return 0;
        }
        boolean[][] blueVisisted = new boolean[row][column];
        boolean[][] redVisisted = new boolean[row][column];
        Queue<Pair> blueQueue = new ArrayDeque<>();
        Queue<Pair> redQueue = new ArrayDeque<>();

        // 1) Segreagate 1st row 1st column, last row , last column
        for (int i = 0; i < A.size(); i++) {
            for (int j = 0; j < A.get(0).size(); j++) {
                // if its a first row or first column then it touches the blue lake
                if (i == 0 || j == 0) {
                    // mark it as visited and add it to the blue queue
                    blueVisisted[i][j] = true;
                    blueQueue.add(new Pair(i, j));
                }
                if (i == row - 1 || j == column - 1) { // this is last row or last column hence touching red lake
                    // mark it as visited and add it to the blue queue
                    redVisisted[i][j] = true;
                    redQueue.add(new Pair(i, j));
                }
            }
        }

        // Now we have border touching nodes with lakes.
        // Do a BFS for each node and then check if adjacent nodes can be also added to the queue

        bfs(blueQueue, blueVisisted, row, column, A);
        bfs(redQueue, redVisisted, row, column, A);


        // now that blue we have filled both of the visited array.
        // we will find the common for both red and blue
        int ans = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (blueVisisted[i][j] && redVisisted[i][j]) {
                    ans++; // incrase the number of common cell for red and blue.
                }

            }

        }

        return ans;
    }

    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    private void bfs(Queue<Pair> queue, boolean[][] visisted,
                     int row, int column, ArrayList<ArrayList<Integer>> matrix) {
        while (!queue.isEmpty()) {
            // remove mar* work add*
            Pair curernt = queue.remove();

            // Explore all 4 directions
            for (int i = 0; i < 4; i++) {
                int newX = curernt.i + dx[i];
                int newY = curernt.j + dy[i];

                // Check for all the boundary contination
                if (newX < 0 || newX >= row ||
                    newY < 0 || newY >= column || visisted[newX][newY] == true) {
                    continue;
                }
                // Now water always flows from heigher to lower height
                // which means if we are having a value in the unvisisted cells which are
                // greater then equql to current cell value, then water can flow from
                // new cell to this current cell. mark all those cell as visisted
                // which we denote that from this cell we can go to the lake
                if (matrix.get(newX).get(newY) >= matrix.get(curernt.i).get(curernt.j)) {
                    // height is greater hence water will flow
                    visisted[newX][newY] = true;
                    queue.add(new Pair(newX, newY));

                }
            }
        }
    }

    public static void main(String[] args) {
        int [][] ala = {

            {1, 2, 2, 3, 5},
            {3, 2, 3, 4, 4},
            {2, 4, 5, 3, 1},
            {6, 7, 1, 4, 5},
            {5, 1, 1, 2, 4}
        };
//        int [][] ala = {
//
//            {2, 2},
//            {2, 2}
//        };

        //ArrayList<ArrayList<Integer>> al =  new ArrayList<ArrayList<Integer>>(ala);
         WaterFlow_02 obj = new WaterFlow_02();

        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        for (int[] array : ala) {
            ArrayList<Integer> listVal = new ArrayList<Integer>();
            for(int val : array){
                listVal.add( val);
            }
        list.add(listVal);
        }

        System.out.println(obj.solve(list));

    }


}