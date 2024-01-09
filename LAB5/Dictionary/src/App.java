import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
    private Map<Character, TreeSet<String>> wordMap;  // using TreeSet as it is implementation for NavigableSet interface
                                                        // which is sorted and does not accept duplicated values
    public App() {  // Constructor
        wordMap = new TreeMap<>();
    }
// insert a collection of words (sorted)
    public void insert(TreeSet<String> wordsToInsert) {
        for (String word : wordsToInsert) {
            insertWord(word);
        }
    }
        // insert a single word in the correct place
    public void insertWord(String word) {
        if (!word.isEmpty()) {
            char firstLetter = Character.toUpperCase(word.charAt(0));
            TreeSet<String> wordSet = wordMap.computeIfAbsent(firstLetter, k -> new TreeSet<>()); // craet a new set if not exist or update 
            boolean added = wordSet.add(word); // add function return true and ignore duplicated
            if (!added) { 
                System.out.println("The word '" + word + "' already exists.");
            }
            }
            else {
                System.out.println("You cannot insert an empty word.");
            }
    }
    
    public void removeWord(String word) {
        char firstLetter = Character.toUpperCase(word.charAt(0));
        // getOrDefault will return the default value to ensure that even if there was no set for the key, we still have a valid one to work with. 
        TreeSet<String> wordSet = wordMap.getOrDefault(firstLetter, new TreeSet<>()); 
        
        boolean removed = wordSet.remove(word);
        if (removed) {
            System.out.println("Word '" + word + "' removed successfully.");
        } else {
            System.out.println("Word '" + word + "' not found in the dictionary.");
        }
    }
    // remove all words for a specific Key
    public void removeAllKey(char key) {
        char upperCaseKey = Character.toUpperCase(key);
    
        // Check if the key exists in the map before attempting removal
        if (wordMap.containsKey(upperCaseKey)) {
            wordMap.remove(upperCaseKey);
            System.out.println("All words for letter '" + upperCaseKey + "' removed successfully.");
        } else {
            System.out.println("No words found for letter '" + upperCaseKey + "'.");
        }
    }

    // search with regex
     public void search(String regexPattern) {
        Pattern pattern = Pattern.compile(regexPattern); //compiles the specified regular expression
        wordMap.forEach((letter, wordsSet) -> { // Iterate Over wordsMap Entries
            TreeSet<String> matchingWords = new TreeSet<>();
            wordsSet.forEach(word -> { //Iterate Over Words in wordsSet
                Matcher matcher = pattern.matcher(word); // create Matcher instances for matching  words.
                if (matcher.matches()) { // check if it matches
                    matchingWords.add(word);
                }
            });
            System.out.println("Words for letter " + letter + " matching pattern '" + regexPattern + "': " + matchingWords);
        });
    }

    // print 
    public void printDictionary() {
        wordMap.forEach((letter, wordsSet) -> {
            System.out.println("Letter " + letter + ": " + wordsSet);
        });
    }

    // print a word
    public void getWords(char key) {
        char upperCaseKey = Character.toUpperCase(key);
        TreeSet<String> wordsSet = wordMap.getOrDefault(upperCaseKey, new TreeSet<>());
    
        if (!wordsSet.isEmpty()) {
            System.out.println("Words starting with letter " + upperCaseKey + ": " + wordsSet);
        } else {
            System.out.println("No words found for letter " + upperCaseKey);
        }
    }
   
    public static void main(String[] args) {
    
        App dictionary = new App();
        
        // Defines values as array of string

        String[] aWords = {"Apple", "Adventure", "Atmosphere", "Acoustic", "Alligator", "Amethyst", "Avocado", "Astonish", "Astronomy", "Abundant"};
        String[] bWords = {"Banana", "Brave", "Breeze", "Bubble", "Blossom", "Balloon", "Beacon", "Ballet", "Bonsai", "Blissful"};
        String[] cWords = {"Cactus", "Cascade", "Crisp", "Calm", "Charm", "Celestial", "Cello", "Cerulean", "Cherish", "Cinnamon"};
        String[] dWords = {"Dazzle", "Delight", "Dolphin", "Dream", "Dewdrop", "Diamond", "Dusk", "Divine", "Dainty", "Dragonfly"};
        String[] eWords = {"Eagle", "Eclipse", "Elegant", "Enchant", "Emerald", "Endless", "Essence", "Evergreen", "Exquisite", "Ephemeral"};
        String[] fWords = {"Fairy", "Flame", "Fiesta", "Frost", "Floral", "Firefly", "Fascinate", "Fable", "Feather", "Flicker"};
        String[] gWords = {"Gazebo", "Glimmer", "Grace", "Gentle", "Galaxy", "Glisten", "Garnet", "Gentleman", "Giggly", "Glitter"};
        String[] hWords = {"Harmony", "Heavenly", "Honey", "Harbor", "Hope", "Heartfelt", "Halcyon", "Haven", "Halo", "Hyacinth"};
        String[] iWords = {"Imagine", "Infinite", "Inspire", "Ivory", "Island", "Illuminate", "Impulse", "Incandescent", "Ingenious", "Ineffable"};
        String[] jWords = {"Jubilant", "Jade", "Journey", "Joyful", "Jazz", "Jasmine", "Jovial", "Jigsaw", "Jubilee", "Jocular"};
        String[] kWords = {"Kaleidoscope", "Kindle", "Kinetic", "Keen", "Kismet", "Kale", "Kudos", "Kiss", "Kittens", "Knight"};
        String[] lWords = {"Lagoon", "Luminous", "Lullaby", "Lavender", "Lively", "Lunar", "Luscious", "Lyric", "Labyrinth", "Lilac"};
        String[] mWords = {"Majestic", "Mystic", "Moonlight", "Melody", "Mirth", "Magenta", "Mosaic", "Mellow", "Miracle", "Majesty"};
        String[] nWords = {"Nebula", "Nectar", "Nirvana", "Noble", "Nurturing", "Nautical", "Novel", "Nuance", "Nebulous", "Nestle"};
        String[] oWords = {"Orchid", "Opulent", "Oasis", "Oceanic", "Optimistic", "Ornate", "Outstanding", "Overcome", "Overjoyed", "Onyx"};
        String[] pWords = {"Peach", "Pristine", "Petal", "Panorama", "Pleasure", "Ponder", "Panache", "Peaceful", "Perfume", "Pinnacle"};
        String[] qWords = {"Quasar", "Quaint", "Quell", "Quest", "Quiver", "Quintessence", "Quirky", "Quiet", "Quintessential", "Quench"};
        String[] rWords = {"Radiant", "Reverie", "Ripple", "Rustic", "Rendezvous", "Rhapsody", "Resplendent", "Rejoice", "Rose", "Rapture"};
        String[] sWords = {"Serene", "Sapphire", "Serenade", "Symphony", "Sparkle", "Stellar", "Sublime", "Savor", "Sculpt", "Sylvan"};
        String[] tWords = {"Tranquil", "Twilight", "Tender", "Tropical", "Talisman", "Tidal", "Traverse", "Timeless", "Tintinnabulation", "Treasure"};
        String[] uWords = {"Umbra", "Utopia", "Unwind", "Uplift", "Utter", "Umbrella", "Unique", "Upbeat", "Universe", "Unity"};
        String[] vWords = {"Velvet", "Vivid", "Vibrant", "Vanilla", "Valiant", "Vortex", "Verdant", "Verve", "Voyage", "Virtue"};
        String[] wWords = {"Whisper", "Wander", "Wisp", "Willow", "Wavelength", "Wondrous", "Wishful", "Waltz", "Wonder", "Wildflower"};
        String[] xWords = {"Xanadu", "Xylophone", "Xenon", "Xeric", "X-factor", "Xenial", "Xenophobe", "Xanthein", "Xenagogue", "Xerox"};
        String[] yWords = {"Yearning", "Yonder", "Yoga", "Yummy", "Yield", "Yarn", "Yonder", "Yaffle", "Yoga", "Yonder"};
        String[] zWords = {"Zephyr", "Zenith", "Zeal", "Zest", "Zing", "Zircon", "Zestful", "Zen", "Zeppelin", "Zany"};

        dictionary.insert(new TreeSet<>(Arrays.asList(aWords)));
        dictionary.insert(new TreeSet<>(Arrays.asList(bWords)));
        dictionary.insert(new TreeSet<>(Arrays.asList(cWords)));
        dictionary.insert(new TreeSet<>(Arrays.asList(dWords)));
        dictionary.insert(new TreeSet<>(Arrays.asList(eWords)));
        dictionary.insert(new TreeSet<>(Arrays.asList(fWords)));
        dictionary.insert(new TreeSet<>(Arrays.asList(gWords)));
        dictionary.insert(new TreeSet<>(Arrays.asList(hWords)));
        dictionary.insert(new TreeSet<>(Arrays.asList(iWords)));
        dictionary.insert(new TreeSet<>(Arrays.asList(jWords)));
        dictionary.insert(new TreeSet<>(Arrays.asList(kWords)));
        dictionary.insert(new TreeSet<>(Arrays.asList(lWords)));
        dictionary.insert(new TreeSet<>(Arrays.asList(mWords)));
        dictionary.insert(new TreeSet<>(Arrays.asList(nWords)));
        dictionary.insert(new TreeSet<>(Arrays.asList(oWords)));
        dictionary.insert(new TreeSet<>(Arrays.asList(pWords)));
        dictionary.insert(new TreeSet<>(Arrays.asList(qWords)));
        dictionary.insert(new TreeSet<>(Arrays.asList(rWords)));
        dictionary.insert(new TreeSet<>(Arrays.asList(sWords)));
        dictionary.insert(new TreeSet<>(Arrays.asList(tWords)));
        dictionary.insert(new TreeSet<>(Arrays.asList(uWords)));
        dictionary.insert(new TreeSet<>(Arrays.asList(vWords)));
        dictionary.insert(new TreeSet<>(Arrays.asList(wWords)));
        dictionary.insert(new TreeSet<>(Arrays.asList(xWords)));
        dictionary.insert(new TreeSet<>(Arrays.asList(yWords)));
        dictionary.insert(new TreeSet<>(Arrays.asList(zWords)));
        // start input
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n----- Word Dictionary Menu -----");
            System.out.println("1. Insert Words");
            System.out.println("2. Remove a Word");
            System.out.println("3. Remove All Words for a Key");
            System.out.println("4. Search for Words by Regex Pattern");
            System.out.println("5. Print Dictionary");
            System.out.println("6. Get Words for a Given Letter");
            System.out.println("7. Exit");
            System.out.print("Enter your choice : ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                // insert words 
                case 1:
                System.out.print("Enter words separated by commas: ");
                String[] wordsArray = scanner.nextLine().split(",");
                TreeSet<String> wordsSet = new TreeSet<>(Arrays.asList(wordsArray));
                for (String word : wordsArray) {
                    if (word.matches("^[a-zA-Z]+$")) {  // Check if the input contains only alphabet

                        wordsSet.add(word);
                    } 
                    else {
                        System.out.println("Invalid word: " + word + ". Skipping...");
                    }
                    }                    
                    dictionary.insert(wordsSet);
                    break;
                case 2:
                   // Remove Word
                   System.out.print("Enter the word to remove: ");
                   String wordToRemove = scanner.nextLine();
                   dictionary.removeWord(wordToRemove);
                   break;
                case 3:
                    // remove all words for a key logic
                    System.out.print("Enter the letter to remove all words for: ");
                    char keyToRemove = scanner.next().charAt(0);
                    dictionary.removeAllKey(keyToRemove);
                    break;                
                case 4:
                    // Search for Words by Regex Pattern
                    System.out.print("Enter the regex pattern to search: ");
                    String regexPattern = scanner.nextLine();
                    dictionary.search(regexPattern);
                    break;
                case 5:
                   // Print Dictionary
                   dictionary.printDictionary();
                   break;
                case 6:
                    // Get Words for a Given Letter
                    System.out.print("Enter the letter to get words for: ");
                    char keyToGet = scanner.next().charAt(0);
                    dictionary.getWords(keyToGet);
                    break;
                case 7:
                    System.out.println("Exit");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 7.");
            }
        }
    }
}

