/**
 * File: Problem Set 2 - High-Low Guessing Game
 * Author: Mikah Ho
 * Date Created: April 20, 2026
 * Date Last Modified: April 27, 2026
 */

import java.util.Scanner;
import java.util.Random; // i realized what i did wrong at like 3 something so i can't really fix it anymore

public class HighLowGame { //note: sorry if this is atrocious to read lol, i'm still trying to figure out when and where to use methods

	public static void main(String args[]) { //where the main part of the game runs

		Scanner input = new Scanner(System.in);
		Random random = new Random();

		System.out.println("Welcome to the High Low Guessing Game!\n");

		int rounds = getNumberOfRounds();
		int roundNumber = 1;
		int score = 0;

		String range = getRange();
		int start = getStartOfRange(range);
		int end = getEndOfRange(range);

		int middle = 0; //for odd range (1 even value)

		int middle1 = 0; //for even range (2 even values)
		int middle2 = 0;

		String menu = "";

		if ((end - start + 1) % 2 != 0) { //odd range, finds number of values within range (inclusively) then checks if it's even or odd
			
			middle = ((end - start) / 2) + start; 

			if (end == start + 2) { //if range contains only 3 numbers

				menu = "Please select High, Low or Even:" + 
					"\n1. High (" + end + ")" +
					"\n2. Low (" + start + ")" +
					"\n3. Even (" + middle + ")\n";
			}
			else {

				menu = "Please select High, Low or Even:" + //yes i know this looks awful
					"\n1. High (" + (middle + 1) + " to " + end + ")" +
					"\n2. Low (" + start + " to " + (middle - 1) + ")" +
					"\n3. Even (" + middle + ")\n";
			}
		}
		else { //even range

			middle1 = ((end - start) / 2) + start;
			middle2 = ((end - start) / 2) + start + 1;

			menu = "Please select High, Low or Even:" +
					"\n1. High (" + (middle2 + 1) + " to " + end + ")" +
					"\n2. Low (" + start + " to " + (middle - 1) + ")" +
					"\n3. Even (" + middle1 + " or " + middle2 + ")\n"; 
		}

		int randomNum = 0;
		int option = 0;
		String result = "incorrect";

		while (roundNumber <= rounds) {

			System.out.println("\nRound: " + roundNumber + "\n");

			randomNum = random.nextInt(end - (start - 1)) + start;

			option = getOptionNumber(menu);

			if ((end - start + 1) % 2 != 0) { //even range

				if (randomNum > middle && option == 1 || //high
					randomNum < middle && option == 2 || //low
					randomNum == middle && option == 3) { //even

					result = "correct";
				}
			}
			else { //odd range
				
				if (randomNum > middle2 && option == 1 || //high
					randomNum < middle1 && option == 2 || //low
					(randomNum == middle1 || randomNum == middle2) && option == 3) { //even

					result = "correct";
				}
			}

			if (result == "correct") {

				score++;
			}

			System.out.println("\nThe number was " + randomNum + ". You were " + result + ".\nCurrent Score: " + score);
			
			roundNumber++;
		}

		System.out.println("\nTotal Score: " + score); //123

		if (rounds % 2 == 0 && score >= (rounds / 2) || //checks if score is 50% or more of rounds
			rounds % 2 != 0 && score >= ((rounds / 2) + 1)) { //adds 1 for odd number of rounds

			System.out.println("Congratulations! You got " + score + " out of " + rounds + " correct.");
		}
		else {

			System.out.println("You got " + score + " out of " + rounds + " correct. Better luck next time.");
		}
	}

	public static int getNumberOfRounds() { //retrieves number of rounds from user

		Scanner input = new Scanner(System.in);

		int rounds = 0;
		
		do {

			System.out.print("Input a number of rounds to play: ");

			if (input.hasNextInt()) {

				rounds = input.nextInt();

				if (rounds > 0) {

					return rounds;
				}
				else {

					System.out.println("Invalid input!\n");
					input.nextLine();
				}
			}
			else {

				System.out.println("Invalid input!\n");
				input.nextLine();
			}

		} while (rounds < 1);

		return rounds;
	}

