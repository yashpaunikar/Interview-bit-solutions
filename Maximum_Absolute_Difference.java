/*
f(i, j) = |A[i] - A[j]| + |i - j| can be written in 4 ways 
(Since we are looking at max value, we don’t even care if 
the value becomes negative as long as we are also covering 
the max value in some way).

1) (A[i] + i) - (A[j] + j)
2) -(A[i] - i) + (A[j] - j) 
3) (A[i] - i) - (A[j] - j) 
4) (-A[i] - i) + (A[j] + j) = -(A[i] + i) + (A[j] + j)
Note that case 1 and 4 are equivalent and so are case 2 and 3.
*/

public class Solution {
    public int maxArr(int[] A) {
        int max1 = Integer.MIN_VALUE; //(A[i] + i)
        int max2 = Integer.MIN_VALUE; //(A[i] - i)
        int min1 = Integer.MAX_VALUE; //(A[i] + i)
        int min2 = Integer.MAX_VALUE; //(A[i] - i)
        
        for(int i = 0; i < A.length; i++){
            max1 = Math.max(A[i]+i, max1);
            min1 = Math.min(A[i]+i, min1);
            
            max2 = Math.max(A[i]-i, max2);
            min2 = Math.min(A[i]-i, min2);
        }
        return Math.max(max1-min1, max2-min2);
    }
}
