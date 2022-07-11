package com.interview.graph.bfs;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * There is a rectangle with left bottom as  (0, 0) and right up as (x, y). There are N circles such that their centers are inside the rectangle.
 *
 * Radius of each circle is R. Now we need to find out if it is possible that we can move from (0, 0) to (x, y) without touching any circle.
 *
 * Note :  We can move from any cell to any of its 8 adjecent neighbours and we cannot move outside the boundary of the rectangle at any point of time.
 *
 *
 *
 *
 * Input Format
 *
 * 1st argument given is an Integer x.
 * 2nd argument given is an Integer y.
 * 3rd argument given is an Integer N, number of circles.
 * 4th argument given is an Integer R, radius of each circle.
 * 5th argument given is an Array A of size N, where A[i] = x cordinate of ith circle
 * 6th argument given is an Array B of size N, where B[i] = y cordinate of ith circle
 * Output Format
 *
 * Return YES or NO depending on weather it is possible to reach cell (x,y) or not starting from (0,0).
 * Constraints
 *
 * 0 <= x, y, R <= 100
 * 1 <= N <= 1000
 * Center of each circle would lie within the grid
 * For Example
 *
 * Input:
 *     x = 2
 *     y = 3
 *     N = 1
 *     R = 1
 *     A = [2]
 *     B = [3]
 * Output:
 *     NO
 *
 * Explanation:
 *     There is NO valid path in this case
 * Logic : Check for each point lies in the circle or not. Set the flag in visited dp matrix as true if it lies in the matrix
 *      : Do BFS and return true if we meet the target x,y cordinates.
 *
 */
public class ValidPath01 {
    int[] dx = {0,0,1,-1,1,1,-1,-1};
    int[] dy = {1,-1,0,0,1,-1,-1,1};

    public String solve(int x, int y, int n, int r, int[] X, int[] Y) {

        return bfs(x,y,X,Y,r) ? "YES" : "NO";
    }

    private boolean bfs(int fx,int fy,int[] X,int[] Y,int r){

        Queue<int[]> q = new LinkedList();
        q.offer(new int[]{0,0});
        // Create a visited array for final destination
        boolean[][] visited = new boolean[fx+1][fy+1];
        visited[0][0] = true;

        while(!q.isEmpty()){

            int[] temp = q.poll();
            int x = temp[0];
            int y = temp[1];

            if(x==fx && y==fy){
                // if the value matches return
                return true;
            }


            for(int k=0;k<8;k++){
                // checking in each direction for all point
                int nx = x+dx[k];
                int ny = y+dy[k];
                if(nx>=0 && nx<=fx && ny>=0 && ny<=fy && !visited[nx][ny] &&!isInsideCircle(nx,ny,X,Y,r)){
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx,ny});
                }
            }
        }
        return false;
    }

    private boolean isInsideCircle(int x,int y,int[] X,int[] Y,int r){
        for(int i=0;i<X.length;i++){
            int dist = (x-X[i])*(x-X[i]) + (y-Y[i])*(y-Y[i]);
            if(dist<=r*r){
                return true;
            }
        }
        return false;
    }
}

