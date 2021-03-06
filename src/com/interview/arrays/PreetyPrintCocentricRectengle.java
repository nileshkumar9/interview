package com.interview.arrays;

/**
 * Print concentric rectangular pattern in a 2d matrix.
 *
 * Let us show you some examples to clarify what we mean.
 *
 * Example 1:
 *
 * Input: A = 4.
 *
 * Output:
 *
 * 4 4 4 4 4 4 4
 * 4 3 3 3 3 3 4
 * 4 3 2 2 2 3 4
 * 4 3 2 1 2 3 4
 * 4 3 2 2 2 3 4
 * 4 3 3 3 3 3 4
 * 4 4 4 4 4 4 4
 * Example 2:
 *
 * Input: A = 3.
 *
 * Output:
 *
 * 3 3 3 3 3
 * 3 2 2 2 3
 * 3 2 1 2 3
 * 3 2 2 2 3
 * 3 3 3 3 3
 * The outermost rectangle is formed by A, then the next outermost is formed by A-1 and so on.
 *
 * You will be given A as an argument to the function you need to implement, and you need to return a 2D array.
 *
 * Logic : https://www.youtube.com/watch?v=TUKdwZQw7iU
 * 
 */
public class PreetyPrintCocentricRectengle {

    public int[][] prettyPrint(int A) {

        int start = 0;
        int size  = (A*2 )-1;
        int end = size-1;
        int n = A;
        int[][] a = new int[size][size];

        while(n!=0){
            for(int i=start; i<= end; i++){
                for(int j=start ; j<= end; j++){
                    if(i==start || i == end || j== start || j== end){
                        a[i][j] = n;
                    }
                }
            }
            ++ start;
            --end;
            --n;

        }
        return a;

    }
}

