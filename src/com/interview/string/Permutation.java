package com.interview.string;

/**
 * Java program to find all permutations of a given String using recursion.
 * For example, given a String "XYZ", this program will print
 * all 6 possible permutations of * input e.g. XYZ, XZY, YXZ, YZX, ZXY, XYX
 *
 *
 * After 1st iteration perm (first parameter of permutation() method) will be
 * "" + 1 as we are doing word.charAt(i) and i is zero. Next, we take out that
 * character and pass the remaining characters to the permutation method again
 * e.g. "23" in the first iteration.
 *
 * The recursive call ends when it reaches to base case i.e. when the remaining
 * word becomes empty, at that point "perm" parameter contains a valid permutation
 * to be printed. You can also store it into a List if you want to.
 *
 *
 *
 */
public class Permutation {

    private static void permutation(String perm, String word) {
        System.out.println("Perm is : " + perm + " word : " + word);
        if (word.isEmpty()) {
            System.out.println("Came in this");
            System.err.println(perm + word);
        } else {
            for (int i = 0; i < word.length(); i++) {
                permutation(perm + word.charAt(i), word.substring(0, i) + word.substring(i + 1, word.length()));
            }
        }
    }

    public static void main(String[] args) {

        String word = "1234";
        permutation("", word);

    }
}
