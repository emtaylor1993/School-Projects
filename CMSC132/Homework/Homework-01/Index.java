import java.util.ArrayList;

public class Index {
    private ArrayList<WordEntry> wordList = new ArrayList<WordEntry>();
    int numOfWordOccurrences = 0;

    public Index addWord(String word, int[] pages) throws InvalidParameterException { 
        if (word == null || word.equals("") || pages.length == 0 || pages == null)
            throw new InvalidParameterException();
        wordList.add(new WordEntry(word, pages));
        return this;
    }

    public String longestWord() {
        String longestWord = "";
        if (wordList.size() > 0) {
            for(int i = 0; i < wordList.size(); i++) {
                if (wordList.get(i).getWord().length() > longestWord.length()) {
                    longestWord = wordList.get(i).getWord();
                }
            }
	  	  
            return longestWord;
        }
	  
	    return longestWord;
    }

    public int numUniqueWords() {
        int numUniqueWords = 0;
        
        // Conditional if statement for WordList of length 1
        if (wordList.size() == 1) {
            return 1;
        }
	  
        // Conditional if statement for WordList of length 2
        if(wordList.size() == 2) {
            if(wordList.get(0) != wordList.get(1))
                return 2;
        }
	  
        // Conditional if statement for WordList of length 3
        for(int i = 0; i < wordList.size(); i++) {
            for(int j = i++; j < wordList.size(); j++) {
                if(wordList.get(i) != wordList.get(j))
                    numUniqueWords++;
            }
        }
	  
        return numUniqueWords;
    }

    public int numWordOccurrences() {	  
        for(int i = 0; i < wordList.size(); i++) {
            numOfWordOccurrences += wordList.get(i).getPages().length;
        }
	  
        return numOfWordOccurrences;
    }

    public boolean isAlphabetized() {
        String previous = "";
	  
        if (wordList.size() == 0) {
            return true;
        }
	  
        for(int current = 0; current < wordList.size(); current++) {
            if(wordList.get(current).getWord().compareToIgnoreCase(previous) > 0)
                previous = wordList.get(current).getWord();
            else {
                return false;
            }
        }
	  
        return true;
    }
  
    public void removeWord(String word) throws InvalidParameterException {
        for (int i = 0; i < wordList.size(); i++) {
            if(word.equals(wordList.get(i).getWord()))
                wordList.remove(i);
        }
        numOfWordOccurrences --;
    }

    public String toString() {
        String result = "";
	  
        if(wordList.size() > 0) {
            for(int i = 0; i < wordList.size(); i++) {
                result += wordList.get(i).getWord() + ":" + wordList.get(i).page() + "\n"; 
            }
        }
	  
        return result;
    }
}