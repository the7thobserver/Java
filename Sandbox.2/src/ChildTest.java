public class ChildTest extends ParentTest {
	public int x = 1;

	public void print() {
        System.out.println("In Child");
    }
	
	public static void main( String args[] )
	{
		ParentTest s = new ChildTest();
		System.out.println(s.x);
		s.print();   
	}
}