
import java.util.*;
public class QuickSort {
       
          static void quickSort(int[] ar) 
          {
        	 int pivot = ar[ar.length/2];
	        
        	 int i = 0;
        	 int high = ar.length -1;
        	 int low = 0;
        	 
        	while(low < high)
        	{
        		printArray(ar);
        		while(ar[high] > pivot)
        		{
        			high--;
        		}
        		while(ar[low] < pivot)
        		{
        			low++;
        		}
        		
        		if(low < high)
        		swap(ar, high, low);
        		
        		//System.out.println("FIRST " + low + " " + high);
        	}
        	System.out.println("FIRST " + low + " " + high);
        	
        	
        	quicksort(ar, 0, low);
        	quicksort(ar, high + 1, ar.length-1);
        	
          }   
          
          static void quicksort(int[] ar, int l, int h)
          {
        	  if(h-l == 0 || h-1-l==0)
        		  return;
        	  
        	  int pivot = ar[(l+h)/2];
        	  
        	  System.out.println("PIV " + pivot);
         	 int i = 0;
         	 int high = h;
         	 int low = l;
         	System.out.println(low + " " + high);
         	
         	while(low < high)
        	{
        		printArray(ar);
        		while(ar[high] > pivot)
        		{
        			high--;
        		}
        		while(ar[low] < pivot)
        		{
        			low++;
        		}
        		
        		if(low < high)
        		swap(ar, high, low);
        		
        		//System.out.println("FIRST " + low + " " + high);
        	}
         	
         	quicksort(ar, l, low);
         	quicksort(ar, h, high + 1);
          }
          
          static void swap(int[] ar, int i, int j)
          {
        	  int temp = ar[i];
        	  ar[i] = ar[j];
        	  ar[j] = temp;
          }
 
 static void printArray(int[] ar) {
         for(int n: ar){
            System.out.print(n+" ");
         }
           System.out.println("");
      }
       
      public static void main(String[] args) {

    	  int[] ar = {5, 8, 1, 3, 7, 9, 2};
//           Scanner in = new Scanner(System.in);
//           int n = in.nextInt();
//           int[] ar = new int[n];
//           for(int i=0;i<n;i++){
//              ar[i]=in.nextInt(); 
//           }
           quickSort(ar);
           printArray(ar);
      }    
   }
