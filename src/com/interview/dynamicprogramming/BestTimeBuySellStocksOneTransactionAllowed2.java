package com.interview.dynamicprogramming;

/**
 * https://www.youtube.com/watch?v=HWJ9kIPpzXs&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=32
 *
 * Continuation of Buy and sell series
 * Question 2.
 * We have been given with price array of share on different dates.
 * Constraints is we are not allowed to have overlapping transactions, which means
 * every buy should be closed with a sell then only initiate next transaction.
 *
 * Logic : Collect all the profit in upstox. Till there is no price drops.
 *          Once the price strats dropping, we will have this profit stored in this segment.
 *          We will maintain buy and sell pointers, if price is increasing keep increasing
 *          the sell pointer, the moment we encounter an dip we will collect the profit
 *          and then we will make buy and sell pointer togeter, if there is continuous
 *          dips we will keep moving both the pointers unit there is an up tick. Since again
 *          there is an uptic now just move the sell pointers
 *
 *
 *          If dip, move B and S, if there is any increment move sell only.
 *
 *
 *
 *
 */
public class BestTimeBuySellStocksOneTransactionAllowed2 {

    public static void main(String[] args) {
        int [] prices = {1,2,3};

        int buyingDate = 0;
        int sellingDate = 0;
        int profit = 0;
        for (int i =1 ; i< prices.length ; i++) {
            if (prices[i] > prices[i-1]){
                // this means there is an increment in price so increase selling date only
                sellingDate ++;
            } else {
                profit = profit + (prices[sellingDate] - prices[buyingDate]);
                buyingDate = sellingDate = i; // make both selling date and buying dat together
            }

        }
        // we need this if there is only upticks and the prices ends
        profit = profit + (prices[sellingDate] - prices[buyingDate]);

        System.out.println( "Overall profit collected in each segment : " + profit );


    }
}
