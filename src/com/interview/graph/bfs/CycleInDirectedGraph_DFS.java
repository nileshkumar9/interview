package com.interview.graph.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class CycleInDirectedGraph_DFS {
    /**
     * Appraoch :
     * With DFS its easy, just have extra visited array, and if its true,
     * it means we have visisted this from somewhere.
     */

    class Edge{
        int source;
        int neighbor;
        Edge( int source, int neighbor){
            this.source = source;
            this.neighbor = neighbor;
        }
    }
    public int solve(int node, ArrayList<ArrayList<Integer>> edges) {

        // First create a adjacency list for graph

        ArrayList<Edge>[] graph = createAdjacencyList(node, edges);

        // now to detecte the cycle, we will do do bfs
        // if we get any element that has already been visisted, that means,
        // we somehow reached here from one path and hence this will be a cycle.
        // for not connected component of graph, we will do loop on all vertices
        boolean[] visited = new boolean[node];
        // Extra one is required.
        boolean[] extra = new boolean[node];
        for(int i=0; i<node; i++){
            if(visited[i] == false){
                // process only unvisited graph
                int result = doDFSToDetectCycle(graph, i, visited,extra);
                if(result ==1){
                    return 1;// cycle found
                }
            }
        }
        return 0; // no cycle found

    }
    class Pair{
        int vertex;
        String pathSoFar;
        Pair(int vertex, String pathSoFar){
            this.vertex = vertex;
            this.pathSoFar = pathSoFar;
        }
    }

    private int doDFSToDetectCycle(ArrayList<Edge>[] graph, int source, boolean[] visited, boolean[] extra) {

        // process all the child of graph
        for(Edge edge : graph[source]){
            if (extra[edge.neighbor] == true) {
                return 1; // catched the cycle
            } else if(visited[edge.neighbor] == false){
                visited[edge.neighbor] = true;
                // it is important to get
                extra[edge.neighbor] = true;
                // add all child to the queue for next level
                // only add unvisited neighbor.
                int ans =  doDFSToDetectCycle(graph, edge.neighbor, visited,extra);
                if(ans ==1){
                    return  1;

                }
            }

        }
        extra[source] = false;

        return 0;

    }

    /**
     * this will create a graph, if we have number of nodes, and a arraylist of edges.
     * of m*2 dimension
     *
     * @param node
     * @param edges
     */
    private ArrayList<Edge>[] createAdjacencyList(int node, ArrayList<ArrayList<Integer>> edges) {
        ArrayList<Edge>[] graph = new ArrayList[node];
        for (int i = 0; i < node; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        for (int i = 0; i < edges.size(); i++) {
            int source = edges.get(i).get(0) -1;
            int neighbor = edges.get(i).get(1)-1;
            // Node that its zero based index, so we have made 0 based graph

            graph[source].add(new Edge(source,  neighbor));
            // graph[neighbor].add(new Edge(neighbor, source));
        }
        return graph;
    }


}
