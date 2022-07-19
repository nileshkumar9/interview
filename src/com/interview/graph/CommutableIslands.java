package com.interview.graph;

import com.interview.graph.bfs.CycleInUndirectedGraph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class CommutableIslands {

    /**
     *
     * There are A islands and there are M bridges connecting them. Each bridge has some cost attached to it.
     *
     * We need to find bridges with minimal cost such that all islands are connected.
     *
     * It is guaranteed that input data will contain at least one possible scenario in which all islands are connected with each other.
     *
     * Input Format:
     *
     * The first argument contains an integer, A, representing the number of islands.
     * The second argument contains an 2-d integer matrix, B, of size M x 3:
     *     => Island B[i][0] and B[i][1] are connected using a bridge of cost B[i][2].
     * Output Format:
     *
     * Return an integer representing the minimal cost required.
     * Constraints:
     *
     * 1 <= A, M <= 6e4
     * 1 <= B[i][0], B[i][1] <= A
     * 1 <= B[i][2] <= 1e3
     * Examples:
     *
     * Input 1:
     *     A = 4
     *     B = [   [1, 2, 1]
     *             [2, 3, 4]
     *             [1, 4, 3]
     *             [4, 3, 2]
     *             [1, 3, 10]  ]
     *
     * Output 1:
     *     6
     *
     * Explanation 1:
     *     We can choose bridges (1, 2, 1), (1, 4, 3) and (4, 3, 2), where the total cost incurred will be (1 + 3 + 2) = 6.
     *
     * Input 2:
     *     A = 4

     *     B = [   [1, 2, 1]
     *             [2, 3, 2]
     *             [3, 4, 4]
     *             [1, 4, 3]   ]
     *
     * Output 2:
     *     6
     *
     * Explanation 2:
     *     We can choose bridges (1, 2, 1), (2, 3, 2) and (1, 4, 3), where
     *     the total cost incurred will be (1 + 2 + 3) = 6.
     *      Note:You only need to implement the given function.
     *      Do not read input, instead use the arguments to the function.
     *      Do not print the output, instead return values as specified.
     *      Still have a question? Checkout Sample Codes for more details.
     *
     * Logic :
     *      We will maintain a priority queue where the value in priority queue
     *      where we will always get the smalled in the queue.
     *      We will do BFS and will get all the value
     *
     *      We will keep on marking the visisted array.
     *
     *      https://www.youtube.com/watch?v=Vw-sktU1zmc
     *
     *      Prims algorithms
     *
     *
     *
     */
    public class Pair implements Comparable<Pair>{
        int vertex;
        int acquiringVertex;
        int weight;

        public Pair(int vertex, int acquiringVertex, int weight) {
            this.vertex = vertex;
            this.acquiringVertex = acquiringVertex; // edge throught which we came.
            this.weight = weight;
        }

        @Override
        public int compareTo(Pair o) {
            return this.weight - o.weight ;
        }
    }
    class Edge{
        int source;
        int neighbor;
        int weight;

        public Edge(int source, int neighbor, int weight) {
            this.source = source;
            this.neighbor = neighbor;
            this.weight = weight;
        }
    }
    public int solve(int node, ArrayList<ArrayList<Integer>> B) {

        // build adjacency list first from the given input
        ArrayList<Edge>[] graph = createAdjacencyList(node,B);

        // we will create a priority queue
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0,-1,0)); // adding root elment here
        boolean[] visited = new boolean[node];
        int minimumCost = 0;

        // BFS
        while(pq.size()>0){

            // remove mark* work add*
            Pair current = pq.remove();
            if(visited[current.vertex] == true){
                continue; // if visited do nothing
            }
            // mark * , mark this as visited
            visited[current.vertex] = true;

            // work : Add to the path cost

            minimumCost = minimumCost+current.weight;

            // add its neighbor
            for(Edge child:graph[current.vertex]){
                // add child of this vertex
                if(visited[child.neighbor] == false){
                    // here adding the vertex from where we are getting the connections.
                    // not required for this problem, but if we have to pring the path
                    // instead of minimum cost of the path , this will be useful.

                    pq.add(new Pair(child.neighbor, current.acquiringVertex,child.weight));
                }
            }

        }
        return minimumCost;


    }
    private ArrayList<Edge>[] createAdjacencyList(int node, ArrayList<ArrayList<Integer>> edges) {
        ArrayList<Edge>[] graph = new ArrayList[node];
        for (int i = 0; i < node; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        for (int i = 0; i < edges.size(); i++) {
            int source = edges.get(i).get(0) -1;
            int neighbor = edges.get(i).get(1)-1;
            int weight = edges.get(i).get(2);
            // Node that its zero based index, so we have made 0 based graph
            graph[source].add(new Edge(source, neighbor,weight));
            graph[neighbor].add(new Edge(neighbor, source, weight));
        }
        return graph;
    }

}
