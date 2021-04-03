/*
BEAUTIFUL PROBLEM !!
You are given a binary string(i.e. with characters 0 and 1) 
S consisting of characters S1, S2, …, SN. In a single operation, 
you can choose two indices L and R such that 1 ≤ L ≤ R ≤ N and flip 
the characters SL, SL+1, …, SR. By flipping, we mean change character 
0 to 1 and vice-versa.

eg-
S = 010
Pair of [L, R] | Final string
_______________|_____________
[1 1]          | 110
[1 2]          | 100
[1 3]          | 101
[2 2]          | 000
[2 3]          | 001
We see that two pairs [1, 1] and [1, 3] give same 
number of 1s in final string. So, we return [1, 1].

If S = 111
No operation can give us more than three 1s in final string. 
So, we return empty array [].
*/

// to solve this problem, if you observe keenly
// we shud be able to find a subarray which has
// max(count of 0 - count of 1) then we will be able to 
// find such L and R.

// Brute - generate all subarrays ans get max value 
// count of 0 - count of 1

// optimised- Kadane's variant. Maintain a count & maxcount
// incr count when you see 0 and decr otherwise.

public class Solution {
    public ArrayList<Integer> flip(String A) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        int start = 1; // indicates
        result.add(0);
        result.add(0);
        int count = -1;
        boolean all1 = true;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<A.length();i++){
            if(count<0){
              count = 0;
              start = i+1;
            }
            char c = A.charAt(i);
            if(c=='0'){
              count++;
              all1 = false;
            }
            else
              count--;
            
            if(count>max){
                max = count;
                result.set(0,start);
                result.set(1,i+1);
            }
        }
        if(all1)
        return new ArrayList<Integer>();
        return result;
    }
}
