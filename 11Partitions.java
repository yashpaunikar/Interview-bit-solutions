/*
Approach link- https://www.youtube.com/watch?v=yEYi1lNMHE0&ab_channel=AnmolGera
maintain count of sumofarray/3 and 2*sumofarray/3
iterate till 2nd last element
get count of number of times you encounter sum/3
After that whenever we encounter 2*sum/3 we add 
count of sum/3 to it.
Finally, we will get number of partitions possible
*/

public class Solution {
    public int solve(int A, int[] B) {
        int sum = 0;
        for(int i=0; i<B.length; i++){
            sum += B[i];
        }
        // if not divisible by 3 then
        // no solution exists
        if(sum % 3 != 0) return 0;
        
        int countSumBy3 = 0;
        int count2SumBy3 = 0;
        int sum1 = 0;
        // We are only checking counts of
        // sum/3 and 2sum/3 so we need atleast 
        // 1 element to complete the partition
        // thats why we go till 2nd last element
        for(int i = 0; i < B.length-1; i++){
            sum1 += B[i];
          //everytime we encounter 2*sum/3 we add 
          //count of sum/3 to it
            if(sum1 == 2*sum/3){
                count2SumBy3 += countSumBy3;
            }
            if(sum1 == sum/3){
                countSumBy3++;
            }
        }
        return count2SumBy3;
    }
}
