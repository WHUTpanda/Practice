package learn;

public class HelloWorld {

	public static void main(String[] args) {
		System.out.println("helloworld");
	}

}
/**
 * 源文件名必须与public类名相同
 * 一个源文件中只能有一个public类
 * 一个源文件中可以有多个非源文件类
 * String类型一旦被创建就不可更改，通常进行连接是创建了一个新的对象，原先的对象被JVM回收了
 * StringBuilder线程不安全但是速度较快（和StringBuffer相比）
 * dataType[] arrayRefVar;   // 数组申明的首选方法
 * 重写：不能抛出比父类更加广泛的异常。访问权限不能做更严格的限制。
 * 多态存在的三个必要条件：
 *1.继承
 *2.重写
 *3.父类引用指向子类对象
 */