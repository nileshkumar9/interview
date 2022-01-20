package com.interview.dynamicprogramming;

import java.util.List;

/**
 * https://www.interviewbit.com/problems/max-sum-contiguous-subarray/
 * Find the contiguous subarray within an array, A of length N which has the largest sum.
 *
 * Input Format:
 *
 * The first and the only argument contains an integer array, A.
 * Output Format:
 *
 * Return an integer representing the maximum possible sum of the contiguous subarray.
 * Constraints:
 *
 * 1 <= N <= 1e6
 * -1000 <= A[i] <= 1000
 * For example:
 *
 * Input 1:
 *     A = [1, 2, 3, 4, -10]
 *
 * Output 1:
 *     10
 *
 * Explanation 1:
 *     The subarray [1, 2, 3, 4] has the maximum possible sum of 10.
 *
 * Input 2:
 *     A = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
 *
 * Output 2:
 *     6
 *
 * Explanation 2:
 *     The subarray [4,-1,2,1] has the maximum possible sum of 6.
 *
 *  Logic : KAdane's algorithm
 *  https://www.youtube.com/watch?v=VMtyGnNcdPw
 *
 */
public class MaxSumContiguousSubarray {

    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maxSubArray(final List<Integer> A) {
        // this is kadane's algorithms
        int currentSum = A.get(0);
        int overallSum = A.get(0);

        for (int i =1 ; i< A.size(); i++){
            if(currentSum >= 0){ // if previous sum is coming positive the given element will tag along IT
                currentSum += A.get(i);
            } else {
                currentSum = A.get(i);
            }

            // at each operation it will see if current sum becomes greater than overallSum.
            // This will give maximum sum
            if (overallSum < currentSum){
                overallSum = currentSum; // update the current sum
            }
        }
        return overallSum ;
    }

}
