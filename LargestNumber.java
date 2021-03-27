// solution to largest number
// o(nlogn) + o(n) + o(n)
public class Solution {
    public String largestNumber(final List<Integer> A) {
        String [] num = new String[A.size()];
        for(int i = 0; i<A.size(); i++){
            num[i] = String.valueOf(A.get(i));
        }
        
        Arrays.sort(num, new Comparator<String>(){
            public int compare(String a, String b){
                String A = a+b;
                String B = b+a;
                if(A.compareTo(B) > 0) return -1;
                else return 1;
            }
        });
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i<num.length; i++){
            sb.append(num[i]);
        }
        
        int flag = 0; // 0 0,0,0,0,0 should return "0"
        for(int i = 0; i<sb.length(); i++){
            if(sb.charAt(i) != '0'){
                flag = 1;
                break;
            } 
        }
        
        if(flag == 0) return "0";
        else return sb.toString();
    }
}























