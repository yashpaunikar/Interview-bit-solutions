// approach 1: sort
// approach 2: use a count array to mark presence
// approach 3: us ebelow approach. o(n), o(1).
/*
It may be helpful to use the fact that the size of the set we are looking to track is [1, N]
which happens to be the same size as the size of the array.
This means we can use the array to track these elements.
We traverse the array and if A[i] is in [1,N] range, we try to put in the index of same value in the array.
*/
public class Solution {
    public int firstMissingPositive(int[] A) {
        int n = A.length;
        for(int i = 0; i < n; i++){
            int num = A[i];
            int pos = num  - 1;
            if(pos >= 0 && pos < n && A[pos] != num){
                int temp = num;
                A[i] = A[pos];
                A[pos] = temp;
                i--;
            }
        }
        for(int i = 0; i < n; i++){
            if(A[i] != i+1) return i+1;
        }
        return n+1;
    }
}
