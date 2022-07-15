package com.interview.graph.shortestPath;

import java.util.ArrayDeque;
import java.util.Queue;

public class KnightOnChessBoard {
    // we can move in eight direction
    int dx[] = {2, 1, -1, -2, 2, 1, -1, -2};
    int dy[] = {1, 2, 2, 1, -1, -2, -2, -1};

    public int knight(int A, int B, int C, int D, int E, int F) {
        return doBFS(A, B, C, D, E, F);


    }

    class Pair {
        int x;
        int y;
        int distance;

        Pair(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    private int doBFS(int chessX, int chessY, int startX, int startY, int endX, int endY) {
        // Create a two d array for visited.
        boolean[][] visited = new boolean[chessX][chessY];

        Queue<Pair> queue = new ArrayDeque();
        Pair start = new Pair(startX - 1, startY - 1, 0);
        queue.add(start);
        visited[start.x][start.y] = true;
        while (!queue.isEmpty()) {
            // remove mark* work end *
            Pair current = queue.remove();
            // Check if this is the target destinaton
            if (current.x == endX - 1 && current.y == endY - 1) {
                return current.distance; // this is at target postions already.
            }

            // checking for each 8 position
            for (int i = 0; i < 8; i++) {
                int newX = current.x + dx[i];
                int newY = current.y + dy[i];
                // boundrary conditions
                if (newX >= 0 && newX< chessX &&
                    newY >= 0 && newY < chessY && !visited[newX][newY]) { // not visited
                    // visit it first
                    visited[newX][newY] = true;
                    queue.add(new Pair(newX, newY, current.distance + 1));


                }
            }

        }

        return -1;
    }

    public static void main(String[] args) {
        KnightOnChessBoard knightObj = new KnightOnChessBoard();


        System.out.println(knightObj.knight(8, 8, 1, 1, 8, 8));
    }
}
