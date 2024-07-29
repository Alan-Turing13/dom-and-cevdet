import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WordAnalyser {

    public String removePunctuation(String word) {
        String punctuationRegex = "\\p{Punct}";
        return word.replaceAll(punctuationRegex, "");
    }

    public String[] findLongestWords(String text) {
        ArrayList<String> arrayList = new ArrayList<>();
        String[] words = text.split(" ");
        int maxLength = 0;

        for (String w : words) {
            if (removePunctuation(w).length() >= maxLength) {
                maxLength = removePunctuation(w).length();
            }
        }
        System.out.println("Max length " + maxLength);
        for (String w : words) {
            if (removePunctuation(w).length() == maxLength) {
                System.out.println("Adding " + removePunctuation(w));
                arrayList.add(removePunctuation(w));
            }
        }
        return arrayList.toArray(new String[0]);
    }

    public Map<Character, Integer> calculateLetterFrequency(String text) {
        // TODO: Implement the logic to calculate the frequency of each letter in the given text
        //        calculateLetterFrequency("Hello world").get('l'); should return 3
        //        calculateLetterFrequency("This is a fairly boring thing.").get('z'); should return 0

        Map<Character, Integer> letterFrequencyMap = new HashMap<>();

        // Add all alphabet characters in the map initially
        for (int i = 97; i<123; i++) {
            letterFrequencyMap.put(Character.valueOf((char) i), 0);
        }

        for (Character c : text.toLowerCase().toCharArray()) {
            if (Character.isAlphabetic(c)) {
                // Increments the counter of letter
//                letterFrequencyMap.compute(c, (k, v) -> v + 1);

                // Simpler implementation
                letterFrequencyMap.put(c, letterFrequencyMap.get(c) + 1);
            }
        }



        return letterFrequencyMap;
    }

}

