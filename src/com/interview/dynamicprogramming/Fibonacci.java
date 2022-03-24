package com.interview.dynamicprogramming;

public class Fibonacci {
    public static void main(String[] args) {
        int n = 10;
        //int ans = fibonacci(n);
        int ans = fibonacci(n, new int[n+1]);
        System.out.println("Fibo ans is : " + ans);
    }

    // NEW dp way, storing the value in an array tabulation.
    private static int fibonacci(int n, int [] dp){
        if(n==0 || n==1){
            return n;
        }
        if(dp[n] !=0){
            // we will fetch the value from stored array
            return dp[n];
        }
        int fibo1 = fibonacci(n-1,dp);
        int fibo2 = fibonacci(n-2,dp);
        int fibon = fibo1 + fibo2;
        // sotre the calculation against the dp
        dp[n] = fibon;
        return fibon;
    }
    // Old recursion way
    private static int fibonacci(int n) {
        if (n == 0 || n==1){
            return n;
        }
        int fibon1 = fibonacci(n-1);
        int fibon2 = fibonacci(n-2);
        int fibon = fibon1 + fibon2;
        return fibon;
    }

}
