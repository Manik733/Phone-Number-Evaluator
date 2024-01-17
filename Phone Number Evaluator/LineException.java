/****    
 * Name: Manik Singh
 * Student Number: T00715263
 * Assignment Number: 4
 * Due Date: October 24, 2023
 * Program Description: This file contains the LineException class which is a child class of the 
 * Exception class. It will throw a custom exception if the input has provided invalid line code.
****/

public class LineException extends Exception
{
    public LineException()
    {
         super(" Line code is invalid ");
    }
    
    public LineException(String message)
    {
         super(message + " Line code is invalid ");
    }
}
