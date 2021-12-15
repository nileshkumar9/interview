package com.interview.bitmanipulation;

import java.util.ArrayList;

/**
 * @nilesh kumar
 * Find Duplicate Number and Missing Number from 1 to N | One Duplicate One Missing | Bit Manipulation
 *
 * https://www.youtube.com/watch?v=MvklwzVz654&list=PL-Jc9J83PIiFJRioti3ZV7QabwoJK6eKe&index=10
 *
 * We will first form an array from 1 to N and will XOR with the given array.
 * This will cancel out all the duplicates and we will be left with repeting number and unique number.
 * From there onwards, it will be similar to TwoUniqueRestDuplicate.
 * one set will have 0 to RMSB or 1 to RMSB
 */
public class FindDuplicateNumberandMissingNumberIn1toN {
    public void twoUniqueRestTwiceXOR(ArrayList<Integer> lists) {
        int unique = 0;
        // doing xor one given set
        int xxory = 0;
        for (Integer val : lists) {
             xxory= xxory ^ val;
        }
        // then XOR from 1 to N. This will create a duplicate and will XOR out the repeting and missing number
        for(int i =1 ; i<= lists.size();i++){
            xxory = xxory^i;
        }

        // find the right most significant bit
        int rmsb = xxory & -xxory;

        // now with RMSB we will do a & which will give us either 0 or 1
        // whatever are giving 0 will be one set and what ever that is giving 1 will be another set.
        // Since we know that two unique number will lie either in 0 or 1.
        // doing XOR on these set will give us the unique set.
        int x = 0;
        int y = 0;
        for(Integer val : lists){
            if((val & rmsb )== 0){
                x = x ^ val;
            } else {
                y = y^val;
            }
        }
        // we will have to do for 1 to N because this will introduce duplicacy in the set and will xor out
        // Given set : 1 2 3 4 5 7 7 8
        // 1 to N    : 1 2 3 4 5 6 7 8 -- to introduce duplicacy
        for(int i =1; i<=lists.size() ; i++){
            if((i & rmsb )== 0){
                x = x ^ i;
            } else {
                y = y^i;
            }
        }
        // Now we know that we have x and y which can be missing and repiting

        for(int val : lists){
            if(val == x){
                System.out.println( "Missing number is " + y);
                System.out.println( "Repeating number is " + x);
                break;
            } else if (val == y){
                System.out.println( "Missing number is " + x);
                System.out.println( "Repeating number is " + y);
                break;

            }
        }


    }

    public static void main(String[] args) {
        FindDuplicateNumberandMissingNumberIn1toN twoUniqueRestTwiceXOR = new FindDuplicateNumberandMissingNumberIn1toN();
        ArrayList<Integer> lists = new ArrayList<Integer>();
        lists.add(1); // Here 7 is duplicating and 6 is missing, we will findout the duplicating and missine number
        lists.add(2);
        lists.add(3);
        lists.add(4);
        lists.add(5);
        lists.add(7);
        lists.add(7);
        lists.add(8);

       twoUniqueRestTwiceXOR.twoUniqueRestTwiceXOR(lists);
    }
}
