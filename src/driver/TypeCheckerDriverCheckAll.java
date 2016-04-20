package driver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.gui.TreeViewer;

import antlr4.MiniJavaLexer;
import antlr4.MiniJavaParser;
import parser.MiniJavaNodeJumper;
import parser.MiniJavaNodePrunerListener;
import parser.MiniJavaTypeCheckerListener;
public class TypeCheckerDriverCheckAll {
	
	public static Collection<String[]> getFiles() {
		Collection<String[]> params = new HashSet<String[]>();
		for(File f : new File("./input_output/TypeCheckerFullTests").listFiles()) {
			if(f.getName().contains(".java")) {
				String[] arr = new String[] { f.getName().substring(0, f.getName().indexOf('.')) };
				params.add(arr);
			}
		}
		return params;
	}

	public static void main(String[] args) {
		for(String[] arr : getFiles()) {
			String fileName = arr[0];
			File fileIn = new File("input_output/TypeCheckerFullTests/" + fileName + ".java");
			BufferedReader br;
			String inString = "";
			try {
				br = new BufferedReader(new FileReader(fileIn));
				while(true) {
					String nextLine = br.readLine();
					if(nextLine == null) {
						break;
					}
					inString += nextLine + "\n";
				}
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
				return;
			}
			
			MiniJavaLexer lexer = new MiniJavaLexer(new ANTLRInputStream(inString));
			
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			
			MiniJavaParser parser = new MiniJavaParser(tokens);
			
			ParseTree tree = parser.program();
			tree.getChildCount();
			
			
			//System.out.println(tree.toStringTree(parser));
			//System.out.println("Error count: " + parser.getNumberOfSyntaxErrors());
			
			ParseTreeWalker walker = new ParseTreeWalker();
			MiniJavaNodePrunerListener listener = new MiniJavaNodePrunerListener();
			walker.walk(listener, tree);
			
			MiniJavaNodeJumper listener2 = new MiniJavaNodeJumper();
			walker.walk(listener2, tree);
			
			System.out.println("Starting: " + fileName);
			System.out.println("Actual: ");
			MiniJavaTypeCheckerListener listener3 = new MiniJavaTypeCheckerListener();
			walker.walk(listener3, tree);
			
			if(listener3.errorCount==0){
				System.out.println("No type check errors found.");
			} else {
				for(String s : listener3.errors) {
					System.out.println(s);
				}
			}
			
			System.out.println("Expected: ");
			fileIn = new File("input_output/TypeCheckerFullTests/" + fileName + ".out");
			try {
				br = new BufferedReader(new FileReader(fileIn));
				while(true) {
					String nextLine = br.readLine();
					if(nextLine == null) {
						break;
					}
					System.out.println(nextLine);
				}
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
				return;
			}
			System.out.println("Ending: " + fileName);
		}
	}

}
