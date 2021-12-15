package com.interview.linkedList;

/**
 * @author  Nilesh Kumar
 * Problem Description
 *
 * Given a Linked List A consisting of N nodes.
 *
 * The Linked List is binary i.e data values in the linked list nodes consist of only 0's and 1's.
 *
 * You need to sort the linked list and return the new linked list.
 *
 * NOTE:
 *
 * Try to do it in constant space.
 *
 *
 * Problem Constraints
 *  1 <= N <= 105
 *
 *  A.val = 0 or A.val = 1
 *
 *
 *
 * Input Format
 * First and only argument is the head pointer of the linkedlist A.
 *
 *
 *
 * Output Format
 * Return the head pointer of the new sorted linked list.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  1 -> 0 -> 0 -> 1
 * Input 2:
 *
 *  0 -> 0 -> 1 -> 1 -> 0
 *
 *
 * Example Output
 * Output 1:
 *
 *  0 -> 0 -> 1 -> 1
 * Output 2:
 *
 *  0 -> 0 -> 0 -> 1 -> 1
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  The sorted linked list looks like:
 *   0 -> 0 -> 1 -> 1
 * Explanation 2:
 *
 *  The sorted linked list looks like:
 *   0 -> 0 -> 0 -> 1 -> 1
 *
 *
 */
public class SortBinaryLinkedList {

    /**
     * Logic for below is we will iterated through the List. On each occurance of 0 we will link it to Zero Pointers
     * and when we find 1 we will link it to onePointers. OneHead and ZeroHead will be set at first.
     * At end of the loop we will have zeroPointers at one place
     * and onePointers at one place. Then we will have zeroPointer next pointing to oneHead. and we will return zeroHead.
     * There is another easy approach documented at end, read the comments.
     *
     * @param A
     * @return
     */
    public ListNode solve(ListNode A) {
        ListNode head = A;
        ListNode current = A;
        ListNode zeroPointer = null;
        ListNode zeroHead = null;
        ListNode onePointer = null;
        ListNode oneHead = null;
        // In bigining set zero pointers or one pointers and move the current to next
        if (current.val == 0) {
            zeroPointer = current;
            zeroHead = current;
        } else {
            oneHead = current;
            onePointer = current;
        }
        // To handle if there is only one value in LL. either 1 or 0.
        if (current.next == null) {
            return current;
        }

        current = current.next;
        // Iterated through LL and make zero together ane one together.
        while (current != null) {
            if (current.val == 0) {
                // For first element was 1 then we need to initialize zeroPointers and ZeroHead
                if (zeroPointer == null) {
                    zeroPointer = current;
                    zeroHead = current;
                } else {
                    // only move the pointer not the zeroHead or oneHead
                    zeroPointer.next = current;
                    zeroPointer = zeroPointer.next;
                }
            }
            if (current.val == 1) {
                // For first element was 0 then we need to initialize onePointers and oneHead
                if (onePointer == null) {
                    onePointer = current;
                    oneHead = current;
                } else {
                    onePointer.next = current;
                    onePointer = onePointer.next;
                }
            }
            current = current.next;
        }
        // Now combine the oneHead with zeroTail
        zeroPointer.next = oneHead;
        onePointer.next = null; // Set the onePinters last node to null.
        return zeroHead;

    }

    // Another approach is simple.
    // Loop to count the ZeroCount and size of the list.
    // In another loop starting from head of the list, iterated and substitute the value as zero until
    // we have reached the zeroCount.
    // In next loop continue till we reaches the null of list and substitute the Remaining value with 1.
    /**
     *     public ListNode solve(ListNode head) {
     *         if (head == null) {
     *           return null;
     *         }
     *         int size = 0;
     *         ListNode temp = head;
     *         int zero = 0;
     *         while (temp != null) {
     *           if (temp.val == 0) {
     *             zero++;
     *           }
     *           size++;
     *           temp = temp.next;
     *         }
     *         if (zero == size) {
     *           return head;
     *         }
     *         temp = head;
     *         while (temp != null && zero != 0) {
     *           temp.val = 0;
     *           zero--;
     *           temp = temp.next;
     *         }
     *         while (temp != null) {
     *           temp.val = 1;
     *           temp = temp.next;
     *         }
     *
     *         return head;
     *     }
     */
}

