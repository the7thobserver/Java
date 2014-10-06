import java.util.Stack;


public class ProxyQueue<E> {
	Stack<E> in, out;
	int size;
	
	public ProxyQueue()
	{
		in = new Stack<E>();
		out = new Stack<E>();
		size = 0;
	}
	
	public void enqueue(E e)
	{
		in.add(e);
		size++;
	}
	
	public E dequeue()
	{
		if(out.size() == 0)
		{
			if(in.size() == 0)
				return null;
			
			int inSize = in.size();
			
			for(int i = 0; i < inSize; i++)
				out.add(in.pop());
		}
		
		size--;
		return out.pop();
	}
	
	public int getSize()
	{
		return size;
	}

}
