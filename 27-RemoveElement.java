class Solution {
    public int removeElement(int[] nums, int val) {
        int startIndex = 0;
        int endIndex = nums.length;
            while(startIndex < endIndex){
            if(nums[startIndex] == val) {
                nums[startIndex] = nums[endIndex-1];
                endIndex--;
            } else {
                 startIndex++;
            }
            }
        return endIndex;     
    }
}