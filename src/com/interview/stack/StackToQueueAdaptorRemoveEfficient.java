package com.interview.stack;

import java.util.Stack;

/**
 * https://www.youtube.com/watch?v=J8EejK8zvw8&list=PL-Jc9J83PIiEyUGT3S8zPdTMYojwZPLUM&index=52
 * Use Stack to behave as a Queue, this should be remove effccient, Add can be of o(n)
 *
 *
 * Logic: We will use two stack, will put all the element from the stack 1 to stack2 during
 * of new element. in this way top of the stack will always have element that was added first
 * in the main stack thus remove from main stack will be o(1) and efficient
 *
 */
public class StackToQueueAdaptorRemoveEfficient {
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
            while (mainStack.size()>0){
                helperStack.push(mainStack.pop());
            }
            mainStack.push(val);
            while (helperStack.size()>0){
                mainStack.push(helperStack.pop());
            }
        }
        int remove(){ // Queue remove in FIFO
            if(size()==0){
                System.out.println("Queue underflow");
                return -1;
            } else {
                return mainStack.pop();
            }
        }

        int peek(){ // element present at the top of the queue.
            if(size()==0){
                System.out.println("Queue underflow");
                return -1;
            } else {
                return mainStack.peek();
            }
        }
    }
}
