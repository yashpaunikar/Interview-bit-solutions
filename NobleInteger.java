/*Given an integer array A, find if an integer 
p exists in the array such that the number of 
integers greater than p in the array equals 
to p.*/

// brute check for every element. o(n^2)
// solution in o(nlogn) sorting below
// Dry run to understand the logic
public class Solution {
    public int solve(ArrayList<Integer> A) {
        Collections.sort(A);
        for(int i = 0; i < A.size()-1; i++){
            //ignore duplicates
            if(A.get(i) == A.get(i+1)) 
                continue;
            //check number of element greater 
            //if not duplicate
            if(A.get(i) == A.size()-1-i)
                return 1;
        }
        // for a case like this, -1, -2, -3, -4, 0
        // here last is 0. The condition that 
        // there are 0 elements greater 0 holds
        // so we have to handle corner case below
        if(A.get(A.size()-1) == 0)
            return 1;
        return -1;
    }
}
