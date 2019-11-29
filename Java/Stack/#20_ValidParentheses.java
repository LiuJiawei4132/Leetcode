/* 
    
*/

class Solution {
    HashMap<Character, Character> map;
    public Solution() {
        this.map = new HashMap<Character, Character>();
        this.map.put(']', '[');
        this.map.put('}', '{');
        this.map.put(')', '(');
    }

    public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);  
            
            if (this.map.containsKey(ch)) {
                char top = stack.empty() ? '#' : stack.pop();
                if (this.map.get(ch) != top)
                    return false;
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}