package com.interview.graph.pathTraversal;

import java.util.ArrayList;

public class WordSearchBoard {
    public int exist(ArrayList<String> a, String b) {
        int row = a.size();
        if (row == 0) return 0;
        int column = a.get(0).length();
        if (column == 0) return 0;

        if (b.length() == 0) return 1;
        boolean[][] visited = new boolean[row][column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if ((a.get(i).charAt(j) == b.charAt(0)) && do_dfs(a, b, i, j, 0, visited)) {
                    return 1;
                }
            }
        }

        return 0;
    }

    public boolean do_dfs(ArrayList<String> matrix, String stringToMatch, int i, int j,
                          int index, boolean[][] visited) {
        if (index == stringToMatch.length()) return true;
        int row = matrix.size();
        int column = matrix.get(0).length();

        // boundary conditions
        if (i < 0 || i >= row || j < 0 || j >= column) return false;

        //if (visited[i][j] == true || a.get(i).charAt(j) != b.charAt(len)) return false;
        if (matrix.get(i).charAt(j) != stringToMatch.charAt(index)) return false;

        visited[i][j] = true;
        if (do_dfs(matrix, stringToMatch, i+1, j, index+1, visited) ||
            do_dfs(matrix, stringToMatch, i-1, j, index+1, visited) ||
            do_dfs(matrix, stringToMatch, i, j+1, index+1, visited) ||
            do_dfs(matrix, stringToMatch, i, j-1, index+1, visited)) return true;
        visited[i][j] = false;

        return false;
    }

    public static void main(String[] args) {
        ArrayList<String> input = new ArrayList<>();
        input.add( "AAAAA");
        input.add(  "AAAAA");
        input.add(  "AAAAA");
        input.add(   "AAAAA");
        input.add(   "AAAAA");
        String B = "AAFBAAA";
        WordSearchBoard obj = new WordSearchBoard();
        System.out.println(obj.exist(input,B));
    }
}
