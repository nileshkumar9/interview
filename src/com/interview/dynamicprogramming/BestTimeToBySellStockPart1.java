package com.interview.dynamicprogramming;

/**
 * https://www.youtube.com/watch?v=4YjEHmw1MX0&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=30
 * For given value of stock price, find the best time to buy the stock and sell the stock.
 * Best Time to Buy and Sell Stocks - One Transaction Allowed
 *
 * Integer[] inputarray =  {7,1,5,3,6,4};
 *
 * Logic :
 *      We will find the least stock price and the difference if the stock is sold every day.
 *      If everyday's profit is greater than overall profit we will change the overall profit.
 *
 *
 */
public class BestTimeToBySellStockPart1 {

    public static void main(String[] args) {

        Integer[] stockPrice =  {7,1,5,3,6,4};

        int overallProfit = 0;
        int leastStockPriceSoFar = Integer.MAX_VALUE;
        int profitSoFar =0;

        for(int i=0 ; i<stockPrice.length ; i++){
            // for every value check if it is the least price so far
            if (stockPrice[i] < leastStockPriceSoFar){
                // We will capture this value as the least value
                leastStockPriceSoFar = stockPrice[i];
            }
            // Now for every least value we will capture the profit.
            // we will have this much profit if we sell today
            profitSoFar = stockPrice[i] - leastStockPriceSoFar;

            // Now verify if its the max profit
            if(profitSoFar >= overallProfit){
                // Update the overall Profit
                overallProfit = profitSoFar;
            }
        }
        System.out.println( "Max profit for given range is : " + overallProfit);

    }
}
