/**
 * 用两条栈来模拟队列
 * 队列的特点就是先入先出，我们要保证栈顶元素一直是最先进入栈的元素
 */

class MyQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;
    /** Initialize your data structure here. */
    public MyQueue() {
        s1 = new Stack<Integer>(); // s1作为主栈
        s2 = new Stack<Integer>(); // s2作为辅助栈
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        // 将s1的所有元素刷入s2
        while (!s1.empty()) {
            s2.push(s1.pop());
        }
        // 后入的元素在队列中是处在末尾的
        s1.push(x);

        // 将s2的所有元素刷入s1
        while (!s2.empty()) {
            s1.push(s2.pop());
        }
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(!empty()) 
            return s1.pop();
        throw new RuntimeException("error");
    }
    
    /** Get the front element. */
    public int peek() {
        if(!empty()) 
            return s1.peek();
        throw new RuntimeException("error");
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */