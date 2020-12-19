package com;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day4A {

	public static void main(String[] args) {
		
		Scanner input = null;
		try {
			input = new Scanner(new File("Data/Day4Data.dat"));
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
		
		String wholeFile = "";
		
		while(input.hasNextLine()) {
			String a = input.nextLine();
			char b[] = a.toCharArray();
			if( b.length == 0 ) {
				wholeFile = wholeFile + "\n";
			} else {
				wholeFile = wholeFile + a + " ";
			}
		}
		
		int valid = 0;
		int invalid = 0;
		String allLines[] = wholeFile.split("\n");
		for(int i = 0; i < allLines.length; i++) {
			if(allLines[i].contains("byr") && allLines[i].contains("iyr") && allLines[i].contains("eyr") && allLines[i].contains("hgt") && allLines[i].contains("hcl") && allLines[i].contains("ecl") && allLines[i].contains("pid")) {
				valid++;
			} else {
				invalid++;
			}
		}
		
		System.out.println("Valid = " + valid + " Invalid = " + invalid);
		input.close();


	}

}
