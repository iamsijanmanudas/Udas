import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World");
        ArrayList<String> words = readWords("F:/School/Java/Assignment1/Udas/res/words.txt");
        HashMap<String , Integer> wordCounter = buildHashMap(words); //create a hashmap to count the occurance of each word
        // create a function that reads from the hashmap and writes it to a html file with word count and word to a html table format
        createHTMLFile(wordCounter);
        System.out.println(words);
        System.out.println(wordCounter);
        Collections.sort(words); 
        System.out.println(words);
        ArrayList <WordFrequency> wordsListFromHashmap  = new ArrayList <>();
        wordsListFromHashmap = populateArrayFromHashMap(wordCounter);
        Collections.sort(wordsListFromHashmap); 
        System.out.println(wordsListFromHashmap);


        createSortedHTMLFile (wordsListFromHashmap);
    }


/** This is the function that creates a HTML file using a ArrayList<WordFrequency> that displays a sorted table of words and count variables from the instances
 * @param wordsList
 * @throws IOException
 */
private static void createSortedHTMLFile (ArrayList <WordFrequency> wordsList) throws IOException
{
    File file = new File ("res/sorted.html");

    FileWriter FileWriter = new FileWriter(file);
    StringBuilder builder = new StringBuilder();
    builder.append("<h1>Word Count<h1>");
            
    builder.append("<html>"); 
    builder.append("<head>");
    builder.append("<style>");
    builder.append("table {"); builder.append("  font-family: arial, sans-serif;");builder.append("  border-collapse: collapse;");builder.append("  width: 100%;");builder.append("}"); builder.append("td, th {");builder.append("  border: 1px solid #dddddd;");builder.append("  text-align: left;"); builder.append("  padding: 8px;"); builder.append("}");builder.append("tr:nth-child(even) {");  builder.append("  background-color: #dddddd;"); builder.append("}");
    builder.append("</style>");
    builder.append("</head>");
    builder.append("<body>");
    builder.append("<table>"); 
    for (WordFrequency word: wordsList) //makes a for each loop to use the keys from .keySet() of the hashmap wordCounter 
    {
        builder.append ("<tr>");
        builder.append ("<td>"+ word.getWord() + "</td>");
        builder.append ("<td>"+ word.getCount() + "</td>"); // gets the value associated with each key 
        builder.append ("</tr>");
    }

    builder.append("</table>");

    builder.append("</body>");
    builder.append("</html>");

    FileWriter.append(builder.toString());
    FileWriter.close();

}


    //phase 2 Step 9
/** function to populate an ArrayList<WordFrequence> from the hashmap
 * @param wordCounter this is the passed HashMap
 * @return returns the populated array
 */
private static ArrayList <WordFrequency>  populateArrayFromHashMap(HashMap<String, Integer> wordCounter) 
    {
        ArrayList <WordFrequency> wordsList  = new ArrayList <>();
        for (String key : wordCounter.keySet())
        {
            WordFrequency count = new WordFrequency(key,wordCounter.get(key));//assigns the value of hashmap to a new instance of class
            wordsList.add(count);//assigns the values of the new instance of class to the array
        }
       return wordsList;
    }
 
    //step 6
    /** this is the function that will create a raw HTML file displaying the contents of the passed hashMap<String, Integer> in a table form
     * @param wordCounter 
     */
    private static void createHTMLFile(HashMap<String, Integer> wordCounter)
    {
        File file = new File("res/words.html");

        try {
            FileWriter FileWriter = new FileWriter (file);
            StringBuilder builder = new StringBuilder();
            builder.append("<h1>Word Count<h1>");
            
            builder.append("<html>"); 
            builder.append("<head>");
            builder.append("<style>");
            builder.append("table {"); builder.append("  font-family: arial, sans-serif;");builder.append("  border-collapse: collapse;");builder.append("  width: 100%;");builder.append("}"); builder.append("td, th {");builder.append("  border: 1px solid #dddddd;");builder.append("  text-align: left;"); builder.append("  padding: 8px;"); builder.append("}");builder.append("tr:nth-child(even) {");  builder.append("  background-color: #dddddd;"); builder.append("}");
            builder.append("</style>");
            builder.append("</head>");
            builder.append("<body>");
         
            builder.append("<table>"); 
            for (String key: wordCounter.keySet()) //makes a for each loop to use the keys from .keySet() of the hashmap wordCounter 
            {
                builder.append ("<tr>");
                builder.append ("<td>"+ key + "</td>");
                builder.append ("<td>"+ wordCounter.get(key) + "</td>"); // gets the value associated with each key 
                builder.append ("</tr>");
            }

            builder.append("</table>");

            builder.append("</body>");
            builder.append("</html>");

            FileWriter.append(builder.toString());
            FileWriter.close();


        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       


    }


    /**This is the function that will build a HashMap out of the arrayList<String> with the word as key and count of word as value
     * @param words
     * @return the hashMap
     */
    private static HashMap<String, Integer> buildHashMap(ArrayList<String> words) 
        {
            HashMap<String,Integer> wordCounter = new HashMap<>(); //declaration
            
            for (String word: words)
            {
                Integer count = wordCounter.get(word);//to get the value associated with the key 

                if (count==null)//check if the value is null for that key and initialize the value if it is
                {
                    wordCounter.put(word,1);//put(key,value) is a method to assign value to the key 
                }
                else// if it is already initializd and needs to be counted again
                {
                    wordCounter.put(word, count+1);
                }
            }
            return wordCounter;
        }


    //Step 4
    /**This is the function that creates a ArrayList of type String by reading the txt file
     * @param fileName
     * @return
     */
    private static ArrayList<String> readWords(String fileName)//how to read a txt file and save contents to an Array
    {
        File file = new File (fileName);//declare a file
        ArrayList<String> wordList = new ArrayList<>(); //declare an array

        try {
            FileReader reader = new FileReader(file);//to read the contents of a file
            BufferedReader bufferedReader = new BufferedReader(reader);//we create a bufferReader object which is used to read lines from txt file

            String line = bufferedReader.readLine();
            while (line != null)//until the eof the line will not be null
            {
                
                String[] words = line.split("[\\s,.]+"); //if you come across [ .,]+ then split the line for output
                //now words is an array of strings made from each line of the text
                for (String word: words)
                { // for each loop where word = words[i]

                    if (word.trim().length() > 0)
                    {
                        wordList.add(word.toLowerCase()); //add each word after trimming special characters and makiting it lower case
                    }
                }
                line = bufferedReader.readLine();//read the next line
            }
            bufferedReader.close();//always close it
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return wordList;//return array
    }


}