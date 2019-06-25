/* Leetcode 832 - Flipping an Image
- Go through every row and interchange first & last indices, second & second last so on
- AFter that loop, if 1 make elements 0, if 0 make elements 1
- Return new array
*/

class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        for(int i=0; i < A.length; i++){
            int j = 0;
            int k = A[i].length-1;
            while(j < k){
                int temp = A[i][j];
                A[i][j++] = A[i][k];
                A[i][k--] = temp;
                             
            } 
            
            for(int l = 0; l < A[i].length; l++){
                if(A[i][l] == 0)
                    A[i][l] = 1;
                else
                    A[i][l]= 0;
            }
            
        }
        

        return A;
    }
}