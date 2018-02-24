
public class SumOfTwoBinaryNumbers {
	public static void main(String[] args) {
		int a[]={1,0,0,1,1,1};
		int b[] = {1,1,1,0,0,1};
		print(findSum(a, b));
	}
	
	public static void print(int a[])
	{
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+" ");
		}
	}
	
	public static int[] findSum(int a[], int b[])
	{
		int sum[] = new int[a.length+1];
		int carry=0;
		for (int i = a.length-1; i >-1 ; i--) {
			int temp = a[i]+b[i]+carry;
			switch(temp)
			{
			case 0:
				sum[i+1]=0;
				carry = 0;
				break;
			case 1:
				sum[i+1]=1;
				carry = 0;
				break;
			case 2:
				sum[i+1]=0;
				carry = 1;
				break;
			case 3:
				sum[i+1]=1;
				carry = 1;
				break;
			}
			
			sum[0] = carry;
			
				
		}
		return sum;
	}
	
}
