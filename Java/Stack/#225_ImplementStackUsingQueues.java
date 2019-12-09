/**
 * 用队列来模拟一个栈
 * 栈和核心就是后入先出，我们要保证每次添加的数据都要到队列的开头
 * 所以用到两条队列
 */

class MyStack {
    Queue<Integer> q1;
    Queue<Integer> q2;

    /** Initialize your data structure here. */
    public MyStack() {
        q1 = new LinkedList<Integer>(); // 主队列
        q2 = new LinkedList<Integer>(); // 辅助
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        q2.add(x);
        // 将q1所有数据刷进q2
        while(q1.peek() != null) {
            q2.add(q1.remove());
        }

        // 交换两条队列
        Queue<Integer> tmp = new LinkedList<>();
        tmp = q2;
        q2 = q1;
        q1 = tmp;
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(!empty())
            return q1.poll();
        throw new RuntimeException("error");
    }
    
    /** Get the top element. */
    public int top() {
        if(!empty())
            return q1.peek();
        throw new RuntimeException("error");
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.peek() == null;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */