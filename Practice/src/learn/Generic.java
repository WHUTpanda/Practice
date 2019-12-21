package learn;


public class Generic {
	public static void main(String[] args) {
		int a=1;
		g(a);
		String b="1";
		g(b);
		double c=1.0;
		g(c);
	}
	public static <T> void g(T a) {
		System.out.println(a.getClass().toString());
	}
}
