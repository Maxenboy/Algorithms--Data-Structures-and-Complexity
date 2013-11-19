package test;

import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.FileReader;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Allfiles {
	String[] args;

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws Exception {
		BufferedReader br1=new BufferedReader(new FileReader("out.txt"));
		BufferedReader br2=new BufferedReader(new FileReader("Output/sm-random-50.txt"));
		StringBuilder out=new StringBuilder();
		StringBuilder correct= new StringBuilder();
		String s,t;
		while((s=br1.readLine())!=null){
			out.append(s+"\n");
		}
		while((t=br2.readLine())!=null){
			correct.append(t+"\n");
		}
		br1.close();
		br2.close();
		assertTrue(out.toString().equals(correct.toString()));
	}

}
