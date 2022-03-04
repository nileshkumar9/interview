package Problems;

import java.util.ArrayList;

public class QuestionsOnJava {
    /**
     * Write a program to find the min and max value for the values from this array.
     *
     * [100, 24, 190, 299, 282, 115, 204, 221] Min... by Sushant Panda
     * Sushant Panda2:09 PM
     * [100, 24, 190, 299, 282, 115, 204, 221]
     *
     *
     *
     * Min: 24, Max: 299
     */

    /**
     *
     *
     * Write a program to remove the duplicates from an array
     *
     *
     * [100, 200, 203, 11, 100, 34, 100, 234, 200]
     *
     * [100, 200, 203, 11, 34, 234]
     *
     */

    /**
     * [x1, y1, x2, y2, x3, y3, x4, y4]
     *
     *
     *
     * [100, 50, 0, 0, 0, 50, 100, 0]
     *
     *
     * p1 = 100, 50
     * p2 = 0 , 0
     * p3 = 0, 50
     * p4 = 100, 0
     * ---------100, 50
     * |
     * |y2-y1
     * 0, 0 ---x2-x1------100, 0
     * 1)
     *
     * [0, 50, 100, 50, 100, 0, 0, 0]
     *
     *
     *
     */

    public static void main(String[] args) {
        int[] inputArray = new int[]{100, 24, 190, 299, 282, 115, 204, 221};

        minMaxOfAnArray(inputArray );

        int[] duplicateArray = {100, 200, 203, 11, 100, 34, 100, 234, 200};


       removeDuplicatesInTheArray(duplicateArray);


        areaOfARectangleFromCoordinates();

    }
    static class Coordinates{
        Integer x;
        Integer y;
        public Coordinates( ) {

        }
        public Coordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void areaOfARectangleFromCoordinates() {
        int[] input = new int[]{100, 50, 0, 0, 0, 50, 100, 0};
        // int[] input = new int[]{0, 50, 100, 50, 100, 0, 0, 0};
        // int[] input = new int[]{20, 20, 90, 20, 90, 50, 20, 50};



        ArrayList<Coordinates> al = new ArrayList<>();

        int initialX = input[0];
        int initialY = input[1];
        int xdistance =0;
        int ydistance =0;

        for(int i=2; i<input.length; i =i+2){
            int x = input[i];
            int y= input[i+1];

            if(  initialX ==  x ){
                // x is matching calcualte x distance
                xdistance = Math.abs(  y - initialY);
            }

            if(  initialY == y ){
                // x is matching calcualte x distance
                ydistance = Math.abs(x - initialX);
            }


//            Coordinates coordinates = new Coordinates(x,y);
//            al.add(coordinates);



        }
        // Now i have all the coordinates in pair.
        // 2 find adjacent pairs
        // [100, 50, 0, 0, 0, 50, 100, 0]
        // either x will be same 100, 50 And 100 , 0
//        Coordinates xCoardinates = new Coordinates();
//        Coordinates yCoardinates = new Coordinates();
//

//        for(Coordinates coordinates : al){
//            if(xCoardinates.x == null  ){
//                // x is matching
//                xCoardinates.x = coordinates.x;
//                xCoardinates.y = coordinates.y;
//            }
//            if(  xCoardinates.x == coordinates.x ){
//                // x is matching calcualte x distance
//                  xdistance = Math.abs( coordinates.y - xCoardinates.y);
//
//            }
//
//            if(yCoardinates.x == null   ){
//                // x is matching
//                yCoardinates.x = coordinates.x;
//                yCoardinates.y = coordinates.y;
//            }
//            if(  yCoardinates.y == coordinates.y ){
//                // x is matching calcualte x distance
//                ydistance = Math.abs(coordinates.x - yCoardinates.x);
//
//            }
//
//        }
        System.out.println( "Area is  : " + xdistance * ydistance);
        // Or Y will be same 0 , 0 and 0, 50

    }

    private static ArrayList<Integer> removeDuplicatesInTheArray(int[] duplicateArray) {

        ArrayList<Integer> resultArray = new ArrayList<>();
         for(int i=0; i < duplicateArray.length ; i++){
            if( ! resultArray.contains(duplicateArray[i])){
                // its now not a duplicate value so add to result
                resultArray.add(duplicateArray[i]);
            }
        }


        System.out.println(resultArray);
        return resultArray ; // change this
    }

    private static void minMaxOfAnArray(int[] inputArray ) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        // iterate over an array and find the max and min
        for(int i=0; i<inputArray.length; i++){
            if(inputArray[i] < min ){ // case when the value is less than current min
                min = inputArray[i];

            } else if (inputArray[i] > max) {
                // updating max
                max = inputArray[i];
            }
        }

        System.out.println("Min value : " + min);
        System.out.println("Max value : " + max);


    }


}
