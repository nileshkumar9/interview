package com.interview.linkedList;

import java.util.Stack;

/**
 * @author  Nilesh Kumar
 * Given a singly linked list, determine if its a palindrome.
 * Return 1 or 0 denoting if its a palindrome or not, respectively.
 *
 * Notes:
 *
 * Expected solution is linear in time and constant in space.
 * For example,
 *
 * List 1-->2-->1 is a palindrome.
 * List 1-->2-->3 is not a palindrome.
 * https://www.interviewbit.com/problems/palindrome-list/
 *
 *
 *  Logic:
 *  Iterate to LL and Add to Stack
 *  Iterate again on LL and keep pulling out from stack and compare it from LinkedList.
 *  If all matches its a palindrome.
 *
 */
public class PalindromeLinkedList {

    public int isLinkedListPalindrome(ListNode A) {
        ListNode temHead = A;
        ListNode currentHead = A;
        int isPalindrome = 0;

        Stack<Integer> stackN = new Stack<Integer>();
        while(temHead != null){
            stackN.push(temHead.val);
            temHead = temHead.next;
        }
        while(currentHead != null) {
            int val = stackN.pop();
            if(val == currentHead.val){
                isPalindrome = 1;
            } else{
                isPalindrome = 0;
                break;
            }
            currentHead = currentHead.next;

        }
        return isPalindrome;
    }
}
