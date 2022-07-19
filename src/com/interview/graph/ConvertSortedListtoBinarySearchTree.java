package com.interview.graph;

public class ConvertSortedListtoBinarySearchTree {
    /**
     * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
     * <p>
     * A height balanced BST : a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
     * <p>
     * Example :
     * <p>
     * <p>
     * Given A : 1 -> 2 -> 3
     * A height balanced BST  :
     * <p>
     * 2
     * /   \
     * 1     3
     * <p>
     * Logic :
     * Lets fid the mid. which will become the root of BST.
     * all left will goes as left side, all other goes to the right.
     */


    // Definition for binary tree
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    //Definition for singly-linked list.
    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        // to check for 1 size list
        if (head.next == null) {
            return new TreeNode(head.val);
        }

        // find the mid of the linked list
        ListNode slow = head;
        ListNode fast = head.next;

        // Lets find the mid of the linked list
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode mid = slow.next; // middle element
        slow.next = null;

        TreeNode root = new TreeNode(mid.val);
        root.left = sortedListToBST(head); // start to the left half
        root.right = sortedListToBST(mid.next);

        return root;

    }

}
