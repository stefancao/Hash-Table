import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

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
 * Filename : HashTable.java
 *
 * I hereby certify that the contents of this file represent
 * my own original individual work. Nowhere herein is there 
 * code from any outside resources such as another individual,
 * a website, or publishings unless specifically designated as
 * permissible by the instructor or TA.
 */ 
 
public class HashTable {

	// initializing arraylist and variables
	ArrayList<LinkedList<String>> HashTable1;
	ArrayList<LinkedList<String>> HashTable2;
	ArrayList<LinkedList<String>> HashTable3;
	ArrayList<LinkedList<String>> HashTable4;
	
	public static final int size = 10;
	
	private int collisions1 = 0;
	private int longestList1 = 0;
	private int numberOfKeys1 = 0;
	
	private int collisions2 = 0;
	private int longestList2 = 0;
	private int numberOfKeys2 = 0;
	
	private int collisions3 = 0;
	private int longestList3 = 0;
	private int numberOfKeys3 = 0;
	
	private int collisions4 = 0;
	private int longestList4 = 0;
	private int numberOfKeys4 = 0;
	
	
	//default constructor
	public HashTable(){
		
		//creating 4 different hashtables for testing each hashfunctions
		
		HashTable1 = new ArrayList<LinkedList<String>>();
		for(int i = 0; i < size; i++){
			LinkedList<String> nodeList = new LinkedList<String>();
			HashTable1.add(nodeList);
		}
		
		HashTable2 = new ArrayList<LinkedList<String>>();
		for(int i = 0; i < size; i++){
			LinkedList<String> nodeList = new LinkedList<String>();
			HashTable2.add(nodeList);
		}
		
		HashTable3 = new ArrayList<LinkedList<String>>();
		for(int i = 0; i < size; i++){
			LinkedList<String> nodeList = new LinkedList<String>();
			HashTable3.add(nodeList);
		}
		
		HashTable4 = new ArrayList<LinkedList<String>>();
		for(int i = 0; i < size; i++){
			LinkedList<String> nodeList = new LinkedList<String>();
			HashTable4.add(nodeList);
		}
	
	}
	
	
	//Hash Functions
	
	// hashfunction1 - adds ip the ASCII values of the characters in the key
	int hashFunction1(String stringName){
		int asciiValue = 0;
		for(int i = 0; i < stringName.length(); i++){
			asciiValue += stringName.charAt(i);
		}

		asciiValue %= size;
		
		return asciiValue;
	}
	
	// hashfunction2 - uses the first three characters of the key
	int hashFunction2(String stringName){
		int asciiValue = 0;
		
		asciiValue += stringName.charAt(0);
		asciiValue += stringName.charAt(1)*27;
		asciiValue += stringName.charAt(2)*729;
		
		asciiValue %= size;

		return asciiValue;
	}
	
	// hashfunction 3 - uses all characters in the key
	int hashFunction3(String stringName){
		int asciiValue = 0;
		for (int i = 0; i < stringName.length(); i++){
			asciiValue += (int) stringName.charAt(stringName.length() - i - 1) * Math.pow(37, i);
		}
		
		asciiValue %= size;
		
		return asciiValue;
	}
	
	// hashfunction4 - My own hashfunction, use the first character of the key
	int hashFunction4(String stringName){
		int asciiValue = 0;
		asciiValue += stringName.charAt(0);
		
		asciiValue %= size;
		
		return asciiValue;
	}
	
	
	// Method for printing the hash table
	public void print(){
		
		System.out.print("HashTable 1\n");
		for(int i = 0; i < HashTable1.size(); i++){
			System.out.print(i + ":" + "\t");
			for(int j = 0; j < HashTable1.get(i).size(); j++){
				System.out.print(HashTable1.get(i).get(j).trim() + ", ");
			}
			System.out.print("\n");
		}
		
		
		System.out.print("\nHashTable 2\n");
		for(int i = 0; i < HashTable2.size(); i++){
			System.out.print(i + ":" + "\t");
			for(int j = 0; j < HashTable2.get(i).size(); j++){
				System.out.print(HashTable2.get(i).get(j).trim() + ", ");
			}
			System.out.print("\n");
		}
		
		
		System.out.print("\nHashTable 3\n");
		for(int i = 0; i < HashTable3.size(); i++){
			System.out.print(i + ":" + "\t");
			for(int j = 0; j < HashTable3.get(i).size(); j++){
				System.out.print(HashTable3.get(i).get(j).trim() + ", ");
			}
			System.out.print("\n");
		}
		
		System.out.print("\nHashTable 4\n");
		for(int i = 0; i < HashTable4.size(); i++){
			System.out.print(i + ":" + "\t");
			for(int j = 0; j < HashTable4.get(i).size(); j++){
				System.out.print(HashTable4.get(i).get(j).trim() + ", ");
			}
			System.out.print("\n");
		}
	
	}
	
