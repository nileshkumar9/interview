package com.interview.graph.shortestPath;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * https://www.interviewbit.com/problems/word-ladder-ii/
 * https://www.youtube.com/watch?v=mIZJIuMpI2M
 * Given two words (start and end), and a dictionary, find the shortest transformation sequence from start to end, such that:
 * <p>
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary
 * If there are multiple such sequence of shortest length, return all of them. Refer to the example for more details.
 * <p>
 * Note:
 * <p>
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * Input Format
 * <p>
 * The first argument is string start.
 * The second argument is string end.
 * The third argument is an array of strings dict
 * Output Format
 * <p>
 * Return all transformation sequences such that first word of each sequence is start and last word is end, all intermediate words belongs to dictionary(dict) and consecutive words had atmost 1 difference.
 * Example :
 * <p>
 * :
 * <p>
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * Return
 * <p>
 * [
 * ["hit","hot","dot","dog","cog"],
 * ["hit","hot","lot","log","cog"]
 * ]
 * <p>
 * Logic : https://www.youtube.com/watch?v=mIZJIuMpI2M
 * Use word Ladder 1 to get the BFS shortest path value
 * this becomes, to reach to end node from given node using minimum jump.
 * All Edge we can assume as of same weight
 * We cannot use DFS, as Dfs are not used to find shortest distance, and its used in tree.
 * This is a graph problem with BFS.
 * <p>
 * Time complexity : length of word = N(for each word we have to do transforamation) *
 * 26 *
 * N (check for every transfromation) *
 * W(number of word in dictionary)
 * Now that we have depth or shortestPath Value
 * <p>
 * We will now have to use DFS.
 * We will use DFS and, will keep the track of all the path if we found the path we will break. at that level
 * <p>
 * We will first make the adjencyList here.
 * While making the adjency list , we will always maintain the child at next level.
 * Making Adjecency list is critical here , where the child will be always as next level, hence
 * we will never be having parent of this child.
 */
public class WordLadder2 {
    //public int solve(String A, String B, String[] C) {
    public ArrayList<ArrayList<String>> findLadders(String start, String end, ArrayList<String> dict) {

            return wordLadder1(start, end, dict) ; //as the number of transformation will be 1 more then edges

    }

    private ArrayList<ArrayList<String>>  wordLadder1(String startWord, String endWord, ArrayList<String> dictionary) {
        // Enahncement to word ladder 1
        HashMap<String, Set<String>> adjecencyList = new HashMap();

        // 1. put all the dictionary item into a set.
        // Also check if the end word exists in set
        HashSet<String> set = new HashSet<>();
        for (String word : dictionary) {
            set.add(word); // this will remove all duplicates.
        }
        if (!set.contains(endWord)) {
            return null; // if the end word doesn't exits return
        }

        Queue<String> queue = new ArrayDeque<>();
        queue.add(startWord);
        // Enhancement to wordLadder 1 : while doing the traversal we will prepare the adjecency list]
        HashMap<String, Integer> visited = new HashMap<>();
        visited.put(startWord, 0);

        // now do bfs processing
        while (!queue.isEmpty()) {
            // remove mark* work add *
            // We have to process for each and every node of the level
            //while (currentLevelSize-- > 0) {
            String currentWord = queue.remove();
            char[] temp = currentWord.toCharArray();

            for (int i = 0; i < currentWord.length(); i++) {
                // for every character of this word we have to do the transformation
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    // check for all 26 possible replacement of one char.
                    // basically we can only do one trasformation at a time
                    // so for each character we are finding the word from dictionary and adding it to the queue

                    temp[i] = ch; // replacing the ith character of the word with all 26 character one by one.

                    String tempWord = String.valueOf(temp);
                    if (tempWord.equals(currentWord)) {
                        // ignore the current work as it will be one of the 26th transforamtion
                        continue;
                    }

                    // add this transformed word into the queue.
                    // if only this word exists in the dictionary
                    if (set.contains(String.valueOf(tempWord))) {
                        // check if its not visited
                        if (visited.get(tempWord) == 0) {
                            // mark as visited, and will put its level as one more then its parent node.
                            visited.put(tempWord, visited.get(currentWord) + 1);
                            // remove word from the set as it is processed

                            set.remove(tempWord);
                            queue.add(tempWord);
                            // add to the current node
                            Set<String> tempset = adjecencyList.get(currentWord);
                            if (tempset == null) {
                                tempset = new HashSet<String>();
                            }
                            tempset.add(tempWord);
                            adjecencyList.put(currentWord, tempset);

                        } else if (visited.get(tempWord) == visited.get(currentWord) + 1) {
                            // if already visisted and new word is the child (We should always move down)
                            Set<String> tempset = adjecencyList.get(currentWord);
                            tempset.add(tempWord);
                            adjecencyList.put(currentWord, tempset);
                        }
                    }
                }
                // since we made our adjecency list now we have to make the tempWord as current word

                temp[i] = currentWord.charAt(i);
            }
            // }
        }
        // Step 2 : We will now do the DFS here

        ArrayList<ArrayList<String>> finalPath = new ArrayList<>();
        DFS(startWord, endWord, adjecencyList, finalPath, new ArrayList<String>());

        return finalPath; // if it has reached here , then we don't have the path
    }

    private void DFS(String startWord, String endWord, HashMap<String, Set<String>> adjecencyList, ArrayList<ArrayList<String>> finalPath, ArrayList<String> path) {
        path.add(startWord);
        if (startWord == endWord) {
            finalPath.add(path);
            path.remove(startWord);
            return;
        }
        for (String s : adjecencyList.get(startWord)) {
            DFS(s, endWord, adjecencyList, finalPath, path);
        }
        path.remove(startWord); // to back track.
    }

    public static void main(String[] args) {
        //  String A = "ymain";
        //  String B = "oecij";
//        String[] C = { "ymann", "yycrj", "oecij", "ymcnj", "yzcrj", "yycij", "xecij", "yecij", "ymanj", "yzcnj", "ymain" };

        String A = "hit";
        String B = "cog";
        String[] C = {"hot", "dot", "dog", "lot", "log", "cog"};

        WordLadder2 wl = new WordLadder2();
      // System.out.println(wl.findLadders(A, B, C));

    }
}


