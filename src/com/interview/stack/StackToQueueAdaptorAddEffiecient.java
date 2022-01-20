package com.interview.stack;

import java.util.Stack;

/**
 * https://www.youtube.com/watch?v=EbMCOZzpRpw&list=PL-Jc9J83PIiEyUGT3S8zPdTMYojwZPLUM&index=54
 * Use Stack to behave as a Queue, this should be add effccient, other can be of o(n)
 *
 * Logic: We will use two stack, will put all the element from the stack 1 to stack2 during
 * of new element. in this way top of the stack will always have element that was added first
 * in the main stack thus remove from main stack will be o(1) and efficient
 *
 */
public class StackToQueueAdaptorAddEffiecient {
    public static class StackToQueueAdaptor{
        Stack<Integer> mainStack;
        Stack<Integer> helperStack;

        public StackToQueueAdaptor(Stack<Integer> mainStack, Stack<Integer> helperStack) {
            this.mainStack = mainStack;
            this.helperStack = helperStack;
        }

        int size(){
            return mainStack.size();
        }

        void add( int val) { // queue method name is add to add
            // in order to make add efficient just push to the main stack
            mainStack.push(val);
        }
        int remove(){ // Queue remove in FIFO
            // We will push everythign from mainStack to helper.
            // we will captre the last element that is at the bottom of the stack and
            // will return that particular value as this is the first element that got added.
            // DON'T push last element to the helper stack
            // push everything back from helper to the main stack
            if(size()==0){
                System.out.print("Queu under flow");
                return -1;
            } else{
                while(mainStack.size()>1){
                    helperStack.push(mainStack.pop());
                }
                int val = mainStack.pop(); // We will not put it into helper stack as we have to remove it.

                while(helperStack.size()>0){
                    mainStack.push(helperStack.pop());
                }
                return val;

            }
        }

        int peek(){ // element present at the top of the queue.
            // We will push everythign from mainStack to helper.
            // we will captre the last element that is at the bottom of the stack and
            // will return that particular value as this is the first element that got added.
            // push last element to the helper stack
            // push everything back from helper to the main stack
            if(size()==0){
                System.out.print("Queu under flow");
                return -1;
            } else{
                while(mainStack.size()>1){
                    helperStack.push(mainStack.pop());
                }
                int val = mainStack.pop();
                helperStack.push(val);
                while(helperStack.size()>0){
                    mainStack.push(helperStack.pop());
                }
                return val;

            }

        }
    }
}
