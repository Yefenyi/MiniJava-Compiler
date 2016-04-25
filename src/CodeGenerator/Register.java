package CodeGenerator;

import org.antlr.v4.runtime.tree.ParseTree;


public class Register {
	String type;
	int number;
	boolean neededValue;//TODO Update neededValue based on data graph
	ParseTree represents;
	
	public Register(String type, int number){
		this.type = type;
		this.number = number;
	}
	
	@Override
	public String toString(){
		if(this.isZeroReg()){
			return "$zero";
		}
		return "$"+this.type + String.valueOf(number);
	}
	public void setTree(ParseTree pt){
		if(this.isZeroReg()) return;
		this.represents = pt;
	}
	public boolean sameTree(ParseTree pt){
		return pt.equals(this.represents);
		//TODO a better version of this
	}
	private boolean isZeroReg(){
		return this.type.equals("zero");
	}
}

