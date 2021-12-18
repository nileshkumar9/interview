package com.interview.arrays;

import java.util.ArrayList;

public class PascalTriangle {
    public ArrayList<ArrayList<Integer>> solve(int A) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(A==0) return result;


        for(int i=0; i<A ; i++){ // rows zero based index it is
            ArrayList<Integer> row = new ArrayList<Integer>();
            for(int j=0 ; j <= i ; j++){ // for columns
                if(j ==0 || j ==i){ // if first or last value set the value to 1
                    row.add(1);
                } else { // get previous rows j and j-1 value
                    row.add(result.get(i-1).get(j-1) + result.get(i-1).get(j)) ;

                }

            }
            result.add(row);

        }
        return result;
    }

    public static void main(String[] args) {
        new PascalTriangle().solve(5);
    }
}

