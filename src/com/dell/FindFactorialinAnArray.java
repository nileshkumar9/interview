package com.dell;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindFactorialinAnArray {

    /**
     * factorial both {10, 5, 1024, 120, 32}
     * Factorial of 5 means => 5 x 4 x 3 x 2 x 1
     * Find if there exists a factorial for this number
     *
     */

    static BigInteger calculateFactorial(int number){
         BigInteger fact   = new BigInteger("1");

         for (int i = 2; i <= number; i++)
             fact = fact.multiply(BigInteger.valueOf(i));

        return fact;
    }


    public static void main(String[] args){

        ArrayList<Integer>  a = new ArrayList<>();
        a.add(10);
        a.add(5);
        a.add(1024);
        a.add(120);
        a.add(32);

        // fact(5) = 120 // good approach to solve this remember the previous values
        // Sort the array
        //5 , 10, 32, 120 , 1024

        // impove the factorial


        for (int i=0;i<a.size(); i++){
            BigInteger factorial = calculateFactorial(a.get(i));
            boolean found = a.contains(factorial);
            //boolean found = findIfPresentInArray(factorial,a);
            if(found){
                System.out.println(a.get(i)+ "  factorial : " + factorial + " found");
                break;
            }
        }
    }


}
