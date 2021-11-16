package com.interview.arrays;

/**
 * @Nilesh Kumar
 * we will use intuition approach.
 *
 * algorithm is simple for {1,3,5,4,2},
 *   // 1) traverse from last and find index1 where a[index1] < a[index1+1] ==> index1 = 1 for value {3}
 *   // 2) Traverse from last and find index2, where a[index2] > a[index1] ==> index2 = 3 for value {4}
 *   // 3) swap element of index 1 and index2 ==> 1 ,4, 5 , 3, 2
 *   // 4) reverse everything from index1+1 to last; ==> 1 , 4, -reversed--2, 3, 5
 *   // Catch if index1 is not found don't perform ste 2 , 3 and we have to reverse it anyway. This will happen for last
 *   element in the sequence, where reversing will give us first element. {5 ,4, 3, 2,1} ==> {1,2,3,4,5}
 *
 *   https://www.interviewbit.com/problems/next-permutation/
 *   https://www.youtube.com/watch?v=LuLCLgMElus
 *
 */
public class NextPermutation {
    public static void main(String[] args){
        int[] a = new int [] {1,3,5,4,2};;

        nextPermutation(a);
        System.out.println(a[0] + " " + a[1] + " " + " " + a[2] + " "+a[3] +" " + a[4] );
    }

    private static void nextPermutation(int[] a) {
        // 1) traverse from last and find index1 where a[index1] < a[index1+1]
        int index1 = findIndex1(a);
         // 2) Traverse from last and find index2, where a[index2] > a[index1]
        if(index1 != Integer.MIN_VALUE){
            int index2 = findIndex2(a, index1);
             // 3) swap element of index 1 and index2
            swap(a, index1, index2);
        }

        // 4) reverse everything from index1+1 to last;
        reverseArrayFromIndex(a, index1 == Integer.MIN_VALUE  ? 0 :index1+1);
    }

    private static void reverseArrayFromIndex(int[] a, int reverseFromThisIndex) {

        int leftIndex = reverseFromThisIndex;
        int rightIndex = a.length-1;
        while (leftIndex<rightIndex){
            int temp = a[leftIndex];
            a[leftIndex] = a[rightIndex];
            a[rightIndex] = temp;

            leftIndex++;
            rightIndex--;
        }
    }

    private static void swap(int[] a, int index1, int index2) {
        int temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }

    private static int findIndex1(int[] a) {
        for (int i = a.length-2; i>=0;i--){
            if (a[i] <= a[i+1]){
                return i;
            }
        }
        return Integer.MIN_VALUE;
    }
    private static int findIndex2(int[] a, int index1) {
        int index =Integer.MIN_VALUE;
        for (int i=a.length-1; i>=0;i--){
            if (a[i] >= a[index1]){
                return i;
            }
        }
        return index;
    }
}
