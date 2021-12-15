package com.interview.arrays;

import java.util.ArrayList;

/**
 * @Author Nilesh kumar
 * Given an unsorted integer array, find the first missing positive integer.
 *
 * Example:
 *
 * Given [1,2,0] return 3,
 *
 * [3,4,-1,1] return 2,
 *
 * [-8, -7, -6] returns 1
 *
 * Your algorithm should run in O(n) time and use constant space.
 *
 * Logic :
 * https://www.youtube.com/watch?v=-lfHWWMmXXM
 * Iterate in the array and then swap the integer value to the correct positions. Take a note that position starts at 0 in array.
 * In first iteration we keep on swapping the value untill the given index holds the correct integer which will be equal to the index number.
 * Once we are done all the index will be holding the number same a index value.
 * We now iterate to the array and find the first value which is not equal to the index and returns that index( +1) value;
 */
public class FirstMissingPositiveInteger {
    public int firstMissingPositive(ArrayList<Integer> A) {
        if (A == null || A.size() ==0  ) return 1;
        // get the size of array
        int n = A.size();
        int correctPosition = 0;
        for (int i=0; i<n; i++){
            correctPosition = A.get(i) -1;
            while( (A.get(i) >=1 && A.get(i) <= n) && A.get(i) != A.get(correctPosition) )
            {
                int temp = A.get(i);
                A.set(i, A.get(correctPosition));
                A.set(correctPosition, temp);
                correctPosition = A.get(i)-1 ;
            }

        }

        for(int i =0 ; i< n; i++){
            if (i+1 != A.get(i)  ){
                return i+1;
            }
        }

        return n+1;



    }
    public static void main(String[] args) {
        FirstMissingPositiveInteger firstMissingPositiveInteger = new FirstMissingPositiveInteger();
        ArrayList<Integer> A = new ArrayList<>();
        A.add(-5);
        A.add(5);
        A.add(1);
        System.out.print("First missing integer  "+ firstMissingPositiveInteger.firstMissingPositive( A));
    }
}

