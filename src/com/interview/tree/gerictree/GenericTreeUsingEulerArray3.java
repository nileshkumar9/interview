package com.interview.tree.gerictree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * This is in continuation of questions from index 39 onwards
 * https://www.youtube.com/watch?v=cBQs7kqK_Dw&list=PL-Jc9J83PIiEmjuIVDrwR9h5i9TT2CEU_&index=39
 */
public class GenericTreeUsingEulerArray3 {

    private static class Node {
        int data;
        ArrayList<Node> childeren = new ArrayList<>();

        Node() {

        }

        Node(int data) {
            this.data = data;
        }
    }

    /**
     * d(10) will print self and it faimily
     * similarly d(20) will print self and its own family
     * d(10) --> sself(10) + d(20) + d(30)
     */
    public static void displayNode(Node node) {
        String str = node.data + "--> ";

        for (Node child : node.childeren) {
            str += child.data + ", ";
        }
        str += "."; // 1) printed self and its children
        System.out.println(str);

        for (Node child : node.childeren) {
            displayNode(child);
        }

    }

    /**
     * This constructs the tree from given arralylist.
     * Elements in input array are in the form of euler preorder sequence.
     * Tree constructed will be like this
     * 10
     * 20(10)        30(10)          40(10)
     * 50(20) 60(20)   70(30) 80(30) 90(30)    100(40)
     * 110(80)  120(80)
     *
     * @param root
     * @param arr
     * @return
     */
    private static Node constructTreefromgivenArrayEuler(Node root, int[] arr) {
        Stack<Node> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                st.pop();
            } else {
                Node temp = new Node();
                temp.data = arr[i];

                if (st.size() > 0) {
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
    static int size;
    static int max;
    static int min;
    static int height;

    public static void main(String[] args) {
        Node root = null;
        // Euler path is when we traverse we add root from left , and then when we go right of the node,
        // we add -1
        int[] arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};

        root = constructTreefromgivenArrayEuler(root, arr);

        displayNode(root);

        max = Integer.MAX_VALUE;
        min = Integer.MIN_VALUE;
        size = 0;
        height =0;
        /**
         * Multisolver is the strategy where we change multiple value while visiting the tree
         *
         */
        multisolver(root, 0);

        /**
         * Find predecessor and successor for given element
         */
        successor =null;
        predecessor = null;
        state=0;
        predecessorAndSuccessor(root,90);
        System.out.println("Predecessor ===> : "+ predecessor.data);
        System.out.println("Successor ===> : "+ successor.data);

        /**
         * Find ceil and floor for given data element
         */
        ceil =Integer.MAX_VALUE; // will be smallest element among element larger then given data
        floor = Integer.MIN_VALUE ; // Will be largest element among elements smaller then given data
        ceilAndFloor(root,65);
        System.out.println("Ceil ===> : "+ ceil);
        System.out.println("Floor ===> : "+ floor);


        /**
         * Kth largest in the given tree
         * This is the variation of finding floor for kth element
         */
        floor =Integer.MAX_VALUE; // will be smallest element among element larger then given data
        int k =4  ;// to give the 3rd largest element in the tree
        kthLargestElement(root,3);
        System.out.println("kth largest element in the tree is  ===> : "+ kthLargestElement(root,k));

        /**
         * https://www.youtube.com/watch?v=tDx3PPwgSxs&list=PL-Jc9J83PIiEmjuIVDrwR9h5i9TT2CEU_&index=47
         * To find the subtree that has maximum sum
         */
        maximumSumNode = 0;
        maximumSum = Integer.MIN_VALUE;
        maxSumSubTree(root);
        System.out.println("Maximum sum is for node : " + maximumSumNode + " and sum is : " + maximumSum);


        /**
         * https://www.youtube.com/watch?v=GIA2cZgOdwg&list=PL-Jc9J83PIiEmjuIVDrwR9h5i9TT2CEU_&index=49
         * To find the diameter of given generic tree
         * deepestchild + secondDippestChild + 2 --> for every node and do this for all Node.
         */
        diameter = 0;
        calculateDiameterReturnHeight(root);
        System.out.println("Diameter of this tree is at node : " + maximumSumNode + " and sum is : " + diameter);


        /**
         * https://www.youtube.com/watch?v=5ry6gRrzPqc&list=PL-Jc9J83PIiEmjuIVDrwR9h5i9TT2CEU_&index=51
         * Iterative preOrder and PostOrder Traversal of generic tree.
         */

        iterativePreOrderPostOrder(root);

    }
    static class Pair{
        Node node;
        int state;

        public Pair(Node node , int state) {
            this.state = state;
            this.node = node;
        }

    }

    private static void iterativePreOrderPostOrder(Node node) {
        /**
         * Logic is we will maintain a Stack and we will maintaint the state alongwith it
         * each element will be pushed with Node and state. (10 -1)
         * State will be -1 initially.
         * When State is -1  --> its preorder, print and increase the state's value
         *  if State is 0 to child.size()-1 --> just increse the state, and add to the stack child
         *  if state is child.size() --> its postOrder, print and Pop
         *  // Take help of Euler diagram to understand this
         *  // State signifies the child number that we are referring to.
         *  // We wil use pair class to maintain the state
         */
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(node, -1));

        String preOrder = "";
        String postOrder = "";
        while(st.size() > 0){
            Pair top = st.peek();
            if(top.state ==  -1){
                // Preorder
                preOrder = preOrder + " " + top.node.data;
                top.state ++;

            } else if ( top.state >=0 && top.state <= node.childeren.size() -1){
                // Here state will be 0
                Node child = top.node.childeren.get(top.state); // getting nth child of node
                st.push( new Pair(child, -1));
                top.state ++;
            } else {
                // Post order as this case state will be = to child.size()
                postOrder = postOrder + " " + top.node.data;
                st.pop();
            }

        }
        System.out.println("Preorder : " + preOrder );
        System.out.println("PostOrder : " + postOrder );

    }


