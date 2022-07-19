package com.interview.graph.dfs;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSortPeepCoding {
    /**
     * There are a total of A courses you have to take, labeled from 1 to A.
     * Some courses may have prerequisites, for example to take course 2 you have to first take course 1, which is expressed as a pair: [1,2].
     * The pairs are given as two arrays B and C, where [B[i], C[i]] form a pair.
     * <p>
     * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
     * Return 1 if it is possible to finish all the courses, or 0 if it is not possible to finish all the courses.
     * <p>
     * <p>
     * Problem Constraints
     * 1 <= A <= 64
     * 1 <= length(B) = length(C) <= 1e5
     * 1 <= B[i], C[i] <= A
     * <p>
     * <p>
     * Input Format
     * The first argument of input contains an integer A, representing the number of courses.
     * The second argument of input contains an integer array, B.
     * The third argument of input contains an integer array, C.
     * <p>
     * <p>
     * Output Format
     * Return a boolean value:
     * 1 : If it is possible to complete all the courses.
     * 0 : If it is not possible to complete all the courses.
     * <p>
     * <p>
     * Example Input
     * Input 1:
     * A = 3
     * B = [1, 2]
     * C = [2, 3]
     * Input 2:
     * <p>
     * A = 2
     * B = [1, 2]
     * C = [2, 1]
     * <p>
     * <p>
     * Example Output
     * Output 1:
     * 1
     * Output 2:
     * <p>
     * 0
     * <p>
     * <p>
     * Example Explanation
     * Explanation 1:
     * It is possible to complete the courses in the following order:
     * 1 -> 2 -> 3
     * Explanation 2:
     * <p>
     * It is not possible to complete all the courses.
     * <p>
     * Logic : This is a variation of Topological sort
     * <p>
     * https://www.youtube.com/watch?v=6Vi5Td_a8B8&list=PL-Jc9J83PIiHfqDcLZMcO9SsUDY4S3a-v&index=17
     * <p>
     * Topological sort answere is always reverse of order of work.
     * // we can directly print the value in post order as well.
     *
     * Reverse the topological sort and this will give the order
     * of compilation, or order of taking the course.
     * We can solve it using DFS, as well as BFS
     * <p>
     * Solvign it here using DFS
     */

    public int solve(int A, ArrayList<Integer> B, ArrayList<Integer> C) {

        // I am building a ArrayList<ArrayList<Integer>>
        // so that my existing code of building graph work wihout any changes

        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();

        for (int i = 0; i < B.size(); i++) {
            ArrayList<Integer> edge = new ArrayList<>();
            edge.add(B.get(i));
            edge.add(C.get(i));
            edges.add(edge);
        }

        ArrayList<Edge>[] graph = createAdjacencyList(A, edges);

        boolean[] visited = new boolean[A]; // number of vertices
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<A; i++){
            if(visited[i] == false){
                // get conncected components
                topologicalSort(graph,i,visited,stack);
            }
        }

        // Now that we have processed all the element in the stack
        // if the stack size is not equal to graph size,
        // this means the vertex that we added in the stac in topological sort
        // is less then the actual course, hence this will be not possible to complete the courses
        while(stack.size()>0){
            // print the stack content.
            // if we have toprint the order of exectuiton of task
            // then we will have to print it in reverse order.
            // Always remember, cyclic graph will not work in case of topoligical sort
            // in that case we will have to use indegreee calculcation as well.
            // refer to cycle in directed graph problem that i have made.
            System.out.println(stack.pop());;

        }



        return 0;

    }

    public void topologicalSort(ArrayList<Edge>[] graph, int src, boolean[] visited, Stack<Integer> stack){

        visited[src] = true;
        for(Edge child : graph[src]){
            if(visited[child.neighbor] == false){
                topologicalSort(graph, child.neighbor, visited,stack);
            }
        }
        // allways push in the post order to get the topological sort
        stack.push(src);
    }


    class Edge {
        int source;
        int neighbor;
        //int weight;

        public Edge(int source, int neighbor) {
            this.source = source;
            this.neighbor = neighbor;
            //this.weight = weight;
        }
    }

    private ArrayList<Edge>[] createAdjacencyList(int node, ArrayList<ArrayList<Integer>> edges) {
        ArrayList<Edge>[] graph = new ArrayList[node];
        for (int i = 0; i < node; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        for (int i = 0; i < edges.size(); i++) {
            int source = edges.get(i).get(0) -1;
            int neighbor = edges.get(i).get(1)-1;
            //int weight = edges.get(i).get(2);
            // Node that its zero based index, so we have made 0 based graph
            graph[source].add(new Edge(source, neighbor));
          //  graph[neighbor].add(new Edge(neighbor, source ));
        }
        return graph;
    }

    public static void main(String[] args) {
            int A = 3;
            ArrayList<Integer> B = new ArrayList<>();

            B.add(1);
            B.add(2);

        B.add(3);

            ArrayList<Integer> c = new ArrayList<>();
            c.add(2);
            c.add(3);
        c.add(1);
            TopologicalSortPeepCoding obj = new TopologicalSortPeepCoding();
            obj.solve(A,B,c);


    }
}
