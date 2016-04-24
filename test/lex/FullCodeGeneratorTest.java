package lex;

import static org.junit.Assert.fail;

import java.io.File;
import java.util.Collection;
import java.util.HashSet;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class FullCodeGeneratorTest {
	
	@Parameters
	public static Collection<Object[]> getFiles() {
		Collection<Object[]> params = new HashSet<Object[]>();
		for(File f : new File("./input_output/LexerFullTests").listFiles()) {
			if(f.getName().contains(".java")) {
				Object[] arr = new Object[] { f.getName().substring(0, f.getName().indexOf('.')) };
				params.add(arr);
			}
		}
		return params;
	}
	
	private String filePrefix;
	
	public FullCodeGeneratorTest(String filePrefix) {
		this.filePrefix = filePrefix;
	}

	@Test
	public void testAgainstExpectedOutput() {
		fail("Not yet implemented");
	}

}
