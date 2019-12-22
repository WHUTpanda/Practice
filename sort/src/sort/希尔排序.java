package sort;


public class 希尔排序 {

	public static void main(String[] args) {
		int a[]= {34,12,43,23,64,54,32,9,3,0,8,5,4,7,10,6,7,5,6,12,2,5,1,1,16};
		long t1=System.currentTimeMillis();
		sort(a);
		long t2=System.currentTimeMillis();
		System.out.print("用时为："+(t2-t1));

	}
	public static void sort(int []nums)
    {
		int gap=nums.length/2;//增量
		for(;gap>0;gap/=2)//对增量逐渐减半
		{
			for(int i=gap;i<nums.length;i++)//开始插入排序
			{
				int cur=nums[i];//移动值
				for(int j=i-gap;j>=0;j-=gap)
				{
					if(cur<nums[j])//和前面已经排好序的位置上面的数逐个比较
					{
						nums[j+gap]=nums[j];//将正在比较位置的数赋给后一位置
						nums[j]=cur;//当前位置设为移动值
					}
					else 
						break;
				}
				
			}
		}
		for(int k =0;k<nums.length;k++)
        	System.out.print(nums[k]+" ");
        System.out.println();
    }

}
