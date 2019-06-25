/* 412 - Fizz Buzz
- Simple, just read the questions and have if & else conditions
- Be careful as to what order you do the if conditions in
*/


class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> answer = new ArrayList<String>();
        for(int i = 1; i <= n; i++){
            if (i % 3 == 0 && i % 5 == 0)
                answer.add("FizzBuzz");
            else if (i % 5 == 0)
                answer.add("Buzz");
            else if (i % 3 == 0)
                answer.add("Fizz");
            else
                answer.add(Integer.toString(i));
        }
        return answer;
    }
}