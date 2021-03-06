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
	private List<String> labels;
	private Map<String,Boolean> freeRegMap;
	private int maxReg;
	private int stackUsed;
	
	private Set<String> noRegPrefixes;
	private Set<String> rTypePrefixes;
	private Set<String> iTypePrefixes;
	private Set<String> jumpPrefixes;
	
	public RegisterAllocator() {
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
	
	private int max(int a, int b) {
		return a > b ? a : b;
	}
	
	private String renameReg(String ins, String oldReg, String newReg) {
		ins = ins.replaceAll("\\" + oldReg + " ", "\\" + newReg + " ");
		ins = ins.replaceAll("\\" + oldReg + ",", "\\" + newReg + ",");
		ins = ins.replaceAll("\\" + oldReg + "\\)", "\\" + newReg + "\\)");
		return ins.replaceAll("\\" + oldReg + "$", "\\" + newReg);
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
		

		// Get things for each register and free up as possible
		for(int i = 0 ; i < insList.size(); ++i) {
			for(String s : this.assignedRegs.get(i)) {
				if(!this.finalRegMap.containsKey(s)) {
					String usingReg = this.getFreeReg();
					if(usingReg == null) {
						// TODO: do the special stuff
						// 0. Find furthest away register usage
						String regToReassign = "";
						int maxdistance = -1;
						for(String reg : freeRegMap.keySet()) {
							for(int k = i + 1 ; k < insList.size() ; ++k) {
								for(String reg2 : usedRegs.get(k)) {
									if(finalRegMap.get(reg2) != null && finalRegMap.get(reg2).equals(reg)) {
										maxdistance = max(maxdistance, k - i);
										if(maxdistance == k - i) {
											regToReassign = reg2;
										}
									}
								}
							}
						}
						// 1. Find all future uses and rename
						String regToChangeTo = "$t" + (maxReg + 1);
						boolean initialLoad = false;
						for(int k = i; k < insList.size(); ++k) {
							if(usedRegs.get(k).contains(regToReassign)) {
								if(!initialLoad) {
									// 2. Put load in new reg lw $newReg 0($sp) before first use at new reg
									if(!isJumpPrefix(insList.get(k))) {
										insList.add(k, "lw " + regToChangeTo + ", " + stackUsed + "($sp)");
										usedRegs.add(k, new ArrayList<String>());
										assignedRegs.add(k, new ArrayList<String>());
										insList.add(k + 1, this.renameReg(insList.get(k+1), regToReassign, regToChangeTo));
										insList.remove(k+2);
										initialLoad = true;
										k++;
									}
								} else {
									insList.add(k, this.renameReg(insList.get(k+1), regToReassign, regToChangeTo));
									insList.remove(k + 1);
								}
							}
						}
						// 3. Put store after last assignment (go backwards) sw $oldReg 0($sp)
						for(int k = i - 1 ; k >= 0 ; --k) {
							if(assignedRegs.get(k).contains(regToReassign)) {
								insList.add(k + 1, "sw " + regToReassign + ", " + stackUsed + "($sp)");
							}
						}
						// TODO: Loop + if statement stuff
						// 5. Make sure we have room in the stack
						this.stackUsed += 4;
						System.out.println("================Recursing==============");
						for(int k = 0 ; k < insList.size() ; ++k) {
							if(k == i) {
								System.out.println("RAN OUT HERE");
							}
							System.out.println(insList.get(k));
						}
						return this.allocateRegs(insList);
					}
					//System.out.println("putting new thing in map: " + s + "," + usingReg);
					this.finalRegMap.put(s, usingReg);
					//System.out.println("testing after map add: " + s + "," + this.finalRegMap.get(s));
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
					//System.out.println("Freed register " + s);
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