	// Add all of the words in the file 'filename' to the hash table
	void processFile (String filename){
		
		File stringfile = new File(filename);
		try {
			@SuppressWarnings("resource")
			Scanner inStrings = new Scanner(stringfile).useDelimiter("\n");
			while(inStrings.hasNext()) {
			
				// storing the string in tempString
				String tempString = inStrings.next();
				
				// Hashing with hashFunction1
				int key = hashFunction1(tempString);
				
				if(HashTable1.get(key).size() != 0){
					collisions1++;
					if(HashTable1.get(key).size() + 1 > longestList1){
						longestList1 = HashTable1.get(key).size() + 1; 
					}
				}
				HashTable1.get(key).add(tempString);
				numberOfKeys1++;
				
				
				// Hashing with hashFunction2
				key = hashFunction2(tempString);
				
				if(HashTable2.get(key).size() != 0){
					collisions2++;
					if(HashTable2.get(key).size() + 1 > longestList2){
						longestList2 = HashTable2.get(key).size() + 1; 
					}
				}
				HashTable2.get(key).add(tempString);
				numberOfKeys2++;
				
				
				
				// Hashing with hashFunction3
				key = hashFunction3(tempString);
				
				if(HashTable3.get(key).size() != 0){
					collisions3++;
					if(HashTable3.get(key).size() + 1 > longestList3){
						longestList3 = HashTable3.get(key).size() + 1; 
					}
				}
				HashTable3.get(key).add(tempString);
				numberOfKeys3++;
				
				
				// Hashing with hashFunction4
				key = hashFunction4(tempString);
				
				if(HashTable4.get(key).size() != 0){
					collisions4++;
					if(HashTable4.get(key).size() + 1 > longestList4){
						longestList4 = HashTable4.get(key).size() + 1; 
					}
				}
				HashTable4.get(key).add(tempString);
				numberOfKeys4++;

				
			}
			inStrings.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	// print the has statistics 
	void printStats(){
		
		// HashTable 1
		System.out.println("HashTable 1:");
		System.out.println("Number of Collisions is: " + collisions1);
		System.out.println("Length of the longest List is: " + longestList1);
		
		float avg1 = (float) numberOfKeys1 / size;
		System.out.println("Average of all lists: " + avg1);
		
		
		// HasTable 2
		System.out.println("\nHashTable 2:");
		System.out.println("Number of Collisions is: " + collisions2);
		System.out.println("Length of the longest List is: " + longestList2);
		
		float avg2 = (float) numberOfKeys2 / size;
		System.out.println("Average of all lists: " + avg2);
		
		
		// HashTable 3
		System.out.println("\nHashTable 3:");
		System.out.println("Number of Collisions is: " + collisions3);
		System.out.println("Length of the longest List is: " + longestList3);
		
		float avg3 = (float) numberOfKeys3 / size;
		System.out.println("Average of all lists: " + avg3);
		
		
		// HashTable 4
		System.out.println("\nHashTable 4:");
		System.out.println("Number of Collisions is: " + collisions4);
		System.out.println("Length of the longest List is: " + longestList4);

		float avg4 = (float) numberOfKeys4 / size;
		System.out.println("Average of all lists: " + avg4);
		
	
	}
	
}
