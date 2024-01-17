/****    
 * Name: Manik Singh
 * Student Number: T00715263
 * Assignment Number: 4
 * Due Date: October 24, 2023
 * Program Description: This file contains the PrefixException class which is a child class of the 
 * Exception class. It will throw a custom exception if the input has provided invalid prefix code.
****/

public class PrefixException extends Exception 
{
    public PrefixException()
    {
         super(" Prefix code is invalid ");
    }
    
    public PrefixException(String message)
    {
         super(message + " Prefix code is invalid ");
    }
}
