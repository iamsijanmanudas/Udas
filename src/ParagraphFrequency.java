public class ParagraphFrequency implements Comparable <ParagraphFrequency> {
       
 String word;
 Integer count;
 public ParagraphFrequency (String word,  Integer count  )
 {
     this.word = word;
     this.count = count;
 }
 
 
 public String getWord()
 {
     return word;
 }
 
 public void setWord(String passedWord)
 {
     this.word=passedWord;
 }
 public Integer getCount()
 {
     return count;
 }
 
 public void setCount(Integer passedCount)
 {
     this.count=passedCount;
 }
 
 @Override
 public String toString(){
     return "ParahraphFrequency [word = " + word + ", count = " + count + "]";
 }

 @Override
 public int compareTo(ParagraphFrequency secondWord)
 {
     if (this.count > secondWord.count)
     {
         return 1;
     }
     else if(this.count < secondWord.count)
     {
         return -1;
     }
     else 
         return 0;
 }
 
 
 
 }
 

