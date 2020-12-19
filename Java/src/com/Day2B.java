package com;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day2B {

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
			
			if( (password[Integer.parseInt(minMax[0])-1] == letter[0] && password[Integer.parseInt(minMax[1])-1] == letter[0]) || !(password[Integer.parseInt(minMax[0])-1] == letter[0] || password[Integer.parseInt(minMax[1])-1] == letter[0]) ) {
				numInvalid++;
			} else if(password[Integer.parseInt(minMax[0])-1] == letter[0] || password[Integer.parseInt(minMax[1])-1] == letter[0]) {
				numValid++;
			}
		}
		System.out.println(numInvalid + " " + numValid);

	}

}
