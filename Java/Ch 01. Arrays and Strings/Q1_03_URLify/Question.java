package Q1_03_URLify;

import CtCILibrary.AssortedMethods;

public class Question {
	// Assume string has sufficient free space at the end
	public static void main(String[] args){
	        System.out.println("Expected: Mr%20John%20Smith");
	        System.out.print("Result: ");
	        URLify("Mr John Smith    ", 13);
	        System.out.println("Expected: What%20A%20Wonderful%20Day");
	        System.out.print("Result: ");
	        URLify("What A Wonderful Day      ", 20);
	        System.out.println("Expected: I%20Never%20Asked%20For%20Help");
	        System.out.print("Result: ");
	        URLify("I Never Asked For Help        ", 22);
	    }

	    public static void URLify(String sentence, int trueLength){
	        char[] string = sentence.toCharArray();             // Begin by creating a char array using the given sentence string
	        int decrementer = 0;                                // Initially set a decrementer to 0 which will later move our pointer
	        int pointer = string.length - 1;                    // Set the pointer to the end of the array so that characters can be shifted over
	        for(int i = trueLength - 1; i >= 0; i--){           // i is essentially our other pointer which begins where the last character in the sentence is
	            if(' ' == string[i]){                           // If the character is a space...
	                string[pointer - decrementer] = '0';        // add a 0 to the left of our pointer near the end of the array
	                string[pointer - decrementer - 1] = '2';    // add a 2 to the left of the 0
	                string[pointer - decrementer - 2] = '%';    // add a % to the left of the 2
	                decrementer += 3;                           // Now since our pointer is still at the index to the right of the 0, we need to shift left 3 spaces
	            } else {                                        // This leaves our pointer at the next available space for character storage
	                string[pointer - decrementer] = string[i];  // Insert the character that i points to, in the space our pointer is pointing to
	                decrementer++;                              // Decrement our decrementer
	            }
	        }
	        String formatted = new String(string);              // Form a string from our newly formatted char[]
	        System.out.println(formatted);                      // Print the string to the console
	    }
}
