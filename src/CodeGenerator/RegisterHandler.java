package CodeGenerator;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.tree.ParseTree;


public class RegisterHandler {
	private List<Register> regs;
	private Register zero = new Register("zero",0);
	private int nextReg = 0;
	public RegisterHandler(){
		regs=new ArrayList<Register>();
		for(int i=0;i<100;i++){
			regs.add(new Register("t",i));
		}
	}
	
	public Register getAssignment(String pt){
		for(Register reg : regs){
			if(reg.sameTree(pt)){
				return reg;
			}
		}
		return zero;
	}
	
	public List<String> setAssignment(String pt){
		if(getAssignment(pt)==zero){
			//System.out.print("Assigning: "+pt+" to:");
			//System.out.println(nextReg);
			regs.get(nextReg).setTree(pt);
			nextReg++;
		}
		//Return list is for if any memory management instructions has to be done to save reg values
		return null;
	}
	public void replaceLast(String pt){
		if(nextReg!=0){
			regs.get(nextReg-1).setTree(pt);
		}
	}
	
	public Register getNextReg(){
		return regs.get(nextReg);
	}

}
