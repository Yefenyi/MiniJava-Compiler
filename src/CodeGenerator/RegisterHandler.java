package CodeGenerator;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.tree.ParseTree;


public class RegisterHandler {
	List<Register> regs;
	Register zero = new Register("zero",0);
	int currentReg = 0;
	public RegisterHandler(){
		regs=new ArrayList<Register>();
		for(int i=0;i<100;i++){
			regs.add(new Register("t",0));
		}
	}
	
	public Register getAssignment(ParseTree pt){
		for(Register reg : regs){
			if(reg.sameTree(pt)){
				return reg;
			}
		}
		return zero;
	}
	
	public List<String> setAssignment(ParseTree pt){
		regs.get(currentReg).setTree(pt);
		currentReg++;
		//Return list is for if any memory management instructions has to be done to save reg values
		return null;
	}

}
