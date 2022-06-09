import java.io.*;
import java.util.*;
public class sorts
{
	static long BubbleIt =0;//num of iterations for Bubble Method
	static long SeleIt = 0;//num of iterations for Sorting Method
	static long MerIt = 0;//num of iterations for Merge Method
	public static void main(String[] args) throws IOException
	{
		File file = new File("primes1.txt");
		Scanner infile = new Scanner(file);
		
		int[] data1 = new int[100000];//bubbles sort
		int[] data2 = new int[100000];//selection sort
		ArrayList<Integer> data3= new ArrayList<Integer>();//merge sort
		
		
		//files converted into arrays
		int Index = 0;
		int A;
		while (infile.hasNextInt())
		{
			A = infile.nextInt();
			data1[Index] = A;
			data2[Index] = A;
			data3.add(A);
			Index++;
		}
		 
		//BUBBLE SORT METHOD
		System.out.println("-------------------------------------------------------------------");
		System.out.println("Beginning Bubble Sort..." );
		//begining time
		long begTime = System.currentTimeMillis();
		data1 = BubbleSort(data1);
		//endtime
		long endTime = System.currentTimeMillis();
		System.out.println("First 10 sorted numbers: ");
		System.out.println();
		for (int i=0; i<10; i++)
		{
			System.out.print(data1[i] +" ");
		}
		System.out.println();
		System.out.println("Seconds to sort: "+(endTime -begTime)/1000.0);
		System.out.println("Bubble iterations: " + BubbleIt);
		//last 10
		System.out.println();
		System.out.println("Last 10 sorted numbers: ");
		for (int i=99990;i<100000; i++)
		{
			System.out.print(data1[i] +" ");
		}
		//Buffer area
		System.out.println("-------------------------------------------------------------------");
		
		
		//SELECTION SORT METHOD
		System.out.println("Beginning Selection Sort..." );
		//beg time
		long begTime2 = System.currentTimeMillis();
		data2 = SelectionSort(data2);
		long endTime2 = System.currentTimeMillis();
		System.out.println("First 10 sorted: ");
		System.out.println();
		for (int i=0;i <10; i++)
		{
			System.out.print(data2[i]+" ");
		}
		System.out.println();
		System.out.println("Seconds to sort: " +(endTime2 - begTime2)/1000.0);
		System.out.println("Selection iterations: " + SeleIt);
		//last 10
		System.out.println();
		System.out.println("Last 10 sorted numbers: ");
		for (int i = 99990; i<100000; i++)
		{
			System.out.print(data2[i] + " ");
		}
		//Buffer area
		System.out.println("-------------------------------------------------------------------");
		
		
		
		//MERGE SORT
		System.out.println("Beginning Merge Sort...");
		//beg time
		long begTime3 = System.currentTimeMillis();
		data3 = MergeSort(data3);
		long endTime3 = System.currentTimeMillis();
		System.out.println("Number of iterations: " +MerIt);
		//first 10
		System.out.println("First 10 sorted: ");
		System.out.println();
		for (int i=0; i<10; i++)
		{
			System.out.print(data3.get(i) + " ");
		}
		System.out.println();
		System.out.println("Seconds to sort: "+ (endTime3 - begTime3)/1000.0);
		//last 10
		System.out.println();
		System.out.println("Last 10 sorted numbers:" );
		for (int i = 99990; i < 100000; i++)
		{
			System.out.print(data3.get(i) + " ");
		}
		
		
		
		
	}
	
	static int[] BubbleSort(int[] data)
	{
		int Temp;
		for (int x=0; x<data.length; x++)
		{
		   for (int y=0; y<data.length-1-x; y++)
		   {
		      BubbleIt++;// compare data[y] & data[y+1] and swap if needed
		      if (data[y] > data[y+1])
		      {
		         Temp = data[y];
		         data[y] = data[y+1];
		         data[y+1] = Temp; 
		      }
		   }
		}
		return data;
	}
	
	
	
	static int[] SelectionSort(int[] data)
	{
		int min;
		int Temp;
		for (int x=0; x<data.length; x++)
		{
		   min = x;  // data[x] will start as the smallest value
		   for (int y=x; y<data.length; y++)
		   {
		      SeleIt++;
		      if (data[y] < data[min])
		      {
		         min = y;
		      }
		   }
		   // swap data[x] with data[min]
		   Temp = data[x];
		   data[x] = data[min];
		   data[min] = Temp;       
		}
		return data;
	}
	
	static ArrayList<Integer> MergeSort(ArrayList<Integer> dataset)
	{
	   if (dataset.size() == 1) return dataset;
	   else
	   {
	      // split data into 2 parts
	      ArrayList<Integer> LeftData = new ArrayList<Integer>(dataset.subList(0,dataset.size()/2));
	      ArrayList<Integer> RightData = new ArrayList<Integer>(dataset.subList(dataset.size()/2,dataset.size()));
	      dataset = Merge(MergeSort(LeftData), MergeSort(RightData));
	   }
	   return dataset;
	}

	// merge the left and right lists together
	static ArrayList<Integer> Merge(ArrayList<Integer> LeftData, ArrayList<Integer> RightData)
	{
	   ArrayList<Integer> MergedData = new ArrayList<Integer>();
	   MerIt++;
	   while (LeftData.size() > 0 || RightData.size() > 0)
	   {
	      if (RightData.size() == 0)
	      {
	         MergedData.add(LeftData.get(0));
	         LeftData.remove(0);
	      }
	      else if (LeftData.size() == 0)
	      {
	         MergedData.add(RightData.get(0));
	         RightData.remove(0);
	      }
	      else if (LeftData.get(0) < RightData.get(0))
	      {
	         MergedData.add(LeftData.get(0));
	         LeftData.remove(0);
	      }
	      else
	      {
	         MergedData.add(RightData.get(0));
	         RightData.remove(0);
	      }
	   }
	   return MergedData;
	}
}