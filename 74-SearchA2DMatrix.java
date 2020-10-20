// 74. Search a 2D Matrix

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        // Think about it as a 1D matrix, flatten it out
        int totalRows = matrix.length;
        int totalColumns = matrix[0].length;
        
        // left & right index
        int left = 0;
        int right = totalRows * totalColumns-1; // last item in last row (totalColumns-1 so array does not go out of bounds)
        
        // binary search, find midPoint and to find the value in midPoint, use int findRow = mid / totalColumns AND mid % totalColumns;
        while (left <= right) {
            int mid = (left + right) / 2;
            int findRow = mid / totalColumns;
            int findColumn = mid % totalColumns;
            
            int matrixTarget = matrix[findRow][findColumn];
            
            if (target == matrixTarget) {
                return true;
            } else if (matrixTarget > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return false;
    }
}