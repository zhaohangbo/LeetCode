import java.util.Stack;

public class P155_MinStack {
	class MinStack
	{
	    class Element
	    {
	        final int value;
	        final int min;
	        Element(final int value, final int min)
	        {
	            this.value = value;
	            this.min = min;
	        }
	    }
	    final Stack<Element> stack = new Stack<>();

	    public void push(int x) {
	        final int min = (stack.empty()) ? x : Math.min(stack.peek().min, x);
	        stack.push(new Element(x, min));
	    }

	    public void pop()
	    {
	        stack.pop();
	    }

	    public int top()
	    {
	        return stack.peek().value;
	    }

	    public int getMin()
	    {
	        return stack.peek().min;
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
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
