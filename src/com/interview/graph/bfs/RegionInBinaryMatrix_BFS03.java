package com.interview.graph.bfs;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 *
 * Logic :
 *   visit each cell in the matrix,
 *   For each cell value do a BFS or DFS. This solution is using BFS
 *   We will mark each cell as visited and will move in all 8 direction. If all these
 *   cell is having value as 1, we will keep pushing into the queue as its a connected component.
 *   We are fliping the visisted cell value to 0, marking it as visisted. Instead we could have used
 *   visited 2d matrix if we don't want to change the matrix.
 *   Once visited we will terminate.
 *
 */
public class RegionInBinaryMatrix_BFS03 {
    int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public int regionInBinaryMatrix(int[][] A) {
        int answer = 0;

        // Traverse for each of the matrix cell
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                // do BFS for each of the cell
                if (A[i][j] == 1) {
                    int tempAnswer = doBFSTraversal(A, i, j);
                    answer = Math.max(tempAnswer, answer);
                }
            }
        }

        return answer;

    }

    class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private int doBFSTraversal(int[][] matrix, int row, int column) {
        // Add this element as the fist element into the queue
        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(row, column));
        matrix[row][column] = 0;
        int count = 1;
        // we will not use a new visited matrix,
        // instead we will flip the value to zero making it as visited as
        // this will not be considered in next iteration.

        while (!queue.isEmpty()) {
            // remove mark* work add*
            Pair currentValue = queue.remove();
            // cordinates
            int currentRow = currentValue.x;
            int currentColumn = currentValue.y;

            // Now we have to go in eight directions
            for (int i = 0; i < 8; i++) {
                int newX = dx[i] + currentRow;
                int newY = dy[i] + currentColumn;

                // check the boundray condition
                if (newX >= 0 && newX < matrix.length &&
                    newY >= 0 && newY < matrix[0].length
                    && matrix[newX][newY] == 1) {
                    // increase the count
                    count++;
                    // Add to the queue
                    queue.add(new Pair(newX, newY));
                    matrix[newX][newY] = 0; //Marking it as visited/processed
                }
            }
        }
        // At this point, for given cell value, it has processed its all 8 directions
        // for all its child.
        return count;
    }
}

