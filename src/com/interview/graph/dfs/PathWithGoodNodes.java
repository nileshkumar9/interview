package com.interview.graph.dfs;

import java.util.ArrayList;

public class PathWithGoodNodes {
    /**
     * https://www.youtube.com/watch?v=VjeeyLctD2s&t=3s
     * https://www.interviewbit.com/problems/path-with-good-nodes/
     * <p>
     * // Logic : We will keep on incremented the goodNodeCount for each child, and once we reach
     * the leaf we will see if its withing the maxGoodNode limit
     */
    class Edge {
        int source;
        int neighbour;

        Edge(int source, int neighbour) {
            this.source = source;
            this.neighbour = neighbour;
        }

    }

    public int solve(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> edges, int maxGoodNodes) {
        Integer ans = new Integer(0);

        int numberofVertices = A.size();
        // Now make a adjecency list
        // its an undirected graph
        ArrayList<Edge>[] graph = new ArrayList[numberofVertices];
        // Against each vertices initialize an arraylist of edges

        for (int i = 0 ; i < numberofVertices; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        // Now we will prepare the adjacency list
        // We will read all the edges from input
        for (int i = 0; i < edges.size(); i++) {
            int source = edges.get(i).get(0);
            int neighbour = edges.get(i).get(1);
            graph[source].add(new Edge(source, neighbour));
            graph[neighbour].add(new Edge(neighbour, source));
        }
        // Now we have created a graph

        // Step 2: We will do dfs
        // Initial source is given 1, and parent we are assuming it to be -1 for root node.
        ans = dfs_CalculateGoodNodes(1, -1, A, graph, maxGoodNodes, ans, 0);
        return ans;
    }

    private int dfs_CalculateGoodNodes(int source, int parent, ArrayList<Integer> typeOfNodes,
                                       ArrayList<Edge>[] graph, int maxGoodNodes, int ans, int goodNodes) {
        // we will compare from the array of good node
        if(typeOfNodes.get(source-1)==1) goodNodes++;

        if(goodNodes > maxGoodNodes) return 0;

        int countOfChild =0;
        //Process each child of this source
        for(Edge edge : graph[source]){
            if(edge.source !=parent){
                countOfChild++; // we will increase the child cound as this is not the leaf node.
                // call dfs only for child
                dfs_CalculateGoodNodes(edge.source, source, typeOfNodes, graph, maxGoodNodes, ans, goodNodes);
            }
        }
        // if its a leaf node and we have not returned from this function yet.
        // this means this is a good node
        if(countOfChild ==0){
            ans++;
        }

        return ans;


    }


}
