package sort;

public class 选择排序 {

	public static void main(String[] args) {
		int a[]= {9,8,3,7,6,12,2,5};
		long t1=System.currentTimeMillis();
		sort(a);
		long t2=System.currentTimeMillis();
		System.out.print("用时为："+(t2-t1));

	}
	public static void sort(int []nums)
    {
        for(int i=0;i<nums.length-1;i++)
        {
        	int min=nums[i];
        	int min_j=i;
            for(int j=i+1;j<nums.length;j++)
            {
                if(min>nums[j])
                {
                	min=nums[j];
                	min_j=j;
                } 
            }
            nums[i]=nums[min_j]+(nums[min_j]=nums[i])*0;
            
        }for(int k =0;k<nums.length;k++)
                	System.out.print(nums[k]+" ");
                System.out.println();
    }

}
