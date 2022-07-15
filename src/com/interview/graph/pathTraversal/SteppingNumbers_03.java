package com.interview.graph.pathTraversal;

import java.util.ArrayList;
import java.util.Collections;

public class SteppingNumbers_03 {
    /**
     * Logic : Make graph for the number with the first letter of the digit
     * LEts its start at :   3
     * next level : 32        34
     * next level: 321 323   343   345
     */
    public ArrayList<Integer> stepnum(int A, int B) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (A == 0) {
            ans.add(0);
        }

        // We will start for all digit as first digit or root of graph
        for (int i = 1; i <= 9; i++) {
            exploreAllPathAndCaptureResult(i, A, B, ans);
        }
        Collections.sort(ans);

        return ans;

    }


    private void exploreAllPathAndCaptureResult(int value, int startNumber, int endNumber, ArrayList<Integer> ans) {


        // if the value exceeds endNumber
        if (value > endNumber) {
            return;
        }


        // the value if it lies withing the given range then add to the list
        if (value >= startNumber && value <= endNumber) {
            ans.add(value);
        }

        // do this recoursively for all the element of the graph
        // each number will have only two child,
        // one where the last digit will only be one smaller
        // second where the last digit will be only one grater
        int lastDigit = value % 10; //  for value 12 it will give 2

        int valuewithLastdigitSmaller = 0;
        int valuewithLastdigitGreater = 0;
        // Explore previous adjacent
        if (lastDigit != 0) // we cannot decrease and make new number if we have last as 0
        {
            valuewithLastdigitSmaller = (value * 10) + (lastDigit - 1); // for value value 12 it will give 121, decreased last digit and appended it to last
            exploreAllPathAndCaptureResult(valuewithLastdigitSmaller, startNumber, endNumber, ans);
        }

        // explore next adjacent.
        if (lastDigit != 9) // we cannot increase and make a new number if last digit is 9
        {
            valuewithLastdigitGreater = (value * 10) + (lastDigit + 1); // for value 12 it will give 123. increased last digit and added to previous value
            exploreAllPathAndCaptureResult(valuewithLastdigitGreater, startNumber, endNumber, ans);

        }
    }

    public static void main(String[] args) {
        SteppingNumbers_03 obj = new SteppingNumbers_03();
        System.out.println(obj.stepnum(10,12));
    }
}
