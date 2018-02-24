
public class MaxSubArrayDivideAndConquer {

	public static void main(String[] args) {
		
		int a[] = {13,-3,-25,20,-3,-16,-23,18,20,-7,12,-5,-22,15,-4,7};
		System.out.println(findMaxSubArray(a, 0, a.length-1));
	}
	
	public static ResultArray findCrossSubArray(int arr[], int low, int mid, int high)
	{
		int leftSum = Integer.MIN_VALUE;
		int sum = 0;
		int maxLeft = mid;
		for (int i = mid; i > low; i--) {
			sum+=arr[i];
			if(sum>leftSum)
			{
				leftSum = sum;
				maxLeft = i;
			}
		}
		
		int rightSum = Integer.MIN_VALUE;
		sum = 0;
		int maxRight = mid+1;
		for (int i = mid+1; i < high; i++) {
			sum+=arr[i];
			if(sum>rightSum)
			{
				rightSum = sum;
				maxRight = i;
			}
		}
		ResultArray result = new ResultArray(maxLeft, maxRight, leftSum+rightSum);
		return result;
	}
	
	public static ResultArray findMaxSubArray(int[] arr, int low, int high)
	{
		if(low == high)
		{
			return new ResultArray(low, high, arr[low]);
		}
		int mid = (low+high)/2;
		ResultArray leftResult = findMaxSubArray(arr, low, mid);
		ResultArray rightResult = findMaxSubArray(arr, mid+1, high);
		ResultArray crossResult = findCrossSubArray(arr, low, mid, high);
		
		if(leftResult.max>rightResult.max && leftResult.max>crossResult.max)
			return leftResult;
		else if(rightResult.max>crossResult.max)
			return rightResult;
		else
			return crossResult;
	}
	
	static class ResultArray
	{
		private int start,end,max;
		
		public ResultArray(int start, int end, int max)
		{
			this.start = start;
			this.end = end;
			this.max = max;
		}
		
		public int getStart()
		{
			return this.start;
		}
		
		public int getEnd()
		{
			return this.end;
		}
		
		public int getMax()
		{
			return this.max;
		}
		
		public String toString()
		{
			return "Start Index:"+start+" End Index:"+end+" Maximum Sum:"+max;
		}
		
	}
}