    static int diameter;

    private static int calculateDiameterReturnHeight(Node node) {
        /**
         * Calculate deepestChild and secondDeepest child of each element.
         * Find if the diameter is greater than previous diameter replace it
         * We will calculate the height of the tree and will keep updating the diameter of the tree.
         *
         */
        int deepestHeight =-1; // this wil be for height
        int secondDeepestHeight =-1; // this will be second heighest height
        for(Node child : node.childeren){
            int childHeight = calculateDiameterReturnHeight(child);
            if(deepestHeight > childHeight){
                // Since child height is greater then current height, that will become the height
                // HEight is the maximum value of height at given point
                // We will update the value with deepest and second deepest
                secondDeepestHeight = deepestHeight;
                deepestHeight = childHeight; // this will become new deepest height

            } else if (childHeight > secondDeepestHeight){
                secondDeepestHeight = childHeight;
            }

        }

        if((deepestHeight + secondDeepestHeight +2) > diameter){
            diameter = (deepestHeight + secondDeepestHeight+2);
        }

        deepestHeight ++;
        return deepestHeight;
    }


    static int maximumSumNode;
    static int maximumSum;

    private static int maxSumSubTree(Node node) {
        /**
         * We will calculate sum for each element and we will return the sum
         * If sum calculated is greater than maximumSum then we will change the heap value
         * Travel and Change strategy.
         */
        int sum =0;

        for(Node child : node.childeren){
            int childSum = maxSumSubTree(child);
            sum = sum + childSum;
        }
        sum = sum + node.data; // add itself to the sum

        if(sum > maximumSum){
            // update the value of the heap
            maximumSum = sum;
            maximumSumNode = node.data;
        }
        return sum;
    }

    private static int  kthLargestElement(Node node, int k) {
        /**
         * Logic, initital we will find the floor of +infinity
         * This will give us the largest element in the tree.
         * Now in next iteration, we will use this largest element and will find the floor of it
         * This will give us second larges element in the tree.
         * similarly keep finding floor for kth time taking the element found in previous step
         *
         */
        int factor = Integer.MAX_VALUE; // Setting initially to + infinity
        floor = Integer.MIN_VALUE; //Finding the largest in smallest group

        for(int i=0;i<k;i++){
            ceilAndFloor(node, factor); // finding floor for this factor which is intially +infining
            // changed the factor everytime, in first iteration this will be larges value of tree
            factor = floor; // floor is found in ceilAndFloor method.
            floor = Integer.MIN_VALUE; // re-setting floor for new data element
        }
        return factor; // after kth iteratin this will be nth largest element

    }


    static int ceil;
    static int floor;

    private static void ceilAndFloor(Node node, int data) {
        /**
         * Iterated for each element and set the ceil and floor.
         * Ceil is just greated then the data
         * and floor is just smallest then the data
         */
        if(node.data> data){
            //since this node qualifies for ceil condtionts
            // we will check and udpate the previously calculated ceil value if this is smaller
            // then previously calculated ceil value
            if(node.data< ceil){ // smallest among ceil
                ceil = node.data;
            }
        }

        if(node.data < data){
            if(node.data> floor){ // largest amont floor
                floor = node.data;
            }
        }

        for(Node child : node.childeren){
            ceilAndFloor(child, data);
        }
    }


    static Node successor;
    static Node predecessor;
    static int state ;

    private static void predecessorAndSuccessor(Node node, int data) {
        /**
         * We will keep the state as 0 till we encounter the value equal to data in node.
         * We will keep upating precessor till the state is 0, because after state is 1 we don't touch precessor
         * When data matches, we will change state to 1 marking we found the data.
         * Immediately next element in the sequence we will set state to 2 and will mark successor.
         */

        if(state ==0){
            // either node data will be same as passed data then change state
            // else update precessor
            if(node.data ==data){
                state =1;
            } else{
                predecessor = node;
            }
        } else if (state ==1 ){
            // We found the matching element and set the state, so immediate next node will
            // be visited with state as 1 which will be successor of matched value and change to state 2
            successor = node;
            state = 2;
        }
        for(Node child : node.childeren){
            predecessorAndSuccessor(child,data);
        }

    }


    private static void multisolver(Node node, int depth) {
        /**
         * Using this method we will calcuate size, max, min, height and will keep it in heap memory
         * Remember all the static values are sitting in heap area hence there value will be retained
         * during the recursion call.
         */
        size= size+1;
        min = Math.min(min,node.data);
        max = Math.max(max,node.data);
        height = Math.max(height,depth);

        for(Node child : node.childeren){

        }
    }


}
