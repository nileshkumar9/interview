package com.interview.linkedList;

/**
 * @author  Nilesh Kumar
 *
 *     /**
 *      * Definition for singly-linked list.
 *      * class ListNode {
 *      *     public int val;
 *      *     public ListNode next;
 *      *     ListNode(int x) { val = x; next = null; }
 *      * }
 *      *
 * Problem :
 * Given a singly linked list and an integer K, reverses the nodes of the
 *
 * list K at a time and returns modified linked list.
 *
 * NOTE : The length of the list is divisible by K
 *
 * Example :
 *
 * Given linked list 1 -> 2 -> 3 -> 4 -> 5 -> 6 and K=2,
 *
 * You should return 2 -> 1 -> 4 -> 3 -> 6 -> 5
 *
 * Try to solve the problem using constant extra space.
 *
 * https://www.interviewbit.com/problems/k-reverse-linked-list/
 *
 * Logic :
 * Reverse the first sub-list of size k. While reversing keep track of the next node and previous node.
 * Let the pointer to the next node be next and pointer to the previous node be prev.
 * See this post for reversing a linked list.
 * head->next = reverse(next, k) ( Recursively call for rest of the list and link the two sub-lists )
 * Return prev ( prev becomes the new head of the list (see the diagrams of an iterative method of this post )
 *
 */
public class KReverseLinkedList {

        public ListNode reverseList(ListNode A, int B) {
            // first reverse in the given group
            ListNode current = A;
            ListNode prev = null;
            ListNode next = null;
            int count =0;
            while (count < B && current != null ){
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
                count ++;

            }
            // Now we are calling recursively. This is setting the prev of last stack to head of current.

            if(next != null ){
                A.next = reverseList(next, B);
            }

            return prev;

        }
    }

