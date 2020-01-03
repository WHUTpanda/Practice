package domain;

public class FourElementType {
	public String one;
	public String two;
	public String three;
	public String four;
	public FourElementType(String one,String two,String three,String four) {
		this.one=one;
		this.two=two;
		this.three=three;
		this.four=four;
 	}
	public FourElementType() {
	}
	public void setOne(String one) {
		this.one = one;
	}
	public String getFour() {
		return four;
	}
	public void setFour(String four) {
		this.four = four;
	}
	public void setTwo(String two) {
		this.two = two;
	}
	public void setThree(String three) {
		this.three = three;
	}
	public String getOne() {
		return one;
	}
	public String getThree() {
		return three;
	}
	public String getTwo() {
		return two;
	}

	public String toString() {
		if(one==null)
			one="_";
		if(two==null)
			two="_";
		if(three==null)
			three="_";
		if(four==null)
			four="_";
		return "("+one+","+two+","+three+","+four+")";
	}
}
