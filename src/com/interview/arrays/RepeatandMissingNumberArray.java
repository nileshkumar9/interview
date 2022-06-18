package com.interview.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.interviewbit.com/problems/repeat-and-missing-number-array/
 * There are certain problems which are asked in the interview to also check
 * how you take care of overflows in your problem.
 *
 * This is one of those problems.
 *
 * Please take extra care to make sure that you are type-casting your ints to long
 * properly and at all places. Try to verify if your solution works if number of elements is as large as 105
 *
 * Food for thought :
 *
 * Even though it might not be required in this problem, in some cases, you might be required
 * to order the operations cleverly so that the numbers do not overflow.
 * For example, if you need to calculate n! / k! where n! is factorial(n),
 * one approach is to calculate factorial(n), factorial(k) and then divide them.
 * Another approach is to only multiple numbers from k + 1 ... n to calculate the result.
 * Obviously approach 1 is more susceptible to overflows.
 * You are given a read only array of n integers from 1 to n.
 *
 * Each integer appears exactly once except A which appears twice and B which is missing.
 *
 * Return A and B.
 *
 * Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * Note that in your output A should precede B.
 *
 * Example:
 *
 * Input:[3 1 2 5 3]
 *
 * Output:[3, 4]
 *
 * A = 3, B = 4
 * Logic : https://www.youtube.com/watch?v=MvklwzVz654&list=PL-Jc9J83PIiFJRioti3ZV7QabwoJK6eKe&index=10
 * XOR on itself and from 1 to N will lead to missing and duplicate.
 *
 * Bitwise operation : FindDuplicateNumberandMissingNumberin1toN
 *
 */
public class RepeatandMissingNumberArray {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> repeatedNumber(final List<Integer> A) {
        // We will first find the XOR on given list.
        int xory=0;
        for (int val : A){
            xory = xory ^ val;
        }
        // we will create duplicacy in IT
        for(int i =1 ; i<=A.size(); i++){
            xory = xory ^ i;
        }
        // At this point we are left with x or y. One of it will be duplicating and one will be missing.

        // find the right most significant bit.
        int rmsb = xory & -xory;

        // Now we will find the duplicating and repeting repeatedNumber
        int x = 0;
        int y = 0;
        for (int val : A){
            if((val & rmsb ) == 0){
                x = x ^ val;
            } else{
                y = y ^ val;
            }
        }
        for (int i = 1; i<= A.size(); i++ ){
            if((i & rmsb ) == 0){
                x = x ^ i;
            } else{
                y = y ^ i;
            }
        }

        //Now one will be repeting and one will be missing
        //to find out whichone is repeating in X and y
        ArrayList<Integer> result = new ArrayList<>();
        for(int val : A){
            if (x == val){
                result.add(x); // Since X is matching it will be duplicating
                result.add(y); // then Y will be missing
                break;
            } else if (y == val){
                result.add(y); // Since Y is matching it will be duplicating
                result.add(x); // then x will be missing
                break;
            }
        }

        return result;
    }
}
