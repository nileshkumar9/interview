package com.interview.tree.gerictree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/**
 * This is in continuation of questions from index 23 onwards
 * https://www.youtube.com/watch?v=TKZEBXtzKSM&list=PL-Jc9J83PIiEmjuIVDrwR9h5i9TT2CEU_&index=23
 */
public class GenericTreeUsingEulerArray2 {

    private static class Node{
        int data;
        ArrayList<Node> childeren = new ArrayList<>();

        Node (){

        }

        Node(int data){
            this.data = data;
        }
    }

    /**
     * d(10) will print self and it faimily
     *      similarly d(20) will print self and its own family
     *      d(10) --> sself(10) + d(20) + d(30)
     */
    public static void displayNode(Node node){
        String str = node.data + "--> ";

        for(Node child : node.childeren){
            str += child.data + ", ";
        }
        str += "." ; // 1) printed self and its children
        System.out.println(str);

        for(Node child : node.childeren){
            displayNode(child );
        }

    }
    public static int size(Node node){
        int size =0;
        if(node == null){
            return 0;
        }

        for(Node child : node.childeren){
            size += size(child);
        }
        return size+1;
    }


    /**
     * This constructs the tree from given arralylist.
     * Elements in input array are in the form of euler preorder sequence.
     * Tree constructed will be like this
     *                      10
     *        20(10)        30(10)          40(10)
     *  50(20) 60(20)   70(30) 80(30) 90(30)    100(40)
     *                     110(80)  120(80)
     * @param root
     * @param arr
     * @return
     */
    private static Node constructTreefromgivenArrayEuler(Node root, int[] arr) {
        Stack<Node> st = new Stack<>();
        for(int i = 0; i< arr.length; i++){
            if(arr[i] == -1){
                st.pop();
            } else{
                Node temp = new Node();
                temp.data = arr[i];

                if (st.size() >0){
                    // we peep from stack and make
                    st.peek().childeren.add(temp);
                } else {
                    // if stack is empty that means that is the root element;
                    root = temp;
                }
                st.push(temp);
            }

        }
        return root;
    }


    public static void main(String[] args) {
        Node root = null;
        // Euler path is when we traverse we add root from left , and then when we go right of the node,
        // we add -1
        int [] arr = {10, 20, 50, -1, 60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};

        root = constructTreefromgivenArrayEuler(root, arr);

        displayNode(root);

        System.out.print( "Size of the tree : ");
        System.out.println(size(root));

       // Commenting this line because this disturb our tree structure hence other questions disturbs;
        // System.out.println("Linearize a tree ");
        //linearizeGenericTree(root);

        System.out.println("Find element in generic tree ");
        boolean found = findElementInGenericTree(110, root);
        if(found){
            System.out.println("Element found");
        } else{
            System.out.println("Element not found");
        }

        /**
         * https://www.youtube.com/watch?v=oEBwL5pHzTs&list=PL-Jc9J83PIiEmjuIVDrwR9h5i9TT2CEU_&index=28
         */
        System.out.println("Print Node to Root path for given element");
        ArrayList<Integer> nodeToRoot = printNodeToRootPathElement(root, 110);
        System.out.println(nodeToRoot);

        System.out.println("Print Root to Node path for given element");
        ArrayList<Integer>  rootToNode = printNodeToRootPathElement(root, 110);
        Collections.reverse(rootToNode);
        System.out.println(rootToNode);

        // LowestCommonAncestor
        /**
         * Lowest common ancestor in a given tree
         * LCA
         */
        int LCA = lowestCommonAncestor(root, 110, 120);
        System.out.println("LCA for 110 and 120 ==> " + LCA);

        // Distance between nodes in term of edges
        /**
         * https://www.youtube.com/watch?v=5N5tpizDXys&list=PL-Jc9J83PIiEmjuIVDrwR9h5i9TT2CEU_&index=32
         * Distance between nodes in term of edges.
         */
        int distanceBetweenNodes = distanceBetweenNodes(root, 70, 110);
        System.out.println("Distance between given node :: ==> " + distanceBetweenNodes);

         /**
         * https://www.youtube.com/watch?v=y_PIhsd9vt0&list=PL-Jc9J83PIiEmjuIVDrwR9h5i9TT2CEU_&index=34
         * Are tree similar in shape
         */
        boolean  areTreeSimilarInshape = areTreeSimilarInshape(root,root);
        System.out.println("Are tree similar in shape :: ==> " + areTreeSimilarInshape);


        /**
         * https://www.youtube.com/watch?v=v2MqQoma9uc&list=PL-Jc9J83PIiEmjuIVDrwR9h5i9TT2CEU_&index=36
         * Are tree mirror of each other in shape (not comparing the data).
         * This questions is very similar to similarTree only the index calculations changes.
         * Tree wil be mirror when the left of tree1 is similar to right of tree 2
         * Remember that in mirror, left becomes right, similarly ith becomes size-ith index
         */
        boolean  areTreeMirrorInShape = areTreeMirrorInShape(root,root);
        System.out.println("Are tree Mirror in shape :: ==> " + areTreeMirrorInShape);

        /**
         * https://www.youtube.com/watch?v=v2MqQoma9uc&list=PL-Jc9J83PIiEmjuIVDrwR9h5i9TT2CEU_&index=36
         * A tree are symetric in shape if its mirror image of itself.
         * An object is Symetric is shape when we can divide the object exactly in two half
         * E.g face is symetrical if you cut it vertically from nose. Where as palm is not symetric in shape
         *
         */
        boolean  areTreeSymmetric = areTreeSymmetric(root );
        System.out.println("Are tree Symmetric in shape :: ==> " + areTreeSymmetric);

    }

