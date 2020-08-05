package string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Solution {
	
    public static ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer> result1 = new ArrayList<>();
        int end = A.size()- 1;
        int carry = 0;
        int value = A.get(end) + carry + 1;
        if (value > 9) {
        	result.add(value % 10);
        	carry = 1 ;
        }else {
        	result.add(value);
        }
        
        end -= 1;
        if(A.size() == 1) {
        	result.add(carry);
        }
        while (end >= 1){
            value = A.get(end) + carry;
            if(value > 9){
            	result.add(value % 10);
            	carry = 1 ;
            }else {
            	result.add(value);
            	carry = 0;
            }
            end--;
        }
        Collections.reverse(result);
        if(A.size() != 1) {
            int data = A.get(0) + carry;
            Stack<Integer> stack = new Stack<Integer>();
        	while (data != 0){
        	    stack.push (data % 10);
        	    data = data/10;
        	}
        	while(!stack.isEmpty()){
        		int popped = stack.pop();
        		System.out.println(popped);
        	    result1.add(popped);
        	}
        }
        
        for(int i=0; i< result.size(); i++){
            result1.add(result.get(i));
        }
        while (result1.get(0) == 0) {
        	result1.remove(0);
        }
        return result1;
    }
    
    public static void main(String[] args) {
		
    	int []data = {9};
    	
    	ArrayList<Integer> test = new ArrayList<>();
        for(Integer text:data) {
            test.add(text);
         }

    	System.out.println(plusOne(test));
	}
}
