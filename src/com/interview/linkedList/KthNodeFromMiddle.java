package com.interview.linkedList;

import java.util.LinkedList;

/**
 * @author  Nilesh Kumar
 *
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 *
 * Problem Description
 *
 * Given a linked list A of length N and an integer B.
 *
 * You need to find the value of the Bth node from the middle towards the beginning of the Linked List A.
 *
 * If no such element exists, then return -1.
 *
 * NOTE:
 *
 * Position of middle node is: (N/2)+1, where N is the total number of nodes in the list.
 *
 *
 * Problem Constraints
 * 1 <= N <= 105
 * 1<= Value in Each Link List Node <= 103
 * 1 <= B <= 105
 *
 *
 * Input Format
 * First argument is the head pointer of the linkedlist A.
 *
 * Second argument is an integer B.
 *
 *
 *
 * Output Format
 * Return an integer denoting the value of the Bth from the middle towards
 * the head of the linked list A. If no such element exists, then return -1.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = 3 -> 4 -> 7 -> 5 -> 6 -> 1 6 -> 15 -> 61 -> 16
 *  B = 3
 *  Input 2:
 *
 *  A = 1 -> 14 -> 6 -> 16 -> 4 -> 10
 *  B = 2
 *  Input 3:
 *
 *  A = 1 -> 14 -> 6 -> 16 -> 4 -> 10
 *  B = 10
 *
 *
 * Example Output
 * Output 1:
 *
 *  4
 *  Output 2:
 *
 *  14
 *  Output 3:
 *
 *  -1
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  The Middle of the linked list is the node with value 6.
 *  The 1st node from the middle of the linked list is the node with value 5.
 *  The 2nd node from the middle of the linked list is the node with value 7.
 *  The 3rd node from the middle of the linked list is the node with value 4.
 *  So we will output 4.
 * Explanation 2:
 *
 *  The Middle of the linked list is the node with value 16.
 *  The 1st node from the middle of the linked list is the node with value 6.
 *  The 2nd node from the middle of the linked list is the node with value 14.
 *  So we will output 14.
 * Explanation 3:
 *
 *  The Middle of the linked list is the node with value 16.
 *  There are only 3 nodes to the left of the middle node and we need to find the 10th node which doesn't
 *  exist so we will return -1.
 *
 *  https://www.interviewbit.com/problems/kth-node-from-middle/
 *
 *  Logic :
 *  Find the middle count. then substract middle from given integer to get the number from begining.
 *  Iterate again and find the desired node.
 *
 */

public class KthNodeFromMiddle {
    public int solve(ListNode A, int B) {

        //base case
        if(A==null || A.next==null) return -1;

        // find the middle element and count it position.
        ListNode slowPointer =A;
        ListNode fastPointer = A;
        ListNode result = A;
        int middle = 1;
        while(fastPointer !=null && fastPointer.next != null){
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
            middle++;

        }

        // if difference of middle and kth element is less return -1
        if(middle-B < 1){
            return -1;
        }

        // Loop through the linked list till desired position and print the element.
        for (int i=1; i< (middle-B) ; i++){
            result=result.next;
        }
        return result.val;
    }
}

