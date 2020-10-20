// 4. Median of Two Sorted Arrays

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //if input1 length is greater than switch them so that input1 is smaller than input2.
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int x = nums1.length;
        int y = nums2.length;

        int low = 0;
        int high = x;
        
        while (low <= high) {
            int partitionX = (low + high)/2;
            int partitionY = (x + y + 1)/2 - partitionX; // +1 so it works for both even and odd size
            
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1]; // if there are no values on the left of partition, then set it to MIN
            int minRightX = (partitionX == x) ? Integer.MAX_VALUE : nums1[partitionX]; // if there are no values on the left of partition, then set it to MAX
            
            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1]; // if there are no values on the left of partition, then set it to MIN
            int minRightY = (partitionY == y) ? Integer.MAX_VALUE : nums2[partitionY];  // if there are no values on the left of partition, then set it to MAX
            
              if (maxLeftX <= minRightY && maxLeftY <= minRightX) { // if this condition satsifies, then array is sorted
               if ((x + y) % 2 == 0) {
                    return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2.0;
                } else {
                    return Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) { //we are too far on right side for partitionX. Go on left side.
                high = partitionX - 1;
            } else { //we are too far on left side for partitionX. Go on right side.
                low  = partitionX + 1;
            }
        }
        
        
        throw new IllegalArgumentException();    
        
        
    }
}