package Problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public final class Questions2 {
    static Integer val;
    static {

    }


    public static void main(String[] args) {
        //
        //evenNumber();

        // question 2
        // Input array
        Integer[] inputarray =  {7,1,5,3,6,4};
        // 1 , 6 5

        // min = 1
        // Max = 6
        // diff= 5






    }

    private static void evenNumber() {
        // To find the Even number

        String [] arrayInput = new String[]{"1","2","3","4","5"};
        // Task : Return the even list of integer

        final
        // Dummy input to solve it first
        List<Integer> num= new ArrayList<Integer>();

        List<String> output = Arrays.asList(arrayInput).stream()
                            .filter(input -> Integer.parseInt( input) %2 ==0)
                            .collect(Collectors.toList());

        System.out.println( "Output : " + output );
    }

}


