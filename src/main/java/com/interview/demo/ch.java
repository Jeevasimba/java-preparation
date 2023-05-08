package com.interview.demo;

class Solution {
    public int maxProfit(int[] prices) {

        int min = Integer.MAX_VALUE;
        int ans = 0;

        for (int i = 0; i < prices.length; i++) {

            if(min<prices[i]){
                int temp = prices[i]-min;
                if(temp>ans){
                    ans = temp;
                }
            } else if (min>prices[i]) {
                min =  prices[i];
            }

        }

        return ans;
    }
}