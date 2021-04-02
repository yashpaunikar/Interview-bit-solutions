Given a non-negative number represented as an array of digits,
add 1 to the number ( increment the number represented by the digits ).
The digits are stored such that the most significant digit is at the head of the list.
/*
First convince yourself that constructing numbers and then adding 1 will not work.
The number of digits can be really high ( Imagine 1000 - 10000 digits ).

Now, lets look at how we will add 1.
Try to think of how you would add 1 on paper. Start from the last digit, and maintain carry.
*/

public class Solution {
    public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        int i = 0;
        //remove zeros
        while(i < A.size()-1 && A.get(i) == 0){
            A.remove(i);
        }
      
        int carry = 1;
        int sum;
        for(i = A.size()-1; i>=0; i--){
            sum = A.get(i) + carry;
            carry = sum / 10;
            sum %= 10;
            A.set(i, sum);
            // if anywhere carry becomes 0
            // then no need to co ntinue further
            if(carry == 0)
                break;
        }
        // if still carry remains then
        // its a case of 9 9 9 9 9
        if(carry != 0)
            A.add(0, carry);
        
        return A;    
    }
}
