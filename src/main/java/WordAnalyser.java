import java.util.ArrayList;
import java.util.Map;

public class WordAnalyser {

    public String removePunctuation(String word){
        String punctuationRegex = "\\p{Punct}";
        return word.replaceAll(punctuationRegex, "");
    }

    public String[] findLongestWords(String text) {
        ArrayList<String> arrayList = new ArrayList<>();
        String[] words = text.split(" ");
        int maxLength = 0;

        for (String w : words){
            if (removePunctuation(w).length() >= maxLength){
                maxLength = removePunctuation(w).length();
            }
        }
        System.out.println("Max length " + maxLength);
        for (String w: words){
            if (removePunctuation(w).length() == maxLength){
                System.out.println("Adding " + removePunctuation(w));
                arrayList.add(removePunctuation(w));
            }
        }
        return arrayList.toArray(new String[0]);
    }

    public Map<Character, Integer> calculateLetterFrequency(String text) {
        // TODO: Implement the logic to calculate the frequency of each letter in the given text
        return null;
    }
}

