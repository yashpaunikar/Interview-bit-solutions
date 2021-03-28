/*
Triplets with Sum between given range

Solution 1: brute- generate all possible triplets and check their sum o(n^3).
Solution 2: o(nlogn) + o(n^2) using 2 pointer gives TLE
Solution 3:  passes AC.
*/

//optimised
 public class Solution {
    public int solve(ArrayList<String> A) {
        //take variables a,b,c and assign it with first 3 numbers
        double a = Double.parseDouble(A.get(0)); 
        double b = Double.parseDouble(A.get(1)); 
        double c = Double.parseDouble(A.get(2)); 
        // excute the loop from index 3 onwards
        for(int i = 3; i < A.size(); i ++){
            // check if sum fall in (1, 2)
            if((a+b+c) > 1 && (a+b+c) < 2){
                return 1;
            }
            // if not, then check is sum greater then 2
            // if so, then replece MAX(a,b,c) to new number
            else if((a+b+c) >= 2){
                if(a > b && a > c){
                    a = Double.parseDouble(A.get(i));
                }
                else if( b > c){
                    b = Double.parseDouble(A.get(i));
                }
                else{
                    c = Double.parseDouble(A.get(i));
                }
            }
            // else then sum must be less than 1
            // then replece MIN(a,b,c) to new number
            else{
                if(a < b && a < c){
                    a = Double.parseDouble(A.get(i));
                }
                else if( b < c){
                    b = Double.parseDouble(A.get(i));
                }
                else{
                    c = Double.parseDouble(A.get(i));
                }
            }
        }
        // check for last a, b, c  pair
        if((a+b+c) > 1 && (a+b+c) < 2){
            return 1;
        }
        else{
            return 0;
        }
    }
}

//////////////////////////////
//similar to 2 pointer 
public class Solution {
    public int solve(ArrayList<String> A) {
        ArrayList<Double> ar=new ArrayList<Double>();
        for(int i=0;i<A.size();i++)
            ar.add(Double.parseDouble(A.get(i)));
            
        int l=0,m=1,h=A.size()-1;
        Collections.sort(ar);
        while(l<h && m<h)
        {   Double sum=ar.get(l)+ar.get(m)+ar.get(h);
            if(sum>1.0 && sum<2.0)
            {
                return 1;
            }
            
            else if(sum>=2)
            {
                h--;
            }
            else
            {
                l++;
                m++;
            }
        }
        return 0;
    }    
}
// suboptimal Solution
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


























