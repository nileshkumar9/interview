package com.interview.arrays;

import java.util.ArrayList;

/**
 * https://www.interviewbit.com/problems/minimum-lights-to-activate/
 *
 * Problem Description
 *
 * There is a corridor in a Jail which is N units long. Given an array A of size N. The ith index of this array is 0 if the light at ith position is faulty otherwise it is 1.
 *
 * All the lights are of specific power B which if is placed at position X, it can light the corridor from [ X-B+1, X+B-1].
 *
 * Initially all lights are off.
 *
 * Return the minimum number of lights to be turned ON to light the whole corridor or -1 if the whole corridor cannot be lighted.
 *
 * Problem Constraints
 * 1 <= N <= 1000
 *
 * 1 <= B <= 1000
 *
 *
 *
 * Input Format
 * First argument is an integer array A where A[i] is either 0 or 1.
 *
 * Second argument is an integer B.
 *
 *
 *
 * Output Format
 * Return the minimum number of lights to be turned ON to light the whole corridor or -1 if the whole corridor cannot be lighted.
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [ 0, 0, 1, 1, 1, 0, 0, 1].
 * B = 3
 * Input 2:
 *
 * A = [ 0, 0, 0, 1, 0].
 * B = 3
 *
 *
 * Example Output
 * Output 1:
 *
 * 2
 * Output 2:
 *
 * -1
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * In the first configuration, Turn on the lights at 3rd and 8th index.
 * Light at 3rd index covers from [ 1, 5] and light at 8th index covers [ 6, 8].
 * Explanation 2:
 *
 * In the second configuration, there is no light which can light the first corridor.
 *
 * Logic : https://www.youtube.com/watch?v=JG77IVjK8D8
 *
 * Starting from begining we will segment in each given range of B, will find if there is a bulb
 * starting from right in given segment and then we will light it up.
 *  Then we will see go to the next index of i which will be B+righ(index wehre we found a previous bulb)
 *
 *
 */
public class MinimumLightsToActivate {
    public int solve(ArrayList<Integer> A, int B) {
        int n = A.size();
        int count = 0;
        int i = 0;
        while(i<n){
            // for given index we will have a right most index at i+(b-1) and left at i-(B-1)

            int right = Math.min(i+B-1, n-1); // Max or min is required to prevent array out of bound exceptions
            int left = Math.max(i-B+1,0);
            boolean bulbFound = false;
            while(right>left){ // for each segment we will loop and find the presence of bulp, if found we will break as the bulb is found in given segment box
                if(A.get(right) ==1){
                    bulbFound = true;
                    break;
                }
                right --;
            }
            if(!bulbFound){ // return -1 when bulp is not found in a given segment
                return -1;
            }
            count ++; // increse the counter as at this point bulb is found in a segment
            i = right + B; // next i will be from the position the bulp is found (right) to the range of bulb because of B
        }
        return count;
    }
}

