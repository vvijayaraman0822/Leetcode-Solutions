// 57. Insert Interval

class Interval {
    int start;
    int end;
    
    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
          if (intervals == null || intervals.length == 0) {
            return new int[][]{newInterval};
        }
        
        
        // Add the sorted array into the LinkedList
        LinkedList<Interval> list = new LinkedList<>();        
        boolean shouldInsert = true;
        for (int[] arr : intervals) {
            if (intervals.length == 1 && arr[0] <= newInterval[0]) {
                list.add(new Interval(arr[0], arr[1]));
                list.add(new Interval(newInterval[0], newInterval[1]));
                break;
            }
             
           if (arr[0] > newInterval[0] && shouldInsert) {
               list.add(new Interval(newInterval[0], newInterval[1]));
               shouldInsert = false;
           }
            list.add(new Interval(arr[0], arr[1]));
        }
        
        if (shouldInsert == true) {
           list.add(new Interval(newInterval[0], newInterval[1]));
        }
               
                
        // Final LinkedList
        LinkedList<Interval> result = new LinkedList<>();
        for(Interval current : list) {
            if (result.isEmpty() || result.getLast().end < current.start) {
               result.add(current); 
            } else {
                result.getLast().end = Math.max(result.getLast().end, current.end);
            }            
        }
        
        // Add from LinkedList to an array for final output
        int[][] answer = new int[result.size()][2];
        int counter = 0;
        for (Interval a : result) {
            answer[counter][0] = a.start;
            answer[counter][1] = a.end;
            counter++;
        }        
        
        return answer;        
        
    }
}