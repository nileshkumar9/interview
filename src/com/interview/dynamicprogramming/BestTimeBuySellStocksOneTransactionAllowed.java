package com.interview.dynamicprogramming;

/**
 * https://www.youtube.com/watch?v=4YjEHmw1MX0&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=31
 *
 * We will assume, if we have to sell today what will be maximum profit.
 *
 * To get maximum profit, we should have purchased when the price was minimum.
 *
 *
 */
public class BestTimeBuySellStocksOneTransactionAllowed {

    public static void main(String[] args) {
        int [] prices = {1,2,3};

        // we will travel from left of the graph to right,
        // will calculate leastSoFar price.
        int leastSoFar = Integer.MAX_VALUE;
        int overAllProfit = 0;
        int profitIfSoldToday = 0;
        for(int i =0 ; i < prices.length ; i++){
            if(prices[i] < leastSoFar){
                // prices are increasing so we should not sell
                // we need to maintain because this gives immediate previous least value
                leastSoFar = prices[i];
            }
            // Now calculate profit if sold today.
            // todays price minus least so far
            profitIfSoldToday = prices[i] - leastSoFar;
            if(profitIfSoldToday> overAllProfit){
                // update the overall profit
                overAllProfit = profitIfSoldToday;
            }
        }
        System.out.println( "Overall profit : " + overAllProfit );


    }
}
