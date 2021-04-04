/*
hotel has C rooms. Bookings contain an arrival 
date and a departure date. find whether there are 
enough rooms in the hotel to satisfy the demand. 
Write a program that solves this problem in 
time O(N log N) .
*/

/*
naiive-
Approach: The idea is to take every interval one 
by one and find the number of intervals that overlap 
with it. Keep track of the maximum number of intervals 
that overlap with an interval. Check if max intervals 
found are greater than K. If greater return false.

Algorithm: 
Run two nested loops the outer loop from start 
to end and inner loop from i+1 to end.
For every iteration of outer loop find the 
count of intervals that intersect with the current 
interval.
Update the answer with maximum count of 
overlap in each iteration of outer loop.
*/

//2 pointer approach where we do not see overlaps 
//rather we see timeline to asses number of
//rooms at anytime.
public class Solution {
    public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
        int n = arrive.size();
        Collections.sort(arrive);
        Collections.sort(depart);
        //first room occupied so i is 
        //set to 1. Set j = 0, as we are yet 
        //to see if the room has been vacated
        //or not.
        int roomsNeeded = 1, result = 1;
        int i = 1, j = 0;
        
        while(i < n && j < n){
            if(arrive.get(i) < depart.get(j)){
                roomsNeeded++;
                i++;
            }
            //equality here means, for eg.-
            //Iam allowed to arrive at the same 
            //time when other departs.
            else if(arrive.get(i) >= depart.get(j)){
                roomsNeeded--;
                j++;
            }
        
            if(roomsNeeded > result)
                result = roomsNeeded;
        }
        return result <= K;
    }
}
