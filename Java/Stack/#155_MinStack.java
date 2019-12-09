/**
 * 设计一个能在常数时间内检索到最小元素的栈
 * 我们用两个栈来模拟
 * 一个栈(data)负责存储数据
 * 一个栈(helper)负责映射data每一层所对应的最小数据
 */

class MinStack {
    Stack<Integer> data;
    Stack<Integer> helper;
    /** initialize your data structure here. */
    public MinStack() {
        data = new Stack<Integer>();
        helper = new Stack<Integer>();
    }
    
    public void push(int x) {
        data.push(x);
        if (helper.empty() || helper.peek() >= x)
            helper.push(x);
        else 
            helper.push(helper.peek());
    }
    
    public void pop() {
        if (!data.empty()) {
            data.pop();
            helper.pop();
        }
    }
    
    public int top() {
        if (!data.empty())
            return data.peek();
        throw new RuntimeException("栈中元素为空，此操作非法");
    }
    
    public int getMin() {
        if (!helper.empty())
            return helper.peek();
        throw new RuntimeException("栈中元素为空，此操作非法");
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */