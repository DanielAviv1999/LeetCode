import java.util.Arrays;
import java.util.Comparator;
class Main {
   public static void main(String[] args) {
      // int[][] costs = {
      //    {20,60},
      //    {10,50},
      //    {40,200},
      //    {30,300}
      // };
      int[][] costs = {
         {10,20},
         {30,60},
         {40,30},
         {60,20}
      };
      System.out.println("res: " + twoCityScheduling(costs));
   }
   private static int twoCityScheduling(int[][] costs) {
      int res = 0;
      Arrays.sort(costs, new Comparator<int[]>() {
         public int compare(int[] a, int[] b) {
            return Integer.compare(b[1] - b[0], a[1] - a[0]);
         }
      });     
     
      for (int i = 0; i < costs.length; ++i) 
         res += i < costs.length / 2 ? costs[i][0] : costs[i][1];
         
      return res;
   }   
}