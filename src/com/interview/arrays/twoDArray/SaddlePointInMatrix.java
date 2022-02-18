package com.interview.arrays.twoDArray;

/**
 * https://www.youtube.com/watch?v=6YIWq2JGzEQ&list=PL-Jc9J83PIiFkOETg2Ybq-FMuJjkZSGeH&index=18
 * A Saddle point is a point or element, which is minimum in the row and max in its column.
 * In any given matrix there will be only one such value.
 * There is chance that we may not have any saddle point.
 * Minimum in row and maximum in column
 *
 * Logic :
 *      We will first find the minimum element in given row, and then will check if
 *      that is highest element in its column. If its highest we will print this other wise
 *      we will break for this value,
 *      We will do this for each row until we find. if we find we will break as there can be
 *      only one saddle point so no need to check others.
 *
 */
public class SaddlePointInMatrix {
    public static void main(String args[]) {
        int [][] array=
            {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
            };

        displayMatrix(array);

        saddlePoint(array);

    }

    private static void saddlePoint(int[][] array) {

        // first find the minimum element in a row
        for (int i=0; i<array.length;i++){ // this is row loop
            // lets find the saddle value index j as o
            int svj =0; // for this row
            for(int j=1; j<array[0].length;j++){
                // checking all column of this row
                if(array[i][svj] > array[i][j]){
                    // we have new minimum in a row so update svj
                    svj = j;
                }
            } // By end of this we have minmum in give row i

            // Now check if this value is max in its column then only it can be saddle point
            boolean flag = true;
            for (int j=0; j<array.length; j++){ // checking all rows for given column
                if(array[i][svj] < array[j][svj]){
                    // if the svj value is smaller then anyother value in column
                    // it means it is not the saddle point as it has to be highest in column
                    flag = false;
                    break; // break the loop of next row evaluation
                }
            }
            if(flag){
                // this means i, svj is a saddle point if we have reached here
                System.out.println("saddle point is " +
                                       array[i][svj]);
            }

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