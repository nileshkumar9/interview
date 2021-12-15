package com.interview.arrays;

/**
 * To replace all the occurance of duplicates with 0 in  a row in a matrix
 * Iterated for each element and then replace.
 * Input :  new int [][] {
 *  {1, 1, 2, 2, 3, 4, 5},
 *  {1, 1, 1, 1, 1, 1, 1},
 *  {1, 2, 3, 4, 5, 6, 7},
 *  {1, 2, 1, 1, 1, 1, 1}};
 * Output :
 *  1, 0, 2, 2, 3, 4, 5,
 *  1, 0, 0, 0, 0, 0, 0,
 *  1, 2, 3, 4, 5, 6, 7,
 *  1, 2, 0, 0, 0, 0, 0,
 */
public class ReplaceDuplicatesWithZero {
    public static void main(String args[]) {

        int[][] input= new int [][] { {1, 1, 2, 2, 3, 4, 5},{1, 1, 1, 1, 1, 1, 1}, {1, 2, 3, 4, 5, 6, 7},{1, 2, 1, 1, 1, 1, 1}};
        for(int i = 0 ; i < input.length   ; i++){
            for (int j=0 ; j < input[0].length  ; j++) {
                int k = j + 1;
                while( k < input[0].length   ){
                    if (input[i][j] == input[i][k]){
                        input[i][k] = 0;
                    }
                    k++;
                }
                j = k-1;
            }
        }

        // Printing input after manipulations
        for(int i = 0 ; i < input.length   ; i++){
            for (int j=0 ; j < input[0].length  ; j++) {
                 System.out.print(input[i][j] + ", ");
            }
            System.out.println();

        }


    }

}

