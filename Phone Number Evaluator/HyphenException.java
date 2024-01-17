/****    
 * Name: Manik Singh
 * Student Number: T00715263
 * Assignment Number: 4
 * Due Date: October 24, 2023
 * Program Description: This file contains the HyphenException class which is a child class of the 
 * Exception class. It will throw a custom exception if the input has provided invalid hyphens.
****/

public class HyphenException extends Exception
{
    public HyphenException()
    {
         super(" The number format provided is incorrect. Hyphen/s is/are missing ");
    }
    
    public HyphenException(String message)
    {
         super(message + " number format provided is incorrect. Hyphen/s is/are missing ");
    }
}
