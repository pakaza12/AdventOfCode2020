package com;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day3A {

	public static void main(String[] args) {
		
		//Num rows = n
		//num columns needed = (n-1)*3
		//Num times to copy over = roundUp(num columns needed / numColumns)
		
		int rightShift = 1;
		int downShift = 2;
		
		Scanner input = null;
		try {
			input = new Scanner(new File("Data/Day3Data.dat"));
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
		
		int numColumns = 0;
		int numRows = 0;
		//Get the number of columns and rows in the inputFile
		while(input.hasNextLine()) {
			char[] a = input.nextLine().toCharArray();
			numColumns = a.length;
			numRows++;
		}
		input.close();
		
		try {
			input = new Scanner(new File("Data/Day3Data.dat"));
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
		
		
		int numColumnsNeeded = (numRows-1) * rightShift;
		int numCopy = (int) Math.ceil((double)numColumnsNeeded / (double)numColumns);
		
		int numTrees = 0;
		int numNotTrees = 0;
		char graph[][] = new char[numRows][numColumnsNeeded+1];
		
		int b = 0;
		while(input.hasNextLine()) {
			char a[] = input.nextLine().toCharArray();
			
			int c = 0;
			for(int i = 0; i < numColumnsNeeded+1; i++) {
				graph[b][i] = a[c];
				c++;
				if(c == a.length) {
					c = 0;
				}
			}
			b++;
		}
		
		b = downShift;
		for(int i = rightShift; i < numColumnsNeeded+1; i+=rightShift) {
			if(b > numRows) {
				break;
			}
			if(graph[b][i] == '.') {
				graph[b][i] = 'O';
				numNotTrees++;
			} else if(graph[b][i] == '#') {
				graph[b][i] = 'X';
				numTrees++;
			}
			b+=downShift;
		}
		
		System.out.println(numTrees + " " + numNotTrees);

	}

}
