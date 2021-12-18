package com.interview.arrays;

import java.util.ArrayList;

/**
 * https://www.interviewbit.com/problems/find-duplicate-in-array/
 * Problem Description
 *
 * Given a read only array of n + 1 integers between 1 and n, find one number that repeats in linear time using less than O(n) space and traversing the stream sequentially O(1) times.
 * Sample Input:
 *
 * [3 4 1 4 1]
 *
 * Sample Output:
 *
 * 1
 *
 * If there are multiple possible answers ( like in the sample case above ), output any one.
 *
 * If there is no duplicate, output -1
 *
 * Logic : Should mark the value's index (starts from 0, so value -1), to negative while traversing
 * if you are encountering a negative value in the traversal, that means we are again visiting that valu's index
 * https://www.youtube.com/watch?v=YoPx8sG_a7E
 *
 *
 */
public class FindDuplicateinArray1ToN {

    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int repeatedNumber(final int[] A) {
        // Traverse and mark the value at given index negative.
        // if negative val is encountered that means its duplicating

        ArrayList<Integer> result = new ArrayList<>();

        for (int i =0 ; i< A.length; i++){
            int index =Math.abs(A[i]) -1;
            int val =  A[index];

            if (val>0){ // if the index of given value is not marked  it means its new one
                A[index] = A[index] * -1;
            } else { // if the index of given value is marked already that means its a duplicate
                result.add(Math.abs(A[i]));
            }
        }
        return result.get(0);
    }
}
