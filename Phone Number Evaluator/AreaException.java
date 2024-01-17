/****    
 * Name: Manik Singh
 * Student Number: T00715263
 * Assignment Number: 4
 * Due Date: October 24, 2023
 * Program Description: This file contains the AreaException class which is a child class of the 
 * Exception class. It will throw a custom exception if the input has provided invalid area code.
****/

public class AreaException extends Exception
{
    public AreaException()
    {
         super(" Area code is invalid ");
    }
    
    public AreaException(String message)
    {
         super(message + " Area code is invalid ");
    }
}
