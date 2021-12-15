package com.interview.arrays;


import java.util.ArrayList;
import java.util.List;

/**
 * @author Nilesh Kumar
 * https://www.interviewbit.com/problems/kth-row-of-pascals-triangle/
 * Problem Description
 *
 * Given an index k, return the kth row of the Pascal's triangle.
 * Pascal's triangle: To generate A[C] in row R, sum up A'[C] and A'[C-1] from previous row R - 1.
 *
 * Example:
 *
 * Input : k = 3
 *
 *
 * Return : [1,3,3,1]
 *
 * Note: k is 0 based. k = 0, corresponds to the row [1].
 *
 * Note: Could you optimize your algorithm to use only O(k) extra space?
 *
 * Logic : in Kth row, given column of pascal triangle is sum of previous previous column-1 and column
 * 0(n2)
 *
 */
public class PascalTriangleKthRows {
    public static ArrayList<Integer> getRow(int A) {
        // finding the Kth rows of pascal triangle
        // List<ArrayList<Integer>> finalResult = new ArrayList<ArrayList<Integer>>();
        // We are using just row and prev  only and overriding them one by one to save space
        ArrayList<Integer> row, prev = null;

        // Printing pascal triangle of K rows
        for (int i = 0 ; i<= A; ++i){
            row = new ArrayList<Integer>();
            for(int j =0; j<= i; ++j){
                // if its first column or last column its always 1
                if(j==0 || j==i){
                    row.add(1);
                }
                else{
                    // get the previous rows first two column to get the current values
                    row.add(prev.get(j-1)+ prev.get(j));
                }
            }
            // To print the Kth row only return this
            prev = row;
            // if we have to print all the rows till Kth rows we will keep on adding the result like below
            //finalResult.add(row);
        }
        return prev;
    }

    public static void main(String[] args){
        ArrayList<Integer> result = getRow(4);
        for(Integer i : result){
            System.out.print(i);
        }
    }


}

