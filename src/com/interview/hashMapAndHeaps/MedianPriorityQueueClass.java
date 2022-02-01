package com.interview.hashMapAndHeaps;

import java.util.PriorityQueue;

/**
 * https://www.youtube.com/watch?v=dshWERdcAdg&list=PL-Jc9J83PIiHq5rMZasunIR19QG3E-PAA&index=16
 * Median priority queue is a queue which give the median of sorted value of array and if the
 * count is even, in that case there are two mid element then it will give the smallest of the values.
 *
 * Logic : We will maintain two pq, left pq will be MAX PQ(Containing max at peek) and
 * right PQ will be min PQ(Containt smalles at peak).
 * By default always add to left PQ
 * If element is greater than right PQ top, then add to right
 * 2) Always ensure the difference in size of leftPQ and rightPQ is not more than 1. If its getting more
 * pull one from right to the left.
 *
 */
public class MedianPriorityQueueClass {
    public static class MedianPriorityQueue{
        PriorityQueue<Integer> left;
        PriorityQueue<Integer> right;

        public MedianPriorityQueue(PriorityQueue<Integer> left, PriorityQueue<Integer> right) {
            this.left = left;
            this.right = right;
        }

        public int size(){
            return left.size() + right.size();
        }

        public void add(int val){
            if(right.size()>0 && right.peek()>val){
                right.add(val);// if right has anything and value is more than the peek of right
            }else {
                left.add(val);
            }
            if(left.size() - right.size() ==2){
                right.add(left.remove()); // if left is bigger then right remvoe from left and add to right
            } else if(right.size() - left.size() ==2 ){
                left.add(right.remove());
            }
        }

        public int remove(){
            if (this.size() ==0){
                System.out.println("Queue underflow");
                return -1;
            }
            if(left.size() >= right.size()){
                // this is when the total no in array is odd.
                return left.remove();
            } else{
                return right.remove();
            }
        }

        public int peek(){
            if (this.size() ==0){
                System.out.println("Queu underflow");
                return -1;
            }
            if(left.size() >= right.size()){
                // this is when the total no in array is odd.
                return left.peek();
            } else{
               return right.peek();
            }
        }


    }

}
