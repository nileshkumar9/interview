package com.interview.dynamicprogramming;

/**
 * https://www.youtube.com/watch?v=SHDu0Ufjyk8&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=29
 *
 * <p>
 * If for given n number of frineds, how to put them in a pair,
 * A friend has an option either to be alone or be in group.
 * <p>
 * We just have to give count.
 * <p>
 * We don't have to duplicate the permutation like we don't have to count
 * 1,2 ,3 and 3, 2, 1 as two answer all such permutation is one count.
 * <p>
 * A given guy can either be single or can pair up with someone.
 * <p>
 * Formula : f(n) = f(n-1) + (n-1) * f(n-2)
 */
public class FriendsPairing {


    public static void main(String[] args) {

        int numberOfFriends = 5; // width of the dimension
        int[] dp = new int[numberOfFriends+1];

        dp[0] = 0;
        dp[1] = 1; // stores if there were total 1 person then count of pairing
        dp[2] = 2;
        for (int i=3 ; i<=numberOfFriends ; i++){
            dp[i] = dp[i-1] + ((i-1) * dp[i-2]);
        }

        System.out.println("Total number of ways we can pair is : " + dp[numberOfFriends]);

    }
}
