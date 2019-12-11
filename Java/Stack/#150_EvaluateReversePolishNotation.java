/**
 * 用字符串来模拟栈
 * 
 */

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        

        for (String s : tokens) {
            int res = 0;
            Stack<Integer> tmp = new Stack<>();
            if (s.equals("+"))  
                tmp.push(stack.pop() + stack.pop()); 
            else if (s.equals("-"))
                tmp.push(stack.pop() + stack.pop()); 
            else if (s.equals("*"))
                tmp.push(stack.pop() + stack.pop()); 
            else if (s.equals("/"))
                tmp.push(stack.pop() + stack.pop()); 
            else
                stack.push(Integer.parseInt(s));
            if (!tmp.isEmpty())
                stack.push(tmp.pop());
        }
        
        return stack.peek();
    }
}