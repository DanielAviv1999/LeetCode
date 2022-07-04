class Main {
   public static void main(String[] args) {
      int[] A = {1,3,5,6};
      int x1 = 5, x2 = 2, x3 = 7, x4 = 0;
      System.out.format("for %d the insert position is: %d\n", x1, searchInsertPosition(A, x1));
      System.out.format("for %d the insert position is: %d\n", x2, searchInsertPosition(A, x2));
      System.out.format("for %d the insert position is: %d\n", x3, searchInsertPosition(A, x3));
      System.out.format("for %d the insert position is: %d\n", x4, searchInsertPosition(A, x4));
      
   }
   private static int searchInsertPosition(int[] A, int k) {
      int low = 0,
         mid, high = A.length - 1;
      if (A[0] >= k) 
         return 0;
      while (low <= high) {
         mid = (high - low) / 2 + low;
         if (A[mid] != k) 
            if (A[mid - 1] > k) high = mid - 1;
            else if (A[mid] < k) low = mid + 1;
            else return mid;
         
         else return mid;
      }
      return A.length;
   }
}