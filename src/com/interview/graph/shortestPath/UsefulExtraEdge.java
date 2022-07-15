package com.interview.graph.shortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://www.interviewbit.com/problems/useful-extra-edges/hints/
 *
 * Problem Description
 * <p>
 * <p>
 * <p>
 * Given a graph of A nodes. Also given the weighted edges in the form of array B.
 * <p>
 * You are also given starting point C and destination point D.
 * <p>
 * Also given are some extra edges in the form of vector E.
 * <p>
 * You need to find the length of the shortest path from C to D if you can use maximum one road from the given roads in E.
 * <p>
 * All roads are bidirectional.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= A <= 100000
 * <p>
 * 1 <= |B| <= 100000
 * <p>
 * 1 <= C, D <= A
 * <p>
 * 1 <= |E| <= 300
 * <p>
 * All lengths of the roads lie between 1 and 1000.
 * <p>
 * <p>
 * <p>
 * Input Format
 * First argument is the integer A.
 * <p>
 * Second argument is the vector of vectors B.
 * <p>
 * Third argument is the integer C.
 * <p>
 * Fourth argument is the integer D.
 * <p>
 * Fifth argument is the vector of vectors E.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return -1 if C is not reachable from D. Else return the shortest distance between them.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = 3
 * B = [   [1, 2, 1]
 * [2, 3, 2]
 * ]
 * C = 1
 * D = 3
 * E = [   [1, 3, 2]
 * ]
 * Input 2:
 * <p>
 * A = 4
 * B = [   [1, 2, 1]
 * [2, 3, 2]
 * [3, 1, 4]
 * ]
 * C = 1
 * D = 4
 * E = [   [1, 3, 2]
 * ]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 2
 * Output 2:
 * <p>
 * -1
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * Use the direct edge from 1 to 3. It has shortest path from 1 to 3.
 * Explanation 2:
 * <p>
 * 4 cannot be reached from 1.
 * <p>
 * Logic : To use BFS
 */
public class UsefulExtraEdge {
    static class pair {
        int to, weight;

        pair(int x, int y) {
            to = x;
            weight = y;
        }
    }

    static ArrayList<ArrayList<pair>> gr = new ArrayList<>();

    private int shortestPath(int nodes, int start, int end, int[][] E) {
        int[] distance = new int[nodes];
        int[] parent = new int[nodes];
        boolean[] visited = new boolean[nodes];
        Arrays.fill(distance, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);
        PriorityQueue<pair> p = new PriorityQueue<>(new Comparator<pair>() {
            @Override
            public int compare(pair o1, pair o2) {
                return o1.weight - o2.weight;
            }
        });
        p.add(new pair(start, 0));
        distance[start] = 0;

        while (!p.isEmpty()) {
            int node = p.peek().to;
            int dis = p.peek().weight;
            p.poll();
            if (visited[node]) {
                continue;
            }
            visited[node] = true;
            for (pair child : gr.get(node)) {
                int new_node = child.to;
                int new_distance = child.weight;

                if (!visited[new_node] && dis + new_distance <= distance[new_node]) {
                    distance[new_node] = dis + new_distance;
                    p.add(new pair(new_node, distance[new_node]));
                    parent[new_node] = node;
                }
            }
        }
        if (parent[end] == -1) {
            return -1;
        }
        int total_sum = distance[end];
        int result = Integer.MAX_VALUE;
        for (int[] road : E) {
            int temp = total_sum;
            int from = --road[0];
            int to = --road[1];
            int dist = road[2];
            if (from >= nodes || to >= nodes) {
                continue;
            }
            if (distance[from] == Integer.MAX_VALUE || distance[to] == Integer.MAX_VALUE) {
                continue;
            }
            int old_dist = Math.abs(distance[from] - distance[to]);
            if (old_dist > dist) {
                temp = temp - old_dist + dist;
            }
            result = Math.min(result, temp);
        }
        return result;
    }

    public int solve(int A, int[][] B, int C, int D, int[][] E) {
        gr.clear();
        C = --C;
        D = --D;
        for (int i = 0; i < A; i++) {
            gr.add(new ArrayList<>());
        }
        for (int[] edge : B) {
            int from = edge[0] - 1;
            int to = edge[1] - 1;
            int weight = edge[2];
            gr.get(from).add(new pair(to, weight));
            gr.get(to).add(new pair(from, weight));
        }
        return shortestPath(A, C, D, E);
    }
}

