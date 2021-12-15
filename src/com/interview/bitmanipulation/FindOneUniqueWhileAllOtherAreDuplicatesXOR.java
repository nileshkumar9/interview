package com.interview.bitmanipulation;

import java.util.ArrayList;

/**
 * @author Nilesh Kumar
 * Find elements that appears once, while all others are duplicates
 * e.g : 10, 11, 11, 12, 12, 13, 13, 20, 20
 * Logic : Do xor of all elements. In XOR, duplicates cancels each others
 */
public class FindOneUniqueWhileAllOtherAreDuplicatesXOR {
    public int findOneUniqueWhileAllOtherAreDuplicates(ArrayList<Integer> lists) {
        int unique = 0;
        for (Integer list : lists) {
            unique = unique ^ list;
        }
        return unique;

    }

    public static void main(String[] args) {
        FindOneUniqueWhileAllOtherAreDuplicatesXOR
            findOneUniqueWhileAllOtherAreDuplicates
            = new FindOneUniqueWhileAllOtherAreDuplicatesXOR ();
        ArrayList<Integer> lists = new ArrayList<Integer>();
        lists.add(10);
        lists.add(11);
        lists.add(12);
        lists.add(11);
        lists.add(12);
        lists.add(13);
        lists.add(13);

        int unique = findOneUniqueWhileAllOtherAreDuplicates.findOneUniqueWhileAllOtherAreDuplicates(lists);
        System.out.print("Unique number : " + unique);
    }
}
