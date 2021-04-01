Covering the following cases :

1) Size of interval array as 0.
2) newInterval being an interval preceding all intervals in the array.
3) newInterval being an interval succeeding all intervals in the array.
4) newInterval not overlapping with any interval and falling in between 2 intervals in the array.
5) newInterval covering all given intervals.

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        Interval current = newInterval;
        int i = 0;
        while(i < intervals.size()){
            Interval in = intervals.get(i);
            if(in.end < current.start){
                //completely succeeding
                i++;
            }else if(in.start > current.end){
                //completely preceding
                intervals.add(i, current);
                break;
            }else{
                // all other cases
                // this combines the intervals 
                // so they might fall under the above 
                // 2 cases eventually
                current.start = Math.min(in.start, current.start);
                current.end = Math.max(in.end, current.end);
                // remove the ith interval as it will be 
                // replaced later
                intervals.remove(i);
            }
        }
        if(i == intervals.size()){
            intervals.add(current);
        }
        return intervals;
    }
}
