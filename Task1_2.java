public class Task1 {
    public static void main(String[] args) {
    
        int arr_nums[] = new int[1000];
        int number;

        // generate array
        for (int i = 0; i < 1000; i++) {
            number = (int) (Math.random() * 1000);
            arr_nums[i] = number;
        }

        // sort array
        for (int i = 0; i < arr_nums.length - 1; i++) {
            for (int j = 0; j < arr_nums.length - i - 1; j++) {
                if (arr_nums[j] > arr_nums[j + 1]) {
                    // swap arr_nums[j] and arr_nums[j+1]
                    int temp = arr_nums[j];
                    arr_nums[j] = arr_nums[j + 1];
                    arr_nums[j + 1] = temp;
                }
            }
        }

        // start time to search
        long startTime = System.nanoTime();

        // find value 55
        boolean flag = binarySearch(arr_nums, 55);

        if (flag) {
            System.out.println("55 is FOUND");
        } else {
            System.out.println("55 is not FOUND");
        }

        // end time
        long endTime = System.nanoTime();

        // compute time
        long computingTime = endTime - startTime;
        
	System.out.println("Start Time: " + startTime);
        System.out.println("End Time: " + endTime);
        System.out.println("Time to search: " + computingTime + " nano
        ...................................................................seconds");
    }

    public static boolean binarySearch(int[] array, int key) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            

            if (array[mid] == key) {
                return true;
            } else if (array[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }
}

