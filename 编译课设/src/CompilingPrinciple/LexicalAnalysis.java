package CompilingPrinciple;

import java.awt.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;
import domain.*;
public class LexicalAnalysis {
	String a;
	Vector<Symbol> sysVector=new Vector<Symbol>();
	public LexicalAnalysis(String path) throws IOException {
		 String s = " ";
        try {
            FileReader rf = new FileReader(path);
            BufferedReader brf = new BufferedReader(rf);
            String rs = brf.readLine();
            while (rs != null) {
                s = s + rs + "\n";
                rs = brf.readLine();
            }
            brf.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        s = s.replaceAll("\n", " ");
        a=s;
	}
	
	public int judgetype(char a) {//判断1表示数字，2表示运算符号，3表示界限符，4表示字母
        switch (a) {
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
            case '0':
                return 1;
            case '+':
            case '-':
            case '*':
            case '/':
            case '=':
            case '#':
            case '<':
            case '>':
            case ':':
                return 2;
            case '|':
            case ',':
            case ';':
            case '.':
            case '(':
            case ')':
            case '{':
            case '}':
                return 3;
            case 'a':
            case 'b':
            case 'c':
            case 'd':
            case 'e':
            case 'f':
            case 'g':
            case 'h':
            case 'i':
            case 'j':
            case 'k':
            case 'l':
            case 'm':
            case 'n':
            case 'o':
            case 'p':
            case 'q':
            case 'r':
            case 's':
            case 't':
            case 'u':
            case 'v':
            case 'w':
            case 'x':
            case 'y':
            case 'z':
            case 'A':
            case 'B':
            case 'C':
            case 'D':
            case 'E':
            case 'F':
            case 'G':
            case 'H':
            case 'I':
            case 'J':
            case 'K':
            case 'L':
            case 'M':
            case 'N':
            case 'O':
            case 'P':
            case 'Q':
            case 'R':
            case 'S':
            case 'T':
            case 'U':
            case 'V':
            case 'W':
            case 'X':
            case 'Y':
            case 'Z':
                return 4;
            default:
                return 0;
        }
    }

    public int  judgeKeyword(String a) {
        switch (a) {
            case "begin":return 1;
            case "const":return 2;
            case "var": return 3;
            case "procedure":return 4;
            case "end":return 5;
            case "odd":return 6;
            case "if":return 7;
            case "then":return 8;
            case "else":return 9;
            case "call":return 10;
            case "while":return 11;
            case "do":return 12;
            case "read":return 13;
            case "write":return 14;
            default:
                break;
        }
        return 33;//标识符
    }
    
    public int judgeoperator(String a) {
    	switch (a) {
    	case "+":return 23;
    	case "-":return 24;
    	case "*":return 25;
    	case "/":return 26;
    	case "=":return 27;
    	case"<":return 28;
    	case">":return 29;
    	case":":return 30;
    	case"!":return 31;
    	default:
    		return 0;
    }}
    public int judgelimit(String a) {
    	switch (a) {
		case "|":return 15;
		case",":return 16;
		case";":return 17;
		case".":return 18;
		case"(":return 19;
		case")":return 20;
		case"{":return 21;
		case"}":return 22;
		default:
			return 0;
		}
    }	

    public Vector<Symbol> outVector() {
    	String current=""+a.charAt(0);
    	int oldjudge =judgetype(a.charAt(0)); 
    	int i =1;
        int currentjudge;
        char qwe=a.charAt(0);
        while (i <a.length()) {
	            qwe = a.charAt(i);
	            currentjudge = judgetype(qwe);
	            if (currentjudge == oldjudge&&(currentjudge==4||currentjudge==1)) {
	                	current = current + qwe;
	            }
	            else {
		            	int value;
		            	if(oldjudge==1) {            		
		            		value=32;   //常数 
		            		Symbol sy=new Symbol(current,value);
		                	sysVector.add(sy);
		            	}
		            	if(oldjudge==2) {
		            		value=judgeoperator(current);
		            		Symbol sy=new Symbol(current,value);
		                	sysVector.add(sy);
		            	}
		            	if(oldjudge==3) {
		            		value=judgelimit(current);
		            		Symbol sy=new Symbol(current,value);
		                	sysVector.add(sy);
		            	}
		            	if(oldjudge==4) {
		            		value=judgeKeyword(current);
		            		Symbol sy=new Symbol(current,value);
		                	sysVector.add(sy);
		            	}
		                current = "" + qwe;
		                oldjudge = currentjudge;
	            }
	            i++;
	        }
        return sysVector;
        }
        public void print() {
        	for(int i=0;i<sysVector.size();i++) {
        		System.out.println("("+sysVector.get(i).getSym()+","+sysVector.get(i).getValue()+")");
        	}
        }
    
   
}
