package org.example;

import java.util.Arrays;

public class CoinChange {

    public static void main(String[] args) {
        int n = 25;
        int[] coins = {1,2,3,5,8};
        int[] dp= new int[n+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        System.out.println();
        System.out.println("Coins required to make sum of "+n +" are : "+ coinSum(n, coins, dp));
    }
    public static int coinSum(int n, int[] coins, int[] dp){

        if(n==0) return 0;

        int ans = Integer.MAX_VALUE;

        for(int i=0; i<coins.length; i++){

            if(n-coins[i]>= 0) {
                int subAns = 0;
                if (dp[n - coins[i]]!= -1) {
                    subAns = dp[n-coins[i]];
                } else {
                    subAns = coinSum(n-coins[i], coins, dp);
                }

                if(subAns != Integer.MAX_VALUE && subAns+1 < ans){
                    ans = subAns + 1;
                }
            }
        }
       return ans;
    }
}
