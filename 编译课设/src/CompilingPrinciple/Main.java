package CompilingPrinciple;

import java.io.IOException;
import java.util.Vector;


import domain.Symbol;

public class Main {

	public static void main(String[] args) throws IOException, SyntaxException {
		run("D://in.txt");
		
	}
	public static void run(String path) throws IOException, SyntaxException {
		LexicalAnalysis la=new LexicalAnalysis(path);//进行词法分析
		Vector<Symbol> syVector = la.outVector();
    	SyntaxAnalysis sa=new SyntaxAnalysis(syVector);//进行语法分析
    	if(sa.isDoWhile(0,0))
    		sa.printFoutElementType();
    	else
    		System.out.print("语法错误");
	}
}
