/*
Given a read only array of integers between 1 and n, 
find one number that repeats in linear time using less 
than O(n) space and traversing the stream sequentially O(1) times.
*/
//naiive- sort array nlogn or check for each element n^2.

//naiive solution- make freq array mark
//presence of elements in it
//iterate and return index of max frequency.
//this takes 0(n) space and 0(2n) time.
public class Solution {
    public int repeatedNumber(final List<Integer> A) {
        int freq[] = new int [A.size()];
        for(int i = 0; i < A.size(); i++){
            freq[A.get(i)] += 1;
        }
        
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        for(int i = 0; i < freq.length; i++){
            if(freq[i] > max){
                max = freq[i];
                maxIndex = i;
            }
        }
        if(max == 0) return -1;
        return maxIndex;    }
}

//optimised - slow and fast pointer - HARE & TORTOISE
//watch proof - https://www.youtube.com/watch?v=-YiQZi3mLq0&ab_channel=GauravSen
int Solution::repeatedNumber(const vector<int> &A) {
    int n=A.size();
    if (n <= 1) return -1; 
    int slow = A[0]; 
    int fast = A[A[0]]; 
    while (fast != slow) { 
        slow = A[slow]; 
        fast = A[A[fast]]; 
    }
    fast = 0; 
    while (slow != fast) { 
        slow = A[slow]; 
        fast = A[fast]; 
    } 
    return slow;
}
