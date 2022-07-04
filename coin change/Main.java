import java.util.Arrays;
class Main {
   public static void main(String[] args) {
      int[] coins = {1,2,5};
      int money = 12;
      System.out.println(coinChange(coins, coins.length, money));
      System.out.println(coinChangeDP(coins, money));
   }
   private static int coinChange(int[] coins, int n, int money) {
      int amount = 0;
      if (money == 0) return 1;
      for (int i = n - 1; i >= 0; --i)
         if (money >= coins[i]) 
            amount += coinChange(coins, i + 1, money - coins[i]);
      
      return amount;
   }
   private static int coinChangeDP(int[] coins, int money) {
      int i, j, k;
      int n = coins.length;
      int[][] dpCoinChange = new int[coins.length][money + 1];
      for (i = 0; i < n; ++i)
         dpCoinChange[i][0] = 1;
      
      for (j = 1; j <= money; ++j)
         for (i = 0; i < n; ++i)
            for (k = i; k >= 0; --k) {
               if (j >= coins[k])
                  dpCoinChange[i][j] += dpCoinChange[k][j - coins[k]];
            }
      
      return dpCoinChange[n - 1][money];
   }
   private static void printMat(int[][] mat) {
      int i, j;
      for (i = 0; i < mat.length; ++i) {
         for (j = 0; j < mat[i].length; ++j)
            System.out.format("%-4d", mat[i][j]);
         System.out.println();
      }
      System.out.println();
   }
}