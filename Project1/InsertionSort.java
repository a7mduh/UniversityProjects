
public class InsertionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int testArray[]= {5, 14, 55, 12, 11, 15, 90};
		System.out.println("The array before sorting: ");
		for(int i=0; i<testArray.length; i++)
			System.out.print(testArray[i]+" ");
		System.out.println();
		IS(testArray);
		System.out.println("The array after sorting: ");
		for(int i=0; i<testArray.length; i++)
			System.out.print(testArray[i]+" ");
		System.out.println();
		BS(testArray, 55); //Applying the binray search after sorting
		
	}
	public static void IS(int Array[])
	{
		int len=Array.length, temp;
		for(int i=1; i<len; i++)
		{
			int key=Array[i];
			int j=i-1;
			while(j>=0 && Array[j]>key) //this loop will put the key element into it's correct position 
			{
				temp=Array[j+1];
				Array[j+1]=Array[j];
				Array[j]=temp;
				j--;
			}
		}
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
