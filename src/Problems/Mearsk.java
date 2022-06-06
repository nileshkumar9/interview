package Problems;

import java.util.HashMap;
import java.util.Map;

public class Mearsk {



    public static void main(String[] args) {


        // 1 , 2, 3 === > One, Two,
        // 12, => Tweleve
        // 21 => twenty one
        // 99 => ninty nine
        //

        // Today is a Thursday
        // Output : t=5
        String inputString = "Today is a Thursday";

        Map<Character, Integer> mapOfCharCounts = getCharacterIntegerMap(inputString);


    }

    public static Map<Character, Integer> getCharacterIntegerMap(String input) {

        Map<Character, Integer> mapOfCharCounts = new HashMap<>();

        for (int i = 0; i < input.length(); i++) {
            Character charValue = input.charAt(i);
            // If there is a repeatition we need to catch it
            if (mapOfCharCounts.containsKey(charValue)) {
                // increment the value
                int count = mapOfCharCounts.get(charValue);
                count++;
                mapOfCharCounts.put(charValue, count);
            } else {
                // for first time
                mapOfCharCounts.put(charValue, 1);
            }

        }
        return mapOfCharCounts;
    }
}
