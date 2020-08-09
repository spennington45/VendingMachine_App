package com.techelevator;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

public class LogFileTest {

	LogFile log = new LogFile();
	
	@Test
	public void logTest() {
		 BufferedReader input;
		 String last = "";
		 String line = "";
		try {
			input = new BufferedReader(new FileReader("log.txt"));
			while ((line = input.readLine()) != null) { 
				last = line;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		log.logWriter("This line is for testing");
		assertEquals(true, last.substring(20).equals("This line is for testing"));
	}

}
