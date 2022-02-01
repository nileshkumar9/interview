package com.interview.hashMapAndHeaps;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * https://www.youtube.com/watch?v=E5WSILx1q0Q&list=PL-Jc9J83PIiHq5rMZasunIR19QG3E-PAA&index=19
 * You wre given K different lists of integer. You have to merge all these lists into one
 * and make sure that the final list is a sorted list
 *
 * Logic: We will use priority queue to solve this. Add first element in the of each list
 * in pq and then keep adding one list item by removing the minimum from the pq. Add the next
 * element from the same list the value of which is removed from queue. keep doing it
 * till the queue is empty. At end all element captured in arraylist will be in sorted value.
 *
 */
public class MergeKSortedList {
    public static class Pair implements Comparable<Pair>{
        int listIndex;
        int dataIndex;
        int val;
        public Pair(int listIndex, int dataIndex, int val ){
            this.listIndex = listIndex;
            this.dataIndex = dataIndex;
            this.val = val;
        }

        @Override
        public int compareTo(Pair other) {
            return this.val - other.val;
        }
    }

    public static ArrayList<Integer>  mergeKSortedList( ArrayList<ArrayList<Integer>> lists){
        // write your code here
        ArrayList<Integer> returnValueList = new ArrayList<>();

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for(int i=0; i<lists.size(); i++){
            /**
             * 1) First add first element from each array into pq
             * Since list value are sorted we will get the starting point of minimum value
             * if we add into the min priority queue
             */
            Pair pair = new Pair(i, 0, lists.get(i).get(0));
            pq.add(pair);
        }
        // We have pq that has minimum value at the peak, we will pop it from pq
        // and continue to add element to PQ from same list, until the peak of the priority queue
        // points to different list value. If peak now contains different list value we will keep adding
        // the values from the list whose value is present in the peak, this is why se are maintaining
        // the listindex and data index while removing from the peak
        while(pq.size() > 0){
            // remove element from the peak and add to the return list
            Pair pair = pq.remove();
            returnValueList.add(pair.val);

            // increase the data index to get next element in current list
            pair.dataIndex++;
            // add next element of same list that is popped
            if((pair.dataIndex  < lists.get(pair.listIndex).size())){
                // if only this list has more elements
                // Note we have incresed dataindex by doing ++
                // list index will not cahnge. only value will change.
                pair.val = lists.get(pair.listIndex).get(pair.dataIndex);
                pq.add(pair);
            }

        }
        return returnValueList;

    }

    public static void main( String[] args){
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(4);
        list1.add(6);
        list1.add(7);

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        list2.add(5);
        list2.add(7);
        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(6);
        list3.add(9);
        list3.add(11);
        list3.add(10);

        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
        mergeKSortedList(lists);
    }

}
