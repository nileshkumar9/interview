package com.interview.graph.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;

public class CloneGraph {
    /**
     * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
     * <p>
     * Note: The test cases are generated in the following format (use the following format to use See Expected Output option):
     * <p>
     * First integer N is the number of nodes.
     * <p>
     * Then, N intgers follow denoting the label (or hash) of the N nodes.
     * <p>
     * Then, N2 integers following denoting the adjacency matrix of a graph, where Adj[i][j] = 1 denotes presence of an undirected edge between the ith and jth node, O otherwise.
     * <p>
     * <p>
     * <p>
     * Problem Constraints
     * 1 <= Number of nodes <= 105
     * <p>
     * <p>
     * <p>
     * Input Format
     * First and only argument is a node A denoting the root of the undirected graph.
     * <p>
     * <p>
     * <p>
     * Output Format
     * Return the node denoting the root of the new clone graph.
     * <p>
     * <p>
     * <p>
     * Example Input
     * Input 1:
     * <p>
     * 1
     * / | \
     * 3  2  4
     * / \
     * 5   6
     * Input 2:
     * <p>
     * 1
     * / \
     * 3   4
     * /   /|\
     * 2   5 7 6
     * <p>
     * <p>
     * Example Output
     * Output 1:
     * <p>
     * Output will the same graph but with new pointers:
     * 1
     * / | \
     * 3  2  4
     * / \
     * 5   6
     * Output 2:
     * <p>
     * 1
     * / \
     * 3   4
     * /   /|\
     * 2   5 7 6
     * <p>
     * <p>
     * Example Explanation
     * Explanation 1:
     * <p>
     * We need to return the same graph, but the pointers to the node should be different.
     * <p>
     * Logic :
     * Lets use BFS:
     * We will createa n new reference.
     * We will maintain a hashmap of Visited list, because normal boolean array is only on
     * value, and if we mark them visisted it will not work
     * We will visit the node from queue, create a new node, and keep it.
     * When we visit its neighbour, we again create a new node, and then update the
     * reference if its a neigbhor of any node.
     */


    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null){
            return null;
        }
        // We will do it using BFS,
        Queue<UndirectedGraphNode> queue = new ArrayDeque<>();
        // this will act as a visited array where older and new mapping will
        // be maintained
        HashMap<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap<>();

        // Adding first element into the node
        queue.add(node);
        // add it to the map
        map.put(node, new UndirectedGraphNode(node.label));

        while (!queue.isEmpty()){
            // Remove node
            UndirectedGraphNode current = queue.remove();

            // traverse all the child of this element
            for(UndirectedGraphNode neighbor : current.neighbors){
                // put this neighbor in the map if it doesn't exists
                if(!map.containsKey(neighbor)){
                    // add it to the map and create a correspoding cloned one
                    UndirectedGraphNode clonedNeighbor = new UndirectedGraphNode(neighbor.label);
                    map.put(neighbor,clonedNeighbor);
                    // Add this into the queue
                    queue.add(neighbor);
                }
                // get the parent and update the reference with the cloned reference of neighbor
                UndirectedGraphNode parentCloned = map.get(current);
                parentCloned.neighbors.add(map.get(neighbor));

            }

        }
        return  map.get(node);
    }

    class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<>();
        }
    }

    ;

}
