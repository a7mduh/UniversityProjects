
public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int testArray[]= {5, 14, 55, 12, 11, 15, 90};
		System.out.println("The array before sorting: ");
		for(int i=0; i<testArray.length; i++)
			System.out.print(testArray[i]+" ");
		System.out.println();
		testArray=MS(testArray);
		System.out.println("The array after sorting: ");
		for(int i=0; i<testArray.length; i++)
			System.out.print(testArray[i]+" ");
		System.out.println();
		BS(testArray, 55); //Applying the binray search after sorting
	}
	public static int[] MS(int[] Array)
	{
		int len=Array.length;
		if (len<=1) //the base condition
		{
			return Array;
		}
		
		int mid=(len/2);
		int[] leftArray, rightArray; //declaring sub-arrays 
		leftArray=new int[mid]; //initializing the sub-arrays
		if (len%2==0)
			rightArray=new int[mid];
		else
			rightArray=new int[mid+1];
		
		for(int i=0; i<mid; i++)
			leftArray[i]=Array[i];
		
		int rightLength=rightArray.length;
		
		for(int i=0; i<rightLength; i++)
			rightArray[i]=Array[i+mid];
		
		int[] sortedArray=new int[len];
		leftArray=MS(leftArray); //recursively divide the arrays into sub-arrays
		rightArray=MS(rightArray);
		sortedArray= merge(leftArray, rightArray); //merge the left and right sub-arrays into sorted order
		return sortedArray;
	}
	static int[] merge(int[] leftArr, int[] rightArr)
	{
		int leftLength=leftArr.length, rightLength=rightArr.length;
		int totalLength=leftLength+rightLength;
		int combinedArray[]=new int[totalLength]; //this will be the result sorted and merged array
		int leftIndex=0, rightIndex=0, combinedIndex=0;
		
		while(leftIndex<leftLength || rightIndex<rightLength) //as long as we have elements in any of the sub-arrays
		{
			if(leftIndex<leftLength && rightIndex<rightLength) //if we have elements in both sub-arrays
			{
				if(leftArr[leftIndex] < rightArr[rightIndex])
					combinedArray[combinedIndex++]=leftArr[leftIndex++];
				else 
					combinedArray[combinedIndex++]=rightArr[rightIndex++];
			}
			else if (leftIndex < leftLength) //remaining elements only in left array
				combinedArray[combinedIndex++]=leftArr[leftIndex++];
			else if (rightIndex < rightLength) //remaining elements only in right array
				combinedArray[combinedIndex++]=rightArr[rightIndex++];
		}
		return combinedArray;
		
	}
	public static int BS(int Array[], int key)
	{
		int len=Array.length, low=0, high=len-1;
		if(len==0)
		{
			System.out.println("The array is empty!");
			return -1;
		}
		int mid=(low+high)/2;
		while(low<=high)
		{
			if(Array[mid]==key)
			{
				System.out.println("Element was found at index: "+mid);
				return mid;
			}
			else if(key>Array[mid])
				low=mid+1;
			else
				high=mid-1;
			mid=(low+high)/2;
		}
		System.out.println("Element was not found");
		return -1;
		
	}

}
