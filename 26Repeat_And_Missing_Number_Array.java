/*
You are given a read only array of n 
integers from 1 to n.Each integer appears 
exactly once except A which appears twice 
and B which is missing.
Return A and B.
Note: Your algorithm should have a linear 
runtime complexity. Could you implement it
without using extra memory?
Note that in your output A should precede B.
Example:
Input:[3 1 2 5 3] 
Output:[3, 4] 
A = 3, B = 4
*/
/*
brute - use hashing to mark presence of 
number
optimal - use sum and sum of squares to 
solve the problem take care of overflows
*/
/*
Best- This can be solved using bit 
manipulation 
*/
public class Solution {
    public int[] repeatedNumber(final int[] A) {
    	int n = A.size();
    	long sum = 0;
    	long sumOfSquares = 0;
    	for(int i = 0; i < A.size(); i++){
    		sum += A.get(i);
    		sumOfSquares += A.get(i) * A.get(i);
    	}

    	long nSum = (n * (n+1))/2;
    	long nSqSum = (n * (n+1) * (2*n + 1))/6

    	long k = sum - nSum;
    	long m = sumOfSquares - nSqSum;

    	long x = (k+m/k)/2;
    	long y = x - k;

    	int res[] =  new int[2];
    	res[0] = int(x);
    	res[1] = int(y);

    	return res;
    }
}
