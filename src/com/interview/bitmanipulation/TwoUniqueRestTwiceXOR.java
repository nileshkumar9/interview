package com.interview.bitmanipulation;

import java.util.ArrayList;

/**
 * @nilesh kumar
 * All Repeating Except Two | Two Unique Rest Twice | Bit Manipulation Interview Questions
 *
 * https://www.youtube.com/watch?v=pnx5JA9LNM4&list=PL-Jc9J83PIiFJRioti3ZV7QabwoJK6eKe&index=9
 *
 * one set will have 0 to RMSB or 1 to RMSB
 */
public class TwoUniqueRestTwiceXOR {
    public int twoUniqueRestTwiceXOR(ArrayList<Integer> lists) {
        int unique = 0;
        // doing xor will give two unique number xor , x xor y
        int xxory = 0;
        for (Integer list : lists) {
             xxory= xxory ^ list;
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
        System.out.println( x);
        System.out.println( y);

        return unique;

    }

    public static void main(String[] args) {
        TwoUniqueRestTwiceXOR twoUniqueRestTwiceXOR = new TwoUniqueRestTwiceXOR ();
        ArrayList<Integer> lists = new ArrayList<Integer>();
        lists.add(10); // 10 and 11 are unique
        lists.add(11);
        lists.add(12);
        lists.add(12);
        lists.add(13);
        lists.add(13);
        lists.add(14);
        lists.add(14);

        int unique = twoUniqueRestTwiceXOR.twoUniqueRestTwiceXOR(lists);
        System.out.print("Unique number : " + unique);
    }
}
