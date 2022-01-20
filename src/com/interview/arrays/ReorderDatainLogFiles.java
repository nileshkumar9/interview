package com.interview.arrays;

import java.util.Arrays;

/**
 *
 * Logic : https://www.youtube.com/watch?v=RAb3of36dm4
 */

public class ReorderDatainLogFiles {

    public static String[] reorderLogs(String[] A) {

        Arrays.sort(A, (log1, log2) -> {
            // created a lambda function here to have custom sorting logic
            String[] log1Split = log1.split("-",2);
            String[] log2Split = log2.split("-", 2);

            boolean isLog1digit = Character.isDigit(log1Split[1].charAt(0)) ;
            boolean isLog2digit = Character.isDigit(log2Split[1].charAt(0)) ;

            //1. if both are letter array then sort based on values
            if (!isLog1digit && !isLog2digit){
                int comparision = log1Split[1].compareTo(log2Split[1]);
                // if both the values in letter log are same then sort based on the key
                if ( comparision ==0 ){
                    return log1Split[0].compareTo(log2Split[0]);
                }
                return comparision;
            }

            // if one is letter and one is digit logs
            if(isLog1digit){
                if(isLog2digit){
                    // Both are digit logs , let them be as it is without reordering
                    return 0;
                }
                // Here, log2 is letter so it should go above the digit logs
                return 1;
            }

            // Here log1 is letter log and log2 must be digit log, because if its not then the first if condition would have been satisfied wehre both of them are letter logs.
            // Since log1 is letter log and log2 is digit log, log1 should some first.
            return -1;

        });
        return A;
    }


    public static void main (String[] args){
        String [] A = new String []
        { "qv4-tbojcv-yd", "uh9-lmtdpiunu", "ta9-5-3-5-5-1", "hn2-yawf-jw-zkw", "nc7-hdly-hrht", "ja7-6-5-7-0-4", "ld1-le-cmt-t-z", "hu2-wfkpj-jv", "iy0-hujr-wmrg-ca", "ia7-y-l-bnaz", "nr1-7-1-7-0-4", "gx0-sm-by-wd-ea" };

        reorderLogs(A);
    }
}

