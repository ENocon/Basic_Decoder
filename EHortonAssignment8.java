//Programmer: Elizabeth Nocon
//Class: CS 1450.001 MW
//Assignment Number: 8
//Due Date: 10/29/2018
//Description: 
//This program reads three text documents, and places their contents into arrayLists. 
//The program then creates iterators for each arrayList and decodes the first secret message.
//The first secret message is then printed. The program then reads three additional text
//files, and places their contents into queues. The program then creates iterators for
//each queue, and decodes the second secret message. The second secret message is then
//printed, and the program ends. 

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.IOException;
import java.util.Queue;
import java.util.LinkedList;
import java.lang.Character;

public class EHortonAssignment8 
{
	public static void main(String[] args) throws IOException
	{
		//Create an instance of the translator class. 
		Translator translator1 =  new Translator();
		
		//Create three arrayLists.
		ArrayList<Integer> keyArrayList = new ArrayList<>();
		ArrayList<Character> msg1ArrayList = new ArrayList<>();
		ArrayList<Integer> msg2ArrayList = new ArrayList<>();
		
		//Create file instance. 
		java.io.File arrayKey = new java.io.File("arrayKey.txt");
						
		//Create a scanner for arrayKeyScanner. 
		Scanner arrayKeyScanner = new Scanner(arrayKey);
		
		//Create an integer variable to hold the number of values in the file. 
		int numberOfValues = arrayKeyScanner.nextInt();
		
		//Read values from arrayKey document, and put them in an ArrayList. 
		for(int i = 0; i < numberOfValues; i++)
		{
			int readValue1 = arrayKeyScanner.nextInt();
			keyArrayList.add(readValue1);
		}
		
		//Close arrayKeyScanner.
		arrayKeyScanner.close();
		
		//Create file instance. 
		java.io.File arrayMessage1 = new java.io.File("arrayMessage1.txt");
								
		//Create a scanner for the trains text file. 
		Scanner arrayMessage1Scanner = new Scanner(arrayMessage1);
				
		//Read values from arrayKey document, and put them in an ArrayList. 
		while(arrayMessage1Scanner.hasNext())
		{
			//Read value from file. 
			String readValue2 = arrayMessage1Scanner.nextLine();
			
			//Create loop to iterate through String and get characters.
			for(int i = 0; i < readValue2.length(); i++)
			{
				//Get character from index of String.
				char charValue = readValue2.charAt(i);
				
				//Add character to ArrayList. 
				msg1ArrayList.add(charValue);
			}
		}
		//Close arrayMessage1Scanner.
		arrayMessage1Scanner.close();
		
		//Create file instance. 
		java.io.File arrayMessage2 = new java.io.File("arrayMessage2.txt");
								
		//Create a scanner.. 
		Scanner arrayMessage2Scanner = new Scanner(arrayMessage2);
				
		//Create an integer variable to hold the number of values in the file. 
		int size = arrayMessage2Scanner.nextInt();
				
		//Read values from arrayMessage2 document, and put them in an ArrayList. 
		for(int i = 0; i < size; i++)
		{
			int readValue3 = arrayMessage2Scanner.nextInt();
			msg2ArrayList.add(readValue3);
		}
				
		//Close Scanner.
		arrayMessage2Scanner.close();
		
		//Create three iterators. (One for each ArrayList).
		Iterator<Character> msg1ArrayListIterator = msg1ArrayList.iterator();
		Iterator<Integer> msg2ArrayListIterator = msg2ArrayList.iterator();
		Iterator<Integer> keyArrayListIterator = keyArrayList.iterator();
		
		//Call decode method and assign to String.
		String msg1 = translator1.decode(msg1ArrayListIterator, msg2ArrayListIterator, keyArrayListIterator);
		
		//Print first decoded message. 
		System.out.println(msg1);
		
		//Create a new instance of the translator class. 
		Translator translator2 = new Translator();
		
		//Create three queues. 
		Queue<Character> queueMessage1 = new LinkedList<>();
		Queue<Integer> queueMessage2 = new LinkedList<>();
		Queue<Integer> queueKey = new LinkedList<>();
		
		//Create file instance. 
		java.io.File queueMessage1File = new java.io.File("queueMessage1.txt");
								
		//Create a scanner for queueMessage1. 
		Scanner queueMessage1Scanner = new Scanner(queueMessage1File);
				
		//Read values from text document, and put them in an queue. 
		while(queueMessage1Scanner.hasNext())
		{
			//Read value from file. 
			String readValue4 = queueMessage1Scanner.nextLine();
			
			//Create loop to iterate through String and get characters.
			for(int i = 0; i < readValue4.length(); i++)
			{
				//Get char from index of String.
				char charValue2 = readValue4.charAt(i);
				
				//Add character to queue. 
				queueMessage1.offer(charValue2);
			}
		}
				
		//Close Scanner.
		queueMessage1Scanner.close();
		
		//Create file instance. 
		java.io.File queueMessage2File = new java.io.File("queueMessage2.txt");
										
		//Create a scanner. 
		Scanner queueMessage2Scanner = new Scanner(queueMessage2File);
						
		//Create an integer variable to hold the number of values in the file. 
		int size2 = queueMessage2Scanner.nextInt();
						
		//Read values from text document, and put them in a queue. 
		for(int i = 0; i < size2; i++)
		{
			int readValue5 = queueMessage2Scanner.nextInt();
			queueMessage2.offer(readValue5);
		}
						
		//Close Scanner.
		queueMessage2Scanner.close();
		
		//Create file instance. 
		java.io.File queueKeyFile = new java.io.File("queueKey.txt");
						
		//Create a scanner for queueKeyScanner. 
		Scanner queueKeyScanner = new Scanner(queueKeyFile);
		
		//Create an integer variable to hold the number of values in the file. 
		int queueSize = queueKeyScanner.nextInt();
		
		//Read values from text document, and put them in a queue. 
		for(int i = 0; i < queueSize; i++)
		{
			int readValue6 = queueKeyScanner.nextInt();
			queueKey.offer(readValue6);
		}
		
		//Close Scanner.
		queueKeyScanner.close();
		
		//Create three iterators. 
		Iterator<Character> queueMessage1Iterator = queueMessage1.iterator();
		Iterator<Integer> queueMessage2Iterator = queueMessage2.iterator();
		Iterator<Integer> queueKeyIterator = queueKey.iterator();
		
		//Call decode function. 
		String msg2 = translator2.decode(queueMessage1Iterator, queueMessage2Iterator, queueKeyIterator);
		
		//Print decoded message. 
		System.out.println(msg2);
		
	} //Main

} //Assignment8

