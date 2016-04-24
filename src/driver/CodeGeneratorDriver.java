package driver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.gui.TreeViewer;

import parser.MiniJavaNodeJumper;
import parser.MiniJavaNodePrunerListener;
import parser.MiniJavaTypeCheckerListener;
import CodeGenerator.BasicCodeGenerator;
import CodeGenerator.GeneratedClass;
import antlr4.MiniJavaLexer;
import antlr4.MiniJavaParser;

public class CodeGeneratorDriver {

	public static void main(String[] args) {
		String fileName = "testcase00_17";
		String in = "input_output/FullCodeGeneratorFullTests/" + fileName + ".java";
		GenericDriver driver = new GenericDriver(in);
		List<String> list = driver.genBasicOutput();
		for(String item:list){
			System.out.println(item);
		}
	}

}
