package com.interview.dynamicprogramming;

/**
 * https://www.youtube.com/watch?v=nqrXHJWMeBc&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=18
 * Count binaryString
 * We will have either at 0/1, we will either put 0 or 1
 * to form n lenght, the combinations will be 2^n. for 4 length of string it will be 2^4
 * Its a kind of include exclude
 * <p>
 * <p>
 * Problem is to give the count of binary string that doesn't have consequitive zeroes
 * <p>
 * <p>
 * DP : 1) Storage and meaning
 * We will make two array one that ends at 0, another that ends at 1.
 * At each of the cell it will contains the count that has the combinations
 * that follows our rule and ends at 0 or 1. O's will go in 0 array
 * and the one ending at 1 will go in 1 array.
 * <p>
 * 2) Direction
 * To start with 0th element and then go to the length of dp
 * 3) Travel and solve
 * In each iterations, we will
 * <p>
 * <p>
 * PS : If we are validating all the values, at the given index in dp, then its a permutation
 * else if we are only considering on value in one iteration, then its a combination.
 */
public class CountBinaryString {
    public static void main(String[] args) {

        int n = 6;
        int[] dpZeroes = new int[n + 1];
        int[] dpOnes = new int[n + 1];

        // fill the oth position
        dpZeroes[0] = 0;
        dpOnes[0] = 0;

        dpZeroes[1] = 1; // we can fill in one way
        dpOnes[1] = 1; // we can fill in one way

        for(int i = 2; i<= n; i++)
        {
            // at each positions, for zeores, we take all the value from previous index of one
            // we will not take previous zeroes as it will make it consecutives and will violates
            dpZeroes[i] = dpOnes[i-1];
            // at give index, for ones array, we will take sum of previous zero and 1
            dpOnes[i] = dpZeroes[i-1] + dpOnes[i-1];
        }

        System.out.println( "total sum :  " + ( dpZeroes[n] + dpOnes[n]));



    }
}
