package com.interview.arrays.twoDArray;

/**
 * https://www.youtube.com/watch?v=lvRdFCMD_Ew&list=PL-Jc9J83PIiFkOETg2Ybq-FMuJjkZSGeH&index=15
 * Diagonal Traversal of td matrix
 *
 * Logic :
 *  Diagonal traversal works on gap , Gap of i an j for first (largest diagonal ) will be 0
 *  gap b/w i and j on second diagonal will be 1 and so one till the array.lentght size
 *  so e.g : first diagonal will be 00(ij), 11(ij), 22, 33,44,55 --> gp is 0 between i an j
 *      second diagonal will be 01(ij), 12(ij), 23, 34, 55 -->  gap is 1
 *      .... and so on.
 *  Key point : i always start from i =0 for all diagonal
 *  gap decides the value of j, where gap will be in range of 0 to array.length
 *  any given the diagonal will end when j gets equal to array.length that is right wall
 *
 */
public class DiagonalTraversalArray {
    public static void main(String args[]) {
        int [][] array=
            {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
            };

        displayMatrix(array);

        diagonalTraversalOfArray(array);

    }

    private static void diagonalTraversalOfArray(int[][] array) {
        System.out.println("========Printing diagonals ==========");
        // Prints upper halfs diagonals
        for (int gap=0; gap< array.length; gap++){ // will print all diagonals
            for(int i =0, j = gap ; j< array.length ; i++, j++){ // i will be 0 and j will b gap
                System.out.print(array[i][j] + "  ");
            }
            System.out.println();
        }
    }

    private static void displayMatrix(int[][] array) {
        System.out.println();
        for(int i = 0; i< array.length; i++){
            for(int j = 0; j< array[0].length; j++){
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
