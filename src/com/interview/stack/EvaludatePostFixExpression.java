package com.interview.stack;

import java.util.Stack;

/**
 * https://www.interviewbit.com/problems/evaluate-expression/
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 *
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 *
 * Input Format
 *
 * The only argument given is character array A.
 * Output Format
 *
 * Return the value of arithmetic expression formed using reverse Polish Notation.
 * For Example
 *
 * Input 1:
 *     A =   ["2", "1", "+", "3", "*"]
 * Output 1:
 *     9
 * Explaination 1:
 *     starting from backside:
 *     *: ( )*( )
 *     3: ()*(3)
 *     +: ( () + () )*(3)
 *     1: ( () + (1) )*(3)
 *     2: ( (2) + (1) )*(3)
 *     ((2)+(1))*(3) = 9
 *
 * Input 2:
 *     A = ["4", "13", "5", "/", "+"]
 * Output 2:
 *     6
 * Explaination 2:
 *     +: ()+()
 *     /: ()+(() / ())
 *     5: ()+(() / (5))
 *     1: ()+((13) / (5))
 *     4: (4)+((13) / (5))
 *     (4)+((13) / (5)) = 6
 *
 * Logic : Input is given in postfix format. In order to evaludate the postFix experession.
 * We will put operants in stack(ValueStack).
 * When we encounter and operators in the expression, pop two element from the stack. and process it with operator,
 * once processed push the calculated value back to the ValueStack. Repeat this till end of the expression.
 * In last we will have final calculated value left in the valueStack.
 *
 * NOTE : As and extra excersise keep check the postfix to prefix and infix conversion of the stack.
 * https://www.youtube.com/watch?v=qusuduyQm8k&list=PL-Jc9J83PIiEyUGT3S8zPdTMYojwZPLUM&index=21
 * https://www.youtube.com/watch?v=BlNXOtll7jo&list=PL-Jc9J83PIiEyUGT3S8zPdTMYojwZPLUM&index=22
 *
 */
public class EvaludatePostFixExpression {
    static public int evalRPN(String[] A) {
        int value = 0;
        Stack<String> valueStack = new Stack<>();
        // Put everthing in stack first
        for(int i = 0; i<A.length; i++){
            if (A[i].equals("+") || A[i].equals("-") || A[i].equals("/") || A[i].equals("*") ){
                // Process if you find a operator in the stack
                // pop two element from the stack, v2 will be first element and v1 will be second element in the stack(reverse)
                // Perform the operation with the stack
                String operator = A[i];
                int val2 = Integer.parseInt(valueStack.pop());
                int val1 = Integer.parseInt(valueStack.pop());

                if(operator.equals("+")){
                    value = val1 + val2;
                } else if (operator.equals("-")){
                    value = val1 - val2;
                } else if (operator.equals("*")){
                    value = val1 * val2;
                } else {
                    value = val1 / val2;
                }
                // once evaludated put the caluclated value back in the value stack
                valueStack.push(String.valueOf(value));
            }else {
                // if we find operands, keep pushing.
                valueStack.push(A[i]);
            }
        }
        return Integer.parseInt( valueStack.pop());
    }

    public static void main(String [] args)
    {
        String[] A = new String[]{"2", "1", "+", "3", "*"};
        int result = evalRPN(A);
        System.out.println(result);
    }
}
