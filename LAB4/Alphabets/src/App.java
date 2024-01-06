public class App {

    @FunctionalInterface
    interface StringChecker {
    boolean checkString(String input);
    }
    
    public static void main(String[] args) {


        StringChecker stringChecker = (s)->{
            for (char ch : s.toCharArray()) {
                if (!Character.isLetter(ch)) 
                {return false; }
            }
            return true;
            };

        String s1 = "menna";
        String s2 = "12345";
       if(  stringChecker.checkString(s1) ){
           System.out.println(s1 + " contains chars only.");
       }
       else {
           System.out.println(s1 + " is not chars only ");
       }
    
    if(  stringChecker.checkString(s2) ){
           System.out.println(s2 + " contains chars only.");
       }
       else {
           System.out.println(s2+ " is not chars only ");
       }
    }
}


