// 350. Intersection of Two Arrays II

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
       List<Integer> finalList = new ArrayList<>();
       HashMap<Integer, Integer> countMap = new HashMap<>();
        
        for (int i = 0; i < nums1.length; i++) {
            if (countMap.containsKey(nums1[i])) {
                countMap.put(nums1[i], countMap.get(nums1[i]) + 1);
            } else {
                countMap.put(nums1[i], 1);
            }
        }
        
        for (int i = 0; i < nums2.length; i++) {
            if (countMap.containsKey(nums2[i]) && countMap.get(nums2[i]) >= 1) {
                finalList.add(nums2[i]);
                countMap.put(nums2[i], countMap.get(nums2[i]) - 1);
            }
        }
        
        int[] outputArray = new int[finalList.size()];
        for(int i = 0; i < finalList.size(); i++) {
            outputArray[i] = finalList.get(i);
        }
        
        return outputArray;
    }
}