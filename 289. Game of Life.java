// 289. Game of Life

class Solution {
    // all 8 directions of neighbours
    final int[][] direction = new int[][] {
        {0, 1},
        {1, 0},
        {1, 1},
        {-1, 1},
        {-1, 0},
        {0, -1},
        {-1, -1},
        {1, -1}
        };
    
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) {
           return;
        }
        
        for (int rows = 0; rows < board.length; rows++) {
            for (int cols = 0; cols < board[0].length; cols++) {
               if (board[rows][cols] == 0) { // Dead cell
                   int lives = count(board, rows, cols);
                   if (lives == 3) {
                       board[rows][cols] = -1; // -1 means it's a live cell
                   }                  
               } else if (board[rows][cols] == 1) { // live cell
                   int lives = count(board, rows, cols);    
                   if (lives < 2 || lives > 3) {
                        board[rows][cols] = 2; // 2 means it is a dead cell
                   } 
               }
            }
        }
        
        updateBoard(board);
    }
    
    private int count(int[][] board, int rows, int cols) {
      int result = 0;
        for(int[] dir : direction) {
            int newRow = dir[0] + rows;
            int newCols = dir[1] + cols;
            
            // board[newRow][newCols] == 2 (used to be a live cell) and board[newRow][newCols] == 1 (current live cell)
            if (newRow >= 0 && newRow < board.length && newCols >= 0 && newCols < board[0].length && (board[newRow][newCols] == 1 || board[newRow][newCols] == 2)) {
                result += 1;
            }
        }
        return result;
    }
    
    public void updateBoard(int[][] board) {
        for (int rows = 0; rows < board.length; rows++) {
            for (int cols = 0; cols < board[0].length; cols++) {
                if (board[rows][cols] == -1) {
                    board[rows][cols] = 1;
                }
                if (board[rows][cols] == 2) {
                    board[rows][cols] = 0;
                }
            }
        }
    }
}
               