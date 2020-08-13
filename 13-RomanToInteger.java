// 13. Roman to Integer
class Solution {
    public int romanToInt(String s) {
            int sum = 0;
            Map<Character, Integer> romanKeys = new HashMap<>();
            romanKeys.put('I', 1);
            romanKeys.put('V', 5);
            romanKeys.put('X', 10);
            romanKeys.put('L', 50);
            romanKeys.put('C', 100);
            romanKeys.put('D', 500);
            romanKeys.put('M', 1000);

            for (int i = 0; i < s.length(); i++) {
                if (i > 0 && romanKeys.get(s.charAt(i)) > romanKeys.get(s.charAt(i - 1))) {
                    sum += romanKeys.get(s.charAt(i)) - (2 * romanKeys.get(s.charAt(i - 1)));
                } else {
                    sum += romanKeys.get(s.charAt(i));
                }
            }
            return sum;
        }
    }
                    