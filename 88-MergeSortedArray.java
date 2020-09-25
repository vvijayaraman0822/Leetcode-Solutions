// 88. Merge Sorted Array

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) { 
        int aEndPointer = nums1.length-1; // end of first array
        int aMergePointer = m-1; // point where last element of actual value in num1 is for which to compare against
        int bEndPointer = n-1; // end of second array
        
        while(aMergePointer >=0 && bEndPointer >=0) {
            if (nums2[bEndPointer] > nums1[aMergePointer]) {
                nums1[aEndPointer] = nums2[bEndPointer];
                aEndPointer--;
                bEndPointer--;
            } else {
                nums1[aEndPointer] = nums1[aMergePointer];
                aEndPointer--;
                aMergePointer--;
                
            }       
        }
        
        while(bEndPointer >= 0) {
            nums1[aEndPointer] = nums2[bEndPointer];
             aEndPointer--;
             bEndPointer--;
        }
    }
}