/*
Given a collection of intervals, merge all overlapping intervals.
For example:
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
Make sure the returned intervals are sorted.
*/
/*
Brute- Sort the interval then for each 
interval check if it merges with any interval 
or not. o(nlogn) + o(n^2)
*/
/*
optimal- Sort the interval
run a loop thru the array
check if current's end >= ith's start
if satisfied merge them
*/


/**
 * Definition for an interval.
 * struct Interval {
 *     int start;
 *     int end;
 *     Interval() : start(0), end(0) {}
 *     Interval(int s, int e) : start(s), end(e) {}
 * };
 */
bool comp(Interval a,Interval b){
        return a.start<b.start;
    } 
vector<Interval> Solution::merge(vector<Interval> &A) {
    sort(A.begin(), A.end(), comp); //sort acc. to start
    
    vector<Interval> ans;
    
    ans.push_back(A[0]);
    
    for(int i=1;i<A.size();i++){
        if(ans.back().end>=A[i].start){
            //need to merge here
            ans.back().end=max(ans.back().end,A[i].end);
        }
        // no merge here so push it into
        // ans vector
        else ans.push_back(A[i]);
    }
    return ans;
}
