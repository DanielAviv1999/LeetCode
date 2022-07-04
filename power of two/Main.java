import java.util.Scanner;
class Main {
   public static void main(String[] args) {
      System.out.print("Enter a number: ");
      int x = (new Scanner(System.in)).nextInt();
      System.out.format("is %d is power of two: %s\n", x, isPowerOfTwo(x));
   }
   private static boolean isPowerOfTwo(int number) {
      if (number <= 0) return false;
      while (number > 1 && number % 2 == 0) number >>= 1;

      return number == 1;
   }
}