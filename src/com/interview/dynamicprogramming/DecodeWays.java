package com.interview.dynamicprogramming;

/**
 * https://www.youtube.com/watch?v=jFZmBQ569So&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=21
 * for given set of integer input, we have to encode it to characters.
 * Now we have 1 for a , 2 for b ... till 26 for z...
 *
 * If Input is : 2 3 1, then it can be b c a, w(23)(a)... So similar combination can be made
 *
 * Logic :
 *      Form all such logic, start solving from begining of the given input,
 *      Not for every new element to the right, it can be considered alone to the previouse
 *      set 23 + 1, or it can be considered in combinations with previous one and itself i.e 2 + 31.
 *      We have not considered more than two element in the last as the digit cannot be
 *      more than 26(2 digit). Also have a check for last two value greater than 26.
 *      0 alone will not have any value
 *      0i will not have any value as 01 is nothing.
 *
 *      Form an dp array and keep working on it.
 */
public class DecodeWays {

    public static void main(String[] args) {

        String input = "21123";

        int[] dp = new int[input.length()];
        // first character in input "2" will be single sigith and will be having 1 way of encoding (1 -a, 2, b like that)
        dp[0] = 1 ;


        for( int i = 1; i<dp.length; i++){
            // find last two charackter
            // case 01
            if( input.charAt(i-1) == '0' &&  input.charAt(i) == '0' ){
                dp[i] = 0; // if both last two characters are 0 then it cannot add any value to the nummber of encoding
                // because 0 alone is nothing and with last two 0 0  will be nothing again. so cound will be 0

            } else if( (input.charAt(i-1) == '0') && (input.charAt(i) != '0')){
                // two scenario will happen here
                // 21103 ; we can form 2110-3 but nothing for 211-03
                // in this case number of encoding will remains like previous positions array
                // as we are only having one character to add to last iterations of dp[i-1]
                dp[i] = dp[i-1];

            } else if( (input.charAt(i-1) != '0') && (input.charAt(i) == '0')){
                // e.g 211 20
                // here 0 alone will not do anything but combined with 20 will make a value
                // also this 20 shold be less than 26
                if(input.charAt(i-1) =='1' || input.charAt(i-1) == '2'){
                    // if there is 3 then it will exceed 26 limit hense check of 1 and 2
                    // as last character is already zero
                    // in this case it will be similar to dp [i-2]
                    dp[i] = (i>=2 ? dp[i-2] : 1);
                } else {
                    dp[i] = 0; // this is 0 0 case which is already coverd earlier
                }


            }  else{
                // both last is non zeroes
                // 211 2 3 - 2112 3 , or 211-23

                if (Integer.parseInt(input.substring(i-1, i+1)) <=26){
                    // if both are less than 26
                    // then
                    dp[i] = dp[i-1] + (i>=2 ? dp[i-2] : 1 ) ; // one combinations of alone and one when considering 23 so we have to go two step back


                } else {
                    dp[i] = dp[i-1];
                }

            }
        }
        System.out.println( "No of total encoding " + dp[input.length()-1]);


    }
}
