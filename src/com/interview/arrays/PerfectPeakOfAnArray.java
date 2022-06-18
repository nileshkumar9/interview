package com.interview.arrays;

/**
 * @author Nilesh Kumar
 *
 * InterviewBit
 *
 * Given an integer array A of size N.
 *
 * You need to check that whether there exist a element which is strictly greater than all
 * the elements on left of it and strictly smaller than all the elements on right of it.
 *
 * If it exists return 1 else return 0.
 *
 * NOTE:
 *
 * Do not consider the corner elements i.e A[0] and A[N-1] as the answer.
 *
 *
 * Problem Constraints
 * 3 <= N <= 105
 *
 * 1 <= A[i] <= 109
 *
 *
 *
 * Input Format
 * First and only argument is an integer array A containing N integers.
 *
 *
 *
 * Output Format
 * Return 1 if there exist a element that is strictly greater than all the elements on left of it
 * and strictly  smaller than all the elements on right of it else return 0.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [5, 1, 4, 3, 6, 8, 10, 7, 9]
 * Input 2:
 *
 *  A = [5, 1, 4, 4]
 *
 *  Logic :
 *  1) Create two arrays mx and mn each of sixe n.
 *  mx[i] stores the greates element within the range of a[0] to a[i];
 *  mn[i] stores the smallest element within the range of a[n-1] to a[i]
 *  To find if any such element exists or not, loop from index 1 to n-2 as last element we don't hv to consider.
 *  if for any index i; a[i]> mx[i] and mn[i] < a[i] then this is the required lment (even for repeating cases.)
 *
 *
 */
public class PerfectPeakOfAnArray {
    public static int perfectPeak(int[] A) {

        int found = 0;
        int n = A.length;
        int[] mx = new int[n];
        int[] mn = new int[n];
        mx[0] = A[0];
        mn[n-1] = A[n-1];

        int mxx = A[0];
        int mnn = A[n-1];

        // find max element from 1st element till last
        for (int i = 1; i< n;i++){
            mxx = Math.max(mxx,A[i]);
            mx[i] = mxx;
        }
        // find min from current element to n-1 element
        for (int i = n-2; i>=0;i--){
            mnn = Math.min(mnn,A[i]);
            mn[i] = mnn;
        }

        for(int i=1 ; i< n-1; i++){
            // because if it is peak element it would be greater than max of start till its index
            // and minimum of last index to its index.
            if ((A[i] > mx[i-1]) && (A[i] < mn[i+1])){
                found =1;
                //return A[i];
                break;
            }
        }
        return found;
    }



    public static void main(String[] args) {
        //int[] nums = { 8, 9, 10, 2, 5, 6 };
        int[] nums = {1, 2, 3, 4, 5, 4, 3, 2, 3, 10};
        System.out.println("The peak element is " + perfectPeak(nums));
    }
}