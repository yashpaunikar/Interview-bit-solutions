/*
Triplets with Sum between given range

Solution 1: brute- generate all possible triplets and check their sum o(n^3).
Solution 2: o(nlogn) + o(n^2) using 2 pointer
Solution 3: Bucketing. 
*/

//Bucketing



////////////////////////////////////
// o(nlogn) + o(n^2) using 2 pointer
public class Solution {
    public int solve(ArrayList<String> A) {
        //two pointer approach reduces time complexity to o(n^2)
        Double num[] = new Double[A.size()];
        for(int i = 0; i < A.size(); i++){
            num[i] = Double.parseDouble(A.get(i));
        }
        
        Arrays.sort(num);
        if(tripletSum(num)) return 1;
        return 0;
    }
    
    private boolean tripletSum(Double[] num){
        for(int i = 0; i <= num.length-3; i++){
            // check triplets.
                int j = i+1;
                int k = num.length - 1;
                while(j != k){
                    if(num[i] + num[j] + num[k] >= 2){
                        k--;
                    }else if(num[i] + num[j] + num[k] <= 1){
                        j++;
                    }else{
                        return true;
                    }
                }
        }
        return false;
    }
}


























