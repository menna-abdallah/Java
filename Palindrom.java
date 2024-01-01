public class Palindrom {
    public static void main(String[] args) {
    	if (args.length == 0) {
        //q.1
            System.out.println("this program does not pass any arguments");
            return;
        }
        else{
        boolean flag = true;
        String str = args[0];
    for(int i =0 ; i < str.length() /2; i++){
    	if ( str.charAt(i) != str.charAt(str.length() - i-1)){
    	flag = false;
    	break;
	}
    	}
    	if (flag) {
		System.out.println("palindrom argument");
    }
    else{
    		System.out.println("Not palindrom argument");
    }
    }
    }
    }
