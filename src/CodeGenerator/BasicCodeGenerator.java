package CodeGenerator;

import java.util.List;
import java.util.Map;

import parser.ParsedClass;


public class BasicCodeGenerator {
	Map<String,ParsedClass> parsedClassMap;
	Map<String,GeneratedClass> genClassMap;
	
	public BasicCodeGenerator(Map<String,ParsedClass> map){
		this.parsedClassMap = map;
	}
	
	public Map<String,GeneratedClass> generate(){
		for(String key: parsedClassMap.keySet()){
			System.out.println(key);
			this.createGenClass(parsedClassMap.get(key));
		}
		return null;
	}

	private void createGenClass(ParsedClass parsedClass) {
		// TODO Auto-generated method stub.
		
	}

	public List<String> getProgram() {
		return null;
	}
}
