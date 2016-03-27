package driver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.gui.TreeViewer;

import antlr4.MiniJavaLexer;
import antlr4.MiniJavaParser;

public class FullParserDriver {
	
	public static void main(String[] args) {
		String fileName = "testcase97-03";
		File fileIn = new File("input_output/ParserFullTests/" + fileName + ".java");
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
		System.out.println(tree.toStringTree(parser));
		System.out.println("Error count: " + parser.getNumberOfSyntaxErrors());
		
		JFrame frame = new JFrame("Antlr AST");
		JPanel panel = new JPanel();
		JScrollPane scrPane = new JScrollPane(panel);
		TreeViewer viewr = new TreeViewer(Arrays.asList(parser.getRuleNames()),tree);
		viewr.setScale(1.5);
		panel.add(viewr);
		frame.add(scrPane);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(200, 200);
		frame.setVisible(true);
		
		
		/*ParseTreeWalker walker = new ParseTreeWalker();
		MiniJavaListener listener = new MiniJavaListener();
		walker.walk(listener, programContext);*/
		
	}

}
