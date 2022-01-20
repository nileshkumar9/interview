package com.interview.stack;

import java.util.Stack;

/**
 * https://www.youtube.com/watch?v=S4mBBDfvWCE&list=PL-Jc9J83PIiEyUGT3S8zPdTMYojwZPLUM&index=56
 * Use single array to use it as two stack
 *
 * Logic: One stack will start at index 0 (tos1) and another end of the array will be having stack two
 * so tos2 will be sitting at array.length.
 * When perfroming action on stack1 increment / decrement tos1
 * When perfroming action on stack2 increment / decrement tos2 accordingly
 * overflow condition will be when both the pointer meets that is tos2 == tos+1
 *
 */
public class TwoStackUsingOneArray {
    public static class TwoStack{
        int[] data;
        int tos1; // top of stack
        int tos2;

        public TwoStack(int capacity){
            data = new int[capacity];
            tos1 = -1;
            tos2 = data.length;
        }

        int size1(){
            return tos1+1;
        }
        int size2(){

            return data.length - tos2;
        }

        void push1(int val1){

            if (tos2== (tos1+1)){
                // all stack is full
                System.out.println("Stack overflow");
            } else {
                tos1++;
                data[tos1] = val1;
            }

        }
        void push2(int val2){
            if (tos2== (tos1+1)){
                // all stack is full
                System.out.println("Stack overflow");
            } else {
                tos2--;
                data[tos2] = val2;
            }
        }

        int pop1(){
            if(size1() == 0){
                System.out.println("Stack underflow");
                return -1;
            }else {
                int val = data[tos1];
                tos1--;
                return val;
            }

        }
        int pop2(){
            if(size2() == 0){
                System.out.println("Stack underflow");
                return -1;
            }else {
                int val = data[tos2];
                tos2 ++;
                return val;
            }

        }

        int top1(){
            if(size1() == 0){
                System.out.println("Stack underflow");
                return -1;
            }else {
                int val = data[tos1];
                return val;
            }

        }
        int top2(){ // return tops of the stack
            if(size2() == 0){
                System.out.println("Stack underflow");
                return -1;
            }else {
                int val = data[tos2];
                return val;
            }
        }
    }
}
