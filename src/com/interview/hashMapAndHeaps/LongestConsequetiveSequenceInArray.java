package com.interview.hashMapAndHeaps;

import java.util.HashMap;

/**
 * https://www.youtube.com/watch?v=rb73tdVFjYE&list=PL-Jc9J83PIiHq5rMZasunIR19QG3E-PAA&index=8
 * For given array, print the longest consequtive sequence
 * input : 10 5 9 11 8 6 15 3 12 2
 *
 * o/p : 1) 1 2 3
 *       2) 5 6
 *       3) 8 9 10 11 12 --> This is longest consequtive seequence
 *       4 15
 * Logic: Push all element in hashmap with key as element and value as boolean true.
 * Now iterate again in the hashmap for each element of the array and mark the value as false once
 * we find that there exists a value in the hashmap which is smaller than given value of array element.
 * We are marking it false, because for given value say 10, if there exists a value immediate small 9
 * this means it has immediate precendance hence this value 10 cannot be start of the sequence.
 * After we are done with this iteration, hashmap will contain true for only those that are start of
 * sequence.
 * Now for each value left with true in hm, again iterate until there exists immediate next in hashmap,
 * maintain the maxcount and the start number
 *
 *
 */
public class LongestConsequetiveSequenceInArray {
    public static void main(String[] args)
    {
        int[] a1 = new int[]{10, 5, 9, 1, 11, 8, 6, 15, 3, 12, 2};

        HashMap<Integer, Boolean> hm = new HashMap<>();
        for (int i = 0; i < a1.length; i++) {
            int aVal = a1[i];
            hm.put(aVal, true); // Creating key, value as value - true
        }

        // 2) Iterate again on the array and
        // Now mark the value as false if there exists a key one smaller than the element value
        for(int i =0; i <a1.length; i++){
            if(hm.containsKey(a1[i] -1)){
                hm.put(a1[i],false); // marking value as false because this cannot be start of sequence
            }
        }

        int maxSequenceCount =0;
        int startOfSequence = Integer.MIN_VALUE;
        for(Integer key : hm.keySet()){
            // Foe each start of sequence find the no of value present in sequence in input
            // maintain tempMax and overallMax count value and start of the seqeunce.
            if(hm.get(key) == true){
                int tempSequenceCount = 1;
                while (hm.containsKey(key+tempSequenceCount)){
                    tempSequenceCount++;
                }
                if(tempSequenceCount>maxSequenceCount){
                    maxSequenceCount = tempSequenceCount;
                    startOfSequence = key;
                }
            }
        }

        // 3) We have start of sequence and next number of count till when the sequence exits

        for(int i=0; i< maxSequenceCount; i++){
            System.out.print(startOfSequence + i  + " ");
        }

    }
}
