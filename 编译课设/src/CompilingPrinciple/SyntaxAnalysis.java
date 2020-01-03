package CompilingPrinciple;

import java.util.Vector;

import javax.swing.text.StyledEditorKit.BoldAction;

import domain.FourElementType;
import domain.Symbol;
class SyntaxException extends Exception{
		public SyntaxException() {
			System.out.print("语法错误");
		}
	}
public class SyntaxAnalysis {
	Vector<Symbol> syVector;
	Vector<FourElementType> fourElementTypes=new Vector<FourElementType>();
	FourElementType curType;
	int num=0;
	public void printFoutElementType() {
		int i=1;
    	for(FourElementType fourElementType:fourElementTypes) {
    		System.out.println(i+":"+fourElementType.toString());
    		i++;
    	}
    	System.out.println(i+":");
    }
	
	public SyntaxAnalysis(Vector<Symbol> SyVector)
	{
		this.syVector=SyVector;
	}
	public void print() {
    	for(int i=0;i<syVector.size();i++) {
    		System.out.println("("+syVector.get(i).getSym()+","+syVector.get(i).getValue()+")");
    	}
    }
	
	
	
	//递归下降法
	//判断是否为doWhile
	public boolean isDoWhile(int start,int end)throws SyntaxException{
		int i=start;
		int Do=0;
		boolean isFind=false;
		if(syVector.get(i).getValue()==12)//判断是否为do
			{
				Do=fourElementTypes.size()+1;
				i++;
			}
		else
			return false;
		if(syVector.get(i).getValue()==21)//判断是否为{
		{
			i++;	
			start=i;		
		}
		else
			return false;
		int j=0;
		for(;i<syVector.size();i++)//找到下一个}
		{
			if(syVector.get(i).getValue()==21)
				j++;
			if(syVector.get(i).getValue()==22)
			{
				if(j==0)
				{
					isFind=true;
					end=i-1;
					i++;
					break;
				}
				else {
					j--;
				}
			}
		}
		if(isFind)//判断找到没有
			isFind=false;
		else
			return false;
		if(!isCode(start,end))//判断{}中间是否为合法代码段
			return false;
		if(syVector.get(i).getValue()==11)//判断是否为while
			i++;
		else
			return false;
		if(syVector.get(i).getValue()==19)//判断是否为(
		{
			i++;
			start=i;		
		}
		else
			return false;
		for(;i<syVector.size();i++)//找到下一个)
			if(syVector.get(i).getValue()==20)
			{
				isFind=true;
				end=i-1;
				i++;
				break;
			}
		if(isFind)//判断找到没有
			isFind=false;
		else
			return false;
		if(!isBoolExpression(start, end))//判断()中间是否为布尔表达式
			return false;
		curType.setFour(String.valueOf(Do));
		fourElementTypes.add(curType);
		FourElementType fourElementType=new FourElementType
				("j",null,null,String.valueOf(fourElementTypes.size()+2));
		fourElementTypes.add(fourElementType);
		if(i>=syVector.size()||syVector.get(i).getValue()!=17)//判断有没有;
			return false;
		return true;		
	}
	//判断是否为代码段
	public boolean isCode(int start,int end) throws SyntaxException {
		int i=start;
		int s=start;
		int e=end;
		while(i<=end){
		for(;i<=end;i++)
		{
			if(syVector.get(i).getValue()==21)//判断是否为{
			{
				i++;	
				int j=0;
				for(;i<syVector.size();i++)//找到下一个}
				{
					if(syVector.get(i).getValue()==21)
						j++;
					if(syVector.get(i).getValue()==22)
					{
						if(j==0)
						{
							i++;
							break;
						}
						else
							j--;
					}
				}		
			}
			if(syVector.get(i).getValue()==17)//根据；进行分割
			{
				e=i;
				i++;
				break;
			}
		}
			
		if(!isAssignment(start, e)&&!isDoWhile(start,e))
			return false;
		start=e+1;
		}
		return true;
	}
	
	
	
