// 56. Merge Intervals

class Intervals {
    int start;
    int end;
    public Intervals(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <=1) {
             return intervals;
        }
        // Add all the elements into a linked list and sort it in an ascending order
        LinkedList<Intervals> list = new LinkedList<>();        
        for (int[] temp : intervals) {
            list.add(new Intervals(temp[0], temp[1]));
        }
        
        // This will sort in ascending order based on the Interval start time or end time
        Collections.sort(list, new Comparator<Intervals>() {
            @Override
            public int compare(Intervals a, Intervals b) {
                return a.start - b.start;
            }
        });
        
        // Traverse through the sorted linked list and merge appropriately
        LinkedList<Intervals> result = new LinkedList<>();    
        for(Intervals current : list) {
            if (result.isEmpty() || result.getLast().end < current.start) {
                result.add(current);
            } else {
                result.getLast().end = Math.max(result.getLast().end, current.end);
            }
        }
        
        int[][] answer = new int[result.size()][2];
        int count = 0;
        for(Intervals ans : result) {
            answer[count][0] = ans.start;
            answer[count][1] = ans.end;
            count++;
        }
                                
        return answer;
        
    }
}