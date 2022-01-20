package com.interview.stack;

import java.util.Stack;

/**
 * Logic : Iteratre through the string lenght and put in stack.
 * Iterate till the stack is empty and build a new string object.
 */
public class ReverseStringUsingStack {
    public String reverseString(String A) {
        Stack<Character> st = new Stack<>();
        for(int i =0; i< A.length(); i++){
            // push to Stack
            st.push(A.charAt(i));
        }
        // now build a new String and return
        StringBuffer string = new StringBuffer(A);
        int index=0;
        while(st.size() > 0){

            string.setCharAt(index, st.pop());
            index++;
        }
        return string.toString();
    }
}

