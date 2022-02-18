package com.interview.arrays.twoDArray;

/**
 * https://www.youtube.com/watch?v=5vP0-g94xEA&list=PL-Jc9J83PIiFkOETg2Ybq-FMuJjkZSGeH&index=20
 * To find a given element in a sorted martrix
 *
 *
 * Logic :
 *      We will compare with the last elment of first row,
 *          if given no is bigger then this value then we will go to next rows last column till.
 *          If given no is smaller then we will search in previous column of this rows
 *          if we don't find then we will break and reaturn faluse
 *
 */
public class SearchInSortedMAtrix {
    public static void main(String args[]) {
        int [][] array=
            {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
            };

        displayMatrix(array);

        searchInAGivenSortedMatrix(14, array);

    }

    private static void searchInAGivenSortedMatrix(int num, int[][] array) {

        boolean flag = false;

        int i = 0;
        int j = array.length - 1;
        while (i < array.length && j >= 0) {
            if (num == array[i][j]) {
                System.out.println("Found at row i = " +i);
                System.out.println("Found at column j = "+j);
                return;
            } else if (num > array[i][j]) {
                i++; // increase the row and check with next rows last column
            } else {
                // check in the same row in preious column
                j--;
            }
        }
        System.out.println("Not found");

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