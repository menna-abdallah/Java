public class Task1 {
    public static void main(String[] args) {
    
    	int arr_nums [] = new int [1000];
    	int number;
    	
    	// generate array
    	for (int i = 0 ; i < 1000 ; i++){
    	number = (int) (Math.random() * 1000);
    	arr_nums [i] = number;
    }
    
    //start time to search
        long startTime = System.nanoTime();
    
    // Find minimum and maximum
        int min = findMin(arr_nums);
        int max = findMax(arr_nums);
        
        // end time 
        long endTime = System.nanoTime();
        
        // compute time 
        long computingTime = endTime - startTime;
        
        System.out.println("min value of the array: " + min);
        System.out.println("max value of the array: " + max);
        System.out.println("Start Time: " + startTime);
        System.out.println("End Time: " + endTime);
        System.out.println("Computing Time: " + computingTime + " nanoseconds");
    }
    
    // find minFunction
     public static int findMin(int[] array) {
        int min = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }

        return min;
    }
    
    //find maxFunction
    public static int findMax(int[] array) {
        int max = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        return max;
    }
    
    
    
    }
