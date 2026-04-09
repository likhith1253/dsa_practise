class Solution {
    public int maxProfit(int[] prices) {
        int i =1;
        int min = prices[0];
        int profit = 0;
        while(i<prices.length){
            if(prices[i]<min){
                min = prices[i];
            }
            else{
                profit = Math.max(profit,prices[i] - min);
            }
            i++;
        }
        return profit;
    }
}