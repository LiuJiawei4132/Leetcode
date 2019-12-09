/**
 * 比较含退格的字符串
 * 先把这两个字符串用栈处理一下
 * 再把两个栈的元素进行对比
 */

class Solution {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> Sstack = new Stack();
        Stack<Character> Tstack = new Stack();

        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (ch != '#') {
                Sstack.push(ch);
            } else {
                if (!Sstack.empty())
                    Sstack.pop();
            }
        }

        for (int i = 0; i < T.length(); i++) {
            char ch = T.charAt(i);
            if (ch != '#') {
                Tstack.push(ch);
            } else {
                if (!Tstack.empty())
                    Tstack.pop();
            }
        }

        while (!Sstack.empty() && !Tstack.empty()) {
            if (!Sstack.pop().equals(Tstack.pop()))
                return false;
        }

        return Tstack.empty() && Sstack.empty();
    }
}