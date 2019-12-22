package sort;

public class 插入排序 {//适合小规模基本有序的数据

	public static void main(String[] args) {
		int a[]= {9,3,0,8,5,4,7,10,6,7,5};
		long t1=System.currentTimeMillis();
		sort(a);
		long t2=System.currentTimeMillis();
		System.out.print("用时为："+(t2-t1));

	}
	public static void sort(int []nums)
    {
       for(int i=0;i<nums.length-1;i++)
       { 
    	   int temp=nums[i+1];
    	   for(int j = i;j>=0;j--)
    	   {
    		   if(temp<nums[j])
    		   {
    			  nums[j+1]=nums[j];
    			  nums[j]=temp;
    		   }
    		   else {
    			   break;
    		   }
    		   
    	   }
    	   
       }
       for(int k =0;k<nums.length;k++)
   			System.out.print(nums[k]+" ");
           System.out.println();
    }
}
