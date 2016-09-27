import java.util.Arrays;
import java.util.Random;

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
 * Filename : OPenAddressCollision.java
 *
 * I hereby certify that the contents of this file represent
 * my own original individual work. Nowhere herein is there 
 * code from any outside resources such as another individual,
 * a website, or publishings unless specifically designated as
 * permissible by the instructor or TA.
 */ 

public class OpenAddressCollision {
	
	// size of the table
	public static final int size = 997;
	
	// number of elements
	public static final int number = 250;
	
	public static void main(String[] args) {
	
		// initializing variables
		int collisionLinear = 0;
		int collisionQuadratic = 0;
		int collisionCubic = 0;
		
		//initialize 3 arrays
		int[] arrayLinear = new int[size];
		Arrays.fill(arrayLinear, -1);
		int[] arrayQuadratic = new int[size];
		Arrays.fill(arrayQuadratic, -1);
		int[] arrayCubic = new int[size];
		Arrays.fill(arrayCubic, -1);
		
		Random randomNumberGenerator = new Random();
		
		for(int x = 0; x < number; x++){
			// Generating a random number
			int randomNumber = randomNumberGenerator.nextInt(100);
			
			//Linear Probing
			int i = 0;
			while (true){
				int key = LinearProbing(randomNumber, i);
				if(arrayLinear[key] == -1){
					arrayLinear[key] = randomNumber;
					break;
				}
				i++;
				collisionLinear++;
			}
			
			//Quadratic Probing
			i = 0;
			while (true){
				int key = QuadraticProbing(randomNumber, i);
				if(arrayQuadratic[key] == -1){
					arrayQuadratic[key] = randomNumber;
					break;
				}
				i++;
				collisionQuadratic++;
			}
			
			//Cubic Probing
			i = 0;
			while (true){
				int key = CubicProbing(randomNumber, i);
				if(arrayCubic[key] == -1){
					arrayCubic[key] = randomNumber;
					break;
				}
				i++;
				collisionCubic++;
			}
			
			
		}

		
		// print out the number of collisions for each probing
		System.out.println("Collisions with Linear Probing is: " + collisionLinear);
		System.out.println("Collisions with Quadratic Probing is: " + collisionQuadratic);
		System.out.println("Collisions with Cubic Probing is: " + collisionCubic);
		
	}
	
	
	// Linear Probing
	public static int LinearProbing(int k, int i){
		return (k + i) % size;
	}
	
	// Quadratic Probing
	public static int QuadraticProbing(int k, int i){
		return (int)(k + Math.pow(i, 2)) % size;
	}
	
	// Cubic Probing
	public static int CubicProbing(int k, int i){
		return (int)(k + Math.pow(i, 3)) % size;
	}
	
}
