package com.interview.tree.gerictree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class GenericTreeUsingEulerArray {

    private static class Node{
        int data;
        ArrayList<Node> childeren = new ArrayList<>();

        Node (){

        }

        Node(int data){
            this.data = data;
        }
    }
    // d(10) will print self and it faimily
    // similarly d(20) will print self and its own family
    // d(10) --> sself(10) + d(20) + d(30)
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

    public static int maximumInAGenericTree(Node root){
        int max = Integer.MIN_VALUE;

        for(Node child : root.childeren){
            int maxOfChild = maximumInAGenericTree(child);
            max = Math.max(maxOfChild,max);
        } // found max in all ot the children
        // Now compare with node itself and max of the children above
        max = Math.max(max,root.data);

        return max;
    }

    public static void main(String[] args) {
        Node root = null;
        // Euler path is when we traverse we add root from left , and then when we go right of the node,
        // we add -1
        int [] arr = {10, 20, 50, -1, 60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};

        Stack<Node> st = new Stack<>();
        for(int i=0; i< arr.length;i++){
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

        displayNode(root);

        System.out.print( "Size of the tree : ");
        System.out.println(size(root));

        System.out.print( "Maximum value in the tree : ");
        System.out.println(maximumInAGenericTree(root));


        System.out.print( "Height of the tree : ");
        System.out.println(height(root));

        System.out.println( "Traversal of tree: Pre and post: ");
        traversal(root);

        System.out.println( "Level order traversal of tree ");
        levelOrderTraversal(root);


        System.out.println( "Level order Linewise traversal of tree ");
        levelOrderLineWiseTraversal(root);

        System.out.println( "Level order Linewise traversal  : Approach two Peep coding ");
        levelOrderLineWiseTraversalAppraoch2(root);

        System.out.println( "Level order Linewise traversal  : Approach three using one queue and marker approach");
        levelOrderLineWiseTraversalAppraoch3(root);

        System.out.println( "Level order Linewise traversal  : Approach 4 using one queue and count approach");
        levelOrderLineWiseTraversalAppraoch4(root);

        System.out.println( "Level order Linewise traversal  : Approach 5 using one Pair class and level approach");
        levelOrderLineWiseTraversalAppraoch5(root);

        System.out.println( "Level order spiral/zig zag traversal  :  two Peep coding ");
        levelOrderLineWiseSpiralTraversal(root);

        System.out.println( "Remove leaves node");
        removeLeavesNode(root);



    }

    private static void removeLeavesNode(Node node) {
        /**
         * Remove the node if it doesn't have child while going into recursion check
         * 2) when the child has leave nodes remove it
         * very important when manipulating any arraylist, always start from end
         * else the array modified from beginning will screw the position of elements as
         * every removal suffiles element to the left.
         */

        // remove node first
        for(int i = node.childeren.size()-1; i>=0; i--){
            Node child = node.childeren.get(i); // Check for each child of this parent from right to left **
            if(child.childeren.size() ==0){ // if this node's doesn't have any child remove it
                node.childeren.remove(child);// remove this child from the node
            }
        }
        for(Node child : node.childeren){
            removeLeavesNode(child); // checking recursion
        }
    }

    private static class Pair {
        Node node;
        int level;

        public Pair(Node node, int level) {
            this.node = node;
            this.level = level;
        }
    }
    private static void levelOrderLineWiseTraversalAppraoch5(Node root) {
        /** we will create a pair class that wil have node and level
         * while adding in queue we will add pair, which wil have level information and a nde
         * once we are done with one level we will change the level value by 1
         * if the level value received from removed element is more than the level variable, we will print new line
         *
         */
        Queue<Pair> queue = new ArrayDeque<>();
        int level =1;
        queue.add(new Pair(root, level));
        while(queue.size()>0){
            Pair pair = queue.remove(); // get the element
            if(level != pair.level){ // we are now removing child of next level
                level = pair.level;
                //change line as level is chaning
                System.out.println();
            }
            // otherwise print the data p
            System.out.print( pair.node.data+ " " );
            for(Node node: pair.node.childeren){
                queue.add(new Pair(node, level +1)); // changing the leve for childs
            }

        }
        System.out.println(); // not required petty printing for self


    }

    private static void levelOrderLineWiseTraversalAppraoch4(Node root) {
        /**
         * Use one queue,
         * Use count as size of element(child) at current level
         * Add all the child till for all the size
         * Add new line
         * 
         * 
         */
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while(queue.size()>0){
            // at end of each level size of queue will number of data at that level
            int count = queue.size();
            for (int i=0; i< count ; i++){
                Node node = queue.remove(); // r
                System.out.print( node.data + " "); // p
                for(Node child : node.childeren){ //a
                    queue.add(child); // adding all the elemnt for given node at a level
                }
            }
            System.out.println(); // done processing this level
        }
        System.out.println(); // this is not required
    }

    private static void levelOrderLineWiseTraversalAppraoch3(Node root) {

        /**
         * Use one queue,
         * First add root node then add the null as a marker
         * Add all its child and then add null when all child are added for this node.
         * Null signifies the level is traveserd, when we encounter null we will change the line
         * Keep doing till the queue is empty
         * 10 null 20 30 40 null 50 6o 0 etc
         */
        Queue<Node> queue = new ArrayDeque<>();

        queue.add(root);
        // we cannot add null in queue hence crated a special marker with -1
        queue.add(new Node(-1));
        while(queue.size()>0){
            // remove r
            Node node = queue.remove();
            if(node.data != -1){
                // if node is not null print and add all child
                System.out.print(node.data + " "); // print
                // add child
                for(Node child :node.childeren){
                    queue.add(child);
                }
            } else { // when node is null
                // this is scenario of level change.
                // only add null when the queue is not empty
                if(queue.size() >0){
                    queue.add(new Node(-1));
                    System.out.println(); // change the line
                }
            }
        }
        System.out.println(); // this is not required
    }

    private static void levelOrderLineWiseSpiralTraversal(Node root) {
        /**
         * Zig zag level order traversal, spiral traversal
         * Visit one leve in one direction, other in reverse direction
         * Logic : Use two stack, main stack and child stack
         * maintain a flag called level
         * when we are traversing a lefel in left to right , we will add the child in left to right direction in stack
         * This since, added in stack, will automatically reverse when popping hence its important to add in that fashin
         *
         */
        Stack<Node> mainStack = new Stack<>();
        Stack<Node> childStack = new Stack<>();
        mainStack.push(root);

        // root is at level 1 for left to right, if we intialize to 0 it will be left to right and zig zag continues
        int level = 1;
        while(mainStack.size()>0){
            //remove print add - same algorithm works
            Node node = mainStack.pop();
            System.out.print(node.data + " ");

            // important to note that children are arraylist
            // if level is odd we goes in right to left direction
            if((level % 2) ==1){
                for(int i=0; i<node.childeren.size(); i++){
                    childStack.push(node.childeren.get(i));
                }
            } else{
                for(int i=node.childeren.size()-1; i >=0; i--){
                    childStack.push(node.childeren.get(i));
                }
            }
            if(mainStack.size() ==0){ // since we are done processing one stack
                // change the stack to process the child which will be next level
                mainStack=childStack;
                childStack = new Stack<Node>();
                level++; // important to increase the leve here
                System.out.println(); // to change the line as we are done processing one level here
            }

        }
    }


    private static void levelOrderLineWiseTraversalAppraoch2(Node root) {

        /**
         * Use two queue, first queue add the element
         * add all child to child queue
         * do this till both child queue and queue is empty
         * we will change the reference of mainqueu to child queue once main queue is empty
         * Thus we are changing queue every time queue(level) is done
         */
        Queue<Node> queue = new ArrayDeque<>();
        Queue<Node> childQueue = new ArrayDeque<>();

        queue.add(root);
        while(queue.size()>0){
            // remove r
            Node node = queue.remove();
            System.out.print(node.data + " "); // print
            // add child
            for(Node child :node.childeren){
                childQueue.add(child);
            }
            // Added all child at this level
            if(queue.size() ==0){ // this means all data at one level is removed and printed
                // change the queue to childqueue, its time to traverse next level
                queue = childQueue;
                childQueue = new ArrayDeque<>();
                System.out.println(); // Print line for next line
            }
        }
    }

    private static void levelOrderTraversal(Node root) {
        // Logic : we use queue, add to the queue,
        // remove the element from the queue and add all its child to the queue
        // Since we are removing from top, child at particular level will be visited and then we will move
        // to its childs
        // Alorithm : r p a (remove print addchild)
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);

        while(queue.size()>0){
            Node node = queue.remove();
            System.out.print(node.data + ", ");
            for(Node child : node.childeren){
                queue.add(child);
            }
        }
        System.out.println(".");

    }

    private static void levelOrderLineWiseTraversal(Node root) {

        /**
         * Use two queue, first queue add the element
         * add all child to child queue
         * do this till both child queue and queue is empty
         */
        Queue<Node> queue = new ArrayDeque<>();
        Queue<Node> childQueue = new ArrayDeque<>();

        queue.add(root);

        while(queue.size()>0 || childQueue.size()>0){
            while(queue.size()>0){
                Node node = queue.remove();
                System.out.print(node.data + ", ");
                for(Node child : node.childeren){
                    childQueue.add(child);
                }
            }
            System.out.println(); // one level is over
            while(childQueue.size()>0){
                Node node = childQueue.remove();
                System.out.print(node.data + ", ");
                for(Node child : node.childeren){
                    queue.add(child);
                }
            } // child level is over
            System.out.println();
        }
    }


    private static int height(Node root) {
        // Logic : get max of all height of the child and add 1 to it and return the value to parent.
        int height=-1;
        for(Node child : root.childeren){
            int childHeight = height(child);
            height = Math.max(height,childHeight);
        }
        return height +1;
    }

    /** Traversal in tree
     * Preorder :
     *      Euler path nodes left
     *      Before going deep into the recursion
     *      Visit nodes before childere N > c
     * PostOrder :
     *      Euler path nodes right side
     *      After returning from the recursion
     *      Visit nodes after childere c > c
     */

    public static void traversal(Node node){

        // Pre area Euler's left while going into recursion
        System.out.println("Node pre "+ node.data); // euler left
        for(Node child : node.childeren){
            System.out.println("Edge pre "+ node.data + " -- " + child.data);
            traversal(child);
            System.out.println("Edge post "+ node.data + " -- " + child.data);
        }
        // Post area Euler's left while comint out of recursion
        System.out.println("Node post "+ node.data); // euler rith

    }
}
