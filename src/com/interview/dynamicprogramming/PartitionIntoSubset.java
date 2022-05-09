package com.interview.dynamicprogramming;

/**
 * https://www.youtube.com/watch?v=IiAsqfjhZnY&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=30
 * we need to make 3 teams of memebers. Its continuation of Friend pairing problem
 * We have to divide n people in k teams.
 * <p>
 * Logic :
 * 1) we will ask how remaining member (n-1) to tell us in how many ways they can make k teams
 * then, add the last team memeber in this team.
 * Since once combined, it will form k times number of ways.
 * <p>
 * 2) in second options n-1 to make (k-1) teams,, then remainin people will also
 * make the same number of teams once associating with teams.
 * <p>
 * Formula :  f(n,k) = k*(f(n-1,k) + f(n-1,k-1)
 * <p>
 * dp : Each cell in the dp will hold the number of teak we can form using given number of
 * people and given number of team.
 */
public class PartitionIntoSubset {
    public static void main(String[] args) {

        int n = 4;// number of people
        int k = 3; // number of team to form

        long[][] dp = new long[k + 1][n + 1]; // colums is people


        // bases cases.
        if (n == 0 || k == 0 || n < k) {
            System.out.println("Number of teams to form is 0");
            ;
            return;
        }

        for (int teams = 1; teams <= k; teams++) { // k is teams in rows
            for (int people = 1; people <= n; people++) { // coulmn is people
                if (people < teams) {
                    dp[teams][people] = 0;
                } else if (people == teams) {
                    dp[teams][people] = 1;
                } else {
                    dp[teams][people] = teams * dp[teams][people - 1] + dp[teams - 1][people - 1];
                }
            }
        }
        System.out.println("Total number of ways to form : " + k +
                               " teams with : " + n + " people is : " + dp[k][n]);
    }
}
