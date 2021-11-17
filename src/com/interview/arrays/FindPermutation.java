package com.interview.arrays;

import java.util.ArrayList;

/**
 * @author nilesh kumar
 * <P>
 * https://www.interviewbit.com/problems/find-permutation/
 *
 * Given a positive integer n and a string s consisting only of letters D or I,
 * you have to find any permutation of first n positive integer that satisfy the given input string.
 *
 * D means the next number is smaller, while I means the next number is greater.
 *
 * Notes
 *
 * Length of given string s will always equal to n - 1
 * Your solution should run in linear time and space.
 * Example :
 *
 * Input 1:
 *
 * n = 3
 *
 * s = ID
 *
 * Return: [1, 3, 2]
 * </P>
 * Logic is : if we find I we print the minimum value 1 and increment it
 * if we find D, we print the Max value which will be string length in begining, and then we decrment it.
 * in the end we will add the max value.
 * */
public class FindPermutation {
    public static void main(String[] args){
        String A = "DIDD";
        int n = 5;

        ArrayList<Integer> result = findPerm(A, n);
        System.out.println( result);
    }
    public static ArrayList<Integer> findPerm(final String A, int B) {
        int s=1;
        int l = B;
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i=0; i< A.length() ; i++){
            if(A.charAt(i) =='I'){
                result.add(s);
                s++;
            } else{
                result.add(l);
                l--;
            }
        }
        result.add(l);
        return result;
    }
}
