public class Palindrom {
    public static void main(String[] args) {
    	if (args.length == 0) {
        //q.1
            System.out.println("this program does not pass any arguments");
            return;
        }
        else{
       	String str = args[0];
       	String str2 ="";
    	for(int i =0 ; i < str.length()-1; i++){
    	str2+= str.charAt(str.length() - i-1);
    	}
    	System.out.println(str2);
    	}
    	}
    	}


