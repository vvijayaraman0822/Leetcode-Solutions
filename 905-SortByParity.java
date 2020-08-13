/* 
Leetcode problem #905 (Sort Array By Parity)
- Create odd & even list 
- Itierate through the array. If odd, add in odd list & if even, add in even list
- Combine both lists and convert into an array
- Return array
*/

class Solution {
    public int[] sortArrayByParity(int[] A) {
        List<Integer> oddList = new ArrayList<Integer>();
        List<Integer> evenList = new ArrayList<Integer>();
        for(int i = 0; i < A.length; i++){
            if(A[i] % 2 == 0)
                evenList.add(A[i]);
            else
                oddList.add(A[i]);
        }
    evenList.addAll(oddList);
  //System.out.print(evenList);
   for(int i = 0; i < evenList.size(); i++){
       A[i] = evenList.get(i);
   }
    
      return A;
        
    }
}
