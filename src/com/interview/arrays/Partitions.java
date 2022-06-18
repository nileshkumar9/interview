package com.interview.arrays;

import java.util.ArrayList;

/**
 * Problem Description
 *
 * You are given a 1D integer array B containing A integers.
 *
 * Count the number of ways to split all the elements of the array into 3 contiguous parts so
 * that the sum of elements in each part is the same.
 *
 * Such that : sum(B[1],..B[i]) = sum(B[i+1],...B[j]) = sum(B[j+1],...B[n])
 *
 *
 *
 * Problem Constraints
 * 1 <= A <= 105
 *
 * -109 <= B[i] <= 109
 *
 *
 *
 * Input Format
 * First argument is an integer A.
 *
 * Second argument is an 1D integer array B of size A.
 *
 *
 *
 * Output Format
 * Return a single integer denoting the number of ways to split the array B into three parts with the same sum.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = 5
 *  B = [1, 2, 3, 0, 3]
 * Input 2:
 *
 *  A = 4
 *  B = [0, 1, -1, 0]
 *
 *
 * Example Output
 * Output 1:
 *
 *  2
 * Output 2:
 *
 *  1
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  There are no 2 ways to make partitions -
 *  1. (1,2)+(3)+(0,3).
 *  2. (1,2)+(3,0)+(3).
 * Explanation 2:
 *
 *  There is only 1 way to make partition -
 *  1. (0)+(-1,1)+(0).
 *
 *  Logic : https://www.interviewbit.com/problems/partitions/
 *
 */
public class Partitions {

    public int solve(int A, ArrayList<Integer> B) {

        int totalSum = 0;
        // find the total sum of the ArrayList
        for(Integer val : B){
            totalSum += val;
        }
        // if total sum is integer division of 3 then proceed else return
        if (totalSum %3 != 0){
            return 0; // as the total sum in not divisable by three.
        }

        int oneThirdSum = totalSum/3;
        int twoThirdSum = 2 * (oneThirdSum) ;
        int count = 0 ;
        int oneThirdSumCount = 0;
        int sum = 0;

        for(int i = 0 ; i < A-1; i++){
            sum = sum + B.get(i);

            if (sum == twoThirdSum){
                count = count + oneThirdSumCount; // get all the combinations including two thirt sum
                // Putting this condition above the onthird check is important
            }

            if (sum == oneThirdSum){
                oneThirdSumCount ++; // get the combinations for oneThirdSum sum
            }

            // We don't need to do for third sections as the last section will always remain constant.


        }
        return count;
    }
}
