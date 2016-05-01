package CodeGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RegisterAllocator {
	
	private Map<String,String> finalRegMap;
	private List<List<String>> usedRegs;
	private List<List<String>> assignedRegs;
	private Map<String,Boolean> freeRegMap;
	
	private Set<String> noRegPrefixes;
	private Set<String> rTypePrefixes;
	private Set<String> iTypePrefixes;
	
	public RegisterAllocator() {
		this.resetEnvironment();
	}
	
	private void resetEnvironment() {
		finalRegMap = new HashMap<String,String>();
		usedRegs = new ArrayList<List<String>>();
		assignedRegs = new ArrayList<List<String>>();
		freeRegMap = new HashMap<String,Boolean>();
		freeRegMap.put("$t0", true);
		freeRegMap.put("$t1", true);
		freeRegMap.put("$t2", true);
		freeRegMap.put("$t3", true);
		freeRegMap.put("$t4", true);
		freeRegMap.put("$t5", true);
		freeRegMap.put("$t6", true);
		freeRegMap.put("$t7", true);
		freeRegMap.put("$t8", true);
		freeRegMap.put("$t9", true);
		freeRegMap.put("$s0", true);
		freeRegMap.put("$s1", true);
		freeRegMap.put("$s2", true);
		freeRegMap.put("$s3", true);
		freeRegMap.put("$s4", true);
		freeRegMap.put("$s5", true);
		freeRegMap.put("$s6", true);
		freeRegMap.put("$s7", true);
		freeRegMap.put("$k0", true);
		freeRegMap.put("$k1", true);
	}
	
	private boolean isRType(String ins) {
		if(rTypePrefixes == null) {
			rTypePrefixes = new HashSet<String>();
			rTypePrefixes.add("or ");
			rTypePrefixes.add("and ");
			rTypePrefixes.add("slt ");
			rTypePrefixes.add("sge ");
			rTypePrefixes.add("sgt ");
			rTypePrefixes.add("sge ");
			rTypePrefixes.add("seq ");
			rTypePrefixes.add("sne ");
			rTypePrefixes.add("snq "); // TODO: Remove once alvin fixes stuff
			rTypePrefixes.add("add ");
			rTypePrefixes.add("sub ");
		}
		for(String s : rTypePrefixes) {
			if(ins.startsWith(s)) {
				return true;
			}
		}
		return false;
	}
	
	private boolean isIType(String ins) {
		if(iTypePrefixes == null) {
			iTypePrefixes = new HashSet<String>();
			iTypePrefixes.add("xori ");
			iTypePrefixes.add("addi ");
		}
		for(String s : iTypePrefixes) {
			if(ins.startsWith(s)) {
				return true;
			}
		}
		return false;
	}
	
	private boolean isSomethingWithNoRegs(String ins) {
		if(noRegPrefixes == null) {
			noRegPrefixes = new HashSet<String>();
			noRegPrefixes.add("jal ");
			noRegPrefixes.add("j ");
			noRegPrefixes.add("J ");
			noRegPrefixes.add("#");
			noRegPrefixes.add("syscall");
			noRegPrefixes.add("nop");
		}
		for(String s : noRegPrefixes) {
			if(ins.startsWith(s)) {
				return true;
			}
		}
		return false;
	}
	
	private void addUsedAndAssignedRegs(String ins) {
		List<String> usedReg = new ArrayList<String>();
		List<String> assignedReg = new ArrayList<String>();
		if(isSomethingWithNoRegs(ins)) {
			// no registers involved with this
		} else if(ins.contains(":")) {
			String[] parts = ins.split(":");
			addUsedAndAssignedRegs(parts[1].substring(1, parts[1].length()).trim());
			return;
		} else if(isIType(ins)) {
			String[] parts = ins.split(" ");
			if(parts[1].contains("t")) {
				assignedReg.add(parts[1].replace(",", ""));
			}
			if(parts[2].contains("t")) {
				usedReg.add(parts[2].replace(",", ""));
			}
		} else if(isRType(ins)) {
			String[] parts = ins.split(" ");
			if(parts[1].contains("t")) {
				assignedReg.add(parts[1].replace(",", ""));
			}
			if(parts[2].contains("t")) {
				usedReg.add(parts[2].replace(",", ""));
			}
			if(parts[3].contains("t")) {
				usedReg.add(parts[3]);
			}
		} else if(ins.startsWith("mult ") || ins.startsWith("div ")) {
			String[] parts = ins.split(" ");
			if(parts[1].contains("t")) {
				usedReg.add(parts[1].replace(",", "")); 
			}
			if(parts[2].contains("t")) {
				usedReg.add(parts[2]);
			}
		} else if(ins.startsWith("mflo ") || ins.startsWith("jalr ")) {
			String[] parts = ins.split(" ");
			if(parts[1].contains("t")) {
				assignedReg.add(parts[1]);
			}
		} else if(ins.startsWith("li ")) {
			String[] parts = ins.split(" ");
			if(parts[1].contains("t")) {
				assignedReg.add(parts[1].replace(",", ""));
			}
		} else if(ins.startsWith("move ")) {
			String[] parts = ins.split(" ");
			if(parts[1].contains("t")) {
				assignedReg.add(parts[1].replace(",", ""));
			}
			if(parts[2].contains("t")) {
				usedReg.add(parts[2].replace(",", ""));
			}
		} else if(ins.startsWith("sw ")) {
			String[] parts = ins.split(" ");
			if(parts[1].contains("t")) {
				usedReg.add(parts[1].replace(",", ""));
			}
			String otherReg = parts[2].split("\\(")[1].replace("\\)", "");
			if(otherReg.contains("t")) {
				assignedReg.add(otherReg);
			}
		} else if(ins.startsWith("lw ")) {
			String[] parts = ins.split(" ");
			if(parts[1].contains("t")) {
				assignedReg.add(parts[1].replace(",", ""));
			}
			String otherReg = parts[2].split("\\(")[1].replace("\\)", "");
			if(otherReg.contains("t")) {
				usedReg.add(otherReg);
			}
		} else if(ins.startsWith("beq ")) {
			String[] parts = ins.split(" ");
			if(parts[1].contains("t")) {
				usedReg.add(parts[1].replace(",", ""));
			}
			if(parts[2].contains("t")) {
				usedReg.add(parts[2].replace(",", ""));
			}
		} else {
			System.err.println("MISSING INSTRUCTION IN REGISTER ALLOCATOR: " + ins);
		}
		usedRegs.add(usedReg);
		assignedRegs.add(assignedReg);
	}
	
	private String replaceAllRefs(String toReplace) {
		if(toReplace.charAt(0) == '#') {
			return toReplace;
		}
		for(String oldRegName : finalRegMap.keySet()) {
			if(toReplace.contains(oldRegName)) {
				toReplace = toReplace.replaceAll("\\" + oldRegName + " ", "\\" + finalRegMap.get(oldRegName) + " ");
				toReplace = toReplace.replaceAll("\\" + oldRegName + ",", "\\" + finalRegMap.get(oldRegName) + ",");
				toReplace = toReplace.replaceAll("\\" + oldRegName + "$", "\\" + finalRegMap.get(oldRegName));
			}
		}
		return toReplace;
	}
	
	private boolean stillNeedReg(int index, String reg) {
		for(int i = index + 1 ; i < this.assignedRegs.size() ; ++i) {
			if(this.usedRegs.get(i).contains(reg)) {
				return true;
			}
			if(this.assignedRegs.get(i).contains(reg)) {
				return true;
			}
		}
		return false;
	}
	
	private String getFreeReg() {
		for(String reg : this.freeRegMap.keySet()) {
			if(this.freeRegMap.get(reg)) {
				this.freeRegMap.put(reg, false);
				return reg;
			}
		}
		System.err.println("We ran out of registers :(");
		return null;
	}
	
	private List<String> allocateRegs(List<String> insList) {
		this.resetEnvironment();
		// Initialize lists of used registers
		for(String s : insList) {
			this.addUsedAndAssignedRegs(s);
		}
		for(int i = 0 ; i  < insList.size() ; ++i) {
			System.out.println(insList.get(i));
			System.out.println("\tAssigned: " + this.assignedRegs.get(i).toString());
			System.out.println("\tUsed: " + this.usedRegs.get(i).toString());
		}

		// Get things for each register and free up as possible
		for(int i = 0 ; i < insList.size(); ++i) {
			for(String s : this.assignedRegs.get(i)) {
				if(!this.finalRegMap.containsKey(s)) {
					String usingReg = this.getFreeReg();
					System.out.println("putting new thing in map: " + s + "," + usingReg);
					this.finalRegMap.put(s, usingReg);
					System.out.println("testing after map add: " + s + "," + this.finalRegMap.get(s));
				}
			}
			for(String s : this.assignedRegs.get(i)) {
				if(!stillNeedReg(i, s)) {
					this.freeRegMap.put(this.finalRegMap.get(s), true);
					System.err.println("Freed register "+ s +" on same step as assignment. Do we even need this?");
				}
			}
			for(String s : this.usedRegs.get(i)) {
				if(!stillNeedReg(i, s)) {
					System.out.println("Freed register " + s);
					this.freeRegMap.put(this.finalRegMap.get(s), true);
				}
			}
		}
		
		for(String s : this.finalRegMap.keySet()) {
			System.out.println("Original: " + s + "; Final: " + this.finalRegMap.get(s));
		}
		
		// Rename all regs
		for(int i = 0 ; i < insList.size(); ++i) {
			insList.set(i, replaceAllRefs(insList.get(i)));
		}
		return insList;
	}
	
	public List<String> allocateAllRegs(List<String> fullProgList) {
		List<String> toOutput = new ArrayList<String>();
		List<String> toCallAllocateOn = new ArrayList<String>();
		int envDepth = 0;
		for(String ins : fullProgList) {
			if(envDepth == 0) {
				if(ins.equals("#exit environment")) {
					System.err.println("Mismatched enter and exit environments (aka yell at Alvin)");
				}
				if(ins.equals("#enter environment")) {
					++envDepth;
					toCallAllocateOn.add(ins);
				} else {
					toOutput.add(ins);
				}
			} else { // We're in something we need to allocate
				if(ins.equals("#enter environment")) {
					++envDepth;
					toCallAllocateOn.add(ins);
				}
				else if(ins.equals("#exit environment")) {
					--envDepth;
					toCallAllocateOn.add(ins);
					if(envDepth == 0) {
						toOutput.addAll(this.allocateRegs(toCallAllocateOn));
						toCallAllocateOn.clear();
					}
				} else {
					toCallAllocateOn.add(ins);
				}
			}
		}
		return toOutput;
	}

}
