class Main {
   public static void main(String[] args) {
      char[][] board = {
         {'X','X','X','X'},
         {'X','O','O','X'},
         {'X','X','O','X'},
         {'X','O','X','X'}
      };
      printMatrix(board);
      surroundedRegions(board);
      printMatrix(board);
   }
   private static void printMatrix(char[][] mat) {
      for (int i = 0; i < mat.length; ++i) {
         for (int j = 0; j < mat.length; ++j) 
            System.out.format("%-4c", mat[i][j]);
         System.out.println();
      }
      System.out.println();
   }
   private static void surroundedRegions(char[][] board) {
      int m = board.length;
      int n = board[0].length;
      for (int j = 0; j < n; ++j) {
         if (board[0][j] == 'O') markIsland(board, 0, j, m, n);
         if (board[m - 1][j] == 'O') markIsland(board, m - 1, j, m, n);
      }
      for (int i = 0; i < m; ++i) {
         if (board[i][0] == 'O') markIsland(board, i, 0, m, n);
         if (board[i][n - 1] == 'O') markIsland(board, i, n - 1, m, n);
      }
      for (int i = 0; i < m; ++i)
         for (int j = 0; j < n; ++j)
            if (board[i][j] == 'Y') board[i][j] = 'O';
            else board[i][j] = 'X';
   }
   private static void markIsland(char[][] board, int i, int j, int m, int n) {
      if (i < 0 || i == m || j < 0 || j == n || board[i][j] != 'O') return;
      board[i][j] = 'Y';
      markIsland(board, i - 1, j, m, n);
      markIsland(board, i, j + 1, m, n);
      markIsland(board, i + 1, j, m, n);
      markIsland(board, i, j - 1, m, n);
   }
}