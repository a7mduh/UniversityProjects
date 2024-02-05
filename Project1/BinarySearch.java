
public class BinarySearch {
	public static void main(String[] args)
	{
		int A1[]= {}; //case 1
		BS(A1, 5);
		
		int A2[]= {1}; //case 2a
		BS(A2, 1);
		
		int A3[]= {5}; //case 2b
		BS(A3, 10);
		
		int A4[]= {10}; //case 2c
		BS(A4, 5);
		
		int A5[]= {5,6,7,8,9,11,55}; //case 3
		BS(A5, 3);
		
		int A6[]= {5,6,7,8,9,11,55}; //case 4
		BS(A6, 100);
		
		int A7[]= {5,6,7,9,11}; //case 5 (middle element)
		BS(A7, 7);
		
		int A8[]= {5,6,7,9,11}; //case 5 (first element)
		BS(A8, 5);
		
		int A9[]= {5,6,7,9,11}; //case 5 (last element)
		BS(A9, 11);
		
		int A10[]= {5,6,7,9,11}; //case 6 (key not in the array)
		BS(A10, 8);
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
