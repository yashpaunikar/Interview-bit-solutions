/*
You are given an array (zero indexed) of N 
non-negative integers, A0, A1 ,…, AN-1.
Find the minimum sub array Al, Al+1 ,…, Ar 
so if we sort(in ascending order) that sub array, 
then the whole array should get sorted.
If A is already sorted, output -1.
*/
//naive- make copy sort see where the difference is

/*
optimised-
start from the beginning and see where
a[start-1] > a[start] occurs set it as
start index.
similarly do this for end index.
We are not done yet.
get min and max from the start and end
array.
now, to the left of start there shud
not be any element more than min.
If it is then change start.

to the roght of end there shud
not be any element less than max.
If it is then change end.
*/

vector<int> Solution::subUnsort(vector<int> &arr) {
    int startIndex = -1;
    int endIndex = -1;
    vector<int> output;
    for(int i=0;i<arr.size()-1;i++){
        if(arr[i] > arr[i+1] ){
            startIndex = i;
            break;
        }
    }
    if(startIndex == -1){
        output.push_back(-1);
        return output;
    }
    for(int i=arr.size()-1;i>0;i--){
        if(arr[i-1] > arr[i]){
            endIndex = i;
            break;
        }
    }
    int minEle = INT_MAX, maxEle = INT_MIN;
    for(int i=startIndex;i<=endIndex;i++){
        minEle = min(minEle, arr[i]);
        maxEle = max(maxEle, arr[i]);
    }
    int minIndex = startIndex;
    int maxIndex = endIndex;
    for(int i = startIndex -1 ;i>=0;i--){
        if(arr[i] > minEle){
            minIndex = i;
        }
    }
    for(int i= endIndex+1;i<arr.size();i++){
        if(arr[i] < maxEle){
            maxIndex = i;
        }
    }
    output.push_back(minIndex);
    output.push_back(maxIndex);
    return output;
}
