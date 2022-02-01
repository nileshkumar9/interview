package com.interview.arrays;

import java.util.ArrayList;

/**
 * https://www.youtube.com/watch?v=jKyuWD8XKjw&list=PL-Jc9J83PIiHOV7lm2uSw4ZiVsIRsGS6r&index=28
 * PeepCoding questions
 * To find the difference of two array a1 and a2 where a2 size is greater than equal to a1
 * Logic :
 * Make a diff array with size of a2
 * Substract corresponding element, if required take a carry (10)
 * IF a1 is smaller take zero at begining
 * e.g : 3 3 3 --> a2
 *       0 2 2 --> a1
 * Remove the leading zero as well
 *
 */
public class DifferenceOfTwoArray {
    public static void main(String[] args){
        int [] a2 = new int[]{3,3,3,3};
        int [] a1 = new int[]{2,2,2};
        // Create a diff array
        int [] diffArray = new int[a2.length];

        int carry = 0;

        int i = a1.length-1;
        int j = a2.length-1;
        int k = diffArray.length-1;

        while(k>0){ // We will do till all the element indiff array are filled
            // if a1 is smaller in size then we will get AIOO as i will be negative
            // so lets set value as 0 if i is negative
            int a1Val = i>=0 ? a1[i] : 0;
            // cases would be either a2 is greater or smaller
            if ((a2[j] + carry) > a1Val){ //carry intially will be 0
                diffArray[k] = (a2[j] + carry) - a1Val;
                carry = 0;
            } else {
                // if smaller then we will have to take carry and substrack
                // take 10 as the carry. for previous element it will be -1;
                diffArray[k] = (a2[j] + carry +10) - a1Val;
                carry = -1;
            }
            i--;
            j--;
            k--;
        }
        // While printing we will do nothing till there is first non zero in the value array
        int index = 0;
        while (index<= diffArray.length){
            if (diffArray[index] ==0){
                index++;
            } else{
                break;
            }
        }

        while (index <= a2.length-1){
            System.out.print (diffArray[index] + " " );
            index++;
        }

    }

}
