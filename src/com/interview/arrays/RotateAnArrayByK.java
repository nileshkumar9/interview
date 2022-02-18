package com.interview.arrays;

/**
 * https://www.youtube.com/watch?v=8RErc0VXAo8&list=PL-Jc9J83PIiHOV7lm2uSw4ZiVsIRsGS6r&index=32
 * Bring last element from end to beginning by k
 * <p>
 * To rotate an element of an array by k element from last
 * eg : a b c d e f g h ---> k =3 rotate last three element.
 * f g h a b c d e ---> rotate last thee element to first
 * Logic :
 * divide array by k from last
 * rotate 0 to array.length-k -1
 * rotate array.length -k to array.length-1
 * then rotate whole array to get the output.
 * <p>
 * edge cases :
 * if k is negative then do k = k + array.length ===
 * if k = -1; that is equal to rotating k = 8-1 = 7
 * if its negative that means it took one element from begining to the end
 * e.g : a b c d e f ---> k =-1
 * then o/p : b c d e a --> taking element from begining to the end which is equivalent
 * to rotatin it by k = 5 -1 = 4 element from last
 * <p>
 * if k > arraylength --> after every array.length rotation, we will get the same value
 * so do modulous on array.length. because lets say length = 10 and k = 101
 * then k = 1 and k = 101 will give same output. so k = 101 % 10 = 1
 */
public class RotateAnArrayByK {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7};

        int k = 3;
        rotateArray(a, k);

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    private static void rotateArray(int[] a, int k) {

        // edge cases
        if (k > a.length) {
            k = k % a.length;
        }
        if (k < 0) {
            k = k + a.length; // since k is negative plus will do same thing
        }
        // reverse first half
        reverseAnArray(a, 0, a.length - k - 1);
        // rotate second half
        reverseAnArray(a, a.length - k, a.length - 1);

        // reverse whole array
        reverseAnArray(a, 0, a.length - 1);

    }


    private static void reverseAnArray(int[] a, int leftIndex, int rigthIndex) {
        int i = leftIndex;
        int j = rigthIndex;
        while (i < j) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
            j--;
        }


    }
}
