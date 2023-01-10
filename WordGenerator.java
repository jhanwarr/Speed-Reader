import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

//importing the classes in some packages that are required

class WordGenerator 
{
	private Scanner words;
	//creating an Scanner class object

	private int sentence;
	private int word_count;

	/**
	 * Constructor to get access the file required to be read
	 * @param filename The name of the file to be read
	 */
	public WordGenerator(String filename)
	{
		//try block to handle the exception if the file is not found
		try
		{
			words = new Scanner(new File(filename));
		}

		catch(FileNotFoundException e)
		{
			System.err.println("The file named \""+filename+"\" is not found.");
			//printing an error message if the file is not found.
			
			System.exit(0);
			//Exiting the class
		}

		sentence = 0;
		word_count = 0;
	}

	/**
	 * Checking if there are more words from the file read which are yet to be processed
	 * @return true if there are more words to be processed or else false
	 */
	public boolean hasNext()
	{
		return words.hasNext();
	}

	/**
	 * Returning the next word that is to be processed
	 * @return The next word in the file which is opened by scanner
	 */
	public String next()
	{
		String s = words.next();

		if(s != null)
			word_count++; 
		//increasing the word count

		char ch = s.charAt(s.length()-1);

		if(ch == '.' || ch == '?' || ch == '!')
			sentence++;
		//check for sentences processed completely
		
		return s;
	}

	/**
	 * The number of words processed till now
	 * @return The count of the words as stored in the variable word_count
	 */
	public int getWordCount()
	{
		return word_count;
	}

	/**
	 * The number of sentences processed so far
	 * @return The count of the sentences as stored in the variable sentence
	 */
	public int getSentenceCount()
	{
		return sentence;
	}
}
