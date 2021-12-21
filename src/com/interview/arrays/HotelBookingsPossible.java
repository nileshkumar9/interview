package com.interview.arrays;

import java.util.ArrayList;
import java.util.Collections;

/**
 * https://www.interviewbit.com/problems/hotel-bookings-possible/
 * Problem Description
 * <p>
 * A hotel manager has to process N advance bookings of rooms for the next season. His hotel has C rooms. Bookings contain an arrival date and a departure date. He wants to find out whether there are enough rooms in the hotel to satisfy the demand. Write a program that solves this problem in time O(N log N) .
 * <p>
 * <p>
 * <p>
 * Input Format
 * First argument is an integer array A containing arrival time of booking.
 * <p>
 * Second argument is an integer array B containing departure time of booking.
 * <p>
 * Third argument is an integer C denoting the count of rooms.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return True if there are enough rooms for N bookings else return False.
 * <p>
 * Return 0/1 for C programs.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [1, 3, 5]
 * B = [2, 6, 8]
 * C = 1
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 0
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * At day = 5, there are 2 guests in the hotel. But I have only one room.
 * <p>
 * Logic :
 * We will sort the array first.
 * Then iterate till the end of the array,
 * increase the capacity when there is entry and go to next arrival value, check if the capacity is increase room size then break
 * Decrease the capacity, when there is exit and go to next depart value.
 * <p>
 * <p>
 * ref : https://www.youtube.com/watch?v=c7lcMWWDlcE
 */

public class HotelBookingsPossible {
    // Logic : iterate on sorted array. keep increasing the capacity counter when there is arrival or departure
    // https://www.youtube.com/watch?v=c7lcMWWDlcE
    public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {

        // Lets sort the array first
        Collections.sort(arrive);
        Collections.sort(depart);

        // We will take the arrival
        int i = 1; // for arrival
        int j = 0; // for depart
        int arrivalSize = arrive.size();
        boolean rv = true;
        int count = 1;

        while (i < arrivalSize && j < arrivalSize) {
            if (arrive.get(i) < depart.get(j)) { // person is entering and there is not exit yet
                count++; // increase the counter as there is arrival in hotel
                i++; // go to next arrival, as we took this arrival
                if (count > K) // exceeded the capacity of room
                {
                    rv = false; // since reached capacity returning false
                    break;
                }

            } else if (arrive.get(i) == depart.get(j)) {
                i++;
                j++; // one entering one departing, so don't change the counter.
            } else {
                // there is a depart value smaller then the arrival.
                // so decrease the capacity, as there is departure due.
                count--;
                if (count < 0) {
                    count = 0;
                }
                j++;  // increase the depart counter as there is departure only.

            }

        }

        return rv;
    }

}

