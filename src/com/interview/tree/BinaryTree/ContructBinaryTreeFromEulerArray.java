package com.interview.tree.BinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

/**
 * https://www.youtube.com/watch?v=XV1ADVV6FbQ&list=PL-Jc9J83PIiHYxUk8dSu2_G7MR1PaGXN4&index=2
 * We are given with euler array, where if child is node the value will be null.
 * Given Euler is in preorder traversal
 *
 * Questions :
 *      1) Construct a Binary tree from Euler format
 *      2) Display a binary tree, in preorder
 *      3) Size of a Binary tree,
 *      4) sum of a binary tree,
 *      5) Max of Binary Tree
 *      6) Height of a Binary Tree
 *
 */
public class ContructBinaryTreeFromEulerArray {

    public static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static class Pair{
        Node node;
        // While constructing we need state,
        // if value is
        //  : 1 attach left,
        //  : 2 attach right.
        //  : 3 pop from stack
        int state ;

        public Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    /**
     * Construct a Binary Tree from given array which is in preorter euler
     */
    private static Node constructBinaryTree(Integer[] arr) {
        Node rootNode = new Node(arr[0], null, null);
        Pair rootPair = new Pair(rootNode, 1); // Always will start with state as 1
        // Push to stack
        Stack<Pair> stack = new Stack<>();
        stack.push(rootPair);

        int index =0;
        while(stack.size() > 0){
            Pair top = stack.peek();
            if(top.state ==1) {
                // Add left child for this node
                index++;
                if(arr[index] != null){
                    Node leftNode = new Node(arr[index] , null, null);
                    Pair leftPair = new Pair(leftNode,1);
                    // set left child of the topNode
                    top.node.left = leftNode ;
                    stack.push(leftPair);
                } else
                {
                    // null means no left child, just increase the state
                    top.node.left = null;

                }
                // increase the state of top node
                top.state = top.state+1;

            } else if(top.state == 2) {

                // Add right child for this node
                index++;
                if(arr[index] != null){
                    Node rightNode = new Node(arr[index] , null, null);
                    Pair rightPair = new Pair(rightNode,1);
                    // set left child of the topNode
                    top.node.right = rightNode ;
                    stack.push(rightPair);
                } else
                {
                    // null means no left child, just increase the state
                    top.node.right = null;

                }
                // increase the state of top node
                top.state = top.state+1;
            } else {
                stack.pop();

            }
        }
        return rootNode;
    }

    public static void main(String[] args) {
        Integer[] arr = {50,25,12,null,null, 37,30,null,null,null, 75,62,null,70,null,null,87,null,null};

        //1) Construct a Binary tree from euler input
        Node rootNode = constructBinaryTree(arr);

        //2)  to display tree in the format of
        // Left child -> node -> right child
        displayTree(rootNode);
        
        //3) size of Binary tree
        int size = size(rootNode);
        System.out.println( "==>> size of tree " + size );

        //4) sum of Binary tree
        int sum = sum(rootNode);
        System.out.println( "==>> sum of tree " + sum );

        //5) Max value in a Binary tree
        int maxValue = maxInBinaryTree(rootNode);
        System.out.println( "==>> Max in a binary tree " + maxValue );


        //6) Height of a Binary tree
        int heightOfBinaryTree = heightOfBinaryTree(rootNode);
        System.out.println( "==>> Height of a binary tree " + heightOfBinaryTree );

        //7) Traversal of a Binary tree
        System.out.println( "==>> Pre Order " );
        preOrderTraversalInBinaryTree(rootNode);

        //8) Traversal of a Binary tree
        System.out.println( "==>> In Order " );
        inOrderTraversalInBinaryTree(rootNode);

        //9) Traversal of a Binary tree
        System.out.println( "==>> Post Order " );
        postOrderTraversalInBinaryTree(rootNode);

        //10) Level Order traversal in Binary tree
        System.out.println( "==>> Level order traversal " );
        levelOrderTraversal(rootNode);

        // 11) Iterative traversal in Binary tree
        System.out.println( "==>> Iterative traversal of Binary tree " );
        iterativePrePostInOrderTraversal(rootNode);


        //12) Node to root path in Binary tree
        System.out.println( "==>> Node to Root path of give node in a Binary tree " );
        ArrayList<Integer> path = new ArrayList<>();
        nodeToRootPath(rootNode, 62, path);
        System.out.println("\nPath is " + path);

        //13) Print all nodes k level downs in Binary tree
        System.out.println( "\n==>> Print all nodes k level downs in Binary tree" );
        printKLevelDownAllNodes(rootNode, 2);

        //14) Print Nodes K Level Far from given nodes
        System.out.println( "\n==>> Print Nodes K Level Far from given nodes" );
        printNodesKLevelFarFromGivenNodes(rootNode, 75, 2);

        // 15) Print path to leaf from root node of given binary tree and sum
        System.out.println( "\n==>> Print path to leaf from root node of given binary tree " );
        String pathFromRootToLeaf = "";
        printPathToLeafFromRootNode(rootNode, 0, pathFromRootToLeaf);

        //16) Create left cloned tree
        Node leftClonedTree = createLeftCloneTree(rootNode);
        System.out.println(" \n ==== >>  Display left cloned tree : \n" );
        displayTree(leftClonedTree);

        //17) Transform Back a left cloned tree to a normal tree
        Node transformedBAckFromLeftCloned = tranformBackFromLeftClonedTree(leftClonedTree);
        System.out.println(" \n ==== >>  Display after transformation of left cloned tree back : \n" );
        displayTree(transformedBAckFromLeftCloned);

        //18) Print Single child node
        System.out.println(" \n ==== >>  Single Child Nodes : \n" );
        printSignleChildNode(rootNode, null);

        //19) Remove leaf nodes in a Binary Tree
        // I am constructing a new binary tree here.
        Node removeLeavRoot = constructBinaryTree(arr);
        removeLeafNodeOfTree(removeLeavRoot, null);
        displayTree(removeLeavRoot);

        //20) Diameter of a Binary Tree
        int diameter = diameterOfBinaryTree(rootNode);
        System.out.println( "===>>>  Diameter of binary tree "+ diameter);

        // 21 ) Tilt of a Binary Tree : Travel and change strategy
        int tiltOfBinaryTree=0;
        tiltOfBinaryTree = tiltOfBinaryTree(rootNode, tiltOfBinaryTree);

        System.out.println( "===>>>  Overall tilt of binary tree "+ tiltOfBinaryTree);

        // 22) Is a Tree BinarySearchTree
        // USe travel and change strategy
        MyBSTPair returnValueBST = isTreeBinarySearchTree(rootNode);
        System.out.println( "===>>>  IS Biniary tree BST   "+ returnValueBST.isBST);






    }

    static class MyBSTPair{
        boolean isBST;
        int max;
        int min;

        public MyBSTPair( ) {

        }

        public MyBSTPair(boolean isBST, int min, int max) {
            this.isBST = isBST;
            this.max = max;
            this.min = min;
        }
    }
    /**
     * A tree is a binary search tree when a node is greater then all elements on its left and is
     * greater than all the elements on its right and this is recursively true for all of its node.
     * Logic :
     *    We will have a BSTPair Class that will contain boolean isBST, node min and node max
     *    For every node, we will first check if the node itself satisfying the BST property
     *    and then check if the node is greater than max of left side and node is less than min on right
     * @param node
     */
    private static MyBSTPair isTreeBinarySearchTree(Node node) {
        if(node == null){
            return new MyBSTPair(true, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        MyBSTPair leftSide = isTreeBinarySearchTree(node.left);
        MyBSTPair rightSide = isTreeBinarySearchTree(node.right);

        MyBSTPair nodeBSTPair = new MyBSTPair();
        // A node needs to get true as a bst property from left and right and also it should
        // be < min on right and >= max on left
        nodeBSTPair.isBST = leftSide.isBST && rightSide.isBST &&
            node.data <= leftSide.max && node.data > rightSide.min;
        nodeBSTPair.min = Math.min(node.data,Math.min(leftSide.min, rightSide.min)) ;
        nodeBSTPair.max = Math.max(node.data, Math.max(rightSide.max, leftSide.max));
        return nodeBSTPair;
    }

    /**
     * https://www.youtube.com/watch?v=gK95sG7Dm-w&list=PL-Jc9J83PIiHYxUk8dSu2_G7MR1PaGXN4&index=47
     * Tilt of a node is leftValue-rightValue
     * Tilt of a Tree is sum of all the tilt of Nodes.
     * Logic :
     *      Calculated local tilt of each node and add it to global variable to get the overall tree tild.
     *      2) Return sum of leftSide and RightSide, because this will be used by parent to caculcate its onw tild
     *
     */
    private static int tiltOfBinaryTree(Node node, int tiltOfBinaryTree) {

        if(node == null){
            return 0;
        }
        int leftSum = tiltOfBinaryTree(node.left, tiltOfBinaryTree);
        int rightSum = tiltOfBinaryTree(node.right, tiltOfBinaryTree);
        // Tilt of each node is left value - right value
        int localTilt = Math.abs(leftSum - rightSum);
        // Tilt of all tree is sum of all tilts
        tiltOfBinaryTree += localTilt;

        // We are returning all sum which will be used by parent to calculate its own tilt
        return leftSum+rightSum+ node.data;

    }

    /**
     * https://www.youtube.com/watch?v=S0Bwgtn32uI&list=PL-Jc9J83PIiHYxUk8dSu2_G7MR1PaGXN4&index=45
     * Diameter of a Binary Tree.
     * To calculate the diameter, maximum length between to nodes.
     * To calculate diameter, max of leftDiameter, rightDiameter and leftHeight+rightHeight+2
     *
     */
    private static int diameterOfBinaryTree(Node node ) {
        if (node == null){
            return 0;
        }
        int leftDiameter = diameterOfBinaryTree(node.left);
        int rightDiameter = diameterOfBinaryTree(node.right);
        int heightDistance = heightOfBinaryTree(node.left) + heightOfBinaryTree(node.right) + 2;

        return Math.max(heightDistance, Math.max(leftDiameter, rightDiameter));
    }

    /**
     * https://www.youtube.com/watch?v=x_0KUwgdm1c&list=PL-Jc9J83PIiHYxUk8dSu2_G7MR1PaGXN4&index=42
     *
     *
     */
    private static void removeLeafNodeOfTree(Node node, Node parent) {

        if (node == null ){
            return ;
        }

        if (node.left == null && node.right == null ){
            // this means it is a leaf node then remove this
           if(parent.left == node ){
               parent.left = null; // if this is a left node
           } else if (parent.right == node){
               parent.right = null;
           }
        }

        // Check this recursively for every node.
        removeLeafNodeOfTree(node.left , node);
        removeLeafNodeOfTree(node.right , node);

        // Approach 2
        // Here we will recursively check, and if its is leaf we will return null, while
        // capturing it we will just check it in its parent left or right, Since we ar returning null
        // this will just delete that node.
        // The method singnatature will here be taking only node as input.

//        if (node == null ){
//            return ;
//        }
//
//        if (node.left == null && node.right == null ){
//            return null;
//        }
//
//        // Check this recursively for every node.
//        node.left = removeLeafNodeOfTree(node.left);
//        node.right = removeLeafNodeOfTree(node.right );
    }

    /**
     * https://www.youtube.com/watch?v=VMJCFRWvb9Q&list=PL-Jc9J83PIiHYxUk8dSu2_G7MR1PaGXN4&index=41
     * We will check if the parent of given node is having either left or rith and not both.
     * Check this recursively for everyNode
     */
    private static void printSignleChildNode(Node node, Node parent ) {
        if(node == null){
            return ;
        }

        if (parent != null && node == parent.left && parent.right == null){
            // It should have only left or right child
            System.out.println(node.data);
        } else if (parent != null && node == parent.right && parent.left == null){
            System.out.println(node.data);
        }

        printSignleChildNode(node.left , node);
        printSignleChildNode(node.right , node);


    }

    /**
     * https://www.youtube.com/watch?v=AvXVChZoZkU&list=PL-Jc9J83PIiHYxUk8dSu2_G7MR1PaGXN4&index=38
     * Recursion on left.left child and then attach it back to node.
     * @param node
     */
    private static Node tranformBackFromLeftClonedTree(Node node) {
        if (node == null){
            return null;
        }

        // Normalize back the left node first
        // Since we are skipping two node, it will break the chain to next duplicate and will point to null
        // for second last node. This will propogate up removing left cloned element.
        Node leftNormalizedNode =tranformBackFromLeftClonedTree(node.left.left);
        Node rightNormalizedNode = tranformBackFromLeftClonedTree(node.right);

        node.left = leftNormalizedNode;
        node.right = rightNormalizedNode;

        return node;
    }

    /**
     * https://www.youtube.com/watch?v=TO7trQloRXc&list=PL-Jc9J83PIiHYxUk8dSu2_G7MR1PaGXN4&index=33
     * Logic :
     *      Using recursion call left and right
     *      and then for given node, create a new node, which will have data as self and left child as left cloned child,
     *      then attach the left of current node to the newly created node,
     *      attach the right to right clone child
     * @param node
     */
    private static Node createLeftCloneTree(Node node) {
        if(node == null ){
            return null;
        }
        // Recursion to create left cloned on left child
        Node leftCloneOnLeftChild = createLeftCloneTree(node.left);
        // Recursion to create right cloned on right child
        Node rightCloneOnLeftChild = createLeftCloneTree(node.right);
        // Now recursion will do its part to create left cloned tree on left child and right child of this node.

        // We will create a new node to duplicate the current node
        // here left child will be left cloned child node.
        Node newNode = new Node(node.data, leftCloneOnLeftChild, null);
        // attach this new node to the current node's left
        node.left = newNode;
        node.right = rightCloneOnLeftChild;
        return node;
    }

    /**
     * https://www.youtube.com/watch?v=A6Z5YvsrDtg&list=PL-Jc9J83PIiHYxUk8dSu2_G7MR1PaGXN4&index=29
     * Logic : Keep adding itself to the path and make a call recursively on left and right child
     *   till we find the leaf node,
     *   Print the path at leaf node and return.
     * @param node
     * @param sum
     */
    private static void printPathToLeafFromRootNode(Node node, int sum, String path) {
        if(node == null){
            return;
        }
        if(node.left ==null && node.right == null){
            // means this is leaf node, add itself to the path and print
            sum += node.data;
            path = path +  node.data + " , ";
            System.out.println( path + "and sum is " + sum);
            return;
        }

        printPathToLeafFromRootNode(node.left, sum+node.data, path+node.data + ", ");
        printPathToLeafFromRootNode(node.right, sum+node.data, path+node.data+ ", ");

    }

    /**
     * https://www.youtube.com/watch?v=B89In5BctFA&list=PL-Jc9J83PIiHYxUk8dSu2_G7MR1PaGXN4&index=26
     * Logic :
     *      This problem is the combination of NodeToRootPath and KlevelDown.
     *   1) first build an array list of node to rooth path.
     *   2) For every element in this ArrayList, we will print the (k-i)th level down.
     *   3) As an extra effor, we will have to make a blocker node to stop printing nodes
     *      printed at previous path value.
     */
    private static void printNodesKLevelFarFromGivenNodes(Node node, int data, int k) {
        // 1) get the node to rooth path list
        ArrayList<Node> path = new ArrayList<>();
        nodeToRootPathVariation(node, data, path);
        // 2) Iterate through the path list and print all the value kth level and so on.
        for (int i=0; i< path.size() ; i++){
            printKLevelDownAllNodes(path.get(i), k-i, i==0 ? null:path.get(i-1));
        }
    }
    /**
     * Logic : This is just a variation of actual implemenation of nodeToRoot
     * Here instead of storing node.data into path , we are storing actual node.
     */
    private static boolean nodeToRootPathVariation(Node node,int data, ArrayList<Node> path) {
        if (node == null) {
            return false;
        }
        if (node.data == data){
            path.add(node);
            return  true;
        }
        boolean foundInLeftchild = nodeToRootPathVariation(node.left,data,path);
        if(foundInLeftchild){
            path.add(node);
            return true;
        }

        boolean foundInRightchild = nodeToRootPathVariation(node.right,data,path);
        if(foundInRightchild){
            path.add(node);
            return true;
        }

        return false;

    }


    /**
     * This is a variation of normal path k level down,
     * Here we are having a blocker node, which will ensure if the blocker node is found,
     * we will not traverse that path.
     * @param node
     * @param k level
     * @param blockerNode
     */
    private static void printKLevelDownAllNodes(Node node, int k, Node blockerNode) {
        if(k<0 || node == null || node == blockerNode ){
            return;
        }
        if(k==0){
            System.out.print(node.data + " "); // since we are print here , it will printed in pre-order.
        }
        printKLevelDownAllNodes(node.left, k-1 , blockerNode);
        printKLevelDownAllNodes(node.right, k-1 , blockerNode);
    }

    /**
     * Logic : Recursively check, if I have to print K level, that means we have to
     * print k-1 level down.
     * if the level is 0, print the data.
     */
    private static void printKLevelDownAllNodes(Node node, int k) {
        if(k<0 || node == null ){
            return;
        }
        if(k==0){
            System.out.print(node.data + " "); // since we are print here , it will printed in pre-order.
        }
        printKLevelDownAllNodes(node.left, k-1);
        printKLevelDownAllNodes(node.right, k-1);
    }

    /**
     * Logic : There are total five cases
     * 1) if null return false
     * 2) return true if data matches
     * 3) Found in left
     * 4) found in Right
     * 5) else return false
     * From where ever its returning true add to path.
     */
    private static boolean nodeToRootPath(Node node,int data, ArrayList<Integer> path) {
        if (node == null) {
            return false;
        }
        if (node.data == data){
            path.add(node.data);
            return  true;
        }
        boolean foundInLeftchild = nodeToRootPath(node.left,data,path);
        if(foundInLeftchild){
            path.add(node.data);
            return true;
        }

        boolean foundInRightchild = nodeToRootPath(node.right,data,path);
        if(foundInRightchild){
            path.add(node.data);
            return true;
        }

        return false;

    }

    /**
     * Logic : Use stack and a pair class.
     * Pair class will have state as 1, 2 and 3
     * if State 1 : preorder, increase state, and add left to stack
     * if state 2 : in order, increase state, and add right
     * if state 3 : post order, pop from stack
     * @param node
     */
    private static void iterativePrePostInOrderTraversal(Node node) {

        String pre = "";
        String inorder = "";
        String postOrder = "";
        Stack<Pair> stack = new Stack<>();
        Pair pair = new Pair(node, 1);
        stack.push(pair);
        while (stack.size() > 0) {
            Pair top = stack.peek();
            if(top.state ==1){ // add in preorder case, state ++, add left child as pair to Stack
                pre += top.node.data + ", ";
                top.state++;
                if(top.node.left != null){
                    // add left child of this node into stack
                    Pair leftPair = new Pair(top.node.left ,1);
                    stack.push(leftPair);
                }
            } else if (top.state ==2){ // add to inorder list, state++, add right child to stack as new pair
                // if state is two its inorder euler state
                inorder += top.node.data + ", ";
                top.state++;
                if(top.node.right != null){
                    // add left child of this node into stack
                    Pair rightPair = new Pair(top.node.right ,1);
                    stack.push(rightPair );
                }
            } else {

                // this is Post order case
                // add to post order case and remove from stack
                postOrder += top.node.data + ", ";
                stack.pop();
            }
        }
        System.out.println(" Preorder is  : " + pre );
        System.out.println(" PostOrder is  : " + postOrder );
        System.out.println(" Inorder is  : " + inorder );
    }

    /**
     * Level order traversal usesu queue.
     * Remove , print add childs (rpa)
     * @param node
     */
    private static void levelOrderTraversal(Node node) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);

        while(queue.size() > 0){
            // size will give element at current level, we will print all element
            int count = queue.size();
            for (int i=0; i<count ; i++){
                // remove node
                Node removeNode = queue.remove();
                System.out.print(removeNode.data + ", ");
                if(removeNode.left !=null){
                    queue.add(removeNode.left);
                }
                if(removeNode.right != null){
                    queue.add(removeNode.right);
                }
            }
            System.out.println(); // New line to change the level
        }

    }


    private static void preOrderTraversalInBinaryTree(Node node) {
        if(node == null){
            return;
        }
        System.out.println(node.data );
        preOrderTraversalInBinaryTree(node.left);
        preOrderTraversalInBinaryTree(node.right);
    }

    private static void inOrderTraversalInBinaryTree(Node node) {
        if(node == null){
            return;
        }
        inOrderTraversalInBinaryTree(node.left);
        System.out.println(node.data );
        inOrderTraversalInBinaryTree(node.right);
    }

    private static void postOrderTraversalInBinaryTree(Node node) {
        if(node == null){
            return;
        }
        postOrderTraversalInBinaryTree(node.left);
        postOrderTraversalInBinaryTree(node.right);
        System.out.println(node.data );

    }

    /**
     * Logic : Get height from left, and right.
     * Caluclate max of left and right, add one and return
     * @param node
     * @return
     */
    private static int heightOfBinaryTree(Node node) {
        if(node == null){
            return 0;
        }

        return 1 + Math.max(heightOfBinaryTree(node.left) , heightOfBinaryTree(node.right));
    }

    private static int maxInBinaryTree(Node node) {
        // Logic : get max from left, max from right and then compare with itself and return max

        if(node ==null){
            return Integer.MIN_VALUE;
        }
        int maxFromLeft = maxInBinaryTree(node.left);
        int maxFromRight = maxInBinaryTree(node.right);
        int maxOfLeftRight = Math.max(maxFromLeft,maxFromRight);


        return Math.max(maxOfLeftRight , node.data);
    }

    private static int sum(Node node) {
        if(node == null){
            return 0;
        }
        int leftSum = sum(node.left);
        int rightSum = sum(node.right);
        return  node.data + leftSum + rightSum;
    }

    private static int size(Node node) {
        // recursion to get left size , right size and then add one to it
        if (node== null) {
            return 0;
        }

        int leftSize = size(node.left);
        int rightSize = size(node.right);
        return leftSize+rightSize+1;
    }

    /**
     * https://www.youtube.com/watch?v=sYU6AnSJyjo&list=PL-Jc9J83PIiHYxUk8dSu2_G7MR1PaGXN4&index=3
     * @param node
     */
    private static void displayTree(Node node) {

        // this is preOrder display Node, left, right
        if(node == null){
            return;
        }
        String str = "";
        str += node.left ==null ? " . " : node.left.data + " " ;
        str += " <-  " + node.data + " -> "; // this will give preorder
        str += node.right ==null ? " . " : node.right.data + " ";

        System.out.println(str);
        displayTree(node.left);
        displayTree(node.right);
    }
}
