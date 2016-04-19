package parser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class EnvironmentTracker {
	
	private Stack<Map<String,ParsedIdentifier>> environs;
	
	public EnvironmentTracker() {
		environs = new Stack<Map<String,ParsedIdentifier>>();
	}
	
	public void addLevel(Map<String,ParsedIdentifier> newMap) {
		environs.push(newMap);
	}
	
	public void removeLevel() {
		environs.pop();
	}
	
	public void addIdentifier(ParsedIdentifier ident) {
		//System.out.println("Adding: " + ident.getName() + " of type " + ident.getType());
		environs.peek().put(ident.getName(), ident);
		//System.out.println(this.getCurrentEnviro());
	}
	
	public boolean identifierExists(String name) {
		for(Map<String,ParsedIdentifier> identMap : environs) {
			if(identMap.containsKey(name)) {
				return true;
			}
		}
		return false;
	}
	public List<List<String>> getCurrentEnviro(){
		List<List<String>> output = new ArrayList<List<String>>();
		for(Map<String,ParsedIdentifier> identMap : environs) {
			List<String> temp = new ArrayList<String>();
			for(String key: identMap.keySet()){
				temp.add(identMap.get(key).getName());
			}
			output.add(temp);
		}
		return output;
	}
	
	public String getIdentifierType(String name) {
		for(Map<String,ParsedIdentifier> identMap : environs) {
			if(identMap.containsKey(name)) {
				return identMap.get(name).getType();
			}
		}
		return null;
	}

}
