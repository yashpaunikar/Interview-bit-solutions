/*
Input 1:
    A = [1, 2, 3]
Output 1:
    [1, 3, 2]
Input 2:
    A = [3, 2, 1]
Output 2:
    [1, 2, 3]
*/
//BRUTE- generate all permutations and then search for 
//given permutation 0(N!)

//Use algorithm mintioned below
vector<int> Solution::nextPermutation(vector<int> &A) {
    //step1- find where A[i] < A[i+1] set index1 = i
    //step2- find where A[j] > A[index1] set index2 = j
    //step3- swap A[index1] and A[index2]
    //step4- reverse index1 + 1 to end.
    int i,j;
    int n = A.size();
    for(i = n - 2;i >= 0;i --)
    {
        if(A[i] < A[i + 1])
            break;
    }
    //corner case - when array is reverse
    //sorted then just reverse and return.
    if(i == -1)
    {
        reverse(A.begin(),A.end());
        return A;
    }
    
    for(j = n - 1;j > i;j --)
    {
        if(A[j] > A[i])
            break;
    }
    swap(A[j],A[i]);
    reverse(A.begin() + i + 1,A.end());
    return A;
}
