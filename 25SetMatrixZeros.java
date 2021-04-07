/*
Given a matrix, A of size M x N of 0s and 1s. 
If an element is 0, set its entire row and 
column to 0.
Input :
    [   [1, 0, 1],
        [1, 1, 1],
        [1, 0, 1]   ]
Output :
    [   [0, 0, 0],
        [1, 0, 1],
        [0, 0, 0]   ]
*/

/*
brute -
create a vector of pair
traverse the matrix first save 
the indices where 0 is there.

Next, traverse the vector to 
go a particular indices and set its col
and row as 0.
this approach takes o(M*N) + o(M*N)*(M+N).
time and o(M*N) space. 
*/

/*
Optimal- make two boolean auxiliary arrays 
corresponding to row and column.
Traverse the matrix, when you see a '0'
mark true corresponding to index in 
the auxiliary array

Traverse the matrix again. If any of 
the corresponding row or column is 
set to be true in auxiliary array
set that particular index as 0. 
Uses- o(M*N) + o(M*N)time and o(M+N)
	  extra space.
*/

public class Solution {
    public void setZeroes(ArrayList<ArrayList<Integer>> a) {
        int m=a.size();
        int n=a.get(0).size();
        //2 auxiliary arrays
        boolean row[] = new boolean[a.size()];
        boolean col[] = new boolean[a.get(0).size()];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(a.get(i).get(j)==0){
                    row[i]=true;
                    col[j]=true;
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
              if(row[i]||col[j]) a.get(i).set(j,0);
            }
        }
	}
}

/*
Best- Instead of using 2 extra arrays
use 1st col as aux array and
use 1st row as other aux array.
Runs in o(1) space.

iterate over the first row.
-if zero found then then the row will
be zero finally. 
iterate over the first col.
-if zero found then then the col will
be zero finally.

iterate over the whole matrix to see
to mark 0 in first row or column

Iterate over the submatix(starting at 1,1) leaving 
out the first row and first col.
*/

public class Solution {
    public void setZeroes(ArrayList<ArrayList<Integer>> matrix) {
        boolean firstRow = false;
        boolean firstCol = false;
        
        //check first row for zero
        for (int i=0;i<matrix.size();i++) {
            if (matrix.get(i).get(0) == 0) {
                firstCol = true;
                break;
            }
        }
        
        //check first col for zero
        for (int i=0;i<matrix.get(0).size();i++) {
            if (matrix.get(0).get(i) == 0) {
                firstRow = true;
                break;
            }
        }
        
        //iterate over the whole matrix to see
        //to mark 0 in first row or column
        for (int i=0;i<matrix.size();i++) {
            for (int j=0;j<matrix.get(0).size();j++) {
                if (matrix.get(i).get(j) == 0) {
                    matrix.get(i).set(0, 0);
                    matrix.get(0).set(j, 0);
                }
            }
        }
        
        //iterate over the submatrix see if 1st col
        //or row is zero, if it is mark that index as 
        //zero
        for(int i=1; i<matrix.size(); i++){
            for(int j=1; j<matrix.get(i).size(); j++){
                if(matrix.get(i).get(0) == 0 || matrix.get(0).get(j) == 0){
                   matrix.get(i).set(j, 0);
                }
            }
        }
        //change first col to 0s if boolean variable is true
        if(firstCol){
            for(int i=0; i<matrix.size(); i++)
                matrix.get(i).set(0,0);
        }
        //change first row to 0s if boolean variable is true
        if(firstRow){
            for(int i=0; i<matrix.get(0).size(); i++)
                matrix.get(0).set(i, 0);
        }
    }
}
