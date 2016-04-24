package CodeGenerator;

import org.antlr.v4.runtime.tree.ParseTree;


public class Register {
	String type;
	int number;
	ParseTree represents;
	
	public Register(String type, int number){
		this.type = type;
		this.number = number;
	}
	
	@Override
	public String toString(){
		return "$"+this.type + String.valueOf(number);
	}
	public void setTree(ParseTree pt){
		this.represents = pt;
	}
}

