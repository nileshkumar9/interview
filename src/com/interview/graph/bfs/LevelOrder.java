package com.interview.graph.bfs;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//  Definition for binary tree
  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) {
       val = x;
       left=null;
       right=null;
      }
  }
// https://www.interviewbit.com/problems/level-order/

public class LevelOrder {
    public int[][] levelOrder(TreeNode A) {
        int[][] ret = null;

        List<List<Integer>> levels = new ArrayList<>();
        TreeNode root = A;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if (root == null) {
            return ret;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            // BFS remove mark* work add *
            int countOnLevel = queue.size();
            List<Integer> resultOnLevel = new ArrayList<>();

            while (countOnLevel > 0) {
                TreeNode node = (TreeNode) queue.remove(); // removing
                countOnLevel--;

                resultOnLevel.add(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            levels.add(resultOnLevel);
        }

        int[][] array = new int[levels.size()][];

        int i = 0;
        for (List<Integer> nestedList : levels) {
            int[] nestedArray = new int[nestedList.size()];
            int j = 0;
            for (Integer val: nestedList){
                nestedArray[j++] = val;
            }

            array[i++] = nestedArray;
        }


        return array;
    }
}


