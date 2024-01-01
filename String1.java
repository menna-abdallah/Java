import java.util.regex.*;
import java.util.StringTokenizer;    
public class String1 {
    public static void main(String[] args) {
 
        String sentence = "Splits a string into an array of substrings of that array";
        String word = "array";
        int count = 0;
        int count2 = 0;
        int count3 = 0;
        
        //method 1 >>>> 
        count = split_string(sentence,word);
        System.out.println("Number of occurrences of the word '" + word+ "' using split: " + count);
       
       // method2 >>> 
             count2 = index_of(sentence,word);
            // System.out.println("counter is :" + count2);
              System.out.println("Number of occurrences of the word '" + word+ "'using index of: " + count2);
              
              // method3  >>>
               count3 = string_tokens(sentence,word);
            // System.out.println("counter is :" + count2);
              System.out.println("Number of occurrences of the word '" + word+ "'using string tokens: " + count3);
              
    }
    
    // method 1
    
     public static int split_string(String sentence, String word) {
     	if (word.equals("")) {
            return 0;
        }
         int count = 0;
      String[] words = sentence.split("[\\s.,;:\"?!(){}\\[\\]%/#]|(- )|( -)");
         for (String w : words) {
            if (w.equalsIgnoreCase(word)) { 
                count++;
            }
        }
        return count;
     } 
    
    
    // method 2 
    public static int index_of(String sentence, String word) { 
        if (word.equals("")) {
            return 0;
        }
        int count =0, position = 0;
 	
 	while (true) {
            position = sentence.indexOf(word, position);
            if (position != -1) {
                count++;
                position++;
            }
            else {
                break;
            }
        }
        return count;
	}
	
	// method 3
	
	public static int string_tokens(String sentence, String word) {
        int count = 0;
        StringTokenizer words = new StringTokenizer(sentence, " ");

        while(words.hasMoreTokens()) {
            if (words.nextToken().equals(word)) {
               count++;
            }
        }
        return count;
    }
	
	}
