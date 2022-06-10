package com.comp.caterpiller;

import java.util.HashMap;

/**
 * Find the number of duplicates in given array. { 12,4,61,5,15,4,7,9,5,44}
 *
 * /o:P: 4 ,5  ---> 2
 *
 *
 */
public class Caterpiller {
    public static void main(String[] args){

        Integer[] integers = new Integer[]  { 12,-4,61,5,15,4,7,9,5,44,15,5};

        HashMap<Integer, Integer> hashMap = findOccouranceOfNumber(integers);
        int numberOfduplicateKey = 0;
        for(Integer key :hashMap.keySet()){
            // iterate here to get duplicate
            if(hashMap.get(key)>1) {
                numberOfduplicateKey++;
            }
        }
        System.out.println(numberOfduplicateKey);

    }
    public static HashMap<Integer, Integer> findOccouranceOfNumber(Integer[] integers){
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i=0; i< integers.length; i++){
            // before putting check the presence in hasmap
            if(hashMap.containsKey(integers[i])){
                // get the value and increment the count
                int count = hashMap.get(integers[i]);
                hashMap.put(integers[i],(count+1));
            } else {
                // if not present add a new value to hasmap
                hashMap.put(integers[i],1);
            }

        }
        return hashMap;
    }
}
