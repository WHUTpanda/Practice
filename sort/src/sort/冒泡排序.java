package sort;

public class 冒泡排序 {

	public static void main(String[] args) {
		int a[]= {34,12,43,23,64,54,32,9,3,0,8,5,4,7,10,6,7,5,6,12,2,5,1,1,16};
		long t1=System.currentTimeMillis();
		sort(a);
		long t2=System.currentTimeMillis();
		System.out.print("用时为："+(t2-t1));

	}
	public static void sort(int []nums)
    {
        for(int i=0;i<nums.length-1;i++)
        {
            for(int j=0;j<nums.length-1-i;j++)
            {
                if(nums[j]>nums[j+1])
                    nums[j]=nums[j+1]+(nums[j+1]=nums[j])*0;//互换值
                
            }
        }
        for(int k =0;k<nums.length;k++)
        	System.out.print(nums[k]+" ");
        System.out.println();
    }

}
