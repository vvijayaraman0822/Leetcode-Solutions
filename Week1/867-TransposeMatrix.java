/* Leetcode 867 - Transpose Matrix 
- Create new Arr for length news rows = old column & new column = old row (Transpose)
- Two for loops running and transpose i and j
- Take A[i,j] and set it to newArr[j,i]
- Return new arr
*/

class Solution {
    public int[][] transpose(int[][] A) {
        int rows = A.length;
        int columns = A[0].length;
        int[][] newArr = new int[columns][rows];
        for(int i=0; i < rows; i++)
            for(int j=0; j < columns; j++){
                newArr[j][i] = A[i][j];
            }
        return newArr;
    }
} 
