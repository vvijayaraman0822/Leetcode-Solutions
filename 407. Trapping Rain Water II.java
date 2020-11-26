// 407. Trapping Rain Water II

class Solution {
    int[][] directions = {{0,1}, {0, -1}, {1,0}, {-1, 0}};        
    class Cell implements Comparable<Cell> {
        int row;
        int col;
        int height;
            
        public Cell(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }
        
        public int compareTo(Cell otherCell) {
            if (this.height == otherCell.height) return 0;
            if (this.height < otherCell.height) return -1;
            return 1;
        }
    }
            
    public int trapRainWater(int[][] heightMap) {
        if (heightMap.length < 1) return 0;
        int m = heightMap.length;
        int n = heightMap[0].length;
        PriorityQueue<Cell> heap = new PriorityQueue<>();
        boolean[][] visited = new boolean[m][n];
        
        // Mark first column and last column as visited and add to Heap
        for(int i = 0; i < m; i++) {
            visited[i][0] = true;
            visited[i][n-1] = true;
            heap.offer(new Cell(i, 0, heightMap[i][0]));
            heap.offer(new Cell(i, n-1, heightMap[i][n-1]));
        }
        
        // Mark first row and last row as visited and add to Heap
        for(int i = 0; i < n; i++) {
           visited[0][i] = true;
           visited[m-1][i] = true;
            heap.offer(new Cell(0, i, heightMap[0][i]));
            heap.offer(new Cell(m-1, i, heightMap[m-1][i])); 
        }
        
        // from the borders, pick the shortest cell visited and check its neighbors:
        // if the neighbor is shorter, collect the water it can trap and update its height as its height plus the water trapped
       // add all its neighbors to the queue.
        int result = 0;
        while (!heap.isEmpty()) {
            Cell current = heap.poll();
            int row = current.row;
            int col = current.col;
            int height = current.height;
            
            for(int[] dirs: directions) {
                int newRow = dirs[0] + row;
                int newCols = dirs[1] + col;
                
                if (newRow > 0 && newRow < m -1 && newCols > 0 && newCols < n-1 && !visited[newRow][newCols]) {
                    visited[newRow][newCols] = true;
                    result += Math.max(0, height - heightMap[newRow][newCols]);
                    heap.offer(new Cell(newRow, newCols, Math.max(height, heightMap[newRow][newCols])));
                }
            }
        }
        return result;
    }
}
                                     
                            
            
            