	//判断是否为赋值语句
	public boolean isAssignment(int start,int end) {
		int i=start;
		curType=new FourElementType();
		if(syVector.get(i).getValue()==33)//标识符
			{
			curType.setFour(syVector.get(i).getSym());
			i++;
			}
		else
			return false;
		if(syVector.get(i).getValue()==27)//=
			{
			curType.setOne(syVector.get(i).getSym());
			i++;
			}
		else
			return false;
		start=i;
		if(isExpression(start, end-1)==0)//表达式
			return false;
		if(syVector.get(end).getValue()!=17)//判断有没有;
			return false;
		fourElementTypes.add(curType);
		return true;
	}
	//判断是否为表达式
	public int isExpression(int start,int end) {
		int rt=isTerm(start, end);
		if(rt==1)//为项
		{
			return 1;
		}
		if(rt==2)
		{
			curType.setTwo("t"+num);
			return 1;
		}
		int i=start;
		
		while(i<=end)//<表达式>+-<项>
		{
			if(syVector.get(i).getValue()==23||syVector.get(i).getValue()==24)
				break;
			i++;
		}
		if(i>end)
			return 0;
		int rs=isExpression(start, i-1);
		if(rs!=0)	
		{
			rt=isTerm(i+1, end);
			if(rt==1)//为项
			{
				if(rs==1)
					fourElementTypes.add(new FourElementType(syVector.get(i).getSym(),
							syVector.get(i-1).getSym(),syVector.get(i+1).getSym(),"t"+(++num)));
				return 2;
			}
			if(rt==2)
			{
				if(rs==1)
					fourElementTypes.add(new FourElementType(syVector.get(i).getSym(),
							syVector.get(i-1).getSym(),"t"+num,"t"+(++num)));
				curType.setTwo("t"+num);
				return 2;
			}
		}
		return 0;
	}
	//判断是否为项
	public int isTerm(int start,int end)
	{
		if(start==end&&(syVector.get(start).getValue()==32||syVector.get(start).getValue()==33))
		{
			if(curType.getTwo()!=null)
				curType.setThree(syVector.get(start).getSym());
			else
				curType.setTwo(syVector.get(start).getSym());
			return 1;
		}
		if(start!=end&&(syVector.get(start).getValue()==32||syVector.get(start).getValue()==33))
		{
			if(syVector.get(start+1).getValue()==25||syVector.get(start+1).getValue()==26)
			{
				if(syVector.get(start+2).getValue()==32||syVector.get(start+2).getValue()==33)
				{
					fourElementTypes.add(new FourElementType(syVector.get(start+1).getSym(),
							syVector.get(start).getSym(),syVector.get(start+2).getSym(),"t"+(++num)));
					return 2;
				}
			}
		}
		return 0;
	}
	//判断是否为布尔表达式
	public boolean isBoolExpression(int start,int end) {
		int i=start;
		curType=new FourElementType();
		int rt=0;
		while(i<=end)
		{
			rt=isJudgingOperator(i);
			if (rt!=0) 
			{
				i+=rt;
				break;
			}
			i++;
		}
		int temp=num;
		int rt1=isExpression(start, i-rt-1);
		int temp1=num;
		int rt2=isExpression(i, end);
		int temp2=num;
		if(rt1!=0&&rt2!=0)
		{
			if(temp!=temp1&&temp1!=temp2)
			{
				curType.setTwo("t"+temp1);
				curType.setThree("t"+temp2);
			}
			else if(temp!=temp1)
				curType.setTwo("t"+temp1);
			else if(temp1!=temp2)
				curType.setThree("t"+temp2);
			return true;
		}
		
		return false;
	}
	//判断是否为比较运算符
	public int isJudgingOperator(int start)
	{
		if(syVector.get(start).getValue()==28)//<
			if (syVector.get(start+1).getValue()==27) //=			
			{
				curType.setOne("j"+syVector.get(start).getSym()+syVector.get(start+1).getSym());	
				return 2;
			}
			else 
				{
				curType.setOne("j"+syVector.get(start).getSym());	
				return 1;
				}
		if(syVector.get(start).getValue()==29)
			if (syVector.get(start+1).getValue()==27) 
			{
				curType.setOne("j"+syVector.get(start).getSym()+syVector.get(start+1).getSym());	
				return 2;
			}
			else 
			{
				curType.setOne("j"+syVector.get(start).getSym());	
				return 1;
			}
		if(syVector.get(start).getValue()==27&&syVector.get(start+1).getValue()==27)
		{
			curType.setOne("j"+syVector.get(start).getSym()+syVector.get(start+1).getSym());	
			return 2;
		}
		if(syVector.get(start).getValue()==31&&syVector.get(start+1).getValue()==27)
		{
			curType.setOne("j"+syVector.get(start).getSym()+syVector.get(start+1).getSym());	
			return 2;
		}
		return 0;
	}
}
