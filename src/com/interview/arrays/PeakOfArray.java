package com.interview.arrays;

/**
 * Find the peak element in an array
 * Given an integer array, find the peak element in it.
 * A peak element is an element that is greater than its neighbors.
 * There might be multiple peak elements in an array, and the solution should report any peak element.
 *
 * We will use binar search approach where we find in left and right sub array. o(logn)
 */
public class PeakOfArray {
    public static int anyPeakInAnArray(int[] A) {
        // Base case.
        if (A == null || A.length == 0) {
            return -1;
        }
        int peakIndex = findAnyPeakElementInAnArray(A, 0, A.length);
        //System.out.println("Value of peak element is " + A[peakIndex]);
        //returns 1 if peak exists in the given array else 0 if peak doesn't exists



        return peakIndex == -1 ? 0 : 1 ;
    }

    private static int findAnyPeakElementInAnArray(int[] a, int left, int right) {
        // Find the mid of array first
        int mid = (left + right)/2;

        // Check if the middle element is a peak element
        if((mid ==0 || a[mid-1] <= a[mid]) &&
            ( mid == a.length-1 || a[mid] >= a[mid+1])){
            return mid;
        }
        // if left element of mid is greater find in left subarray
        if(mid-1 >=0 && a[mid-1] > a[mid]){
            return findAnyPeakElementInAnArray(a, left, mid-1);
        }

        // if right element of mid is greater then mid element then find in right subarray
        return findAnyPeakElementInAnArray(a, mid+1, right);

    }

    public static void main(String[] args)
    {
        //int[] nums = { 8, 9, 10, 2, 5, 6 };
        int[] nums = { 17660, 7480, 26424, 26634, 10867, 7463, 27919, 12159, 18239, 21197, 12023, 1147, 32499, 28487  };
        System.out.println("The peak element is " + anyPeakInAnArray(nums) );
    }
}
