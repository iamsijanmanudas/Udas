import java.util.ArrayList;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        ArrayList<String> words = readWords("F:/School/Java/Assignment1/Udas/res/words.txt");
        HashMap<String , Integer> wordCounter = buildHashMap(words);
        // create a function that reads from the hashmap and writes it to a html file with word count and word to a html table format
        createHTMLFile(wordCounter);
        System.out.println(words);
        System.out.println(wordCounter);



    }

//step 6
    private static void createHTMLFile(HashMap<String, Integer> wordCounter)
    {
        File file = new File("res/words.html");

        try {
            FileWriter FileWriter = new FileWriter (file);
            StringBuilder builder = new StringBuilder();
            builder.append("<h1>Word Count<h1>");

            builder.append("<table>");

            for (String key: wordCounter.keySet())
            {
                builder.append ("<tr>");
                builder.append ("<td>"+ key + "</td>");
                builder.append ("<td>"+ wordCounter.get(key) + "</td>");
                builder.append ("</tr>");
            }

            builder.append("</table>");
            FileWriter.append(builder.toString());
            FileWriter.close();


        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       


    }


    private static HashMap<String, Integer> buildHashMap(ArrayList<String> words) 
        {
            HashMap<String,Integer> wordCounter = new HashMap<>(); 

            for (String word: words)
            {
                Integer count = wordCounter.get(word);

                if (count==null)
                {
                    wordCounter.put(word,1);
                }
                else
                {
                    wordCounter.put(word, count+1);
                }
            }
            return wordCounter;
        }


    //Step 4
    private static ArrayList<String> readWords(String fileName)
    {
        File file = new File (fileName);
        ArrayList<String> wordList = new ArrayList<>();

        try {
            FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line = bufferedReader.readLine();
            while (line != null)
            {
                
                String[] words = line.split("[\\s,.]+"); //if you come across [ .,]+ then split the line for output
                
                for (String word: words)
                { // for each loop where word = words[i]

                    if (word.trim().length() > 0)
                    {
                        wordList.add(word.toLowerCase()); //add each word after trimming special characters and makiting it lower case
                    }
                }
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return wordList;
    }


}