package com.interview.graph.bfs;

import java.util.PriorityQueue;


public class MinCostPath_BFS_Dijkstra {
    /**
     * Problem Description
     * <p>
     * You are given a AB character matrix named C. Every cell in C has a character U,R,L or D indicating up,right,left and down.
     * <p>
     * Your target is to go from top left corner to the bottom right corner of the matrix.
     * <p>
     * But there are some restrictions while moving along the matrix:
     * <p>
     * If you follow what is written in the cell then you can move freely.
     * But if you don't follow what is written in the cell then you have to pay 1 unit of cost.
     * Like: If a cell contains character U and you go right instead of Up you have to pay 1 unit of cost.
     * <p>
     * So your task is to find the minimum cost to go from top-left corner to the bottom-right corner.
     * <p>
     * <p>
     * <p>
     * Problem Constraints
     * 1 <= A,B <= 103
     * C[i][j] can be either U,R,L or D.
     * <p>
     * <p>
     * Input Format
     * First Argument represents a integer A (number of rows).
     * Second Argument represents a integer B (number of columns).
     * Third Argument represents a string array C which contains A strings each of length B.
     * <p>
     * <p>
     * Output Format
     * Return an integer denoting the minimum cost to travel from top-left corner to bottom-right corner.
     * <p>
     * <p>
     * <p>
     * Example Input
     * Input:1
     * <p>
     * A = 3
     * B = 3
     * C = ["RRR","DDD","UUU"]
     * Input:2
     * <p>
     * A = 1
     * B = 4
     * C = ["LLLL"]
     * <p>
     * <p>
     * Example Output
     * Output-1 :
     * <p>
     * 1
     * Output-2 :
     * <p>
     * 3
     * <p>
     * <p>
     * Example Explanation*
     * Explanation for Input-1:
     * <p>
     * Matrix looks like: RRR
     * DDD
     * UUU
     * We go right two times and down two times.
     * So from top-right cell we are going down though right is given so this incurs a cost of 1.
     * Explanation for Input-2:
     * <p>
     * Matrix looks like: LLLL
     * We go right three times.
     * <p>
     * Logic :
     * <p>
     * Dijisktra is same as BFS, but at this time we uses PrioirityQueue
     * due to which it will only pop out the smalles element fist, hence will give us minimum cost always
     * Unlike, normal BFS where it traverse all element of the queue
     */

    class Pair  implements Comparable<Pair>{
        int x;
        int y;
        int wsf;

        Pair(int x, int y, int wsf) {
            this.x = x;
            this.y = y;
            this.wsf = wsf;
        }

        @Override
        public int compareTo(Pair o) {
            return this.wsf - o.wsf;
        }
    }

    // To go in different direction R, d, l, u
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};

    public int solve(int A, int B, String[] C) {
        // All for possible directions
        String s = "RDLU";
        int row = A;
        int column = B;

        // To store the distance to reach at all cordinates
        // // Holds the minimum value to reach this point
        int[][] distance = new int[row][column];

        for(int i=0;i<row; i++){
            for (int j=0; j<column; j++){
                distance[i][j] = Integer.MAX_VALUE;
            }
        }
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();


        pq.add(new Pair( 0,0,0)); // Putting 0,0 cordinates with 0 weight
        // dp array of distance,
        distance[0][0] = 0 ; // Holds the minimum value to reach this point

        // now do BFS on pq
        while(!pq.isEmpty()){
            // remove mark * work add*
            Pair current = pq.remove();

            if(current.x == row-1 && current.y == column-1) {
                // we have reached the destination, return
                return current.wsf; // Return the weight so far
            }

            // go in all the direction and add it to the queue
            for (int i =0; i<4 ; i++){
                // new Position
                int newX = dx[i] + current.x;
                int newY = dy[i] + current.y;

                int currentCost = current.wsf;
                // Now we have to increase the cost if the path doesn't matches for given value
                if(s.charAt(i) != C[current.x].charAt(current.y)){
                    // that is this is a deviation from the path
                    // increase cost.
                    currentCost ++;
                }

                // check for boundries
                if (newX >=0 && newX < row &&
                    newY>=0 && newY< column  && currentCost < distance[newX][newY] ){
                    pq.add(new Pair(newX, newY , currentCost));
                    distance[newX][newY] = currentCost;
                }
            }
        }
        return distance[row-1][column-1];
    }

    public static void main(String[] args) {
        MinCostPath_BFS_Dijkstra m = new MinCostPath_BFS_Dijkstra();
        String[] c = {"UDUD"} ;
        System.out.println( m.solve(1,4, c));
    }

}
