package com.interview.arrays;

import java.util.ArrayList;
import java.util.Collections;

/**
 * https://www.interviewbit.com/problems/wave-array/
 * Problem Description
 *
 * Given an array of integers A, sort the array into a wave like array and return it, In other words, arrange the elements into a sequence such that
 *
 * a1 >= a2 <= a3 >= a4 <= a5.....
 * NOTE : If there are multiple answers possible, return the one that's lexicographically smallest.
 *
 *
 *
 * Problem Constraints
 * 1 <= len(A) <= 106
 *
 * 1 <= A[i] <= 106
 *
 *
 *
 * Input Format
 * First argument is an integer array A.
 *
 *
 *
 * Output Format
 * Return an array arranged in the sequence as described.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [1, 2, 3, 4]
 * Input 2:
 *
 * A = [1, 2]
 *
 *
 * Example Output
 * Output 1:
 *
 * [2, 1, 4, 3]
 * Output 2:
 *
 * [2, 1]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * One possible answer : [2, 1, 4, 3]
 * Another possible answer : [4, 1, 3, 2]
 * First answer is lexicographically smallest. So, return [2, 1, 4, 3].
 * Explanation 1:
 *
 * Only possible answer is [2, 1].
 *
 * Logic : Sort the array and then swap the numbers in pairs
 *  ref : https://www.youtube.com/watch?v=XtdrxX1nkhA
 *
 */
public class WaveArray {
    // Logic : https://www.youtube.com/watch?v=XtdrxX1nkhA
    // Sort the given element and then swap the numbers in the pairs, that will gave the wave
    public ArrayList<Integer> wave(ArrayList<Integer> A) {
        if(A.size() <2) return A;
        // Sorted the numbers
        Collections.sort(A);


        // Swap the number in pairs
        for (int i=0 ; i<A.size()-1; i= i+2){
            int temp = A.get(i);
            A.set(i, A.get(i+1));
            A.set(i+1 , temp);
            //i = i+1; // Since we are swapping in pairs increase by 2
        }
        return A;

    }
}
