package problems;

import java.util.ArrayList;
import java.util.HashMap;

public class Problems {
    // Teneable
    // Group anagrams together.
    public static void main(String[] args) {
        System.out.println("");
        /**
         * array of strings : eat -> tea -> tan -> ate -> nat - > bat
         *
         * Anagram Group :
         *         tan, nat
         *         eat, ate, tea
         *         bat -- is not
         *
         *
         *         k,v
         *         t -1
         *         a -1
         *         n -1
         *
         *  Array of Arrays : grouping by Anagrams
         *
         *  time
         *      o(n) ,
         *  o(n) -> o(n)
         *
         *
         *


         */
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        ArrayList<ArrayList<String>> finalResult = new ArrayList<>();

        ArrayList<ArrayList<String>> result = groupAagrams(input);

        System.out.println("result : " + result);
    }

    private static ArrayList<ArrayList<String>> groupAagrams(String[] input) {
        HashMap<HashMap<Character, Integer>, ArrayList<String>> resultMap = new HashMap<>();

        // lets make frequency map of each string
        for (String str : input) {
            HashMap<Character, Integer> frequencyMap = new HashMap<>();
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
            }
            if (resultMap.containsKey(frequencyMap) == false) {
                // this is for frist tiem adding to result map
                ArrayList<String> list = new ArrayList<>();
                list.add(str);
                resultMap.put(frequencyMap, list);

            } else {
                // add to the existing map value list
                ArrayList<String> existingValue = resultMap.get(frequencyMap);
                existingValue.add(str);
            }
        }

        ArrayList<ArrayList<String>> result = new ArrayList<>();

        for (ArrayList<String> value : resultMap.values()) {
            result.add(value);
        }

        return result;
    }


}
