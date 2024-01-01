public class Main {
    public static void main(String[] args) {
        
         // Check if command line arguments are provided
        if (args.length == 0) {
        //q.1
            System.out.println("this program does not pass any arguments");
            return;
        }
        else if(args.length == 2){
        // q.3
        if(isInt(args[1])){
        int num = Integer.parseInt(args[1]);
       	for (int i = 0; i < num; i++) {
              System.out.println(args[0]);
        }
        }
        else{
            System.out.println("second argument must be integer");
        }
        }
	else{
	// q.2
        // Iterate through arguments and print 
        for (int i = 0; i < args.length; i++) {
        
            if ( isInt(args[i])) {
            	int number = Integer.parseInt(args[i]);
             if(number % 2 == 0)
            	System.out.println(number);
        }
    }
    }
    }
    
    /// check if arg is a number
     public static boolean isInt(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

