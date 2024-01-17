`/****    
 * Name: Manik Singh
 * Student Number: T00715263
 * Assignment Number: 4
 * Due Date: October 24, 2023
 * Program Description: This file has the ValidNumbers class that reads data from numbers.txt text file
 * then verifies it and stores it in valid.txt or invalid.txt based on the data. 
****/

import java.io.*;
import java.util.Scanner;

public class ValidNumbers {

    public static void main(String[] args) throws IOException /* IOException which is a checked exception 
    gets thrown to the operating system. */

    {
 
        //variables declaration

        String nextNumber = "";
        String areaCode;
        String prefix;
        String lineNumber;
        int firstHyphen = 0;
        int secondHyphen = 0;

         
        // Create a Scanner to read from the input file

        File file = new File("numbers.txt");
        Scanner input = new Scanner(file);

        // Create PrintWriter object for valid and invalid numbers

        PrintWriter validNumbers = new PrintWriter("valid.txt");
        PrintWriter invalidNumbers = new PrintWriter("invalid.txt");

        //Using a while loop to read data from input file till the end of file

        while (input.hasNext()) {

            try {  //try block initialisation

            nextNumber = input.nextLine();

                firstHyphen = nextNumber.indexOf("-");
                
                //check for hyphens and throwing HyphenException

                if (firstHyphen < 0) {
                    throw new HyphenException(nextNumber + " has missing hyphen.\n");
                }

                secondHyphen = nextNumber.indexOf("-",firstHyphen + 1);

                if (secondHyphen < 0) {
                    throw new HyphenException(nextNumber + " has missing hyphen.\n");
                }

                //Storing different parts of numbers using substring and then trimming white space

                    areaCode = nextNumber.substring(0, firstHyphen);
                    areaCode = areaCode.trim();
            
                    prefix = nextNumber.substring(firstHyphen + 1, secondHyphen);
                    prefix = prefix.trim(); 

                    lineNumber = nextNumber.substring(secondHyphen + 1);
                    lineNumber = lineNumber.trim();


                    checkArea(areaCode); // Check the area code using checkArea method

                    checkPrefix(prefix); // Check the prefix using prefixArea method

                    if(lineNumber.length() != 4)  //Check the length of line code and throwing LineException
                    {
                        throw new LineException("Line error: " + lineNumber);
                    }

                    //Print statements for valid file

                    validNumbers.println("Testing this Number: " +  nextNumber);

                    validNumbers.println("Code is valid");

                    validNumbers.println("");
                    
            } 
            
            //catch the exceptions thrown in the try block

            catch (HyphenException h) 
            {
                invalidNumbers.println("Testing this Number: " + nextNumber);
                invalidNumbers.println("Hyphen error: " + h.getMessage()+ "\n");
            } 
            
            catch (NumberFormatException nfe) //NumberFormatException is already existing java exception class. So we will just catch it.
            {
                invalidNumbers.println("Testing this Number: " + nextNumber);
                invalidNumbers.println("Number format error. Number provided " + nextNumber + " contains letters. Please add numbers only \n");
            } 
            
            catch (AreaException a) 
            {
                invalidNumbers.println("Testing this Number: " + nextNumber);
                invalidNumbers.println("Area code error: " + a.getMessage()+ "\n");
            } 
            
            catch (PrefixException p) 
            {
                invalidNumbers.println("Testing this Number: " + nextNumber);
                invalidNumbers.println("Prefix error: " + p.getMessage() + "\n");
            } 

            catch (LineException l) 
            {
                invalidNumbers.println("Testing this Number: " + nextNumber);
                invalidNumbers.println("Line error: " + l.getMessage() + "\n");
            } 
            
        }

        // Print statement for terminal

        System.out.println("Numbers verified and sent to Valid and Invalid Files.");

        // Close the input, valid, and invalid files

        input.close();
        validNumbers.close();
        invalidNumbers.close();

    }


    // Helper method to check if the area code is valid

    public static void checkArea(String areaCode) throws AreaException 
        {
            if (areaCode.length() != 3 || !isValidAreaCode(areaCode)) {
                throw new AreaException(areaCode);
            }
        }

    // Helper method to check if the prefix code is valid

    public static void checkPrefix(String prefix) throws PrefixException
        {
            if (prefix.length() != 3 || !isValidPrefix(prefix)) {
                throw new PrefixException(prefix);
            }
        }


    public static boolean isValidAreaCode(String areaCode) {
            int[] validAreaCodes = {236, 250, 672, 778};
            int areaNumber = Integer.parseInt(areaCode);
            for (int i = 0; i < validAreaCodes.length; i++) {
                if (areaNumber == validAreaCodes[i]) {
                    return true;
                }
            }
            return false;
        }
        

    public static boolean isValidPrefix(String prefix) {
        int[] validPrefixes = {214, 220, 252, 289, 299, 314, 377, 828, 471, 371};
        int prefixNumber = Integer.parseInt(prefix);
        for (int i = 0; i < validPrefixes.length; i++) {
                if (prefixNumber == validPrefixes[i]) {
                return true;
            }
        }
        return false;
    }

}
