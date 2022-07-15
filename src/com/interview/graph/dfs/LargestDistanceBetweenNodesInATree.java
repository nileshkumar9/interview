package com.interview.graph.dfs;

import java.util.ArrayList;

public class LargestDistanceBetweenNodesInATree {
    /**
     * Problem Description
     * <p>
     * Given an arbitrary unweighted rooted tree which consists of N nodes.
     * <p>
     * The goal of the problem is to find largest distance between two nodes in a tree.
     * <p>
     * Distance between two nodes is a number of edges on a path between the nodes (there will be a unique path between any pair of nodes since it is a tree).
     * <p>
     * The nodes will be numbered 0 through N - 1.
     * <p>
     * The tree is given as an array A, there is an edge between nodes A[i] and i (0 <= i < N). Exactly one of the i's will have A[i] equal to -1, it will be root node.
     * <p>
     * <p>
     * <p>
     * Problem Constraints
     * 1 <= N <= 40000
     * <p>
     * <p>
     * <p>
     * Input Format
     * First and only argument is an integer array A of size N.
     * <p>
     * <p>
     * <p>
     * Output Format
     * Return a single integer denoting the largest distance between two nodes in a tree.
     * <p>
     * <p>
     * <p>
     * Example Input
     * Input 1:
     * <p>
     * A = [-1, 0, 0, 0, 3]
     * <p>
     * <p>
     * Example Output
     * Output 1:
     * <p>
     * 3
     * <p>
     * <p>
     * Example Explanation
     * Explanation 1:
     * <p>
     * node 0 is the root and the whole tree looks like this:
     * 0
     * /  |  \
     * 1   2   3
     * \
     * 4
     * <p>
     * One of the longest path is 1 -> 0 -> 3 -> 4 and its length is 3, thus the answer is 3.
     * <p>
     * Logic : Calculate the left height and right height +2 , for each child and find the max of it.
     * We will check keeping each node as the root and will see if we are getting the maximum value.
     */

    class Edge {
        int source;
        int destination;

        Edge(int source, int destination) {
            this.source = source;
            this.destination = destination;
        }
    }

    public int solve(ArrayList<Integer> parentIndex) {
        // Here since the array is give that forms the graph, we will form the adjacency list for this
        // undirected graph.

        int node = parentIndex.size();
        if (node <= 1) {
            return 0;
        }

        ArrayList<Edge>[] graph = new ArrayList[node];
        for (int i = 0; i < node; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        int root = -1;
        for (int i = 0; i < node; i++) {
            if (parentIndex.get(i) == -1) {
                // int questiosn its give that that if the value is -1 it is a root node
                root = i; // this index will be the root node value
                continue;
            }
            graph[i].add(new Edge(i, parentIndex.get(i)));
            graph[parentIndex.get(i)].add(new Edge(parentIndex.get(i), i));
        }
        if (root == -1) {
            return 0; // no root given in question
        }

        diameter = 0;
        boolean[] visited = new boolean[node + 1];
        calculateDiameterReturnHeight(root, graph, visited);
        System.out.println(diameter);
        return diameter;

    }

    static int diameter;

    private static int calculateDiameterReturnHeight(int root, ArrayList<Edge>[] graph, boolean[] visited) {
        /**
         * Calculate deepestChild and secondDeepest child of each element.
         * Find if the diameter is greater than previous diameter replace it
         * We will calculate the height of the tree and will keep updating the diameter of the tree.
         *
         */
        int deepestHeight = 0; // this wil be for height
        int secondDeepestHeight = 0; // this will be second heighest height
        visited[root] = true;
        int childCount = 0 ;
        for (Edge child : graph[root]) {
            if (visited[child.destination] == false) {
                childCount++ ;
                int childHeight = calculateDiameterReturnHeight(child.destination, graph, visited);
                if (deepestHeight < childHeight) {
                    // Since child height is greater then current height, that will become the height
                    // HEight is the maximum value of height at given point
                    // We will update the value with deepest and second deepest
                    secondDeepestHeight = deepestHeight;
                    deepestHeight = childHeight; // this will become new deepest height

                } else if (childHeight > secondDeepestHeight) {
                    secondDeepestHeight = childHeight;
                }
            }
        }

        visited[root] = false;

        int tempAns = deepestHeight + secondDeepestHeight;
        // if the child of this node is >= 2 then only the edge will be two
        // int childCount = graph[root].size()
        if(childCount >= 2 ) {
            tempAns = tempAns+2;
        }
        else if (childCount ==1){
            tempAns = tempAns+1; // its will be having only one child node
        }

        diameter = Math.max(tempAns,diameter);

        if(childCount>0) {
            deepestHeight++;
        } else  return 0;

        return deepestHeight;
    }

    public static void main(String[] args) {
        //[ -1, 0 ]

        LargestDistanceBetweenNodesInATree obj = new LargestDistanceBetweenNodesInATree();
        ArrayList<Integer> input = new ArrayList<>();
        input.add(-1);
        input.add(0);
       // input.add(0);
       // input.add(0);
       // input.add(3);
        obj.solve(input);

    }
}