    private static boolean areTreeSymmetric(Node node1 ) {
        /**
         * A tree are symetric in shape if its mirror image of itself.
         * An object is Symmetric is shape when we can divide the object exactly in two half
         *  E.g face is symmetrical if you cut it vertically from nose. Where as palm is not symmetric in shape
         *
         */
        return areTreeMirrorInShape(node1, node1);
    }

    private static boolean areTreeMirrorInShape(Node node1, Node node2) {
        /**
         * two tree are mirror in shape that means the structure of the tree are same
         * with repect to mirror. In mirror ith index becomes size -ith index in other
         * So to check mirror image, first we will check if the number of childeren
         * for each node are same. Once same we will check if the ith index of tree1
         * is similar to size-ith index of tree2.
         * This should be recursively true for each element.
         */

        if(node1.childeren.size() != node2.childeren.size()){
            return false; // breaking immediately if they are not same
        }

        // Checking recursively for each tree
        for(int i=0; i<node1.childeren.size();i++){
            // checking recursively for each child of given node
            int j = node1.childeren.size()-1-i;  // mirror index corresponding to i
            // Now take ith element for first tree and jth element from tree2
            Node child1 = node1.childeren.get(i); //for every element we will check if they are similar
            Node child2 = node2.childeren.get(i); //for every element we will check if they are similar
            if(areTreeMirrorInShape(child1,child2) == false){
                // this is breaking condition the moment we found false
                return false;
            }
        }
        return true;
    }

    private static boolean areTreeSimilarInshape(Node node1, Node node2) {
        /**
         * two tree are similar in shape that means the structure of the tree are same.
         * We are not interested in finding the data equality, we are just checking if structure are same
         * Logic : We will see if the children count is same for each node.
         * and that is recursively true for each and every node.
         */

        if(node1.childeren.size() != node2.childeren.size()){
            return false; // breaking immediately if they are not same
        }

        // Checking recursively for each tree
        for(int i=0; i<node1.childeren.size();i++){
            // checking recursively for each child of given node
            Node child1 = node1.childeren.get(i); //for every element we will check if they are similar
            Node child2 = node2.childeren.get(i); //for every element we will check if they are similar
            if(areTreeSimilarInshape(child1,child2) == false){
                // this is breaking condition the moment we found false
                return false;
            }
        }
        return true;
    }


    private static int distanceBetweenNodes(Node root, int data1, int data2) {

        /**
         * https://www.youtube.com/watch?v=5N5tpizDXys&list=PL-Jc9J83PIiEmjuIVDrwR9h5i9TT2CEU_&index=32
         * Its similar to LCA
         * In lca, the point of lca is from where the root diverged hence the path will be difference
         * between node and lca of first list and second list
         * Now since the list is from node(0th index) to Root(size-1 index), since we know the postion of lca in each list(i,j)
         * that is the difference from 0th index to lca
         * Hence most of code is repeating like lca and then returning i + j
         *
         */
        ArrayList<Integer> nodeToRootFordata1 = printNodeToRootPathElement(root, data1);
        ArrayList<Integer> nodeToRootFordata2= printNodeToRootPathElement(root, data2);


        //Approach 2 where the list is from node to path
        int i= nodeToRootFordata1.size()-1; // looping from last index as element at last indes is root
        int j= nodeToRootFordata2.size()-1;

        while (i>=0 && j>=0 && nodeToRootFordata1.get(i) ==nodeToRootFordata2.get(j)){
            i--;
            j--; // keep going to the previous element
        }
        i++;
        j++; // going back to previous element which will be lca
        // list 1 ===>              70(0 index) -> 30(1 index) -> 10(2 index)
        // list 2 ===> 110(0 index)-> 80(1 index)->30(2 index) -> 10(3 index)
        return i+j;


    }

