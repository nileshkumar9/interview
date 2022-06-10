package com.comp.fireeyeinterview;

// reverse the given digits binary bits
public class ReverseBinaryBitsOfDigit {

    //write a program to delete Kth node of a linkedlist


    public static void main (String[] args){


        System.out.println(new String[3][4]);
        int x = 8;
        System.out.println( "output "+ reverseBinaryBits(x));

        // 1100
        // 0011

    }

    private static int reverseBinaryBits(int x) {
        // reverse holder

        int rev = 0;
        int j = 0;

        boolean flag = false;
        // printing the bits
        for (int i = 31; i >=0; i--){

            int mask = 1 << i;
            if (flag){
                if((x & mask ) !=0){
                    // bit is on
                    System.out.print(1);
                    int smask = (1<<j); // 0010
                    rev |= smask; // rev smask
                } else {
                    System.out.print(0); // this will print all the values as it is

                }
                j++;
            } else {

                if((x & mask ) !=0){
                    // bit is on
                    flag = true; // first occurance of 1 from left
                    System.out.print(1);
                    int smask = (1<<j); // 0001
                    rev |= smask;
                    j++ ;
                }
            }


        }

        System.out.println();
        return rev;
    }

}
