// 79. Word Search

class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || word == null || word.length() == 0) {
            return true;
        }
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0) &&  dfs(board, i, j, 0, word)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public boolean dfs(char[][] board, int i, int j, int count, String word) {
        // count keeps track of how many charaters you have found
        if (count == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] != word.charAt(count)) {
            return false;
        }
        
        // Mark as visited
        char temp = board[i][j];
        board[i][j] = '#';
        // Call dfs on all 4 directions
        boolean found =  dfs(board, i - 1, j, count + 1, word) 
            ||  dfs(board, i + 1, j, count + 1, word) ||  dfs(board, i, j + 1, count + 1, word) 
            ||  dfs(board, i, j - 1, count + 1, word);
        board[i][j] = temp;
        
        return found;
     
    }
}