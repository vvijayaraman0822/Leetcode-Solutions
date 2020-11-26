// 49. Group Anagrams

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> finalList = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            finalList.add(new ArrayList<>());
            return finalList;
        } 
        
        if (strs.length == 1) {
            List<String> innerList = new ArrayList<>();
            innerList.add(strs[0]);
            finalList.add(innerList);
            return finalList;
        }
        
        Map<String, List<String>> map =new HashMap<>();
        
        for (String str : strs) {
            char[] chars = str.toCharArray(); 
            Arrays.sort(chars);
            String key = new String(chars);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            } 
            
            map.get(key).add(str);
        }
        
        finalList.addAll(map.values());
        return finalList;
    }
}