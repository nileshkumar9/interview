package main.java.com.arrays;

public class PickFromBothSide {
    // InterviewBit Questions
    //https://www.interviewbit.com/problems/pick-from-both-sides/
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
