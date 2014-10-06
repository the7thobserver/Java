import java.util.ArrayList;
import java.util.List;

public class IPAddress {
	public static void main(String[] args) {
		IPAddress ip = new IPAddress();
		String s = "123123123123";
		List<String> l = ip.restoreIpAddresses(s);
		
		System.out.println("Potential IP Addresses");
		for(int i = 0;i < l.size(); i++)
			System.out.println(l.get(i));
	}

	public List<String> restoreIpAddresses(String s) {
		// no null or ip addresses < 4
		if(s == null || s.length() < 4)
			return new ArrayList<String>();
		
		List<String> list = new ArrayList<String>();
		
		String temp = "";
		expand(s, 0, 1, temp, 0, list);		// Take a step of 1
		
		temp = "";
		expand(s, 0, 2, temp, 0, list);		// Take a step of 2
		
		temp = "";
		expand(s, 0, 3, temp, 0, list);		// Take a step of 3
		
		return list;
	}

	int count1 = 0;
	private void expand(String orig, int begin, int step, String temp, int count, List<String> list ) {
		// Over step the original string, grabbing invalid characters
		if(begin+ step > orig.length())
			return;

		// Obtain that substring
		String chunk = orig.substring(begin, begin + step);
		
		// Make sure it has no leading 0's
		if(chunk.charAt(0) == '0' && chunk.length() >= 2)
			return;
		
		// Make sure it's legal
		if(Integer.parseInt(chunk) > 255)
			return;
		
		// If it's the last term
		if(count == 3)
		{
			// Make sure there is no characters left that we didn't take
			if(!orig.substring(begin + step).equals(""))	
				return;
			
			temp += chunk;	// Add to the ip address
			
			// See if it's already in the list
			if(!list.contains(temp))
				list.add(temp);
			
			return;
		}
		
		// Term is 0-3th, add it and a .
		temp += chunk + ".";
		
		// Take steps
		expand(orig, begin + step, 1, temp, count + 1, list);
		expand(orig, begin + step, 2, temp, count + 1, list);
		expand(orig, begin + step, 3, temp, count + 1, list);
	}
	
	public ArrayList<String> restoreIpAddresses1(String s) {
	    ArrayList<String> result = new ArrayList<String>();
	    String tempIP = null;
	    
	    for (int i = 1;i<s.length();i++){
	        if(i<=3&&(s.length()-i)<=9&&(s.length()-i)>=3){
	            for (int j=i+1;j<s.length();j++){
	                if(j-i<=3&&(s.length()-j)<=6&&(s.length()-i)>=2){
	                    for (int k=j+1;k<s.length();k++){
	                        if ((k-j)<=3&&(s.length()-k)<=3){
	                            String n1 = s.substring(0, i);
	                            String n2 = s.substring(i, j);
	                            String n3 = s.substring(j, k);
	                            String n4 = s.substring(k, s.length());
	                            if (!(n1.charAt(0) =='0'&& n1.length()>1)&&
	                             !(n2.charAt(0) =='0'&& n2.length()>1)&&
	                             !(n3.charAt(0) =='0'&& n3.length()>1)&&
	                             !(n4.charAt(0) =='0'&& n4.length()>1)&&
	                             Integer.parseInt(n1)<256&&Integer.parseInt(n2)<256&&
	                             Integer.parseInt(n3)<256&&Integer.parseInt(n4)<256){
	                                tempIP = n1+"."+n2+"."+n3+"."+n4;
	                                result.add(tempIP);
	                            }
	                        }
	                    }
	                }
	            }
	        }
	    }
	    return result;
	}
	
}
