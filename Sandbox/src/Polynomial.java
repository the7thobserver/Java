import java.util.LinkedList;
import java.util.ListIterator;


public class Polynomial 
{
	private LinkedList<Term> poly;
	
	public Polynomial()
	{
		poly = new LinkedList<Term>();
	}
	
	public void addTerm(int co, int po)
	{
		poly.addLast(new Term(co,po));
	}
	
	public void print()
	{
		ListIterator<Term> iter = poly.listIterator();
		
		while(iter.hasNext())
		{
			Term t=iter.next();
			System.out.print(t);
		}
		
		System.out.println(" ");
	}
	
	public void insert(int co, int po)
	{
		Term temp = new Term(co,po);
		ListIterator<Term>iter = poly.listIterator();
		
		while(iter.hasNext())
		{
			Term t = iter.next();
			
			if(temp.getPow() == t.getPow())
			{
				t.setCoe(temp.getCoe()+t.getCoe());
				return;
			}
			else if(temp.getPow() > t.getPow())
			{
				iter.previous();
				iter.add(temp);
				return;
			}
		}
	
		iter.add(temp);
	}
	
	public void multiply(int co, int po)
	{
		ListIterator<Term> iter = poly.listIterator();
		
		while(iter.hasNext())
		{
			Term cur = iter.next();
			
			cur.setCoe(co * cur.getCoe());
			cur.setPow(po + cur.getPow());
		}
	}
	
	public void derive()
	{
		ListIterator<Term> iter = poly.listIterator();
		Term t;
		
		while(iter.hasNext())
		{
			t = iter.next();
			int newCoe = t.coe * t.pow;
			int newPow = t.pow - 1;
			
			if(t.pow == 1)
			{
				System.out.print("(" + t.pow  + ", 0)");
				continue;
			}
			
			if(newCoe != 0)
				System.out.print("(" + newCoe + ", " + newPow + ")");
		}
		System.out.println();
	}
	
	static class PolyTest
	{
		public static void main(String[] args)
		{
			Polynomial p = new Polynomial();
			System.out.println("The Equation is ");

			p.addTerm(5,10);
			p.addTerm(9,7);
			p.addTerm(-1,1);
			p.addTerm(-10,0);
			p.print();
			System.out.println("The Sum of the Equation and x is ");
			p.insert(1,1);
		
			p.print();
			System.out.println("The Derivative of the First Equation is ");
			p.derive();
			
			System.out.println("Multiply 2x into the equation gets ");
			p.multiply(2, 1);
			p.print();			
		}
	}
	
	class Term
	{
		private int coe;
		private int pow;
		
		public int getCoe()
		{
			return coe;
		}
	
		public int getPow()
		{
			return pow;
		}
		
		public void setCoe(int co)
		{
			coe = co;
		}
		
		public void setPow(int po)
		{
			pow=po;
		}
		
		public Term(int co,int po)
		{
			coe = co; pow = po;
		}
		
		public String toString()
		{
			return "(" + coe + "," + pow + ")";
		}
	}


}
