// 451. Sort Characters By Frequency

class Solution {
    public String frequencySort(String s) {
        if(s ==  null || s.length() == 0) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if (countMap.containsKey(a)) {
               countMap.put(a, countMap.get(a) + 1); 
            } else {
                countMap.put(a, 1);
            }
        }
        
        // Put all the frequency in the desired bucket - example "tree" -> ee(2) should be in bucket 2
        List<Character>[] arr = new List[s.length() + 1];
        for (char a : countMap.keySet()) {
            int count = countMap.get(a);
            if (arr[count] == null) {
                arr[count] = new ArrayList<>();
            }
            arr[count].add(a);
        }
        
        for (int i = arr.length - 1; i >=0; i--) {
                if (arr[i] != null) {
                    for (char a : arr[i]) {
                        int count = i;
                        for (int j = 0; j < count; j++) {
                            sb.append(a);
                        }
                    }
                }
        }
        
        return sb.toString();
    }
}
            