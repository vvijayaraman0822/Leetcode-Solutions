// 54. Spiral Matrix

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> outputList = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return outputList;
        }
        
        int top = 0;
        int bottom = matrix.length - 1;
        int right = matrix[0].length - 1;
        int left = 0;
        
        while(outputList.size() < matrix.length * matrix[0].length) {
        for (int i = left; i <= right && outputList.size() < matrix.length * matrix[0].length; i++) {
            outputList.add(matrix[top][i]);
        }
        top++;
        
        for (int i = top; i <= bottom && outputList.size() < matrix.length * matrix[0].length; i++) {
            outputList.add(matrix[i][right]);
        }
        right--;
        
        for (int i = right; i >= left && outputList.size() < matrix.length * matrix[0].length; i--) {
            outputList.add(matrix[bottom][i]);
        }
        bottom--;
        
        for (int i = bottom ; i >= top && outputList.size() < matrix.length * matrix[0].length; i--) {
            outputList.add(matrix[i][left]);   
        }
            
        left++;    
                   
        }    
            
        return outputList;
        
    }
}