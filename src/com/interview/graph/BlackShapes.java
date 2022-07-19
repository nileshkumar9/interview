package com.interview.graph;

import java.util.ArrayList;

public class BlackShapes {
    /**
     * https://www.interviewbit.com/problems/black-shapes/hints/
     *
     * Connected Component problem it is
     *
     * We can think of the matrix as a graph i.e. any square which shares
     * a side with any other square would have an edge between them.
     * Now the problem reduces to finding the number of different connected componenets.
     *
     * Simple graph traversal approach:
     *
     */

    private int count = 0;
    private boolean visited[][];
    private int di[] = new int[]{1, -1, 0, 0};
    private int dj[] = new int[]{0, 0, 1, -1};
    private ArrayList<String> A;

    public int black(ArrayList<String> A) {
        int rows, column;

        if (A == null) {
            return 0;
        }

        rows = A.size();
        column = A.get(0).length();

        visited = new boolean[rows][column];
        count = 0;
        this.A = A;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < column; j++) {
                // if not visited and charcter present is x
                if (!visited[i][j] && A.get(i).charAt(j) == 'X') {
                    dfs(i, j, rows, column);
                    count++;
                }
            }
        }

        return count;
    }

    public void dfs(int i, int j, int matrixRow, int matrixColumn) {

        visited[i][j] = true;

        for (int k = 0; k < 4; k++) {

            int newI = i + di[k];
            int newJ = j + dj[k];

            // boundary condition and check
            if (isValid(newI, newJ, matrixRow, matrixColumn) && !visited[newI][newJ]) {
                dfs(newI, newJ, matrixRow, matrixColumn);
            }

        }
    }

    public boolean isValid(int i, int j, int m, int n) {

        if (i < 0 || i >= m || j < 0 || j >= n) {
            return false;
        }

        if (A.get(i).charAt(j) != 'X') {
            return false;
        }

        return true;
    }


}