    private static int lowestCommonAncestor( Node root, int data1, int data2) {
        /**
         * We will find root to node path for both the given data.
         * One approach, which is commented in the code below is to find the list of node to path,
         * reversing the list, will give root to node path. Now iterate from root to path
         * till the elements are common, we will break from where the value gets differenciating
         * hence we have lca from where the path diverged.
         * Approach 2 is also similar, here we calculate node to path. In this
         * the list is in reverse order so we can loop from end of the loop in backword direction
         * if it diverges we will return the previous index, this reduce overhead of
         * reversing the loop unlike in approach 1
         */
        ArrayList<Integer> nodeToRootFordata1 = printNodeToRootPathElement(root, data1);
        //Collections.reverse(nodeToRootFordata1); // reversing to find root to node path
        ArrayList<Integer> nodeToRootFordata2= printNodeToRootPathElement(root, data2);
        //Collections.reverse(nodeToRootFordata2); // reversing to find root to node path

        //Approach 2 where the list is from node to path
        int i= nodeToRootFordata1.size()-1; // looping from last index as element at last indes is root
        int j= nodeToRootFordata2.size()-1;

        while (i>=0 && j>=0 && nodeToRootFordata1.get(i) ==nodeToRootFordata2.get(j)){
            i--;
            j--; // keep going to the previous element
        }
        i++;
        j++; // going back to previous element

        return nodeToRootFordata1.get(i); // both i and j will give similar value.


        //Approach 1 is below in which we take reversed list and interate from start

//        int previous = -1;
//        for(int i =0; i<nodeToRootFordata1.size() ; i++){
//            if(nodeToRootFordata1.get(i) != nodeToRootFordata2.get(i)) break; // since we are diverging from here we will break
//            else{
//                // since we found a match we will proceed to next element but will update the previous
//                previous = nodeToRootFordata1.get(i);
//            }
//        }
//        return previous;

    }

    private static ArrayList<Integer> printNodeToRootPathElement(Node node, int data) {
        if (node.data == data){
            ArrayList<Integer> list = new ArrayList<>();
            list.add(node.data );
            return list;
        }
        /**
         * find element in all child, when it finds the element it will break immediately without
         * traversing whole child
         */
        for(Node child : node.childeren){
            ArrayList<Integer> pathTillChild = printNodeToRootPathElement(child , data);
            if(pathTillChild.size() >0 ){
                // This means we found the element hence we will return by adding self to it
                pathTillChild.add(node.data );
                return pathTillChild;
            }
        }
        return new ArrayList<>();

    }

    private static   boolean findElementInGenericTree(Integer data, Node node) {
        if (node.data == data){
            return true;
        }
        /**
         * find element in all child, when it finds the element it will break immediately without
         * traversing whole child
         */
        for(Node child : node.childeren){
            boolean foundInChild = findElementInGenericTree(data, child);
            if(foundInChild){
                return true;
            }
        }
        return false;

    }

    /**
     * Linearize a generic tree, which means put all as a single node with euler preorder
     * @param node
     */
    private static void linearizeGenericTree(Node node) {
        for(Node child : node.childeren){
            linearizeGenericTree(child);
        }

        while(node.childeren.size() >1){
            // Remove the last node and make it to point secondLast child tail
            // to the point to last child first node
            Node lastChild = node.childeren.remove(node.childeren.size()-1);
            // Since we remove last node second last becomes the last node
            Node secondLastChild = node.childeren.get(node.childeren.size()-1);
            // Point tail of secondChild to top of last child
            Node secondLastTail = getTail(secondLastChild);
            secondLastTail.childeren.add(lastChild);
        }

    }

    private static Node getTail(Node node) {
        /**
         * To get the tail, keep traversing till the size of of the tree
         */
        while(node.childeren.size()==1){
            // since its a linear size tree already, we will have last element whose child size will be 0.
            node = node.childeren.get(0);
        }
        return node;
    }

}
