package com.samsung;

public class FindDuplicateArrayElement {
    public static void main(String[] args) {
        int [][] arr = new int[3][4];
        int [][] transpose = new int[arr[0].length][arr.length];

        //  [ 1 2 3 4]


        for(int i = 0; i<arr.length;i++){
            for(int j=0; j < arr[0].length; j++){
                transpose[j][i] = arr[i][j];
            }
        }

    }
}
