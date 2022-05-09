package com.interview.dynamicprogramming;

/**
 * https://www.youtube.com/watch?v=ju8vrEAsa3Q&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=26
 * <p>
 * In how many ways we can paing for given colors, so that not more than two consequitive
 * fences should have more than same colors.
 * <p>
 * <p>
 * Let fence number is n = 5
 * let number of color is k = 3
 * <p>
 * DP :
 * 1) Storage and meaning : For given locations, in how many ways we can paint a fence
 * Such that not more then two fences has same color. Two scenario will evolve here
 * <p>
 * a) Either its consequitive same color : Then its same count previous different condition
 * b) Either its not same color : Then its prevous total * (k-1) . That will be the combinations.
 * Calculate total in the end.
 * 2) Direction from 0 to n
 * 3) Travel and solve
 */
public class PaintFence {


    public static void main(String[] args) {

        int numberOfFence = 5;
        int numberOfColor = 3;


        long lastTwoSameColor = numberOfColor * 1; // For first two fence
        long lastTwoDifferentColor = numberOfColor * (numberOfColor - 1); // for first two different fence

        long total = lastTwoDifferentColor + lastTwoSameColor;

        for (int i=3; i<=numberOfFence ; i++){
            lastTwoSameColor = lastTwoDifferentColor; // it will be same as last total
            lastTwoDifferentColor = total * (numberOfColor-1); // as we have to make diff color, so take all combination from last total and then  paint with color other then the color used.

            total = lastTwoDifferentColor + lastTwoSameColor;



        }
        System.out.println( "Total colors : " + total);

    }
}
