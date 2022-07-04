class Main {
   public static void main(String[] args) {
      String s = "abc";
      String t = "acbacb";
      int M = s.length();
      int N = t.length();
      System.out.println(isSubsequence(s, t, M, N));
   }
   private static boolean isSubsequence(String s, String t, int j, int i) {
      if (j == 0) 
         return true;
      if (i < j) 
         return false;
      if (s.charAt(j - 1) == t.charAt(i - 1)) 
         return isSubsequence(s, t, j - 1, i - 1);
      else 
         return isSubsequence(s, t, j, i - 1);
   }
}