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
        // if all elements are zero then always true
        // if all elements are negative and one zero
        // return true
        if(A.get(A.size()-1) == 0)
            return 1;
        return -1;
    }
}
