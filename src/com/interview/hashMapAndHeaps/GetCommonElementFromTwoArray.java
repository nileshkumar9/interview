package com.interview.hashMapAndHeaps;

import java.util.HashMap;

/**
 * https://www.youtube.com/watch?v=HPSykge6EGw&list=PL-Jc9J83PIiHq5rMZasunIR19QG3E-PAA&index=5
 * <p>
 * Logic :
 * a1 : 1 1 2 2 2 3 5
 * a2 : 1 1 1 2 2 4 5
 * answer : 1 2 5 (Print the common element only once)
 * Logic : Add first array in to hasmap, Then iterate over second array and check if it contains
 * the value in the hasmap.if its present remove the occurance.
 */
public class GetCommonElementFromTwoArray {

    // Use hashmap to find the highest frequency for given strings
    public static void main(String[] args) {
        int[] a1 = new int[]{1, 1, 2, 2, 2, 3, 5};
        int[] a2 = new int[]{1, 1, 1, 2, 2, 4, 5};

        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < a1.length; i++) {
            int aVal = a1[i];
            if (hm.containsKey(aVal)) {
                int olfValue = hm.get(aVal);
                hm.put(aVal, ++olfValue);
            } else {
                hm.put(aVal, 1);
            }
        }

        // 2) iterate using second array and remove from map once found and printed
        for(int i =0; i <a2.length; i++){
            if(hm.containsKey(a2[i])){
                System.out.print (a2[i] + "  " );
                hm.remove(a2[i]);
            }
        }

    }
}

