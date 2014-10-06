import java.util.Stack;


public class QueueStack<T> 
{
	private Stack<T> inStack, outStack;
	private int size;
	
	public QueueStack()
	{
		inStack = new Stack<T>();
		outStack = new Stack<T>();
		size = 0;
	}
	
	public void enqueue(T i)
	{
		inStack.push(i);
		size++;
	}
	
	public T dequeue() throws Exception
	{
		if(outStack.isEmpty())
		{
			int stackSize = inStack.size();
			
			if(inStack.isEmpty())
				throw new Exception("Is empty");
			
			for(int i = 0; i < stackSize; i++)
			{
				outStack.push(inStack.pop());
			}
		}
		
		return outStack.pop();
	}
		
	public int getSize()
	{
		return size;
	}
	
}
