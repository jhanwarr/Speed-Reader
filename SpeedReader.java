/*
 * 
 *  Author - Raj Vardhan Jhanwar
 *  Due Date - 11/14/2022
 *  Assignment 5
 * 
 * 
 *  Written/Online Sources used - None
 *  Help Obtained - None
 * 
 *  I confirm that the above list of sources is the complete AND that I have not talked 
 *  to anyone else (eg., any CSC 207 students) about the solutions to this problem.
 * 
 */

import java.awt.Graphics;
import java.awt.Font;

//importing the classes in some packages that are required


public class SpeedReader 
{	
	/**
	 * main method to take in the command line arguments, create objects and call on other methods for program execution
	 * @param args Array containing all the command line arguments
	 * @throws InterruptedException Exception thrown if the thread is interrupted and is not able to stop for the specified time
	 */
	public static void main(String[] args) throws InterruptedException
	{
		for(String s: args)
			System.out.println(s);
		//printing the command line arguments


		try
		{
			WordGenerator obj = new WordGenerator(args[1]);
			//Object of the WordGenerator class

			final int WIDTH = Integer.valueOf(args[2]);
			final int HEIGHT = Integer.valueOf(args[3]);
			final int FONT_SIZE = Integer.valueOf(args[4]);
			final int WPM = 60000/Integer.valueOf(args[5]);
			final int H = (int)((HEIGHT/2) - (FONT_SIZE/2));
			//Constant Variables required

			DrawingPanel panel = new DrawingPanel(WIDTH, HEIGHT);
			//creating a constructor of the DrawingPanel class for creating a panel of dimensions 400 by 300 pixels

			Font f = new Font("Courier", Font.PLAIN, FONT_SIZE);

			Graphics g = panel.getGraphics(); 
			g.setFont(f); 
			//setting the graphics's font with the desired one

			while(obj.hasNext())
				demonstratePanel(panel, obj.next(), WPM, H);

			System.out.println("Word(s) processed : "+obj.getWordCount());
			System.out.println("Sentence(s) processed : "+obj.getSentenceCount());
			//The information being printed after the processing of words of the given file
		}

		catch(ClassCastException e1)
		{
			System.err.println("Invalid argument types provided. Exiting the program");
			//error message
			
			System.exit(0);
			//exiting the code
		}

		catch(ArrayIndexOutOfBoundsException e2)
		{
			System.err.println("Invalid number of arguments provided. Exiting the program");
			//error message
			
			System.exit(0);
			//exiting the code
		}

		catch(Exception e3)
		{
			System.err.println("An unkown error occurred. Have to exit the code.");
			//error message
			
			System.exit(0);
			//exiting the code
		}
	}


	/**
	 * function to display the given word in a panel in the desired font
	 * @param display_word the word to be displayed
	 * @throws InterruptedException Exception thrown if the thread is interrupted and is not able to stop for the specified time
	 */
	private static void demonstratePanel(DrawingPanel panel, String display_word, int wpm, int h) throws InterruptedException 
	{
		Graphics g = panel.getGraphics(); 
		//the graphics created in the DrawingPanel class
		
		g.drawString(display_word, 50, h);
		//drawing the given word on the panel
		
		printStaggered(wpm);
		//pausing the program
		
		panel.clear();
		//clearing the panel for displaying the next word
	}


	/**
	 * Function to pause the running of the program for a given number of seconds
	 * @param wpm The number of seconds for which the program has to be paused
	 * @throws InterruptedException Exception thrown if the thread is interrupted and is not able to stop for the specified time
	 */
	private static void printStaggered(int wpm) throws InterruptedException 
	{
		Thread.sleep(wpm);
		//making the current thread sleep/pause for 'wpn' seconds
	} 
	

	/*
	 * Test Output – 
	 *
	 *  SpeedReader
	 *	Sample Reading File.txt
	 *	600
	 *	500
	 *	46
	 *	250
	 *	Word(s) processed : 128
	 *	Sentence(s) processed : 15
	 *		
	 */
}
