package com.interview.arrays;


import java.util.ArrayList;
import java.util.Collections;

/**
 * https://www.interviewbit.com/problems/noble-integer/
 * Problem Description
 *
 * Given an integer array A, find if an integer p exists in the array such
 * that the number of integers greater than p in the array equals to p.
 *
 *
 *
 * Input Format
 * First and only argument is an integer array A.
 *
 *
 *
 * Output Format
 * Return 1 if any such integer p is found else return -1.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [3, 2, 1, 3]
 * Input 2:
 *
 *  A = [1, 1, 3, 3]
 *
 *
 * Example Output
 * Output 1:
 *
 *  1
 * Output 2:
 *
 *  -1
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  For integer 2, there are 2 greater elements in the array. So, return 1.
 * Explanation 2:
 *
 *  There is no such integer exists.
 *
 *  Logic: https://www.youtube.com/watch?v=45hD_iTCZUo
 *  Aftr sorting if the value at current index is equal to the count of number after this.
 */
public class NobelInteger {
    public static int solve(ArrayList<Integer> A) {

        // Sort the ArrayList
        Collections.sort(A);
        int size = A.size();

        // Base check when all element are negative and last element is zero
        // then after sorthing the last value will be zero in that case we will return true
        if (A.get(size-1)==0) return 1;

        // IF there exists a scneario in which for given index
        // We have exactly same number of element after this index without duplicate values
        for (int i=0; i< A.size()-1  ; i++){

            if (A.get(i) == (size - (i +1)) // number of element after this index is same as at current value
                && i+1 < A.size() // We ar counterning the overflow
                && A.get(i) < A.get(i+1)  ){
                return 1;
            }
        }
        return -1;
    }

    public static void main (String[] args){
        ArrayList<Integer> A = new ArrayList<>();
        A.add(2);
        A.add( 5);
        A.add( 7);


        int result = solve(A);
        System.out.print(result);
    }

}

