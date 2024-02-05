import java.util.Arrays;
public class brutForce {

	public static void main(String[] args)
	{
		int[] arr1=new int[25], result;
		for (int i=0; i<25; i++)
		{
			if (i%2==1)
				arr1[i]=-i;
			else
				arr1[i]=i;
		}
		long t1=System.nanoTime();
		result=MAX_SUB(arr1);
		long t2=System.nanoTime();
		System.out.print("The maximuim sub array is: ");
		int len=result.length;
		for (int i=result[0]; i<=result[1]; i++)
			System.out.print(arr1[i]+" ");
		System.out.println("\nThe maximum sum is: "+result[2]);
		long timeNet=t2-t1;
		System.out.println("Time taken for brute force approach:" +timeNet);
	}
	public static int[] MAX_SUB(int Arr[]) // this method is O(n^2)
	{
		int globalSum=Integer.MIN_VALUE, runSum; 
		int length=Arr.length;
		int startIndex=0, endIndex=0;
		for(int i=0; i<length; i++)
		{
			runSum=0;
			for(int j=i; j<length; j++)
			{
				runSum+=Arr[j];
				if(globalSum<runSum)
				{
					globalSum=runSum;
					startIndex=i;
					endIndex=j;
				}	
			}
		}
		return new int[] {startIndex, endIndex, globalSum};
	}

}
