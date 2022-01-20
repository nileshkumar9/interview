package com.interview.stack;

import java.util.Stack;

/**
 * https://www.interviewbit.com/problems/balanced-parantheses/
 * Problem Description
 *
 * Given a string A consisting only of '(' and ')'.
 *
 * You need to find whether parantheses in A is balanced or not ,if it is balanced then return 1 else return 0.
 *
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 105
 *
 *
 *
 * Input Format
 * First argument is an string A.
 *
 *
 *
 * Output Format
 * Return 1 if parantheses in string are balanced else return 0.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = "(()())"
 * Input 2:
 *
 *  A = "(()"
 *
 *
 * Example Output
 * Output 1:
 *
 *  1
 * Output 2:
 *
 *  0
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Given string is balanced so we return 1
 * Explanation 2:
 *
 *  Given string is not balanced so we return 0
 *
 *   Logic :
 *   Take a Stack and iterate on given string.
 *   if we see only '(' push, if we see ')' we will pop to find the closing brackets.
 *   1)if the top of stack doesn't have the balancing opening it means we have more closing bracket or unbalancing closing bracket
 *   2) we are left with anything in stack, which means we had more of the opening bracket
 *
 */
public class BalancedParantheses {
    public static int solve(String A) {
        if(A ==null ){ // base case
            return 1;
        }

        //Take a String
        // if we see only '(' push, if we see ')' we will pop to find the closing brackets.
        // if the top of stack doesn't have the balancing opening or we are left with anything in stack
        // then its unbalances string
        Stack<Character> st = new Stack<>();

        for(int i=0; i< A.length(); i ++){
            char ch = A.charAt(i);

            if (ch == '('){
                // add to stack for all matching brackets
                st.push(ch);
            } else if (ch == ')'){
                if(st.size()>0 && st.peek() == '('){ // we must have a peek containg the matching bracket
                    st.pop();
                } else{
                    // not a balanced statement
                    return 0;
                }
            }
        }
        if(st.size() !=0){
            // Means that after all the operations we are left because we had more opening bracket than the closing bracket.
            return 0;
        }
        return 1;
    }

    public static void main(String[] args){
        int result = solve("(()())");

        System.out.println(result);

    }
}