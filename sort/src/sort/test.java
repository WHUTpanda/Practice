package sort;

public class test {

	public static void main(String[] args) {
		int x=-123;
	    long sum=0;
	    for(;x!=0;x/=10)
	    {	
	    	sum*=10;
	        sum+=x%10;        		
	    }
	    if(sum>2147483647||sum<-2147483648)
	    	System.out.print(0);
	   
	    System.out.print((int)sum);
	}
	
}
