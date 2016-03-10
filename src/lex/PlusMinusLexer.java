package lex;

import java.util.ArrayList;
import java.util.List;

public class PlusMinusLexer implements ILexer {

	@Override
	public List<String> lex(String toLex) {
		String digits = "0123456789";
		int state = 0;
		int index =0;
		String word = "";
		ArrayList<String> output = new ArrayList<String>();
		if(toLex.length()==0){
			return output;
		}
		while(state!= -1){
			switch(state){
				case 0: if(digits.contains(toLex.charAt(index) + "")){
							state=1;
							word = toLex.charAt(index)+"";
							index++;
							if(index>=toLex.length()){
								state=-1;
								output.add(word);
							}
						} else {
							state=2;
						}
						break;
				case 1: if(digits.contains(toLex.charAt(index) + "")){
							state=1;
							word += toLex.charAt(index)+"";
							index++;
							if(index>=toLex.length()){
								state=-1;
								output.add(word);
							}
						} else {
							state=0;
							output.add(word);
							word="";
						}
						break;
				case 2: switch(toLex.charAt(index)){
							case '+': 	output.add("plus");
										break;
							case '-':	output.add("minus");
										break;
							default:	state=-1;
						}
						state=0;
						index++;
						if(index>=toLex.length()){
							state=-1;
						}
						break;
			}
			
		}
		return output;
	}

}
