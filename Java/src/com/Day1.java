package com;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day1 {

	public static void main(String[] args) {
		
		Scanner input = null;
		try {
			input = new Scanner(new File("Data/Day1Data.dat"));
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
		
		int inputNums[] = new int[200];
		int i = 0;
		while(input.hasNextLine()) {
			inputNums[i] = Integer.parseInt(input.nextLine());
			i++;
		}
		
		for(int j = 0; j < i; j++) {
			for(int k = 0; k < i; k++) {
				if(inputNums[j] + inputNums[k] == 2020) {
					System.out.println(inputNums[j] * inputNums[k]);
				}
			}
		}
				
		
	}

}
