package sort;


public class 归并排序 {

	public static void main(String[] args) {
		int a[]= {34,12,43,23,64,54,32,9,3,0,8,5,4,7,10,6,7,6,12,2,5,1,1,16};
		long t1=System.currentTimeMillis();
		sort(a,0,a.length-1);
		long t2=System.currentTimeMillis();
		for(int k =0;k<a.length;k++)
        	System.out.print(a[k]+" ");
        System.out.println();
		System.out.print("用时为："+(t2-t1));

	}
	public static void sort(int []nums,int left,int right) {
		int mid=(left+right)/2;
		if(right>left)
		{
			sort(nums, left, mid);//将左边递归分割
			sort(nums, mid+1, right);//将右边递归分割
			merge(left,mid,right,nums);	//按顺序合并分组
		}
			
	}
	public static void merge(int left,int mid,int right,int nums[]) {
		int i=left;
		int j=mid+1;
		int k=0;
		int a[]=new int[right-left+1];
		while(j<=right&&i<=mid) {
			if(nums[i]>nums[j])
			{
				a[k++]=nums[j++];
			}
			else {
				a[k++]=nums[i++];
			}
		}
		while (i<=mid) {
			a[k++]=nums[i++];
		}
		while(j<=right)
		{
			a[k++]=nums[j++];
		}
		for(k=0;k<a.length;k++)
		{
			nums[left+k]=a[k];
		}
	}


}
