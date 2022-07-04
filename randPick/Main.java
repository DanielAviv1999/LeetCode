import java.util.Random;
public class Main {
   public static void main(String[] args) {
      int[] A = {1,4};
      int total = 1_000_000;
      int count1 = 0;
      for (int i = 0; i < total; ++i)
         if (randPick(A) == 1) ++count1;
      System.out.println((float)count1 / total);
   }
   private static int randPick(int[] A) {
      int N = A.length, x;
      int[] S = new int[N];
      S[0] = A[0];
      for (int i = 1; i < N; ++i)
         S[i] = S[i - 1] + A[i];
      x = (new Random()).nextInt(S[N - 1]) + 1;

      return A[binarySearch(S, x)];
   }
   private static int binarySearch(int[] A, int k) {
      int low = 0, 
         mid, high = A.length - 1;
      if (k <= A[0]) 
         return 0;
      while (low <= high) {
         mid = (high - low) / 2 + low;
         if (k > A[mid]) low = mid + 1;
         else if (k <= A[mid - 1]) high = mid - 1;
         else return mid;
      }
      return -1;
   }
}
