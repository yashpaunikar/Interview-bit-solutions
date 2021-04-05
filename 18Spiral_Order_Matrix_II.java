/*                          |
                            | right  
  top-->*********************
        *                   *
        *                   *
        *                   *
        *                   *
        *********************<--bottom
        ^
        |left
        
        traversal has to be from left to
        right. top to bottom....
        
        Input 1:
         A = 3

        Output 1:
    [   [ 1, 2, 3 ],
        [ 8, 9, 4 ],
        [ 7, 6, 5 ]   ]
*/

public class Solution {
    public int[][] generateMatrix(int n) {
        int a[][] = new int[n][n];
        int top=0;
        int left=0;
        int right=n-1;
        int bottom=n-1;
        int c=1;
        while(c<=n*n){
          // if dimensions are not symmertrical 
          // additional conditions are needed
          //c <= n*m
          // for(int i=top;i<=right&&c <=n*m; i++)
            for(int i=top;i<=right;i++ ){ 
                a[top][i]=c;c++;
            }
            top++;
            for(int i=top;i<=bottom;i++){
                a[i][right]=c;c++;
            }
            right--;
            for(int i=right;i>=left;i--){
                a[bottom][i]=c;c++;
            }
            bottom--;
            for(int i=bottom;i>=top;i--){
                a[i][left]=c;c++;
            }
            left++;
        }
        return a;
    } 
}
