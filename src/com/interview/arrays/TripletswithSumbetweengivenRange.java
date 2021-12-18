package com.interview.arrays;


import java.util.ArrayList;
import java.util.Collections;

/**
 * https://www.interviewbit.com/problems/triplets-with-sum-between-given-range/
 * Given an array of real numbers greater than zero in form of strings.
 *
 * Find if there exists a triplet (a,b,c) such that 1 < a+b+c < 2 .
 *
 *  Return 1 for true or 0 for false.
 *
 * Example:
 *
 * Given [0.6, 0.7, 0.8, 1.2, 0.4] ,
 *
 * You should return 1
 *
 * as
 *
 * 0.6+0.7+0.4=1.7
 *
 * 1<1.7<2
 *
 * Hence, the output is 1.
 *
 * O(n) solution is expected.
 *
 * Logic : https://www.youtube.com/watch?v=XoWPmK9B_hg
 * Here we should sort the array first, check for i=0; mid and J =end
 * If value is greater than max value decrease the J last element index because this will be contributing  most.
 * if the value is less then given range then increase the lower bound.
 * At any given point i , mid and J forming triplet will return the first match and will break.
 */
public class TripletswithSumbetweengivenRange {
    public static int solve(ArrayList<String> A) {

        // Sort the ArrayList
        Collections.sort(A);
        int i=0;
        int j= A.size()-1;
        int mid =0;

        while((j-i)>=2){
            mid = (i + j)/2;

            Double a = Double.valueOf(A.get(i));
            Double b = Double.valueOf(A.get(j));
            Double c = Double.valueOf(A.get(mid));
            double sum = a+b+c;
            if(sum >2 ){ // since the array is sorted if sume is greater than 2 we should reduce the right index.
                j--;
            } else if (sum < 1){
                i++;
            } else {
                return 1;
            }

        }
        return 0;
    }
    public static void main (String[] args){
        ArrayList<String> A = new ArrayList<>();
        A.add("2.673662");
        A.add( "2.419159");

        A.add( "0.573816");
        A.add( "2.454376");
        A.add( "0.403605");
        A.add( "2.503658");
        A.add("0.806191");


        int result = solve(A);
        System.out.print(result);
    }
}

