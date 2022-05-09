package com.interview.dynamicprogramming;

/**
 * https://www.youtube.com/watch?v=VT4bZV24QNo&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=22
 * <p>
 * A problem in which we don't have to include subsequent element.
 * In Greedy algorithm we will ignore some subsets of data, that is what we will do here.
 */
public class MaximumSumNonAdjacentElements {

    public static void main(String[] args) {

        int[] input = {5, 10, 10, 100, 5, 6};
        // To find the maximum sum
        // we will form a dp array
        int exclude = 0;
        int include = input[0]; // we will take the first element in include set
        // now iterate through the whole input
        for (int i = 1; i < input.length; i++) {

            // when building next include, we take what is in previous exclude and add current element to it
            int newInclude = exclude + input[i]; // if we are including current element
            // While building exclude, we take max of previous include and exclude and add current elemen tto it
            int newExclude = Math.max(exclude, include); // if we are excluding current element

            include = newInclude;
            exclude = newExclude;
        }

        System.out.println("Sax sum for non-adjacent element will be : " + Math.max(include, exclude));
    }
}
