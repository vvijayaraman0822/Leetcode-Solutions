// 200. Number of Islands


class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
                
        int rows = grid.length;
        int columns = grid[0].length;
        int numberOfIslands = 0;
        
        for (int i=0; i < rows; i++) {
            for(int j=0; j < columns; j++) {
                if (grid[i][j] == '1') {
                   depthFirstSearch(grid, i, j, rows, columns);  
                   numberOfIslands++; 
                }
            }
        }
        
        return numberOfIslands;
    }
    
    public void depthFirstSearch(char[][] grid, int i, int j, int rows, int columns) {
        if (i < 0 || i >= rows || j < 0 || j >= columns || grid[i][j] != '1') { // out of bounds check or if it is not a 1, don't do anything
            return;
        }
        
        if (grid[i][j] == '1') {
            grid[i][j] = '2';
        }
        
        // call DFS on all 4 directions
        depthFirstSearch(grid, i+1, j, rows, columns); 
        depthFirstSearch(grid, i, j+1, rows, columns);
        depthFirstSearch(grid, i-1, j, rows, columns);
        depthFirstSearch(grid, i, j-1, rows, columns);
        
        return;
    }
        
}