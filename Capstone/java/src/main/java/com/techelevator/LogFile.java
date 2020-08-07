package com.techelevator;

import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

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

	public void receipt(String eventTask) {
		try {
			PrintWriter writer = new PrintWriter(new FileOutputStream(log,true));
			writer.append(eventTask);
			writer.flush();
			writer.close();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error writing to a file");
		}

		
	}
}
