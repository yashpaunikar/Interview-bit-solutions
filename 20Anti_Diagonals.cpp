/*
Perform diagonal traversal like------>
Input: 	
1 2 3
4 5 6
7 8 9
Return the following :
[ 
  [1],
  [2, 4],
  [3, 5, 7],
  [6, 8],
  [9]
]
*/

/*
1 2  3   4    00 01 02 03
5 6  7   8    10 11 12 13   the martix and corresponding
9 10 11 12    20 21 22 23   indices
13 14 15 16   30 31 32 33

Solve this in 2 parts--
1- solve left upper triangular matrix
2- then solve remaining

try to see the relation between indices
and then start printing.
*/

//Solved by me and me alone!!!!!!
vector<vector<int> > Solution::diagonal(vector<vector<int> > &A) {
    int n = A.size();
    vector<vector<int> > ans;
    
    for(int i = 0; i <= n-1; i++){
        vector<int> temp;
        int col = i;
        for(int row = 0; col >= 0; row++, col--){
            temp.push_back(A[row][col]);
        }
        ans.push_back(temp);
    }
    
    for(int i = 1; i <= n-1; i++){
        vector<int> temp;
        int row = i;
        for(int col = n-1; row <= n-1; row++, col--){
            temp.push_back(A[row][col]);
        }
        ans.push_back(temp);
    }
    
    return ans;
}
