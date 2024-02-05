import java.util.*;
public class divAcon {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= new int[25];
		for (int i=0; i<25; i++)
		{
			if (i%2==1)
				arr[i]=-i;
			else
				arr[i]=i;
		}
		long t1=System.nanoTime();
		int sum[]=maxSubArraySum(arr, 0, arr.length-1);
		long t2=System.nanoTime();
		System.out.println("The maximum sub array sum is: "+sum[2]);
		System.out.print("The maximum sub array is: ");
		for (int i=sum[0]; i<=sum[1]; i++)
			System.out.print(arr[i]+" ");
		System.out.println();
		long timeNet=t2-t1;
		System.out.println("Time taken for divide and conquer approach:" +timeNet);
	}
	public static int[] maxSubArraySum(int arr[], int low, int high)
	{
		if (arr.length <=43)
		{
			return MAX_SUB(arr);
		}
		if (low == high)
		{
			int[] returnarr= {low, high, arr[low]};
			return returnarr; //base case
		}
		int mid=(low+high)/2;
		int leftSum[]=maxSubArraySum(arr, low, mid);
		int rightSum[]=maxSubArraySum(arr, mid+1, high);
		int crossingSum[]=FindMaxCrossingSubArray(arr, low, mid, high);
		if (rightSum[2] > leftSum[2] && rightSum[2] >crossingSum[2])
		{
			return rightSum;
		}
		else if (leftSum[2] > rightSum[2] && leftSum[2] > crossingSum[2]) 
		{
			return leftSum;
		}
		else
			return crossingSum;
	}
	public static int[] FindMaxCrossingSubArray(int Arr[], int low, int mid, int high)
	{
		int leftSum=Integer.MIN_VALUE, rightSum=Integer.MIN_VALUE;
		int runningSum=0, leftSubArrIdx=mid, RightSubArrIndex=mid+1;
		
		for (int i=mid; i>=low; i--)
		{
			runningSum+=Arr[i];
			if (runningSum > leftSum)
			{
				leftSum=runningSum;
				leftSubArrIdx=i;
			}
		}
		
		runningSum=0;
		
		for (int i=mid+1; i<=high; i++)
		{
			runningSum+=Arr[i];
			if (runningSum > rightSum)
			{
				rightSum=runningSum;
				RightSubArrIndex=i;
			}
		}
		int returnArr[]= {leftSubArrIdx, RightSubArrIndex, leftSum+rightSum};
		return returnArr;
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
