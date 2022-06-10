package com.comp.dell;

public class FactorialCalulation {
    public static void main(String[] args) {
        System.out.println( "factorial of 5 is " + calculateFactorial(10));

        int[] dp = new int[10+1];
        System.out.println( "factorial of 5 is dp " + calculateFactorialUsingDp(10, dp));



    }

    private static int calculateFactorial(int i) {

        if(i <= 1){
            return 1;
        }
        int result = i * calculateFactorial(i-1);

        return result;
    }
    private static int calculateFactorialUsingDp(int i, int[] dp){

        if (i<=1){
            return 1;
        }
        if(dp[i] !=0){
            return dp[i];
        }
        return i * calculateFactorial(i-1);
    }
}
