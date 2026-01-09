
import java.util.Scanner;

class Solution {
    public int maxProfit(int[] prices) {
        
        
        int n = prices.length;
        int maxright = prices[n-1];
        int profit = 0;
        for(int i=n-2;i>=0;i--){
            profit = Math.max(profit,maxright-prices[i]);
            maxright = Math.max(maxright,prices[i]);
        }
        return profit;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // input size
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int prices[] = new int[n];

        // input array
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
     
        }

        Solution sol = new Solution();
        int result = sol.maxProfit(prices);


        System.out.println("Maximum Profit: " + result);
    }
}