package CodeGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PeepHoleOptimizer {
	private Map<String,GeneratedClass> classMap;
	private Map<String,Integer> immediates = new HashMap<String,Integer>();
	private int peepHoleSize = 3;
	public PeepHoleOptimizer(Map<String,GeneratedClass> map){
		classMap = map;
	}
	/**
	 * Clean up code
	 */
	public void run() {
		for(String key:classMap.keySet()){
			this.optimizeClass(classMap.get(key));	
		}
	}
	private void optimizeClass(GeneratedClass gc) {
		for(String key:gc.methodMap.keySet()){
			this.optimizeMethod(gc.methodMap.get(key));
		}
	}
	private void optimizeMethod(GeneratedMethod generatedMethod) {
		List<String> currentInstructions = new ArrayList<String>();
		List<String> finalCode = new ArrayList<String>();
		for(int i = 0;i<generatedMethod.code.size()&&i<peepHoleSize;i++){
			currentInstructions.add(generatedMethod.code.get(i));
		}
		for(int i = peepHoleSize-1;i<generatedMethod.code.size();i++){
			this.simplify(currentInstructions);
			if(currentInstructions.size()<peepHoleSize){
				currentInstructions.add(generatedMethod.code.get(i));
			}else{
				finalCode.add(currentInstructions.get(0));
				currentInstructions.remove(0);
			}
		}
		generatedMethod.code = finalCode;
	}
	private void simplify(List<String> cI) {
		if(cI.size()==peepHoleSize){
			if(this.removeLI(cI)) return;
		}
	}
	private boolean removeLI(List<String> cI) {
		for(int i = 0;i<peepHoleSize;i++){
			String instruct = cI.get(i);
			if(instruct.contains("li")&&(!instruct.contains("$v"))&&(!instruct.contains("$a"))){
				System.out.println(cI.get(i));
				System.out.println(this.getRegs(cI.get(i)));
				//int v = Integer.getInteger(instruct.substring(instruct.indexOf(", ")));
				System.out.println(instruct.substring(instruct.indexOf(", ")+2));
				//immediates.put(this.getRegs(instruct).get(0),v);
			}
		}
		return false;
	}
	private List<String> getRegs(String instruction){
		List<String> output = new ArrayList<>();
		String[] list = instruction.split(" ");
		for(String s : list){
			if(s.contains("$t")){
				output.add(s.replace(",",""));
			}
		}
		return output;
	}
	
}