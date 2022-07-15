package com.interview.graph.shortestPath;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;

/**
 * https://www.interviewbit.com/problems/word-ladder-i/
 * Given two words A and B, and a dictionary, C, find the length of shortest transformation sequence from A to B, such that:
 * <p>
 * You must change exactly one character in every transformation.
 * Each intermediate word must exist in the dictionary.
 * Note:
 * <p>
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * <p>
 * <p>
 * Input Format:
 * <p>
 * The first argument of input contains a string, A.
 * The second argument of input contains a string, B.
 * The third argument of input contains an array of strings, C.
 * Output Format:
 * <p>
 * Return an integer representing the minimum number of steps required to change string A to string B.
 * Constraints:
 * <p>
 * 1 <= length(A), length(B), length(C[i]) <= 25
 * 1 <= length(C) <= 5e3
 * Example :
 * <p>
 * Input 1:
 * A = "hit"
 * B = "cog"
 * C = ["hot", "dot", "dog", "lot", "log"]
 * <p>
 * Output 1:
 * 5
 * <p>
 * Explanation 1:
 * "hit" -> "hot" -> "dot" -> "dog" -> "cog"
 * <p>
 * Logic :
 * this becomes, to reach to end node from given node using minimum jump.
 * All Edge we can assume as of same weight
 * We cannot use DFS, as Dfs are not used to find shortest distance, and its used in tree.
 * This is a graph problem with BFS.
 * <p>
 * Time complexity : length of word = N(for each word we have to do transforamation) *
 * 26 *
 * N (check for every transfromation) *
 * W(number of word in dictionary)
 */
public class WordLadderI {
    public int solve(String A, String B, String[] C) {
        return wordLadder1(A, B, C) + 1; //as the number of transformation will be 1 more then edges

    }

    private int wordLadder1(String startWord, String endWord, String[] dictionary) {
        // 1. put all the dictionary item into a set.
        // Also check if the end word exists in set
        HashSet<String> set = new HashSet<>();
        for (String word : dictionary) {
            set.add(word); // this will remove all duplicates.
        }
        if (!set.contains(endWord)) {
            return 0; // if the end word doesn't exits return
        }

        Queue<String> queue = new ArrayDeque<>();
        queue.add(startWord);

        int levelCount = 0; // to measure the level of queue

        // now do bfs processing

        while (!queue.isEmpty()) {
            // remove mark* work add *
            levelCount++; // increase the level count

            // We have to process for each and every node of the level
            int currentLevelSize = queue.size();
            while (currentLevelSize-- > 0) {
                String currentWord = queue.remove();

                for (int i = 0; i < currentWord.length(); i++) {
                    // for every character of this word we have to do the transformation
                    char[] temp = currentWord.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        // check for all 26 possible replacement of one char.
                        // basically we can only do one trasformation at a time
                        // so for each character we are finding the word from dictionary and adding it to the queue

                        temp[i] = ch; // replacing the ith character of the word with all 26 character one by one.

                        String tempWord = String.valueOf(temp);
                        if (tempWord.equals(currentWord)) {
                            // ignore the current work as it will be one of the 26th transforamtion
                            continue;
                        } else if (tempWord.equals(endWord)) {
                            // we found the word at this level
                            // return the level value
                            return levelCount;
                        } else {
                            // add this transformed word into the queue.
                            // if only this word exists in the dictionary
                            if (set.contains(String.valueOf(tempWord))) {
                                // remove word from the set as it is processed
                                set.remove(tempWord);
                                queue.add(tempWord);
                            }
                        }
                    }
                }
            }
        }
        return 0; // if it has reached here , then we don't have the path
    }

    public static void main(String[] args) {
      //  String A = "ymain";
      //  String B = "oecij";
//        String[] C = { "ymann", "yycrj", "oecij", "ymcnj", "yzcrj", "yycij", "xecij", "yecij", "ymanj", "yzcnj", "ymain" };

       String A = "hit";
        String B = "cog";
        String[] C = {"hot", "dot", "dog", "lot", "log", "cog"};

        WordLadderI wl = new WordLadderI();
        System.out.println(wl.solve(A,B,C));

    }
}


