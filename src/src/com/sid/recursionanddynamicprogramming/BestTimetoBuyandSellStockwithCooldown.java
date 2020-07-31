package src.com.sid.recursionanddynamicprogramming;


import java.util.HashMap;
import java.util.Map;

/**
 * 309. Best Time to Buy and Sell Stock with Cooldown
 *
 *
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:
 *
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
 * Example:
 *
 * Input: [1,2,3,0,2]
 * Output: 3
 * Explanation: transactions = [buy, sell, cooldown, buy, sell]
 * **/
public class BestTimetoBuyandSellStockwithCooldown {

    public int maxProfit(int[] prices) {
        Map<String,Integer> hm=new HashMap<>();
        return maxProfit(0,0,prices,hm);
    }
    int maxProfit(int idx, int buyOrSell, int[] prices, Map<String,Integer> hm){
        if(idx >= prices.length)
            return 0;

        String key=idx+"maxProfit"+buyOrSell;
        if(hm.containsKey(key))
            return hm.get(key);
        int x=0;
        if(buyOrSell==0){ //we are buying
            int buy=maxProfit(idx+1,1,prices,hm)-prices[idx];
            int nobuy=maxProfit(idx+1,0,prices,hm);
            x=Math.max(buy,nobuy);
        }
        else{//we are selling
            int sell=maxProfit(idx+2,0,prices,hm)+prices[idx];
            int nosell=maxProfit(idx+1,1,prices,hm);
            x=Math.max(sell,nosell);
        }
        hm.put(key,x);
        return x;
    }
    /***
     *
     * Another DP solution
     *
     *1. Define States
     *
     * To represent the decision at index i:
     *
     * buy[i]: Max profit till index i. The series of transaction is ending with a buy.
     * sell[i]: Max profit till index i. The series of transaction is ending with a sell.
     * To clarify:
     *
     * Till index i, the buy / sell action must happen and must be the last action. It may not happen at index i. It may happen at i - 1, i - 2, ... 0.
     * In the end n - 1, return sell[n - 1]. Apparently we cannot finally end up with a buy. In that case, we would rather take a rest at n - 1.
     * For special case no transaction at all, classify it as sell[i], so that in the end, we can still return sell[n - 1]. Thanks @alex153 @kennethliaoke @anshu2.
     * 2. Define Recursion
     *
     * buy[i]: To make a decision whether to buy at i, we either take a rest, by just using the old decision at i - 1, or sell at/before i - 2, then buy at i, We cannot sell at i - 1, then buy at i, because of cooldown.
     * sell[i]: To make a decision whether to sell at i, we either take a rest, by just using the old decision at i - 1, or buy at/before i - 1, then sell at i.
     * So we get the following formula:
     *
     * buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]);
     * sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
     * 3. Optimize to O(1) Space
     *
     * DP solution only depending on i - 1 and i - 2 can be optimized using O(1) space.
     *
     * Let b2, b1, b0 represent buy[i - 2], buy[i - 1], buy[i]
     * Let s2, s1, s0 represent sell[i - 2], sell[i - 1], sell[i]
     * Then arrays turn into Fibonacci like recursion:
     *
     * b0 = Math.max(b1, s2 - prices[i]);
     * s0 = Math.max(s1, b1 + prices[i]);
     * 4. Write Code in 5 Minutes
     *
     * First we define the initial states at i = 0:
     *
     * We can buy. The max profit at i = 0 ending with a buy is -prices[0].
     * We cannot sell. The max profit at i = 0 ending with a sell is 0.
     *
     * **/

    public int maxProfit2(int[] prices) {
        if(prices == null || prices.length <= 1) return 0;

        int b0 = -prices[0], b1 = b0;
        int s0 = 0, s1 = 0, s2 = 0;

        for(int i = 1; i < prices.length; i++) {
            b0 = Math.max(b1, s2 - prices[i]);
            s0 = Math.max(s1, b1 + prices[i]);
            b1 = b0; s2 = s1; s1 = s0;
        }
        return s0;
    }

    public static void main(String[] args) {
        int stocksPrice[]={1,2,3,0,2};
        System.out.println(new BestTimetoBuyandSellStockwithCooldown().maxProfit(stocksPrice));
        System.out.println(new BestTimetoBuyandSellStockwithCooldown().maxProfit2(stocksPrice));
    }
}
