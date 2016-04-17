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
	
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof ParsedIdentifier)) {
			return false;
		}
		
		ParsedIdentifier ident = (ParsedIdentifier) o;
		return ident.getName().equals(this.getName()) && ident.getType().equals(this.getType());
	}
	
}
