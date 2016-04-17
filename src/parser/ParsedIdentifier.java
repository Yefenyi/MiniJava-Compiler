package parser;

public class ParsedIdentifier {

	public String name;
	public String type;
	
	public ParsedIdentifier(String name, String type) {
		this.name = name;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}
	
}
