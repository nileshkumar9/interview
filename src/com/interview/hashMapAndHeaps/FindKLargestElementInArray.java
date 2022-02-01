package com.interview.hashMapAndHeaps;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * For given input of array, find the k largest element in array. Like k(3) largest element
 * input : 2, 10, 5, 17, 7, 18, 6 , 4
 * K = 3
 * output : 10, 17, 18
 *
 * Logic : Implement PriorityQueue, wich by default is min priorityQueue, which means always
 * there will be minimum element priorityqueue which will be at the top for removal.
 * So keep iterating over the input array, and check the peek of the priorityQueue with the
 * value of element. if the value of the array element is greater than the peek value(which will be minimuk)
 * of the group, it will be removed and replaced by element of the array
 * Like this we are always maintaining the best max value in the priorityqueue
 *
 *
 */
public class FindKLargestElementInArray {
    public static void main(String[] args)
    {
        int[] a = new int[]{2, 10, 5, 17, 7, 18, 6 , 4};

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(a[0]);
        pq.add(a[1]);
        pq.add(a[2]);
        for(int i=3; i< a.length ; i++){
            if(a[i] > pq.peek() ){
                // Since the given array element is greater than min of the pq , we will replace it
                pq.remove();
                pq.add(a[i]);
            }
        } // At the end of this iteration, pq will always have 3 element which will be all max value of array

        while(pq.size()>0){
            System.out.print (pq.remove() + ", " );
        }



    }
}
