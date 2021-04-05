/*
You are given an n x n 2D matrix representing an image.
Rotate the image by 90 degrees (clockwise).
You need to do this in place.
Note that if you end up using an additional array,
you will only receive partial score.

Example:
If the array is
[
    [1, 2],
    [3, 4]
]
Then the rotated array becomes:
[
    [3, 1],
    [4, 2]
]
*/

// take transpose and then reverse each row
void Solution::rotate(vector<vector<int> > &A) {
    // take transpose and reverse each row
    for(int i = 0; i < A.size(); i++){
        //j will start from i as we dont want
        //additional swaps which will make 
        //matrix as it was earlier.
        for(int j = i; j < A[0].size(); j++){
            swap(A[i][j], A[j][i]);
        }
    }
    
    //reverse each row in the transposed matrix
    for(int i = 0; i < A.size(); i++){
        int left = 0;
        int right = A[i].size()-1;
        while(left < right){
            swap(A[i][left], A[i][right]);
            left++;
            right--;
        }
    }
}
