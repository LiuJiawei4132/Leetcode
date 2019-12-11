/**
 * 本题难点在于括号内嵌套括号，需要从内向外生成与拼接字符串，这与栈的先入后出特性对应。
 * 这题LeetCode上高赞大佬写的太好了
 * 还是过去看大佬的好
 * 
 */

class Solution {
    public String decodeString(String s) {
        // 保存循环次数
        Stack<Integer> multi_stack = new Stack<>();

        // 保存'['前的字母(之前嵌套的时候res_stack才会保存字母)
        Stack<String> res_stack = new Stack<>();

        StringBuilder res = new StringBuilder();
        int multi = 0;

        for (Character c : s.toCharArray()) {
            // 遇到'['时将multi AND res内容入对应的栈
            if (c == '[') {
                multi_stack.push(multi);
                res_stack.push(res.toString());
                res = new StringBuilder();
                multi = 0;

            // 遇到']'时取出栈内的数据
            } else if (c == ']') {
                int cur_multi = multi_stack.pop(); // 循环次数
                StringBuilder tmp = new StringBuilder(); // 临时保存被循环的内容
                for (int i = 0; i < cur_multi; i++) tmp.append(res);
                res = new StringBuilder(res_stack.pop() + tmp); // 拼接
            } else if (c >= '0' && c <= '9') {
                multi = multi * 10 + Integer.parseInt(c + "");
            } else {
                res.append(c);
            }
        }

        return res.toString();
    }
}