// 720. Longest Word in Dictionary

class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words);
        Set<String> set = new HashSet<>();
        
        String answer = ""; // return empty string if none found
        for (String word : words) {
            if (word.length() == 1 || set.contains(word.substring(0, word.length() - 1)) ) { // check if set contains the word except the last letter
                if (word.length() > answer.length()) {  // set new word only if the new word's length is greater than current answer
                answer = word;
                }
                set.add(word);
            }
        }
        return answer;
    }
}