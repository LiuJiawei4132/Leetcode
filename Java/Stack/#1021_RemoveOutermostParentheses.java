/**
 * 移除最外层的括号
 * 如果进来的是'(',则加入栈,如果进来的是')',则弹出栈,并判断栈是否为空,如果为空则获取一截字符串
 */

class Solution {
    public String removeOuterParentheses(String S) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int start = 0;

        for(int i = 0; i < S.length(); i++){
            if (S.charAt(i) == '(') {
                stack.push('(');
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    sb.append(S.substring(start + 1, i));
                    start = i + 1;
                }
            }
        }

        return sb.toString();
    }
}