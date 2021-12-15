package com.interview.arrays;

/**
 * @author Nilesh Kumar
 * <p>
 * For given two character array, if all elements are put into cycle, can you compare
 * both the array and find both the char are cyclic equals.
 * Logic :
 * Take one array and compare the matching element with another array.
 */
public class CyclicTwoArrays {
    public static void main(String args[]) {
        char[] char1 = new char[]{'n', 'i', 'l', 'e', 's', 'h'};

        char[] char2 = new char[]{'h', 'n', 'i', 'l', 'e', 's'};
        boolean foundCycle = false;

        if (char1.length != char2.length) {
            System.out.println("false");
        }

        for (int j = 0; j < char2.length; j++) {
            // K will be used to start from first elment of first array.
            // taking another temp pointers for j, to iterate in case we have found the match.
            int k = 0;
            int l = j;
            while (char1[k] == char2[l] && k < char1.length) {
                if (l == char2.length - 1) {
                    l = 0;
                }
                k = k + 1;
                l = l + 1;
            }
            if (k == char1.length - 1) {
                foundCycle = true;
                break;
            }
        }
        if (foundCycle) {
            System.out.println("Cycle found");
        } else {
            System.out.println("No Cycle found");
        }
    }
}