import java.util.Scanner;
import java.io.FileWriter;   
import java.io.IOException;  
import java.io.File;
import java.io.FileNotFoundException;
/*
Asks if you want to add to the file, read the whole file or look for a word in the file
*/
class Main {
  public static String fileName;
  //add to the file
  public static void addFile(String s)
  {
    try
    {
      FileWriter writer = new FileWriter(fileName, true);
      writer.write(s+"\r\n");
      writer.close();
    }catch(Exception e)
    {
      System.out.println(e);
    }
    System.out.println("In add file");
  }
  //Read whole file
  public static void readFile()
  {
    try
    {
      File f = new File(fileName);
      Scanner fileReader = new Scanner(f);
      while(fileReader.hasNextLine())
      {
        System.out.println(fileReader.nextLine());
      }
    }catch(Exception e)
    {
      System.out.println(e);
    }

    System.out.println("in read file");
  }
  //Look for word in file
  public static void lookFile(String s)
  {
    try
    {
      File f = new File(fileName);
      Scanner fileReader = new Scanner(f);
      boolean wordFound = false;
      while(fileReader.hasNextLine())
      {
        if(fileReader.nextLine().equals(s))
        {
          wordFound = true;
          System.out.println(s + " was found!");
        }
        
      }
      if(!wordFound)
      {
        System.out.println("Sorry, wasn't found");
      }
    }catch(Exception e)
    {
      System.out.println(e);
    }

    System.out.println("in read file");
    System.out.println("Look for a word");
  }
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    fileName = "myFile.txt";
    //Variables
    String choice = "";
    while(!choice.equals("q"))
    {
      System.out.println("What would you like to do?");
      System.out.println("1 Read the file");
      System.out.println("2 Add to the file");
      System.out.println("3 Look for a word");
      System.out.println("q to quit");
      
      choice = input.nextLine();
      if(choice.equals("1")){
        readFile();
      }else if(choice.equals("2"))
      {
        System.out.println("Add a word: ");
        addFile(input.nextLine());
      }else if(choice.equals("3"))
      {
        System.out.println("What word: ");
        lookFile(input.nextLine());
      }//end if
      
    }//end while loop
  }//end of main method
}//end of Main class