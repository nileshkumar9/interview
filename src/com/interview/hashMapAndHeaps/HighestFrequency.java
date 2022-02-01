package com.interview.hashMapAndHeaps;

import java.util.HashMap;

public class HighestFrequency {
    // Use hashmap to find the highest frequency for given strings
    public static void main(String[] args){
        String str = "aaabbbcccdddeeefff";
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i=0; i<str.length() ;i++){
            char ch = str.charAt(i);
            if(hm.containsKey(ch)){
                int olfValue = hm.get(ch);
                hm.put(ch , ++olfValue);
            } else {
                hm.put(str.charAt(i), 1);
            }
        }

        // iterate to print highest frequency character
        int highestFequency = 0;
        String  highestOccuring =null;
        for(Character ch : hm.keySet()){
            if(highestFequency < hm.get(ch)){
                highestFequency = hm.get(ch);
                highestOccuring=ch.toString();
            }
        }
        System.out.println(highestOccuring);

    }
}
