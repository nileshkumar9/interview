package Problems;

import java.util.List;


//
/**
 Set is an unordered collection of non-repeating values.
 Set B is a subset of set A if A contains all values in B.
 For example: If A={1,2,3,4}, B={2,4}, C={1,7}: B is a subset of A, but C is not.

 boolean isSubset(List<string> A, List<string> B);


 solutions we discussed
 1)
 Brute force, or having two for loops, each of one list and iterating it over
 T(n) = O(n^2)
 S = unchanged
 2) HashMap and getting the values
 T(n) = O(n) + o(1) ==> O(n) overall
 S = O(N) // to create extra hasmpap
 3) inputs are sorted for both arrays
 t(n) = o(n)
 s(n) = unchanged.

 **/
import java.io.*;
    import java.util.*;
    import java.text.*;
    import java.math.*;
    import java.util.regex.*;

public class OCI {

    static boolean isSubset(List<String> A, List<String> B){
        if(B.size() > A.size()){
            return false; // base case check here
        }

        boolean isSubset = false;
        int initialIndex = 0; // initial index of inner loop to start
        // since arrays are sorted
        for(int i=0 ;i<B.size(); i++){

            // find this value in A
            // A={1,2,3,4}, B={2,5}
            String val = B.get(i);
            for( int j = initialIndex ; j<A.size();j++){// loop for A
                if(A.get(j) == val){
                    // match is found
                    initialIndex = j+1;
                    isSubset = true;
                    break;
                }
                isSubset = false;
            }

            if(!isSubset){
                // Values is not found , no need to interate further break from here
                return false;
            }
        }

        return isSubset;
    }

    static int addNumbers(int a, int b) {
        return a+b;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a;
        a = in.nextInt();
        int b;
        b = in.nextInt();
        int sum;

        sum = addNumbers(a, b);
        System.out.println(sum);
    }
}

