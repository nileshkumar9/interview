package com.interview.hashMapAndHeaps;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 *
 * https://www.youtube.com/watch?v=RIjxT24gUv4&list=PL-Jc9J83PIiHq5rMZasunIR19QG3E-PAA&index=20
 *
 * A priorityQueue Implementation is the implementation of MinHeap concept.
 *
 * All works in logn because of hop -< heap order property, cbt complete binary tree
 */
public class PriorityQueueUsingHeap {

    public static class PriorityQueue{
        ArrayList<Integer> data;
        public PriorityQueue(){
            data = new ArrayList<>();
        }

        public void add(int val){
            // 1) add data to the end, this is required to maintain Complete Binary treee structure
            data.add(val);
            // 2) now UpHeapIfy, means swap with the parten till parent is greater then the value added at last
            // this is required to maintain heap property
            upHeapify(data.size()-1);

        }

        private void upHeapify(int childIndexWhereAdded) {
            // base case
            if (childIndexWhereAdded ==0) return; // this means we added at root element

            int parentIndex = (childIndexWhereAdded -1) /2 ; // formulat to calcualte parent index is (ci-1)/2

            if(data.get(parentIndex) > data.get(childIndexWhereAdded)){ // swap if parent is greater than value
                // Swap
                int parentVal = data.get(parentIndex);
                data.set(parentIndex, data.get(childIndexWhereAdded)); // put child at parent indes
                data.set(childIndexWhereAdded, parentVal); // put parent at child index

                upHeapify(parentIndex); // Calling again so that we keep swapping thill correct place.
            }
        }

        public int remove(){
            // 1) Swap first with last , so that remove is of logn. PQ always remove the top of heap

            int rootVal = data.get(0);
            int lastVal = data.get(data.size()-1);
            data.set(0, lastVal);
            data.set(data.size()-1, rootVal);

            // 2) remove from last spot
            data.remove(data.size()-1);

            // 3) downheapify, which means swap parent minimum of its child element(left child, right child)
            // till we reached the last place.
            downHeapify(0);

            return rootVal;

        }
        private void downHeapify(int parentIndex){
            int minimumIndex = parentIndex;
            int leftIndex = 2*parentIndex + 1;
            int rightIndex = 2*parentIndex+2;

            // if left child Exists
            if(leftIndex < data.size()-1 && data.get(leftIndex) < data.get(minimumIndex)){
                minimumIndex = leftIndex; // to check if the left is minimum
            }

            if(rightIndex < data.size()-1 && data.get(rightIndex) < data.get(minimumIndex)){
                minimumIndex = rightIndex; // since we have compared from left index hence if
                // its true that means out of left and right, right child value is smalles
            }

            // 3) we have find the index with which to swap
            if(parentIndex != minimumIndex){
                // swap parent index and minimum index
                int tempVal = data.get(parentIndex);
                data.set(parentIndex, data.get(minimumIndex));
                data.set(minimumIndex,tempVal);

                downHeapify(minimumIndex);
            }


        }

        public int peek(){
            return data.get(0); // Always return 0th index of arraylist
        }
        public int size(){
            return data.size(); // size of the arraylist is the size of heap we are maintaining
        }
    }

    public static void main( String[] args){

    }

}
