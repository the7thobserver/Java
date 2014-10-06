import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class EscanDataAnalyser 
{
	private String filename;
	private HashMap<String, Integer> map = new HashMap<String, Integer>(); 
	
	public EscanDataAnalyser(String filename)
	{
		//this.filename = filename;
		this.filename = "escanData2012.txt";
		readData();
	}

	private void readData()
	{
		Scanner scanner = null;
		
		try {
			scanner = new Scanner(new FileInputStream(filename));
		} catch (FileNotFoundException e) {
			System.out.println("File can't be found");
			System.exit(-1);
		}
		
		String pattern = "\\d{4}-\\d{2}-\\d{2}";
		
		while(scanner.hasNext())
		{	
		    Pattern r = Pattern.compile(pattern);
		    Matcher m = r.matcher(scanner.nextLine());
		    
		    if (m.find()) 
		    {
		         sort(m.group(0));
		    }
		}
	}
	
	private void sort(String data)
	{
		if(map.containsKey(data))
		{
			map.put(data, map.get(data) + 1);
		}
		else
		{
			map.put(data, 1);
		}
	}
	
	public void dumpData()
	{
		for(String key : map.keySet())
		{
			System.out.println("On " + key + ", " + map.get(key) + " people atteneded.");
		}
	}
}
