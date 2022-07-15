package com.interview.graph.pathTraversal;

import java.util.ArrayList;

public class PathInDirectedGraph_01 {
    /**
     * Problem Description
     *
     * Given an directed graph having A nodes labelled from 1 to A containing M edges given by matrix B of size M x 2such that there is a edge directed from node
     *
     * B[i][0] to node B[i][1].
     *
     * Find whether a path exists from node 1 to node A.
     *
     * Return 1 if path exists else return 0.
     *
     * NOTE:
     *
     * There are no self-loops in the graph.
     * There are no multiple edges between two nodes.
     * The graph may or may not be connected.
     * Nodes are numbered from 1 to A.
     * Your solution will run on multiple test cases. If you are using global variables make sure to clear them.
     *
     *
     * Problem Constraints
     * 2 <= A <= 105
     *
     * 1 <= M <= min(200000,A(A-1))
     *
     * 1 <= B[i][0], B[i][1] <= A
     *
     *
     *
     * Input Format
     * The first argument given is an integer A representing the number of nodes in the graph.
     *
     * The second argument given a matrix B of size M x 2 which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].
     *
     *
     *
     * Output Format
     * Return 1 if path exists between node 1 to node A else return 0.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     *  A = 5
     *  B = [  [1, 2]
     *         [4, 1]
     *         [2, 4]
     *         [3, 4]
     *         [5, 2]
     *         [1, 3] ]
     * Input 2:
     *
     *  A = 5
     *  B = [  [1, 2]
     *         [2, 3]
     *         [3, 4]
     *         [4, 5] ]
     *
     *
     * Example Output
     * Output 1:
     *
     *  0
     * Output 2:
     *
     *  1
     *
     *
     * Example Explanation*
     * Explanation 1:
     *
     *  The given doens't contain any path from node 1 to node 5 so we will return 0.
     * Explanation 2:
     *
     *  Path from node1 to node 5 is ( 1 -> 2 -> 3 -> 4 -> 5 ) so we will return 1.
     *
     *
     *
     */
    class Edge{
        int source;
        int neighbour;
        int weight;
        Edge(int source, int neighbour, int weight){
            this.source = source;
            this.neighbour = neighbour;
            this.weight = weight;
        }
    }
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        // 1) created a adjecency list, which is a form of represensing a graph
        // Adjency list is an array of arraylist of edges.
        ArrayList<Edge>[] graph = new ArrayList[A+1]; // A+1 as its 1 based indexing

        for(int i=1; i<=A; i++){
            graph[i] = new ArrayList<>();// fill an empty edge
        }
        // Now loop throught the list of Edges and then fill in adjecency list
        for(int i=1 ; i<= B.size();i++){
            ArrayList<Integer > edges = B.get(i-1);
            int source = edges.get(0); // -1 to make it zero based index
            int neighbour = edges.get(1); // -1 to make it zero based index
            // since its a directed graph
            graph[source].add(new Edge(source,neighbour,0)); // array of graph is one based
            // if it was not a directed draph we would have to  give
            // graph[neighbour].add(new Edge(neighbour, source,0));
        }

        boolean[] visited = new boolean[A+1]; // equal to vertices, its one based indexing hence a+1
        // in general case if graph vertices is starting with 0 it should be A and not A+1;
        int ans = hasPath(graph, 1,A, visited);




        return ans;
    }

    private int hasPath(ArrayList<Edge>[] graph, int source, int destination, boolean[] visited) {
        // find path between source and destination.
        if (source == destination){
            // found the path
            return 1;
        }
        // Now loop recoursively to check if your neighours have a path to node.
        // if neighbours have the path then you also have the path to the node
        visited[source] = true; // mark the source as visisted
        for(Edge edge : graph[source]){
            if(visited[edge.neighbour] == false){
                int hasNeighborPathToDestination = hasPath(graph, edge.neighbour, destination, visited);
                if(hasNeighborPathToDestination ==1){
                    return 1;
                }
            }
        }
        return 0; // doesn't have the path
    }

    public static void main(String[] args) {
        int A = 5;
        ArrayList<ArrayList<Integer>> B  = new ArrayList<>();
        ArrayList<Integer> edges1 = new ArrayList<>();
        edges1.add(1);
        edges1.add(2);

        ArrayList<Integer> edges2 = new ArrayList<>();
        edges2.add(4);
        edges2.add(1);
        ArrayList<Integer> edges3 = new ArrayList<>();
        edges3.add(2);
        edges3.add(4);
        ArrayList<Integer> edges4 = new ArrayList<>();
        edges4.add(3);
        edges4.add(4);
        ArrayList<Integer> edges5 = new ArrayList<>();
        edges5.add(5);
        edges5.add(2);
        ArrayList<Integer> edges6 = new ArrayList<>();
        edges6.add(1);
        edges6.add(3);

        B.add(edges1);
        B.add(edges2);
        B.add(edges3);
        B.add(edges4);
        B.add(edges5);
        B.add(edges6);
        PathInDirectedGraph_01 obj = new PathInDirectedGraph_01();

        int ans = obj.solve(A,B);
        System.out.println("Has path " + ans);




    }
}