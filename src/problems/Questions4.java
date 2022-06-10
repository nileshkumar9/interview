package problems;

import java.util.HashSet;
import java.util.Set;

public class Questions4 {
    public static void main(String[] args) {
        String[] input = new String[]{"Gagan", "Gagan", "Nilesh"};
        String [] output = removeDuplicates(input);
        System.out.println( output);

    }

    private static String[] removeDuplicates(String[] input) {
        Set<String> valuesWithoutDuplicates = new HashSet<>();



        for(int i =0; i< input.length;i++){
            valuesWithoutDuplicates.add(input[i]);
        }
        int i=0;
        String[] output = new String[valuesWithoutDuplicates.size()];
        for(String value : valuesWithoutDuplicates){
            output[i] = value;
        }

        return output;

    }
}
