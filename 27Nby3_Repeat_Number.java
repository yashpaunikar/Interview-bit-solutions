/*
You’re given a read only array of n integers. 
Find out if any integer occurs more than n/3 
times in the array in linear time and constant 
additional space.
If so, return the integer. If not, return -1.
If there are multiple solutions, return any one.
Example :
Input : [1 2 3 1 1]
Output : 1 
1 occurs 3 times which is more than 5/3 times. 

brute- get frequency of each o(n^2)
optimal- sort it and iterate o(nlogn)
optimal- use hashmap uses additional o(n) space
best- use moore's voting algorithm. o(n) time 
	  and o(1) time.
*/

/*
we can have maximum 2 candidates having 
occurences more than n/3
Proof- n elements in the array
so we can have n/3 + n/3 + n/3 elements
of each kind now to have more than n/3 
of each kind we need to make 
n/3+1 + n/3+1 + n/3-2 distribution in 
worst case.
*/
public class Solution {
	public int repeatedNumber(final List<Integer> a) {
		int number1 = -1, number2 = -1, count1 = 0, count2 = 0, n = a.size();
		//getting possible candidates for n/3 repeats
		//using moore's voting algorithm
		for(int i = 0; i < n; i++){
			if(a.get(i) == number1)
				count1++;
			else if(a.get(i) == number2)
				count2++;
			else if(count1 == 0){
			    number1 = a.get(i);
				count1 = 1;
			}
			else if(count2 == 0){
			    number2 = a.get(i);
				count2  = 1;
			}
			else{
				count1--;
				count2--;
			}
		}

		count1 = 0;
		count2 = 0;
		for(int i = 0; i < n; i++){
			if(a.get(i) ==  number1)
				count1++;
			if(a.get(i) ==  number2)
				count2++;
		}

		if(count1 > n/3)
			return number1;
		else if(count2 > n/3)
			return number2;
		else 
			return -1;
	}
}

/*
Goal: for an array of size n and an arbitrary int k, 
find any number that occurs more than n/k times.
Runtime complexity: O(nk), guaranteed to be at most 
O(n^2) for any n and k
Space complexity: O(k), guaranteed to be at most 
O(n) for any n and k
In this problem where k=3, that’s O(n) and O(1)
Idea: Generate final candidates, then verify that 
they occur > n/k times. The final candidates list 
is guaranteed to have at least one of the numbers that 
occur more than n/k times (if there is any such number), 
but not every final candidate necessarily occurred over n/k times. 
We gather the candidates first, then verify that they occurred 
the requisite number of times.

Execution: At most k-1 distinct numbers can occur 
more than n/k times (convince yourself that k or more is too much), 
so we only need to keep track of k-1 distinct potential 
final candidates. Go through the array to build the candidates. 
For each candidate, maintain a counter. When this counter is zero 
(as it will be initially), we switch the candidate to the current 
number (or invalidate it if the number is already a candidate). 
We increase the counter when the number is the same as the candidate 
and decrease the counter each time k-1 numbers are different 
from the candidate.

Why this works: Suppose x is any number that occurs
exactly n/k times. To completely cancel out x from 
the candidates list, we would need to decrease its 
count a total of n/k times. Each decrease in the count 
requires k-1 occurrences of numbers that are not x. 
Hence we would need a total of (k-1)*n/k occurrences 
that are not x to ensure that x is not in the final 
candidates list. If we count the total number of numbers 
including x that we needed to use to ensure this, 
we have n/k + (k-1)*n/k = n/k + n - n/k = n. 
Hence, to exclude x from the final candidates list, 
we needed to use all the numbers in the array.

Note that we assumed that x occurs exactly n/k times, 
but in reality we want it to occur more than that. 
If x occurs any amount more than n/k times, it will 
require more elements than we have available to 
completely nullify it. Therefore, any number that 
gets its count increased more than n/k times is 
guaranteed to remain in the candidates list.

*/

//Code:
public class Solution {
// DO NOT MODIFY THE LIST

public int repeatedNumber(final List<Integer> a) {
    int n = a.size();
    if (n == 0) return -1; // 0 reps <= 0/k
    int k = 3; // want any number that repeats more than n/k times
    if (n/k == 0) return a.get(0); // first number repeats 1>n/k<1
    // n >= k
    Integer[] cands = new Integer[k-1]; // different candidates
    int[] cts = new int[k-1]; // counts for the candidates
    int[] numDiff = new int[k-1];
    // how many numbers have been different since last decrement for candidate c
    // cts[c] should be decremented when numDiff[c]==k-1
    
    // check which numbers survive cancellation
    // results in final candidates
    for (int i = 0; i < n; i++) {
        int num = a.get(i);
        boolean alreadyCand = false; // used to ensure candidates are different
        // determine if num already candidate and update cts/diffs
        for (int c=0; c<k-1; c++) {
            Integer cand = cands[c];
            if (cand != null) {
                if (cand == num) {
                    alreadyCand = true;
                    cts[c]++;
                } else { // cand != num
                    int cDiff = numDiff[c] + 1;
                    if (cDiff == k-1) {
                        cts[c]--;
                        cDiff = 0;
                    }
                    numDiff[c] = cDiff;
                }
            }
        }
        // make a candidate switch and nullify remaining 0-ct candidates
        for (int c=0; c<k-1; c++) {
            if (cts[c] == 0) {
                if (!alreadyCand) {
                    cands[c] = num;
                    cts[c] = 1;
                    alreadyCand = true;
                } else {
                    cands[c] = null;
                }
            }
        }
    }
    
    // verify if a candidate occurs requisite min number of times
    int moreThan = n/k; // result must occurs more than moreThan times
    Arrays.fill(cts, 0); // reset the counts
    for (int i=0; i<n; i++) {
        int num = a.get(i);
        for (int c=0; c < k-1; c++) {
            Integer cand = cands[c];
            if (cand != null && cand == num) {
                int ct = cts[c] + 1;
                if (ct > moreThan) {
                    return num;
                }
                cts[c] = ct;
            }
        }
    }
    return -1;
}
}
