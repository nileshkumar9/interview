package com.interview.arrays;

import java.util.ArrayList;

/**
 * https://www.interviewbit.com/problems/set-matrix-zeros/
 * Given a matrix, A of size M x N of 0s and 1s. If an element is 0, set its entire row and column to 0.
 * Note: This will be evaluated on the extra memory used. Try to minimize the space and time complexity.
 *
 * Input Format:
 *
 * The first and the only argument of input contains a 2-d integer matrix, A, of size M x N.
 * Output Format:
 *
 * Return a 2-d matrix that satisfies the given conditions.
 * Constraints:
 *
 * 1 <= N, M <= 1000
 * 0 <= A[i][j] <= 1
 * Examples:
 *
 * Input 1:
 *     [   [1, 0, 1],
 *         [1, 1, 1],
 *         [1, 1, 1]   ]
 *
 *
 * Output 1:
 *     [   [0, 0, 0],
 *         [1, 0, 1],
 *         [1, 0, 1]   ]
 *
 *
 *
 * Input 2:
 *     [   [1, 0, 1],
 *         [1, 1, 1],
 *         [1, 0, 1]   ]
 *
 *
 *
 * Output 2:
 *     [   [0, 0, 0],
 *         [1, 0, 1],
 *         [0, 0, 0]   ]
 *
 * Logic : Fist visit each element and for any occurance of zero set True to rowVisited and colVisited array.
 * In that way we know which row and column we have to set as zero.
 * o(n2)
 */
public class SetMatrixZeros {
    public void setZeroes(ArrayList<ArrayList<Integer>> a) {
        int rows = a.size();
        int cols = a.get(0).size();

        // maintain two row which will be set to true when a zeros is encountered in row or column
        boolean[] rowVisited = new boolean[rows];
        boolean[] colVisited = new boolean[cols];

        // we will set row or column for each element of matrix
        for(int i= 0 ; i< rows; i++){
            for(int j=0; j<cols ; j++){
                if(a.get(i).get(j) == 0){
                    rowVisited[i] = true;
                    colVisited[j] = true;
                }
            }
        }

        // now we will visit the matrix again and we will set all the value as zero if true is found

        for (int i =0; i<rows ; i++){
            for(int j = 0 ; j<cols; j++){
                if(rowVisited[i] || colVisited[j]) a.get(i).set(j,0);
            }
        }
    }
}
