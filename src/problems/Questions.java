package problems;

import java.util.Arrays;

/**
 * Oracles
 */
public class Questions {
    public static void main(String[] args) {


       // String inputString = "this is an example";
        String inputString = "the taco had a coat of sauce";
       // String inputString = "mississippi uses mips to measure cpus";
        String[] splits = inputString.split("\\s");

        boolean result = false ;
        // for each splits compare one by one and break when there is a match
        for(int i=0;i<splits.length; i++){
            for(int j=i+1; j<splits.length; j++){ // o(nlogn)
                result = isAnagram(splits[i], splits[j]);
                if(result){
                    System.out.println( " Anagram found " + result);
                    break;
                }
            }
            if(result){
               // no need to check for other
                break;
            }
        }

        if(!result){
            System.out.println( " Anagram NOT found " + result);
         }

    }

    public static boolean isAnagram(String str1, String str2){

        String s1 = str1.replaceAll("\\s", ""); // sanatizing the input
        String s2 = str2.replaceAll("\\s", ""); // sanatizing the input

        boolean result = true;
        // base case check
        if(s1.length() != s2.length()){
            result = false; // if length doesn't match
        }

        char[] charArray1 = s1.toCharArray();
        char[] charArray2 = s2.toCharArray();

        // lets sort it for comparison
        Arrays.sort(charArray1); // o(nlongn)
        Arrays.sort(charArray2);

        // comparing it
         result = Arrays.equals(charArray1, charArray2);

        // dummy return for now
        return result;
    }


}
