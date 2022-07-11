package com.interview.graph.shortestPath;

import java.util.ArrayList;

public class SumOfFibonacciNumbers {

    public int fibsum(int A) {
        // solution 1 : This will be unbounded knapsack problem
        // Approach 2 : This can be solved with BFS
        // Approach 3: Using concept of fibonaci


        int result = approach3(A);
        return result;


    }

    /**
     * We will generate the fibonacci number till given number.
     * Now we will prepare a dp array.
     * Here we will always get the result with the immediate previous fibo number in array
     *
     * e.g : 1 1 2 3 5 8 13 --- is a fibonacci numbers
     * we will create an array to generate 1 to N number
     * // Two pointers technique, if we find the number in fibo array then the cound will be 1.
     * if not found in fibo array then the count will be immediate previous fibo number + value in dp array of difference of imeediate previous number
     *
     *
     *  Numbers : 1, 2, 3, 4, 5, 6, 7
     *            1  1  1  2  1  2  2
     *  for 4 = (count of immediate previous fibo 3 + count of diff of fibo (4-3) of 1)
     *
     */

    private int approach3(int n) {

        //int[] fiboTillNFiboNumbers = fiboTillNFiboNumbers(a);
        // Generate fibo number till given number a
       // int[] fiboArray = new int[n];
        ArrayList<Integer> fiboArray = new ArrayList<Integer>();
        int count =0;
        fiboArray.add(count,1);
        count++;
        int temp = 2;
        // here we will have an array till N number in an array
        while(temp <=n){
            fiboArray.add(count++,   temp);
            temp = fiboArray.get(count-1) + fiboArray.get(count-2);
        }
        // Now start finding minimum sum
        int ans =0;
        // since the fiboArray will be sorted array we can start from last
        int i= fiboArray.size()-1;
        while(n>0){
            if(fiboArray.get(i) <= n){
                ans++; // immediate previous of same is found, increase the answer count.
                int diff = n-fiboArray.get(i);
                // since we found the immediate previous, we will have to find the
                // immediate prefious or same of the difference
                n = diff;
            }
            i--;
        }
        return ans;
    }

    private int[] fiboTillNFiboNumbers(int a) {
        int[] result = new int[a+1];
        int[] dpArray = new int[a+1];
        calculateFibo(a, result, dpArray);

        return result;
    }

    private int calculateFibo(int a, int[] result, int[] dpArray) {

        if(a==1 || a ==0) {
            result[a] = 1;
            dpArray[a] = 1;
            return 1;
        }

        if (dpArray[a] != 0){
            return dpArray[a];
        }

        int fibon1 = calculateFibo(a-1, result, dpArray);
        int fibon2 = calculateFibo(a-2, result, dpArray);
        int fibo = fibon1 + fibon2;
        result[a] = fibo;
        dpArray[a] = fibo;

        return fibo;
    }

    public static void main(String[] args) {
        SumOfFibonacciNumbers fibo = new SumOfFibonacciNumbers();

        fibo.fibsum(7);


    }
}
