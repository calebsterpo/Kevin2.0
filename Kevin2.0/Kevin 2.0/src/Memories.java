import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;	
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
	
public class Memories
{
	public File file;
	public FileWriter writer;
	public MemoryObj[] Arr = new MemoryObj[Main.SIZE];
	public Voice mouth;
    int numMem;
    String name;
    public boolean hasMet;
    public static char[] alphabet = {'A','B','C','D','E','F','G','H','I','J','K',
    		  		 'L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	
	public Memories(String user)
	{
	 Arr[0] = new MemoryObj(scramble(user.replaceAll(" ", "")), 0);	
	 name = "Memories/" + scramble(user.replaceAll(" ", ""));
	 
	 if ((file = new File(name + ".txt")).exists())
	 {
	   readTheFile();
	   hasMet = true;
	 }
	 else if (!file.exists())
	 {
	    hasMet = false;
		createFile(name);
		numMem = 1; 
	 }
	 fillFile(name);
	}
	
	public static String scramble(String str)
	{
	 String codedStr = "";
	 char[] word = str.toCharArray();
	 for(int i = 0; i < word.length; i++)
	   codedStr += Character.getNumericValue(word[i])*8 + "" + alphabet[(i*301)%26];
	return codedStr;
	}
	
	public static MemoryObj scramble(MemoryObj str)
	{
	 String codedStr = ""; 
	 char[] word = str.name.toCharArray();
	 for(int i = 0; i < word.length; i++)
	   codedStr += Character.getNumericValue(word[i])*8 + "" + alphabet[(i*301)%26];
	return new MemoryObj(codedStr, str.spot);
	}
	
	public static String unscramble(String codedStr)
	{
	 String fixed = "";
	 codedStr = codedStr.replaceAll("[ABCDEFGHIJKLMNOPQRSTUVWXYZ]", ",");
	 String[] word = codedStr.split(",");
	 for(int i = 0; i < word.length; i++)
	   fixed += (char)((Integer.parseInt(word[i])/8) + 55);
	return fixed;
	}
	
	public void askFavorite(int spot)
	{
	 addMemory(Main.mouth.ask("What is your favorite " + Arr[0].thought[spot] + "?", spot));	
	}
	
	public void askGeneral(String question, int spot)
	{
	 addMemory(Main.mouth.ask(question, spot));
	}
	
	public void addMemory(MemoryObj memory)
	{
	  if (contains(memory.spot) == -1 && !memory.name.equals(""))
	   {
	    Arr[numMem] = memory;
	    numMem++;
	   }
	  else if (contains(memory.spot) != -1)
	    Arr[contains(memory.spot)] = memory;
		 
	  sortMemories();
	  fillFile(name);
	}
	
	public void addMemory(String answer, int spot)
	{
	 if (contains(spot) == -1)
	 {
	 Arr[numMem] = new MemoryObj(scramble(answer), spot);
	 numMem++;
	 }
	 else
	 Arr[contains(spot)] = new MemoryObj(scramble(answer),spot);
	 
	 sortMemories();
	 fillFile(name);
	}
	
	public String getMemory(int spot)
	{
	 int i = contains(spot);
	 if (i > 0)
	 return unscramble(Arr[i].name);
	 return "unknown";
	}
	
	public int contains(int spot)
	{
	 for (int i = 0; i < numMem; i++)
		 if (Arr[i].spot == spot)
			 return i;
	 return -1;
	}
	
	public void createFile(String name)
	{
		file = new File(name + ".txt");
		try 
		{
		 writer = new FileWriter(file, true);
		 PrintWriter printer = new PrintWriter(writer);

		 printer.close();
		 writer.close();
		} catch (IOException e) {e.printStackTrace();}
	}
	
	public void fillFile(String name)
	{
		try 
		{
		 writer = new FileWriter(file, true);
		 PrintWriter printer = new PrintWriter(writer);
			    
		 clearTheFile(name);
		 for(int i = 0; i < Arr.length; i++)
			 if (Arr[i] != null)
			 printer.print(Arr[i].toStringFile() + "\n");
			
		 printer.close();
		 writer.close();
			
		} catch (IOException e) {e.printStackTrace();}
	}
		  
	public void clearTheFile(String name)
	{
	 try {
			writer = new FileWriter(name + ".txt", false);

			  PrintWriter printer = new PrintWriter(writer, false);
			  printer.flush();
			  printer.close();
			  writer.close();
	  } catch (IOException e) {e.printStackTrace();}
	}
		  
	public void readTheFile()
	{
		FileReader reader;
		Scanner inFile;
		try
		{
		  reader = new FileReader(file);
		  inFile = new Scanner(reader);
		  int i = 0;
		  while(inFile.hasNext())
		  {
			String temp = inFile.nextLine();
			String delims = " ";
			String[] memory = temp.split(delims);
			Arr[i] = new MemoryObj(memory[2], Integer.parseInt(memory[0]));
			i++;
		  }
		  numMem = i;
		  inFile.close();
		  reader.close();
		}
		catch (IOException e) {e.printStackTrace();}
		catch (java.lang.ArrayIndexOutOfBoundsException e) 
		{
		  JFrame frame = new JFrame("InputDialog");
		  JOptionPane.showMessageDialog(frame,
			"I'm sorry, I seem to have forgotten you ",
			"System Error",JOptionPane.ERROR_MESSAGE);
		}
	}
		  
	public void sortMemories()
	{
		int N = numMem;
		for(int i = 0; i < N; i++)
		{
		 int large = Arr[i].spot;
		 int pos = i;
		 for(int j = i + 1; j < N; j++)
		  {
			 if(Arr[j].spot < large)
		     {
			   large = Arr[j].spot;
			   pos = j;
		     }
		  }
		MemoryObj temp = Arr[pos];
		 Arr[pos] = Arr[i];
		 Arr[i] = temp;
		}
	}	
			
	public String toString()
	{
	 String memories = "";
	   for(MemoryObj j : Arr)
		   if (j != null)
		 memories = memories + "" + j + "\n";
	 return memories;
	}

}
