package com.interview.hashMapAndHeaps;

import java.util.PriorityQueue;

/**
 * https://www.youtube.com/watch?v=pptk8cUHHUg&list=PL-Jc9J83PIiHq5rMZasunIR19QG3E-PAA&index=14
 * K Sorted array is an array where element is either unsorted by k
 * e.g : 2(+-2) ,3(+-2) , 1(+-2) (k =2) here each element will be maximum up or down by k=2
 *
 * Logic : Keep adding to min PriorityQueue with the size of k, Now at every time we are going to add new
 * value in the queue we will remove the peek which will always contain the min value. Since the PQ
 * which is acting as the funnel of size(k+1), it will always give the sortes value.
 *
 */
public class SortKSortedArray {
    public static void main(String[] args)
    {
        int[] a = new int[]{2, 3, 1, 4, 6, 7, 5, 8, 9};

        int k =2;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<= k ; i++){
            pq.add(a[i]); // Add k+1 element in the pq
        }

        // now keep on removing and adding next element in the pq.
        // By virtue of the pq, it wil always remove the min value once.
        for(int i=k+1; i<a.length; i++){
            // remove from pq, print and then add next element
            System.out.print(pq.remove() + ", " );
            pq.add(a[i]);
        }
        while(pq.size()>0){
            System.out.print(pq.remove() + ", ");
        }

    }
}
