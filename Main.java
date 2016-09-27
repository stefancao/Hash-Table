/**
 * Course: EECS 114 Fall 2015
 *
 * First Name: Stefan
 * Last Name: Cao
 * Lab Section: 1A
 * email address: stefanc1@uci.edu
 *
 *
 * Assignment: lab6
 * Filename : Main.java
 *
 * I hereby certify that the contents of this file represent
 * my own original individual work. Nowhere herein is there 
 * code from any outside resources such as another individual,
 * a website, or publishings unless specifically designated as
 * permissible by the instructor or TA.
 */ 

public class Main {

	public static void main(String[] args) {
		
		if(args.length != 1){
			System.out.println("Please provide a file name...");
		}
		
		HashTable newHashTable = new HashTable();
		newHashTable.processFile(args[0]);
		
		// printing out the hashtable
		newHashTable.print();
		
		// printing out the stats of hashtable
		newHashTable.printStats();
		
	}

}
