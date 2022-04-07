package com.interview.dynamicprogramming;

/**
 * https://www.youtube.com/watch?v=0nF-BMYy7tc&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=19
 * Count binary String similar problem
 * Q : To have to arrange the building , but two building will not be consequitives
 * Here there will be two land of building blocks, and a road in between.
 *
 * Ans : this is similar to what we have in dount binary string where we were not allowing
 *      two zeroes together. But here the extra addition is that we have two parallel blocks.
 *      We will solve one lane similar to the pre-req questions and then we will
 *      go into the other side off the lane.
 *
 *
 * explanation read 0 as building and 1 as space.
 *
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
 *
 *
 *  if we have solved for one row and got 5 ways,
 *  so total ways of solving the answer is 5*5 = 25
 *
 */
public class ArrangeBuilding {
    public static void main(String[] args) {

        int n = 5;
        int[] dpBuildings = new int[n + 1];
        int[] dpSpace = new int[n + 1];

        // fill the oth position
        dpBuildings[0] = 0;
        dpSpace[0] = 0;

        dpBuildings[1] = 1; // we can fill in one way
        dpSpace[1] = 1; // we can fill in one way

        for(int i = 2; i<= n; i++)
        {
            // at each positions, for zeores, we take all the value from previous index of one
            // we will not take previous zeroes as it will make it consecutives and will violates
            dpBuildings[i] = dpSpace[i-1];
            // at give index, for ones array, we will take sum of previous zero and 1
            dpSpace[i] = dpBuildings[i-1] + dpSpace[i-1];
        }

        int totalForOneSide = ( dpBuildings[n] + dpSpace[n]);
        int totalForBothSide = totalForOneSide * totalForOneSide;

        System.out.println( "  totalForBothSide :  " + totalForBothSide);
    }
}
