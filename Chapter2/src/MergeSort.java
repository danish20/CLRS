
public class MergeSort {
	public static void main(String[] args) {
		
		int a[] = {4,5,7,1,2,3,6};
		print(mergeSort(a, 0, 6));
	}
	
	public static void print(int a[])
	{
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
	
	public static int[] mergeSort(int a[],int start, int end)
	{
		if(start<end)
		{
		int pivot = (start+end)/2;
		mergeSort(a, start, pivot);
		mergeSort(a, pivot+1, end);
		a = modifiedMerge(a,start,end,pivot);
		}
		
		return a;
	}
	
	//Using Sentinel
	public static int[] merge(int a[], int start, int end, int pivot)
	{
		
		int num1 = pivot-start+1;
		int num2 = end - pivot;
		int left[] = new int[num1+1];
		int right[] = new int[num2+1];
		
		for (int i = 0; i < num1; i++) {
			left[i] = a[start+i];
		}
		left[num1] = Integer.MAX_VALUE;
		
		for (int i = 0; i < num2; i++) {
			right[i] = a[pivot+i+1];
		}
		right[num2] = Integer.MAX_VALUE;
		
		int i = 0;
		int j = 0;
		
		for(int k = start; k<= end;k++)
		{
			if(left[i]<=right[j])
			{
				a[k] = left[i];
				i++;
			}
			
			else
			{
				a[k] = right[j];
				j++;
			}
		}
		
		return a;
	}
	
	
	//Without using sentinel 
	public static int[] modifiedMerge(int a[], int start, int end, int pivot)
	{
		
		int num1 = pivot-start+1;
		int num2 = end - pivot;
		int left[] = new int[num1];
		int right[] = new int[num2];
		
		for (int i = 0; i < num1; i++) {
			left[i] = a[start+i];
		}
		for (int i = 0; i < num2; i++) {
			right[i] = a[pivot+i+1];
		}		
		int i = 0;
		int j = 0;
		
		for(int k = start; k<= end;k++)
		{
			if(i<num1 && j<num2)
			{
			if(left[i]<=right[j])
			{
				a[k] = left[i];
				i++;
			}
			
			else
			{
				a[k] = right[j];
				j++;
			}
			}
			else if(j<num2)
			{
				a[k] = right[j];
				j++;
			}
			else
			{
				a[k] = left[i];
				i++;
			}
		}
		
		return a;
	}

}
