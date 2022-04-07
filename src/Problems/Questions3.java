//package Problems;
//
//public class Questions3 {
//    public static void main(String[] args) {
//        System.out.println("hi");
//
//        /*
//Given an m x n grid of characters board and a string word, return true if word exists in the grid.
//
//The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
//
//m  b  b  l  e
//p  a  x  y i
//p  l   r   t  s
//a  e  s  r  z
//
//Apale
//
//*/
//        Void callerFunction(){
//
//            Int i = 0;
//            Int j=0;
//            Char[] char = word.toChar();
//            initialPosition = 0
//            for(int i = 0 ; i< grid.length; i++){
//                for(int j = 0 ; j< grid[0].length; j++){
//                    if(grid[i][j] == char[initialPosition]) {
//                        // First occurrence found
//                        Boolean result =findWordInGrid(grid, charInput, initialPosition, i, j);
//                        If (result) {
//                            break;
//                        }
//
//
//                    }
//                    If (result) {
//                        break;
//                    }
//                }
//
//                System.out.println(result);
//            }
//
//
//            Boolean findWordInGrid(char [][] grid, Char[] charInput, int initialPosition,  int i , int j){
//                If ( i <0 || j <0  || i > grid.length-1 || j > grid[0].length-1 ){ // AOB
//                    return false
//                }
//                if(initialPosition >= charInput.length){
//                    return true;
//                }
//
//                if(char[initialPosition] != grid[i][j]){
//                    return false;
//                }
//
//
//                // character is found
//                initialPostion ++;
//                // right
//                Boolean resultR = findWordInGrid(grid, charInput, intialPostion, i , j++ );
//                if(resultR){
//                    Return true;
//                }
//// BOTTOM
//                Boolean resultB = findWordInGrid(grid, charInput, intialPostion,  i++ , j );
//                if(resultB){
//                    Return true;
//                }
//// left
//                Boolean resultL = findWordInGrid(grid, charInput, intialPostion, i , j - - );
//                if(resultL){
//                    Return true;
//                }
//// top
//                Boolean resultT = findWordInGrid(grid,charInput, intialPostion, i – , j );
//
//
//                return resultR  || resultB || resultL || resultT;
//
//            }
//
//
//
//
//        }
//}
