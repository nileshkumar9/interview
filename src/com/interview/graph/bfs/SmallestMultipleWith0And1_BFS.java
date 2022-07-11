package com.interview.graph.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class SmallestMultipleWith0And1_BFS {
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
     *  Also : if we have got a reminder r for string s,
     *      : Fact is , next child will be found using (s + '0' and s+'1'),
     *      but reminder will also be found using (r *10 + 0) % N and (r*10 +1) %N
     *      So we are saved of calculating mod for entire string, rather we are using
     *      the remainder calculated at previous step.
     *  Antther optiationzation :
     *      if smaller string has given us remainder r, then we will not consider
     *      the larger string, and hence we will not add it into the queue, because,
     *      the smaller string will be the first multiple if at all we are going to
     *      find the value by concatinating 0 and 1 into it.
     *
     *
     */
    public String multiple(int N) {
        if (N==1) return "1";

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1); // first reminder of "1" is 1 // we are pushing 1 and not remainder.

        // Now we will have a Arraylist of string to assiciate remainter with string
        //ArrayList<String> v = new ArrayList<>();
        // We will store at each index the corresponding string for the remainder
        // that we have got
        String [] v = new String[N+1];
        v[1] = "1";


        // Create a hashset
        Set<Integer> setValue = new HashSet<>();


        // Now we will keep on iterating over the queue
        while(queue.size() > 0){
            // remove mar * work add *
            Integer reminder = queue.remove();

            if (reminder == 0 ){
                // we found the first multiple of N, so we will discontinue
                return v[0]; //as v[0] is hloding string that is having remainder as 0;
            }
            // two reminders that we will get is
            int r0 = (reminder * 10 + 0) % N ; // this is to find the next reminder using this reminder.
            int r1 = (reminder * 10 + 1) % N ;
            // Advantage here is that we are calculating mod and not on actual string hence reducing time
            // also reminder will be in range of 1 to N-1

            // Now checking if we have not added this reminder then we will push it into our string
            if(v[r0] == null){
                // that means we have never encountered it
                v[r0] = v[reminder] + '0'; // previous string + '0';
                // add into queue
                queue.add(r0);
            }

            if(v[r1] == null){
                // that means we have never encountered it
                v[r1] = v[reminder] + '1'; // previous string + '0';
                // add into queue
                queue.add(r1);
            }

        }

        return v[0]; // will be null if not filled within the loop.
    }


}
