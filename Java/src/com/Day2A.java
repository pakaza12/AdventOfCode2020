package com;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day2A {

	public static void main(String[] args) {
		
		Scanner input = null;
		try {
			input = new Scanner(new File("Data/Day2Data.dat"));
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
		
		int numInvalid = 0;
		int numValid = 0;
		
		while(input.hasNextLine()) {
			String token[] = input.nextLine().split(" ");
			String minMax[] = token[0].split("-");
			char[] letter = token[1].toCharArray();
			char[] password = token[2].toCharArray();
			int numLetter = 0;
			for(int i=0; i<password.length; i++) {
				if(password[i] == letter[0]) {
					numLetter++;
				}
			}
			if(numLetter < Integer.parseInt(minMax[0]) || numLetter > Integer.parseInt(minMax[1])) {
				numInvalid++;
			} else {
				numValid++;
			}
		}
		System.out.println(numInvalid + " " + numValid);

	}

}
