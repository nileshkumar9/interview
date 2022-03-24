package com.interview.dynamicprogramming;

/**
 * https://www.youtube.com/watch?v=HWJ9kIPpzXs&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=31
 * For given value of stock price, find the best time to buy the stock and sell the stock.
 * Here we will have infinite transaction , but it will not be overlapping
 * which means it will be BuySell BuySell . Not not BuyBuySellSell (This is overlapping)
 * Best Time to Buy and Sell Stocks - One Transaction Allowed
 *
 * Integer[] inputarray =  {7,1,5,3,6,4};
 *
 * Logic :
 *      For every upstroke in the given pattern we will collect the profit.
 *      We will maintain the BuyingPoint and SellingPoint from start,
 *      Now we will move the Selling point if the price is incrasing while keeping the buyingpoint
 *      initial Point. Now the moment the next price is dippinp then previous one, we will collect
 *      the profit (sellingPoint - buyingPoint).
 *      Now that the price is decreasing we will keep on moving both buying and selling point
 *      Keep moving BuyingPoint till we have incrase in the price.
 *
 *      In the end we will sum all the profit into one.
 */
public class BestTimeToBySellStockPart2 {

    public static void main(String[] args) {

        Integer[] stockPrice =  {7,1,5,3,6,4};

        int buyingDate=0;
        int sellingDate=0;
        int profit = 0;


        for(int i=1; i< stockPrice.length; i++){
            if(stockPrice[i] >= stockPrice[i-1]){
                // only increase the selling date index as the price are still increasing so
                // no need to collect the profit yet
                sellingDate ++;
            } else {
                // collect older profit
                profit += stockPrice[sellingDate]-stockPrice[buyingDate];
                // change the index of both buying date and selling date
                buyingDate= sellingDate = i;
            }
        }
        profit += stockPrice[sellingDate]-stockPrice[buyingDate];
        System.out.println( "Overall profit for given range is : " + profit);

    }
}
