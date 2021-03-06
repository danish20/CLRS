
public class ReverseInsertionSort {

	public static void main(String[] args) {
		int a[] = {5,4,1,2,3,6};
		a = revInsertionSort(a);
		print(a);
	}
	
	public static void print(int a[])
	{
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+" ");
		}
	}
	public static int[] revInsertionSort(int a[])
	{
		for (int j = 1; j < a.length; j++) {
			int key = a[j];
			int i = j-1;
			while(i>-1 && a[i]<key)
			{
				a[i+1] = a[i];
				i = i-1;
			}
			a[i+1] = key;
		}
		return a;
	}
}
