package com.interview.graph.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class CycleInDirectedGraph_BFS {


    class Edge{
        int source;
        int neighbor;
        Edge( int source, int neighbor){
            this.source = source;
            this.neighbor = neighbor;
        }
    }

    /**
     * https://www.youtube.com/watch?v=6zVWOfwT0Dw
     *  kahn's algorithms
     *  Works for topological sorts as well.
     *  We will maintain the indegreee when the Adjacency List is working on
     *  This is also know and kahn algorithm of BFS
     *
     */
    public int solve(int node, ArrayList<ArrayList<Integer>> edges) {

        // First create a adjacency list for graph

        int[] indegree = new int[node];

        ArrayList<Edge>[] graph = createAdjacencyList(node, edges, indegree);

        // now to detecte the cycle, we will do do bfs
        // if we get any element that has already been visisted, that means,
        // we somehow reached here from one path and hence this will be a cycle.
        // for not connected component of graph, we will do loop on all vertices
        boolean[] visited = new boolean[node];
        // Extra one is required.

        ArrayDeque<Pair> queue = new ArrayDeque<>();

        int count =0;
        for(int i=0; i<node; i++){
            if(indegree[i] ==0){
                // this is the nodes that can be processed
                // without any dependencies
                queue.push(new Pair(i,""+i));
                // mark as visisted
                visited[i] = true;
                count++; // if at the end of this, count and number of nodes are not matching we are having
                // unprocessed nodes, so we will have cycle in it and we will break

            }
        }
        // remove mark * work add*

        while (!queue.isEmpty()){
            // remove
            Pair current = queue.removeFirst();

            // process all the child of graph
            for(Edge edge : graph[current.vertex]){
                //if (extra[edge.neighbor] == true) return 1;
                if(visited[edge.neighbor] == false){
                    // add all child to the queue for next level
                    // only add unvisited neighbor.
                    // decrease dependency of indegreee
                    indegree[edge.neighbor] = indegree[edge.neighbor]-1;
                    // Add this node to the queue only if it has no dependencyies left
                    // in which case the indegreee will be 0
                    if(indegree[edge.neighbor] ==0){
                        visited[edge.neighbor]=true;
                        queue.add(new Pair(edge.neighbor, current.pathSoFar+edge.neighbor));
                        count++;
                    }
                }
            }
        }

        //System.out.println(count);
        //System.out.println(node);
        if(count == node) {
            return 0;
        }
        return 1;
    }


    class Pair{
        int vertex;
        String pathSoFar;
        Pair(int vertex, String pathSoFar){
            this.vertex = vertex;
            this.pathSoFar = pathSoFar;
        }
    }


    /**
     * this will create a graph, if we have number of nodes, and a arraylist of edges.
     * of m*2 dimension
     *
     * @param node
     * @param edges
     */
    private ArrayList<Edge>[] createAdjacencyList(int node, ArrayList<ArrayList<Integer>> edges, int[] indegree) {
        ArrayList<Edge>[] graph = new ArrayList[node];
        for (int i = 0; i < node; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        for (int i = 0; i < edges.size(); i++) {
            int source = edges.get(i).get(0) -1;
            int neighbor = edges.get(i).get(1)-1;
            // Node that its zero based index, so we have made 0 based graph

            graph[source].add(new Edge(source, neighbor));
            // for directed graph it should be source to destination only
            //graph[neighbor].add(new Edge(neighbor, source));
            indegree[neighbor]++;
        }
        return graph;
    }

}
