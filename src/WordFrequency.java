public class WordFrequency implements Comparable <WordFrequency>{
    
 String word;
 Integer count;



public WordFrequency (String word,  Integer count  )
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
    return "WordFrequency [word = " + word + ", count = " + count + "]";
}

@Override
public int compareTo(WordFrequency otherword)
{
    if (this.count > otherword.count)
    {
        return 1;
    }
    else if(this.count < otherword.count)
    {
        return -1;
    }
    else 
        return 0;
}



}
