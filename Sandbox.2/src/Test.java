
public class Test
{
	int i =0;
	int I = 0;
	
    public static void main (String args[ ])
    {

        B o = new A ();
        System.out.println (o.content ());

    }

    public String content () throws Exception
    {

        throw new Exception ("This is an exception on this.content ()");

    }

    private static class B
    {

        public String content ()

        {

        return "B";

        }
     }

     private static class A extends B
     {

        public String content ()
        {

           return "A";
        }
     }
}