package com.interview.graph.bfs;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class SmallestMultipleWith0And1_BFS_Unoptimized1 {
    /**
     * https://www.interviewbit.com/problems/smallest-multiple-with-0-and-1/
     * You are given an integer N. You have to find smallest multiple of N
     * which consists of digits 0 and 1 only. Since this multiple could
     * be large, return it in form of a string.
     * <p>
     * Note:
     * <p>
     * Returned string should not contain leading zeroes.
     * For example,
     * <p>
     * For N = 55, 110 is smallest multiple consisting of digits 0 and 1.
     * For N = 2, 10 is the answer.
     *
     * Logic : https://www.youtube.com/watch?v=Om47LiGTy8o
     *  All binary will formed by adding 0 and 1 in the last. that wil give next sequence of number
     *  E.g : for 1 -> 1
     *            2 -> 10 (Added 0 in the last
     *            3 -> 11 (Added 1 in the last)
     *            4 -> 100 (Added 0 in last of 2)
     *  We will keep on iterating through the list and do the mod % of itself. The first number
     *  getting fully diviged is our answer (number % 4 ==0 ).
     *
     *  Now Since number is string start iterating from start index of string, and then
     *  use the formula (current*10 + (stringAt[i] -'0'.
     *  Also do the modular, because
     *
     *
     */
    public String multiple(int N) {

        Queue<String> queue = new ArrayDeque<>();
        queue.add("1"); // First number will always be 1

        // Create a hashset
        Set<Integer> setValue = new HashSet<>();


        // Now we will keep on iterating over the queue
        while(queue.size() > 0){
            // remove mar * work add *
            String s = queue.remove();
            int reminder = modulus(s , N); // do the modulus of this string with N
            if (reminder == 0 ){
                // we found the first multiple of N, so we will discontinue
                return s;
            }
            if(!setValue.contains(reminder)){
                setValue.add(reminder);
                queue.add(s + '0'); // next value for this string will be 0
                queue.add(s + '1'); // 2nd value will found concatinating 1;
            }

        }

        return null;
    }

    private int modulus(String s, int n) {
        // Since the integer will be very big, hence we will do the modulous in string
        // as integer cannot hold beyond 32 letter
        int current = 0;
        for (int i =0; i< s.length() ; i++){
            current = current * 10 + (s.charAt(i) - '0');
            // we are doing the modulouse of current to reduce the size
            // otherwise string and current at end of this loop will be same
            // and we will run out of int value storage.
            // Also fact is mod of individual digits by number is same as the whole number by given number
            current %= n;
        }
        return current;
    }
}