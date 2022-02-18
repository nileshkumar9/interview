package com.interview.arrays.twoDArray;

/**
 * @author Nilesh Kumar
 * <p>
 * https://www.youtube.com/watch?v=SoxrXQbhCPI&list=PL-Jc9J83PIiFkOETg2Ybq-FMuJjkZSGeH&index=12
 *
 * Rotate given matrix by 90 degree
 * Logice :
 * In rotation, we will get first rwo of the martrix as the last column
 *  second rows as second last column and so on
 *
 *  e.g a b c d
 *      e f g h
 *      i j k l
 *      m n o p
 *
 *      90 degree rotates becomes
 *      m i e a
 *      n j f b
 *      o k g c
 *      p l h d
 *
 *  1) First do a transpose, that will convert rows to column.
 *  2) then reverse the elements of each rows, this will make first column last colum.
 *
 */
public class RotateMatrixBy90Degree {
    public static void main(String args[]) {
        int [][] array=
                {
                    {1,2,3,4},
                    {5,6,7,8},
                    {9,10,11,12},
                    {13,14,15,16}
                };

        displayMatrix(array);

        rotateMatrixBy90(array);

        displayMatrix(array);
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

    private static void rotateMatrixBy90(int[][] array) {

        // transpose the matrix
        transpose(array);


        // reverse each rows to get 90 degree views
        for(int i =0 ; i < array.length; i++){
            int li = 0; // reversing each rows here.
            int ri = array[i].length-1;
            while(li<ri){
                int temp = array[i][li];
                array[i][li] = array[i][ri];
                array[i][ri] = temp;
                li++;
                ri--;
            }
        }

    }

    private static void transpose(int[][] array) {
        for(int i=0;i<array.length ; i++){
            for(int j = i; j<array[0].length;j++){
                int temp = array[i][j];
                array[i][j] = array[j][i];
                array[j][i] = temp;
            }
        }
    }

}