//Translator Class
class Translator
{
	//Private data fields. 
	private Stack8 stack;
	
	//Constructor. 
	public Translator()
	{
		stack = new Stack8();
	}
	
	//Decode method. 
	public String decode(Iterator<Character> msg1Iterator, Iterator<Integer> msg2Iterator, Iterator<Integer> keyIterator)
	{
		while(keyIterator.hasNext())
		{
			//Get next integer in the key file. 
			int key = keyIterator.next();
			
			if(key == 0 && msg1Iterator.hasNext())
			{
				//Get character from msg1 values and push on stack.
				char value = msg1Iterator.next();
				stack.push(value);
			}
			
			if (key == 1 && msg2Iterator.hasNext())
			{
				//Get integer from msg2 values, convert, and push on stack. 
				int integerValue = msg2Iterator.next();
				char characterValue = (char)integerValue;
				stack.push(characterValue);
			}
		}//While loop
		
		//Create a string builder, to add together the characters of the message. 
		//Set the size of the string equal to the size of the stack. 
		StringBuilder secretMessage = new StringBuilder(stack.getSize());
		
		//While the stack is not empty, pop off values and add to message. 
		while (! stack.isEmpty())
		{
			//Get character from stack, and add to the secretMessage.
			secretMessage.append(stack.pop());
			
		}//While loop
		
		return secretMessage.toString();
	}//Decode
	
}//Translator class

//Stack Class
class Stack8 
{
	//Private data fields. 
	private ArrayList<Character> list;
	
	//Create stack constructor. 
	public Stack8()
	{
		list = new ArrayList<>();
	}
	
	//Is empty method. Returns a boolean. 
	public boolean isEmpty() 
	{
		return list.isEmpty();
	}
	
	//getSize method. Returns number of elements on stack. 
	
	public int getSize() 
	{
		return list.size();
	}
	
	//push method. Adds a character to the top of the stack. 
	public void push(Character value)
	{
		//Add object to top of stack.
		list.add(value);
	}
	
	//pop method. Removes and returns the character on the top of the stack.
	public Character pop()
	{
		Character returnValue = list.remove(list.size()-1);
		return returnValue;
	}
	
}//Stack