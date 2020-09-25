// 73. Set Matrix Zeroes

// Time complexity O(M x N), Space complexity O(M + N)
class Solution {
    public void setZeroes(int[][] matrix) {
        Set<Integer> rows = new HashSet<>();
        Set<Integer> columns = new HashSet<>();
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    columns.add(j);
                }
            }
        }
            
            for(int i = 0; i < matrix.length; i++) {
                for(int j = 0; j < matrix[0].length; j++) {
                    if (rows.contains(i) || columns.contains(j)) {
                        matrix[i][j] = 0;
                    }
                }
            }
            
        return;
    }
}

// Time complexity O(M x N), Space complexity O(1)
class Solution {
    public void setZeroes(int[][] matrix) {
        boolean firstRowZero = false;
        boolean firstColumn = false;
        
        // We need to check if there are any zeroes in the first row
        for (int i = 0; i < matrix[0].length; i++) {
           if (matrix[0][i] == 0) {
                firstRowZero = true;
                break;
            }
        }
        
        // We need to check if there are any zeroes in the first column
        for (int i = 0; i < matrix.length; i++) {
           if (matrix[i][0] == 0) {
                firstColumn = true;
                break;
            }
        }  
        
        // Iterate from the second row and second column and use the first cell to mark the zero
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        
        // If either first row or first column is zero, make the whole row and column to zero
       for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
       }
        
        // If first row needs to be set to zero
       if (firstRowZero) {
           for(int i = 0; i < matrix[0].length; i++) {
               matrix[0][i] = 0;
           }
       }
        
        // If first column needs to be set to zero
       if (firstColumn) {
           for(int i = 0; i < matrix.length; i++) {
               matrix[i][0] = 0;
           }
       }      
    }
}