/*
Given a positive integer n and a string s consisting 
only of letters D or I, you have to find any 
permutation of first n positive integer that 
satisfy the given input string.
Input 1:
n = 3
s = ID
Return: [1, 3, 2] we can see 1 increases to 3 seeing 'I'
        then 3 decreases to 2 as it sees 'D'
*/

/*
// My own approach
Approach intuition-The last I will always yield
maximum
take this test case- s=IDIDDID, Is=3; Ds=4; s.length()=7
length of permutation (n) = 8
Begin array with n-Is = beg = 8-3 = 5, push beg to ans
First D seen will have value of no. of Ds = dbeg = 4

now whenever you see a I increment beg and push beg.

whenever you see a D push dbeg and decrement dbeg.

              I D I D D I D
ans will be 5 6 4 7 3 2 8 1
*/
// takes o(2n) time.
vector<int> Solution::findPerm(const string s, int n) {
    int iCount = 0;
    int dCount = 0;
    for(int i = 0; i < s.length(); i++){
        if(s[i] == 'I')
            iCount++;
        else
            dCount++;
    }
    vector<int> ans;
    int beg = n - iCount;
    int dbeg = dCount;
    
    ans.push_back(beg);
    beg++;
    
    for(int i = 0; i < s.length(); i++){
        if(s[i] == 'I'){
            ans.push_back(beg);
            beg++;
        }else{
            ans.push_back(dbeg);
            dbeg--;
        }
    }
    return ans;
}

//Another Soln in one pass
public class Solution {
    public ArrayList<Integer> findPerm(final String A, int B) {
        
        int smallest =1;
        int largest = B;
        ArrayList<Integer> op = new ArrayList<Integer>();
        for(int i=0;i<A.length();i++)
        {
            if(A.charAt(i)=='D')
            {
                op.add(largest);
                largest = largest -1;
            }
            else
            {
                op.add(smallest);
                smallest = smallest+1;
            }
        }
        
        op.add(smallest);
        return op;
    }
}

