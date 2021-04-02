/*
O(n^3) solution is simple.
You look at every pair (i,j) and compute the sum of elements between i and j and then take the maximum of the sums.
Obviously, this is not the best solution.
Next improvement is O(n^2) when you notice that you don’t need to sum up all the elements between i and j. 
You can just add A[j] to the sum you have already calculated in the previous loop from i to j-1.
However, we are looking for something better than N^2.
*/

//Most optimal Kadane's algo runs in o(n).
//Note that no prefix of the solution will ever have a negative sum.
public class Solution {
    
    public int maxSubArray(final List<Integer> A) {
        int max = A.get(0);
        int gmax = A.get(0);
        
        for(int i = 1; i<A.size(); i++){
            max = Math.max(A.get(i), max + A.get(i));
            gmax = Math.max(max, gmax);
        }
        return gmax;
    }
}

//Another implementation of kadane
public class Solution {
    public int maxSubArray(final int[] A) {
        int max = A[0];
        int gmax = A[0];
        
        for(int i = 1; i < arr.length; i++){
            //Note that no prefix of the solution 
            //will ever have a negative sum.
            if(max >= 0)
                max += A[i];
            else
                max = A[i];
            
            if(max > gmax)
                gmax = max;
        }
        return gmax;
    }
}
