package com.techelevator;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class LogFile {
	File log = new File("log.txt");

	public LogFile() {
		try {
			log.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error creating file");
		}

	}

	public void logWriter(String eventTask) {
		
		try {
			PrintWriter writer = new PrintWriter(new FileOutputStream(log,true));
			writer.append(eventTask + "\n");
			writer.flush();
			writer.close();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error writing to a file");
		}

		
	}
}
