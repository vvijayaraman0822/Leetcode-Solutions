/* 557 - Reverse Words in a String III */

class Solution {
    public String reverseWords(String s) {
        char [] arr = s.toCharArray();
        int start = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == ' '){
                reverse(arr, start, i-1 );
                start = i+1;
            }
            else if(arr.length-1 == i)
                reverse(arr, start, i);
        }
            
            return String.valueOf(arr);
        }
        
       
    public void reverse(char[] a, int start, int end){
        while (start < end){
            char temp = a[start];
            a[start++] = a[end];
            a[end--] = temp;
            
        }
    }  
    
}