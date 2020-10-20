// 692. Top K Frequent Words

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i=0; i < words.length; i++) {
            if (map.containsKey(words[i])) {
                map.put(words[i], map.get(words[i]) + 1);
            } else {
                 map.put(words[i], 1);
            }
        }
        
        List<String> output = new ArrayList<>(map.keySet());
        Collections.sort(output, (word1, word2) -> {
            int comparison = map.get(word2).compareTo(map.get(word1));
            if (comparison == 0) {
                return word1.compareTo(word2);
            }
            return comparison;
        });
               
        return output.subList(0, k);
    }
}