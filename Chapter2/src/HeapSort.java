
public class HeapSort {
	public static void main(String[] args) {
		
		int a[] = {4,1,3,2,16,9,10,14,8,7};
		a = heapSort(a);
		printArray(a);
	}
	
	public static void printArray(int a[])
	{
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+" ");
		}
	}
	
	public static int[] heapSort(int a[])
	{
		int n = a.length;
		
		//build heap
		for (int i = (n/2)-1; i >= 0; i--) {
			maxHeapify(a, n, i);
		}
		
		// remove root and move it to last
		for(int i = n-1; i>=0; i--)
		{
			int temp = a[0];
			a[0] = a[i];
			a[i] = temp;
			maxHeapify(a, i, 0);
		}
		
		return a;
	}
	
	public static void maxHeapify(int a[], int n, int i)
	{
		int largest = i;
		int l = 2*i+1;
		int r = 2*i+2;
		
		//largest is the left element
		if(l<n && a[l]>a[largest])
			largest = l;
		
		//largest is right
		if(r<n && a[r]>a[largest])
			largest = r;
		
		if(largest!=i)
		{
			int temp = a[i];
			a[i] = a[largest];
			a[largest] = temp;
			maxHeapify(a, n, largest);
		}
	}
}
