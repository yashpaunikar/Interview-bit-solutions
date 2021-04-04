/*
Given an array A of integers, find the maximum 
of j - i subjected to the constraint of
A[i] <= A[j].
*/

/*
naive soln- o(n^2)
Run two loops. In the outer loop, pick elements one 
by one from the left. In the inner loop, compare the
picked element with the elements starting from the 
right side. Stop the inner loop when you see an 
element greater than the picked element and keep
updating the maximum j-i so far. 
*/ 
/*
efficient- o(nlogn) sorting based

*/
public class Solution {
    //make node class to save the indexes post 
    //sorting
  	class Node implements Comparable<Node>{
		int n;
		int index;
		public Node(int number,int index) {
	        this.n = number;
	        this.index = index;
	    }
		public int compareTo(Node o) {
			Integer a = this.n;
			Integer b = o.n;
			return a.compareTo(b);
		}
	}
	  public int maximumGap(final int[] A) {
	      Node[] nodes = new Node[A.length];  
		  for(int i=0;i<A.length;i++){
	        	nodes[i] = new Node(A[i],i);
	        }
		  Arrays.sort(nodes);
		  
		  int max = nodes[A.length-1].index;
		  
		  for(int i = A.length-1;i>=0;i--){

			  if(nodes[i].index > max){
				  max = nodes[i].index;
			  }
			  nodes[i].n = max - nodes[i].index;
			
		  }
		  
		  max = nodes[0].n;
		  for(int i=0;i<A.length;i++){
			  if(nodes[i].n > max ){
				  max = nodes[i].n;
				
			  }
		  }
		  return max;
		  
	    }

}
