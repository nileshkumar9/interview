package com.interview.dynamicprogramming;

/**
 * Given a string A, partition A such that every substring of the partition is a palindrome.
 * Return the minimum cuts needed for a palindrome partitioning of A.
 * Input Format:
 * The first and the only argument contains the string A.
 * Output Format:
 * Return an integer, representing the answer as described in the problem statement.
 * Constraints:
 * 1 <= length(A) <= 501
 * Examples:
 * Input 1:
 * A = "aba"
 * Output 1: 0
 * Explanation 1:
 * "aba" is already a palindrome, so no cuts are needed.
 * Input 2:
 * A = "aab"
 * Output 2:
 * 1
 * Explanation 2:
 * Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
 */
public class PalindromePartitioning {
    /**
     * Logic :
     * // i is the starting index and j is the ending index. i must be passed as 0 and j as n-1
     * minPalPartion(str, i, j) = 0 if i == j. // When string is of length 1.
     * minPalPartion(str, i, j) = 0 if str[i..j] is palindrome.
     *
     * // If none of the above conditions is true, then minPalPartion(str, i, j) can be
     * // calculated recursively using the following formula.
     * minPalPartion(str, i, j) = Min { minPalPartion(str, i, k) + 1 +
     *                                  minPalPartion(str, k+1, j) }
     *                            where k varies from i to j-1
     *
     * @param args
     */
    public static void main(String[] args) {
        String str = "dVGAaVO25EmT6W3zSTEA0k12i64Kkmmli09Kb4fArlF4Gc2PknrlkevhROxUg";
//        System.out.println("Minimum cuts required for palindrome partitioning"
//                           + "is : " + minPalindromPartion(str,0,str.length()-1)
//        );
        System.out.println("Minimum cuts required for palindrome partitioning"
                               + "is : " + minCut(str)
        );
    }

    /**
     *
     * @param a
     * @return
     */
    public static int minCut(String a)
    {
        /* Create two arrays to build the solution
           in bottom up manner
           C[i][j] = Minimum number of cuts needed
                     for palindrome partitioning
                     of substring str[i..j]
           P[i][j] = true if substring str[i..j] is
                     palindrome, else false
           Note that C[i][j] is 0 if P[i][j] is
           true

            L is substring length. Build the solution in
         bottom up manner by considering all substrings
         of length starting from 2 to n. The loop
         structure is same as Matrix Chain Multiplication
         problem
         // If L is 2, then we just need to
                // compare two characters. Else need to
                // check two corner characters and value
                // of P[i+1][j-1]
            // IF str[i..j] is palindrome, then
                // C[i][j] is 0

           */

        int[] cut = new int[a.length()];
        boolean[][] palindrome = new boolean[a.length()][a.length()];

        for (int i = 0; i < a.length(); i++) {
            int minCut = i;
            for (int j = 0; j <= i; j++) {
                if (a.charAt(i) == a.charAt(j) && (i - j < 2 || palindrome[j + 1][i - 1])) {
                    palindrome[j][i] = true;
                    minCut = Math.min(minCut, j == 0 ? 0 : (cut[j - 1] + 1));
                }
            }
            cut[i] = minCut;
        }

        // Return the min cut value for complete
        // string. i.e., str[0..n-1]

        return cut[a.length() - 1];
    }

    // Non DP ways. this will solve, but has lot of time complexity
    static int minPalindromPartion(String string, int i, int j)
    {
        // base case if string is palindrome break
        if(i>=j || isPalindrome(string , i , j)){
            return 0; // No partitioning required
        }
        int ans = Integer.MAX_VALUE;
        int count = Integer.MAX_VALUE;
        for(int k= i; k<j ; k++) {

            count = minPalindromPartion(string,i,k) + minPalindromPartion(string,k+1,j) + 1;
            ans = Math.min(count, ans);
        }
        return ans;
    }
    static boolean isPalindrome(String string, int i, int j) {
        while(i<j){
            if(string.charAt(i) != string.charAt(j)){
                return false;
            }
            i++; j--;
        }
        return true;
    }

}
