package com.interview.graph.pathTraversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class CaptureRegionsOnBoard {
    /**
     * roblem Description
     *
     * Given a 2D character matrix A of size N x M, containing 'X' and 'O', capture all regions surrounded by 'X'.
     *
     * A region is captured by flipping all 'O's into 'X's in that surrounded region.
     *
     *
     *
     * Problem Constraints
     * 1 <= N, M <= 103
     *
     *
     *
     * Input Format
     * First and only argument 2D character matrix A of size N X M.
     *
     *
     *
     * Output Format
     * Make changes to the the input only as matrix is passed by reference.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     *  A = [  [X, X, X, X],
     *         [X, O, O, X],
     *         [X, X, O, X],
     *         [X, O, X, X]
     *      ]
     *
     *
     * Example Output
     * Output 1:
     *
     *  A = [  [X, X, X, X],
     *         [X, X, X, X],
     *         [X, X, X, X],
     *         [X, O, X, X]
     *      ]
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     *  'O' in (4,2) is not surrounded by X from below.
     *
     *  Logic :
     *     In the matrix, all nodes lying on outer shell will not be converted or captured
     *     as it will always be having un-surrounded region.
     *     Add all zeroes of outer shell in a queue.
     *     Convert all these and its adjacent element with something else saye ^;
     *
     *     Once done, we will only be left with those zeroes which are actually surrounded.
     *     Now we will traverse from start of the matrix and then we will flip al ^ to zeroes to revert actual matrix.
     *     And all zeroes, into X.
     *
     */
    class Pair{
        int x; int y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public void solve(ArrayList<ArrayList<Character>> matrix) {
        int row = matrix.size();
        Queue<Pair> queue = new ArrayDeque<>();

        // for there is no rows exit
        if(row == 0) return;

        int column = matrix.get(0).size();

        // 1.) get all the boundary cells that are zeroes
        for(int i=0; i< row ; i++){
            for(int j=0; j<column ; j++){
                // if it's outer shell
                if(i==0 || j==0 || i==row-1 || j== column-1){
                    // outer shell
                    if(matrix.get(i).get(j) =='O'){
                        // convert to some dummy characters
                        // for each of this we will have to check if they have 0 as adjacent
                        // can be done with dfs as well, create a functions to check zeros flip them to dummy
                        // we are doign by bfs so we are adding it into queue
                        queue.add(new Pair(i,j));
                        matrix.get(i).set(j , '^');

                    }
                }
            }
        }

        // 2: Queue is ready so lets do BFS and we will visit all child

        // all four directions
        int dx[] = {1,-1,0,0};
        int dy[] = {0,0,-1,1};
        // its a multisource bfs
        while(!queue.isEmpty()){
            // remove mark* work add*
            Pair current = queue.remove();

            for(int i=0;i<4;i++){
                int newX = current.x + dx[i];
                int newY = current.y + dy[i];

                // work if neighbour is 0 flip it to dummy characters
                if(newX>=0 && newX< row &&
                   newY>=0 && newY< column && matrix.get(newX).get(newY) == 'O'){
                    // add to the queue
                    queue.add(new Pair(newX, newY));
                    matrix.get(newX).set(newY , '^');
                }
            }
        }

        // 3. Once bfs is done, we ahve matrix with only true 0 in matrix, that is surrounded by x
        // So traverse from begining and we will flip the dummy to 0 and 0 to X
        for(int i=0; i<row ; i++ ){
            for(int j=0; j<column; j++){
                if(matrix.get(i).get(j) == 'O'){
                    matrix.get(i).set(j , 'X');
                }
                if(matrix.get(i).get(j) == '^'){
                    matrix.get(i).set(j , 'O');
                }
            }
        }
    }
}
