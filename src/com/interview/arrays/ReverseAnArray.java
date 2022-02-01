package com.interview.arrays;

/**
 * https://www.youtube.com/watch?v=CuvSfyO5iRU&list=PL-Jc9J83PIiHOV7lm2uSw4ZiVsIRsGS6r&index=30
 * PeepCoding questions to reverse an array
 * <p>
 * Logic :
 * Swap the data of last and first element and keep iterating to reverse and array
 */
public class ReverseAnArray {
    public static void main(String[] args) {
        int[] a2 = new int[]{3, 4, 5, 6};

        reverseAnArray(a2);
        for (int i = 0; i < a2.length; i++) {
            System.out.println(a2[i]);
        }
    }

    private static void reverseAnArray(int[] a) {
        int i = 0;
        int j = a.length - 1;
        while (i < j) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
            j--;
        }
    }

}
