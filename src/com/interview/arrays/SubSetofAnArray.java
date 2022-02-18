package com.interview.arrays;

/**
 * https://www.youtube.com/watch?v=iKSI_9NHR1M&list=PL-Jc9J83PIiHOV7lm2uSw4ZiVsIRsGS6r&index=38
 * PeepCoding questions to print subset of an array
 * Subset is to print all the combination of its element coming or not coming . permutation
 * For gien length of an array there will be : 2 ^ length combinations
 * e.g : 10 , 20
 * Subsets can : 0   - - -> Nothing comes
 * 1  - 20 -> first doesn't come second coms
 * 2  10 - --> first comes second doesn't
 * 3  10 20 --> all comes
 * We will make a binary for all the ourance and we will do and.
 * e.g :   0 binary is   0 0
 * 1 binary is   0 1
 * 2 binary is   1 0
 * 3 binary is   1 1   -
 * So print where there is 1 and dont print where there is 0
 */
public class SubSetofAnArray {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3};

        int limit = (int) Math.pow(2, a.length);
        for (int i = 0; i < limit; i++) {
            String set = "";
            int temp = i;
            // convert i to binarary and use 0 to hide and 1 to show
            for (int j = a.length - 1; j >= 0; j--) {
                // convert to binary
                int r = temp % 2;
                temp = temp / 2;
                // this gives last element for eg for 6 =  1 1 0 , zero will come first
                // thats why we are doing a reverse in intter loop starting from a.length

                if (r == 0) {
                    // if zero we will hide the value
                    set = "-\t" + set; // if reminder is r we will set dash in first
                } else {
                    // if 1 we will show the value
                    set = a[j] + "\t" + set; // here we will prefix a[j]
                }
            }
            System.out.println(set);
        }
    }


}
