package com.interview.arrays;

/**
 * https://www.youtube.com/watch?v=lUdWGkCUD54&list=PL-Jc9J83PIiHOV7lm2uSw4ZiVsIRsGS6r&index=36
 * PeepCoding questions to print  Subarrays of an Array

 */
public class PrintSubArrayofArray {
    public static void main(String[] args) {
        int[] a = new int[]{3, 4, 5, 6};

        for(int i =0; i<a.length ; i++){
            for(int j =i; j<a.length; j++){
                for(int k =i; k<=j;k++){
                    System.out.print(a[k] + " ");
                }
                System.out.println();
            }
        }


    }



}
