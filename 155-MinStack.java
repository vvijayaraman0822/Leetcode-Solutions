// 155 - Min Stack

class MinStack {

    /** initialize your data structure here. */
    Stack<StackPair> stack;
    
    public MinStack() {
       stack = new Stack<>();     
    }
    
    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(new StackPair(x, x));
        } else {
            int currMinInStack = stack.peek().currMin;
            stack.push(new StackPair(x, Math.min(x, currMinInStack)));
        }    
    }
    
    public void pop() {
        if(!stack.isEmpty()) {
            stack.pop();
        }
    }
    
    public int top() {
        return stack.peek().val;
    }
    
    public int getMin() {
        return stack.peek().currMin;
    }
    
    class StackPair {
        int val;
        int currMin;
        
        StackPair(int val, int currMin) {
            this.val = -1;
            this.currMin = currMin;
        }
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