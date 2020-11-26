// 547. Friend Circles

class Solution {
    public int findCircleNum(int[][] M) {
        int circles = 0;
        boolean[] visited = new boolean[M.length];
        
        for (int i = 0; i < M.length; i++) {
            if (!visited[i]) {
                circles++;
                dfs(M, visited, i);
            }
        }
        
        return circles;
    }
    
    public void dfs(int[][] M, boolean[] visited, int rows) {
        for(int i = 0; i < M[0].length; i++) {
            if (!visited[i] && rows != i && M[rows][i] == 1) {
                visited[i] = true;
                dfs(M, visited, i);
            }
        }
    }
}