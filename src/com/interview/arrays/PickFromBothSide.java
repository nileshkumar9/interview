package com.interview.arrays;

/**
 * @author Nilesh Kumar
 * Problem Description
 *
 * Given an integer array A of size N.
 *
 * You can pick B elements from either left or right end of the array A to get maximum sum.
 *
 * Find and return this maximum possible sum.
 *
 * NOTE: Suppose B = 4 and array A contains 10 elements then
 *
 * You can pick first four elements or can pick last four elements or can pick 1 from front
 * and 3 from back etc . you need to return the maximum possible sum of elements you can pick.
 *
 * Problem Constraints
 * 1 <= N <= 105
 * 1 <= B <= N
 * -103 <= A[i] <= 103
 * Input Format
 * First argument is an integer array A.
 * Second argument is an integer B.
 * Output Format
 * Return an integer denoting the maximum possible sum of elements you picked.
 * Example Input
 * Input 1:
 * A = [5, -2, 3 , 1, 2]
 * B = 3
 * Input 2:
 * A = [1, 2]
 * B = 1
 * Example Output
 * Output 1:
 * 8
 * Output 2:
 * 2
 * Example Explanation
 * Explanation 1:
 * Pick element 5 from front and element (1, 2) from back so we get 5 + 1 + 2 = 8
 * Explanation 2:
 * Pick element 2 from end as this is the maximum we can get
 *
 * https://www.interviewbit.com/problems/pick-from-both-sides/
 */
public class PickFromBothSide {

    public int solve(int[] A, int B) {
        int length = A.length;
        int sum= 0;

        for (int i=0 ; i<B;i++){
            sum = A[i] + sum;
        }
        int result = sum;
        // got sum for first B elements
        // Now run do one elements at a time and go to back
        for (int i=0; i<B; i++){
            sum = sum - A[B-1-i]; // removing nth item from first
            sum = sum + A[length-1-i] ; // Adding nth item at last
            result = Math.max (result , sum);
        }
        return result ;
    }
}
