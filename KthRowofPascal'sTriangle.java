//Brute o(k^2) solution
public class Solution {
    public ArrayList<Integer> getRow(int A) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        res.add(1);
        if(A == 0) return res;
        res.add(1);
        if(A == 1) return res;
        for(int i = 2; i <= A; i++){
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for(int j = 0; j<=i; j++){
                if(j == 0 || i == j)
                    temp.add(1);
                else
                    temp.add(res.get(j) + res.get(j-1));
            }
            res = temp;
        }
        return res;
    }
}

// optimised o(k)
// nth row of pascal's triangle has n+1 elements
// ith element of the ath row of pascal's triangle is given by (a+1-i)*((i-1)th element)/i;
public class Solution {
	public ArrayList<Integer> getRow(int a) {
	    ArrayList<Integer> res = new ArrayList<Integer>();
	    res.add(1);
	    for(int i=1; i<=a; i++){
	        int num = (a+1-i)*res.get(i-1)/i;
	        res.add(num);
	    }
	    return res;
	}
}



