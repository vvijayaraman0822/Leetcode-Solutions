// 118. Pascal's Triangle

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> outputList = new ArrayList<>();
        
        if (numRows == 0) {
            return outputList;
        }
        
        List<Integer> innerList = new ArrayList<>();
        innerList.add(1); // First row is always one, insert it manually
        outputList.add(innerList);
        
        for(int i=1; i < numRows; i++) {
            
            List<Integer> prevRow = outputList.get(i-1); // get previous Row
            List<Integer> currRow = new ArrayList<>();
            currRow.add(1); // every row starts with, so add a 1
           
            for(int j = 1; j < i; j++) {
                currRow.add(prevRow.get(j) + prevRow.get(j-1)); // every column is the sum of prev row's (same index) + (index -1)
            }
          
            currRow.add(1); // every row ends with 1, so add a 1
            outputList.add(currRow);    
            
        }
        
        return outputList;
        
    }
}