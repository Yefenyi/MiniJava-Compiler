package CodeGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RegisterAllocatorSimple {
	
	private Map<String,String> finalRegMap;
	private List<List<String>> usedRegs;
	private List<List<String>> assignedRegs;
	private List<String> labels;
	private Map<String,Boolean> freeRegMap;
	private int maxReg;
	private int stackUsed;
	
	private Set<String> noRegPrefixes;
	private Set<String> rTypePrefixes;
	private Set<String> iTypePrefixes;
	private Set<String> jumpPrefixes;
	
	public RegisterAllocatorSimple() {
		this.resetEnvironment();
	}
	
	private void resetEnvironment() {
		maxReg = -1;
		finalRegMap = new HashMap<String,String>();
		usedRegs = new ArrayList<List<String>>();
		assignedRegs = new ArrayList<List<String>>();
		freeRegMap = new HashMap<String,Boolean>();
		labels = new ArrayList<String>();
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
			noRegPrefixes.add("#");
			noRegPrefixes.add("syscall");
			noRegPrefixes.add("nop");
			noRegPrefixes.add("jr ");
		}
		for(String s : noRegPrefixes) {
			if(ins.startsWith(s)) {
				return true;
			}
		}
		return false;
	}
	
	private boolean isJumpPrefix(String ins) {
		if(jumpPrefixes == null) {
			jumpPrefixes = new HashSet<String>();
			jumpPrefixes.add("j ");
			jumpPrefixes.add("J ");
		}
		for(String s : jumpPrefixes) {
			if(ins.startsWith(s)) {
				return true;
			}
		}
		return false;
	}
	
	private void addUsedAndAssignedRegs(String ins) {
		List<String> usedReg = new ArrayList<String>();
		List<String> assignedReg = new ArrayList<String>();
		boolean labelAdded = false;
		if(isSomethingWithNoRegs(ins)) {
			// no registers involved with this
		} else if(ins.contains(":")) {
			String[] parts = ins.split(":");
			labels.add(parts[0].trim());
			labelAdded = true;
			addUsedAndAssignedRegs(parts[1].substring(1, parts[1].length()).trim());
			return;
		} else if(isJumpPrefix(ins)) {
			String[] parts = ins.split(" ");
			if(labels.contains(parts[1].trim())) { // We have a backwards loop, this jump statement is dependent upon stuff used in the common code
				boolean foundLabel = false;
				Set<String> haveBeenAssigned = new HashSet<String>();
				Set<String> toAddToUsed = new HashSet<String>();
				for(int i = 0 ; i < labels.size() ; ++i) {
					if(labels.get(i).equals(parts[1].trim())) {
						foundLabel = true;
					}
					if(foundLabel) {
						for(String s : usedRegs.get(i)) {
							if(!haveBeenAssigned.contains(s)) {
								toAddToUsed.add(s);
							}
						}
						haveBeenAssigned.addAll(assignedRegs.get(i));
					}
				}
				usedReg.addAll(toAddToUsed);
			}
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
			String otherReg = parts[2].split("\\(")[1].split("\\)")[0];
			if(otherReg.contains("t")) {
				assignedReg.add(otherReg);
			}
		} else if(ins.startsWith("lw ")) {
			String[] parts = ins.split(" ");
			if(parts[1].contains("t")) {
				assignedReg.add(parts[1].replace(",", ""));
			}
			String otherReg = parts[2].split("\\(")[1].split("\\)")[0];
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
		if(labels.size() == usedRegs.size()) {
			labels.add("");
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
				toReplace = this.renameReg(toReplace, oldRegName, finalRegMap.get(oldRegName));
			}
		}
		return toReplace.replace("=", "");
	}
	
	private boolean stillNeedReg(int index, String reg) {
		for(int i = index + 1 ; i < this.assignedRegs.size() ; ++i) {
			if(this.usedRegs.get(i).contains(reg)) {
				return true;
			}
			if(this.assignedRegs.get(i).contains(reg)) {
				return false;
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
	
	private int max(int a, int b) {
		return a > b ? a : b;
	}
	
	/**
	 * Need to use = signs at the end so that multiple replacements don't end up blowing away previous replacements
	 * @param ins
	 * @param oldReg
	 * @param newReg
	 * @return
	 */
	private String renameReg(String ins, String oldReg, String newReg) {
		ins = ins.replaceAll("\\" + oldReg + " ", "\\" + newReg + "= ");
		ins = ins.replaceAll("\\" + oldReg + ",", "\\" + newReg + "=,");
		ins = ins.replaceAll("\\" + oldReg + "\\)", "\\" + newReg + "=\\)");
		return ins.replaceAll("\\" + oldReg + "$", "\\" + newReg + "=");
	}
	
	private List<String> allocateRegs(List<String> insList) {
		this.resetEnvironment();
		// Initialize lists of used registers
		for(String s : insList) {
			this.addUsedAndAssignedRegs(s);
		}
		// Find the maximum register used
		for(int i = 0 ; i  < insList.size() ; ++i) {
			for(String s : usedRegs.get(i)) {
				maxReg = max(Integer.parseInt(s.split("t")[1]), maxReg);
			}
			for(String s : assignedRegs.get(i)) {
				maxReg = max(Integer.parseInt(s.split("t")[1]), maxReg);
			}
		}
		// PUT LOADS AND STORES EVERYWHERE!!!
		stackUsed = (maxReg+1) * 4;
		for(int i = 0 ; i < insList.size() ; ++i) {
			for(String s : usedRegs.get(i)) {
				List<String> assigned = new ArrayList<String>();
				assigned.add(s);
				assignedRegs.add(i, assigned);
				usedRegs.add(i, new ArrayList<String>());
				insList.add(i, "lw " + s + ", " + Integer.parseInt(s.split("t")[1]) * 4 + "($sp)");
				++i;
			}
			for(String s : assignedRegs.get(i)) {
				++i;
				List<String> used = new ArrayList<String>();
				used.add(s);
				usedRegs.add(i, used);
				assignedRegs.add(i, new ArrayList<String>());
				insList.add(i, "sw " + s + ", " + Integer.parseInt(s.split("t")[1]) * 4 + "($sp)");
			}
		}
//		for(int i = 0 ; i < insList.size() ; ++i) {
//			System.out.println(insList.get(i));
//			System.out.println("Assigned: " + assignedRegs.get(i).toString());
//			System.out.println("Used: " + usedRegs.get(i).toString());
//		}
		

		// Get things for each register and free up as possible
		for(int i = 0 ; i < insList.size(); ++i) {
			for(String s : this.assignedRegs.get(i)) {
				String usingReg = this.getFreeReg();
				if(usingReg == null) {
					System.out.println("HOWWW?");
				}
				//System.out.println("putting new thing in map: " + s + "," + usingReg);
				this.finalRegMap.put(s, usingReg);
				//System.out.println("testing after map add: " + s + "," + this.finalRegMap.get(s))
			}
			//System.out.println(insList.get(i));
			insList.set(i, replaceAllRefs(insList.get(i)));
			//System.out.println(insList.get(i));
			for(String s : this.assignedRegs.get(i)) {
				if(!stillNeedReg(i, s)) {
					this.freeRegMap.put(this.finalRegMap.get(s), true);
					System.err.println("Freed register "+ s +" on same step as assignment. Do we even need this?");
				}
			}
			for(String s : this.usedRegs.get(i)) {
				if(!stillNeedReg(i, s)) {
					//System.out.println("Freed register " + s);
					this.freeRegMap.put(this.finalRegMap.get(s), true);
				}
			}
//			System.out.println("Begin used");
//			for(String s2 : freeRegMap.keySet()) {
//				if(!freeRegMap.get(s2)) {
//					System.out.println(s2);
//				}
//			}
//			System.out.println("End used");
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
						stackUsed = 0;
						List<String> insList = this.allocateRegs(toCallAllocateOn);
						if(stackUsed > 0) {
							insList.add(0, "subi $sp, $sp, " + stackUsed);
							insList.add("addi $sp, $sp, " + stackUsed);
						}
						toOutput.addAll(insList);
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
