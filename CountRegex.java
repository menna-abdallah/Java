import java.util.regex.*;
public class CountRegex {
    public static void main(String[] args) {

        String inputString = "apple banana orange banana apple banana";
        String wordGroupToCount = "apple|banana"; // Use | to specify different words in the group

        int occurrences = regexOcc(inputString, wordGroupToCount);

        System.out.println("Occurrences of the word group: " + occurrences);
    }


    public static int regexOcc(String s, String wordGroup) {
        int occ = 0;

        // Create a regular expression for matching the group of words
        /*
        the regular expression \\b( + wordGroup + )\\b ensures that it matches a whole word from the specified word group. 
        The wordGroup variable should contain a group of words separated by the | (OR) operator. 
        For example, if wordGroup is "apple|banana," the regular expression will match occurrences of "apple" or "banana" 
        */
        String myregex = "\\b(" + wordGroup + ")\\b";

        // Compile the regular expression pattern
        Pattern pattern = Pattern.compile(myregex);

        // Create a matcher object for the input string 's'
        Matcher matcher = pattern.matcher(s);

        // Iterate through the matches
        while (matcher.find()) {
            // Increment the occurrence counter
            occ++;
        }

        // Return the total number of occurrences
        return occ;
    }

}
