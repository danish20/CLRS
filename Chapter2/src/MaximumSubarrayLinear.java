
public class MaximumSubarrayLinear {
	public static void main(String[] args) {
		int a[] = {13,-3,-25,20,-3,-16,-23,18,20,-7,12,-5,-22,15,-4,7};
		int b[] = {-4,-5,-10,-1,-9};
		System.out.println(findMax(b));
		System.out.println(findMaxWithAllNegatives(b));
	}
	
	public static int findMax(int a[])
	{
		int maxSum = 0;
		int maxEnd = 0;
		for (int x:a) 
		{
			maxEnd = Math.max(0,x+maxEnd);
			maxSum = Math.max(maxSum, maxEnd);	
		}
		return maxSum;
	}
	
	public static int findMaxWithAllNegatives(int a[])
	{
		int maxSum = 0;
		int maxEnd = 0;
		for (int x:a) 
		{
			maxEnd = Math.max(0,x+maxEnd);
			maxSum = Math.max(maxSum, maxEnd);	
		}
		if(maxSum == 0)
		{
			return findMaxElement(a);
		}
		else
			return maxSum;
	}
	
	public static int findMaxElement(int a[])
	{
		int max = Integer.MIN_VALUE;
		for(int x:a)
		{
			max = Math.max(x, max);
		}
		return max;
	}
}
