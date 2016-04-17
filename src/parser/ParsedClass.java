package parser;

import java.util.HashMap;
import java.util.Map;

public class ParsedClass {
	String name;
	String extendsClass;
	Map<String,ParsedMethod> nameToMethod;
	Map<String,ParsedIdentifier> nameToField;
	
	public ParsedClass(String name) {
		this.name = name;
		this.nameToField = new HashMap<String,ParsedIdentifier>();
		this.nameToMethod = new HashMap<String,ParsedMethod>();
	}
	
	public ParsedClass(String name, String extendsClass) {
		this.name = name;
		this.extendsClass = extendsClass;
		this.nameToField = new HashMap<String,ParsedIdentifier>();
		this.nameToMethod = new HashMap<String,ParsedMethod>();
	}
	
	public String getName() {
		return this.name;
	}
	
	public void addMethod(ParsedMethod method) {
		this.nameToMethod.put(method.getName(), method);
	}
	
	public void addField(ParsedIdentifier field) {
		this.nameToField.put(field.getName(), field);
	}

	public boolean hasMethod(String methodName) {
		return this.nameToMethod.containsKey(methodName);
	}

	public boolean hasField(String fieldName) {
		return this.nameToField.containsKey(fieldName);
	}
}
