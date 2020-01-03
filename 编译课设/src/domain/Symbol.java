package domain;

public class Symbol{//标记单词属性
	String sym;
	int value;
	public Symbol(String a,int b) {
		this.sym=a;
		this.value=b;
	}
	
	public String getSym() {
		return sym;
	}
	public int getValue() {
		return value;
	}
}
