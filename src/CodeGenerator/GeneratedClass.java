package CodeGenerator;
import java.util.Map;

import parser.ParsedIdentifier;


public class GeneratedClass {
	String name;
	String parrent;
	int classNumber;
	Map<String,ParsedIdentifier> fieldMap;
	Map<String,GeneratedMethod> methodMap;
	public GeneratedClass(String name){
		this.name = name;
	}
	public GeneratedClass(String name,String parrent){
		this.name = name;
		this.parrent = parrent;
	}
	public void setMethodMap(Map<String,GeneratedMethod> map){
		this.methodMap = map;
	}
	public void setFieldMap(Map<String,ParsedIdentifier> map){
		this.fieldMap = map;
	}
	
}