	public static String getRange() { //retrieves range from user (this part was kinda evil just so you know)

		Scanner input = new Scanner(System.in);

		String range = "";
		String start = "";
		String end = "";

		do { //2-2-2   2-2-   2---2   (cases that don't work because i made the get start and end of range methods return integers instead of strings sdhfshdfjsd)
		    
		    range = ""; //clearing values for every iteration (not having this messed me up earlier)
		    start = "";
		    end = "";

			System.out.println("\nWhat range would you like to play between? (#-#)");

			range = input.nextLine();

			if (range.length() >= 3 && range.length() <= 5 && range.contains("-") && !range.endsWith("-")) { //range can only be between 3 and 5 characters depending on the number of negative values

				start = getStartOfRange(range) + ""; //values have to remain as strings until they are validated
				end = getEndOfRange(range) + "";
    			
    			if (start.length() > 0 && end.length() > 0 && 
					checkNumber(start) == true && checkNumber(end) == true && 
					
					Integer.parseInt(end) >= Integer.parseInt(start) + 2) { //checks if range is large enough and if start < end
    			    
    				return range;
    			}
			}
			
			System.out.println("Invalid input!");
			
		} while (range.length() < 3 || range.length() > 5 || !range.contains("-") || 
				checkNumber(start) == false || checkNumber(end) == false || 
				Integer.parseInt(end) < Integer.parseInt(start) + 2);

		return range;
	}

	public static int getStartOfRange(String range) { //retrieves starting value of range

		int dashes = 0;
		String start = "";

		for (int i = 0; i < range.length(); i++) { //counts number of dashes (-)
    
    		if (range.charAt(i) == '-') {
    
    			dashes++;
    		}
    	}

    	if (dashes == 1) { //no negative numbers
    
    		start = range.substring(0,range.indexOf("-"));
    	}
    	else if (dashes == 2) { //first number is negative
    
    		start = range.substring(0,range.lastIndexOf("-"));
    	}
    	else if (dashes == 3) { //both numbers are negative
    
    		start = range.substring(0,(range.substring(1)).indexOf("-") + 1);
    	}

		return Integer.parseInt(start);
	}

	public static int getEndOfRange(String range) { //retrieves ending value of range

		int dashes = 0;
		String end = "";

		for (int i = 0; i < range.length(); i++) { //counts number of dashes (-)
    
    		if (range.charAt(i) == '-') {
    
    			dashes++;
    		}
    	}

    	if (dashes == 1) { //no negative numbers

    		end = range.substring(range.indexOf("-") + 1);
    	}
    	else if (dashes == 2) { //first number is negative

    		end = range.substring(range.lastIndexOf("-") + 1);
    	}
    	else if (dashes == 3) { //both numbers are negative

    		end = range.substring(range.lastIndexOf("-"));
    	}

		return Integer.parseInt(end);
	}

	public static boolean checkNumber(String num) { //checks if value is a number or not
	    
	    int ascii = 0;
		boolean isNumber = true;
		
	    if (num.startsWith("-")) { //negative number
	    
    	    for (int i = 1; i < num.length(); i++) {
    
    		  	ascii = num.charAt(i);
    			
    		  	if (ascii < 48 || ascii > 57) { //ascii values excluding all digits
    		        
    			    isNumber = false; //checks if the indexed value is not a digit

					return isNumber;
    	   	   	}
    		}
	    }
	    else { //positive number
	        
	        for (int i = 0; i < num.length(); i++) {
    
    		  	ascii = num.charAt(i);
    			
    		  	if (ascii < 48 || ascii > 57) {
    		        
    			    isNumber = false;
					
					return isNumber;
    	   	   	}
    		}
	    }
	    
	    return isNumber;
	} 

	public static int getOptionNumber(String menu) { //retrives option from user (high, low, even)

		Scanner input = new Scanner(System.in);

		int option = 0;

		do {

			System.out.println(menu);

			if (input.hasNextInt()) {

				option = input.nextInt();

				if (option < 1 || option > 3) {

					System.out.println("\nInvalid input!");
					input.nextLine();
				}
			}
			else {

				System.out.println("\nInvalid input!");
				input.nextLine();
			}

		} while (option < 1 || option > 3);

		return option;
	}

}

// i honestly hated writing this (does it get any better? *sob*)

// anyway, here's my question:
// if your life was a book, movie, show, game or song/album, which would it be?
// or in other words, what is the book, movie, show, game or song/album of your life?