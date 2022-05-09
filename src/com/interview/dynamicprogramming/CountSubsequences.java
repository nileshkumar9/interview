package com.interview.dynamicprogramming;

/**
 * https://www.youtube.com/watch?v=IV9pbZsi5cc&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=22
 *
 * ababcbabbc
 * Find all subsequences which are of nature A^i* B^j* C^k
 *
 * with all a together , all b together all c together.
 *
 */
public class CountSubsequences {

    public static void main(String[] args) {

        String inputString = "abcabc";
        int a =0;
        int ab=0;
        int abc=0;

        for(int i=0; i< inputString.length() ;i++){
            char ch = inputString.charAt(i);
            if (ch =='a'){
                // if a is found then value will be 2*a+1
                a = a*2 +1;

            } else if (ch == 'b'){

                ab = 2*ab +a;
            } else if (ch == 'c'){

                abc = 2*abc + ab;
            }
        }

        System.out.println( "Cound of all subsequence of a^i b^j c^k is : " +(  abc));
    }
}
