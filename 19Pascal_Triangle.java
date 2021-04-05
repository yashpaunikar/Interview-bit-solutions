/*
Given numRows, generate the first numRows of Pascal’s triangle.
Pascal’s triangle : To generate A[C] in row R, sum up A’[C] and A’[C-1] from previous row R - 1.

Example:
Given numRows = 5,
Return
[
     [1],
     [1,1],
     [1,2,1],
     [1,3,3,1],
     [1,4,6,4,1]
]

*/

/*
Same logic as for nth row of pascal's triangle
*/

public class Solution {
    public ArrayList<ArrayList<Integer>> solve(int A) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<>>();
        
        // arraylist to store previous row of the pascal's
        // triangle
        ArrayList<Integer> prev = new ArrayList<Integer>();
        for(int i = 0; i < A; i++){
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for(int j = 0; j <= i; j++){
                if(j == 0 || j == i)
                    temp.add(1);
                else
                    temp.add(prev.get(j) + prev.get(j-1));
            }
            res.add(temp);
            prev = temp;
        }
        return res;
    }
}

// Without using previous row

public class Solution {
    public ArrayList<ArrayList<Integer>> solve(int A) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        
        for(int i = 0; i < A; i++){
            ArrayList <Integer> ar = new ArrayList<>();
            
            for(int j = 0; j <= i; j++){
                if(j == 0 || j == i){
                    ar.add(1);
                } else {
                    ar.add(ans.get(i - 1).get(j) + ans.get(i - 1).get(j - 1));
                }
            }
            ans.add(ar);
        }
        return ans;
    }
}
