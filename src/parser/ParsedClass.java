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
	
	public String getExtendsClass() {
		return extendsClass;
	}

	public Map<String, ParsedMethod> getNameToMethod() {
		return nameToMethod;
	}

	public Map<String, ParsedIdentifier> getNameToField() {
		return nameToField;
	}
	public void setExtendsClass(String extendsClass) {
		this.extendsClass = extendsClass;
	}

	public void setNameToMethod(Map<String, ParsedMethod> nameToMethod) {
		this.nameToMethod = nameToMethod;
	}
	public void setNameToField(Map<String, ParsedIdentifier> nameToField) {
		this.nameToField = nameToField;
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
