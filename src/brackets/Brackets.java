package brackets;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author mansisaini
 */
public class Brackets {
    
    private static boolean checkBalancedParentheses(String input)
    {  
        Stack<String> stack = new Stack<>();
        boolean isBalanaced = false;

        for(int i=0; i < input.length(); i++){
	String str = ""+input.charAt(i);	

	//if opening bracket then push into stack
	if(str.equals("(") || str.equals("[") || str.equals("{"))
        {
            stack.push(str);
	}

	//if closing bracket, pop bracket and compare to check if its a pair
	if(str.equals(")") || str.equals("]") || str.equals("}"))
        {
            //if stack becomes empty in between then also its not balanced
            if(stack.isEmpty()){
		return false;
            }
            String opening = stack.peek();
            if(str.equals(")") && opening.equals("("))
            {
		stack.pop();
            }
            if(str.equals("]") && opening.equals("["))
            {
		stack.pop();
            }
            if(str.equals("}") && opening.equals("{"))
            {
            stack.pop();
            }
	}			
    }
	//if stack is empty at end, then its balanced
	if(input.length() > 0 && stack.isEmpty())
        {
            isBalanaced = true;
	}

        return isBalanaced;
}
    //testing the logic:
    public static void main(String[] args) {
        //As stated in the prompt, we're assuming that inputs will only contain [, {, (, ), }, ]
        Scanner user_input = new Scanner(System.in);
        System.out.println("Enter a string of brackets: ");
        String input = user_input.next();
            
            boolean flag = checkBalancedParentheses(input);
            if(flag){
                  
                  System.out.println("Balanced: " + "YES!");
                  
            }else {
		System.out.println("Balanced: " + "NO!");
            }
        }
    }
    