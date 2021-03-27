//Min Steps in Infinite Grid

public class Solution {
    public int coverPoints(ArrayList<Integer> A, ArrayList<Integer> B) {
        int dist = 0;
        for(int i = 1; i < A.size(); i++){
            int xDiff = Math.abs(A.get(i) - A.get(i-1));
            int yDiff = Math.abs(B.get(i) - B.get(i-1));
            int max = Math.max(xDiff, yDiff);
            dist += max;
        }
        return dist;
    }
}

