import java.util.Scanner;

public class AllocationOfBooks {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n(Array Element size) value");
        int n = sc.nextInt();
        System.out.println("Enter k(students value:");
        int k = sc.nextInt();        
        System.out.println("Enter array elements:");
        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        System.out.print("The Number of Pages is : " + findPages(arr, k));
    }
    
    public static int findPages(int[] arr, int k) {
        // code here
        int n = arr.length;
        int min = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0 ; i < n ; i++){
            min = Math.max(min, arr[i]);
            sum += arr[i]; 
        }
        
        //Using Linear Search
        /*
        for(int pages = min ; pages <= sum ; pages++){
            if(countStudents(arr, pages) == k){
                return pages;
            }
        }
        return -1;
        */
        
        //Using Binary Search
        int low = min;
        int high = sum;
        
        if(k > n){
            return -1;
        }
        while(low <= high){
            int mid = (low + high)/2;
            int students = countStudents(arr, mid);
            if(students > k){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
            
        }
        return low;
    }
    
    public static int countStudents(int arr[], int pages){
        int n = arr.length;
        int students = 1;
        int pagecount = 0;
        
        for(int i = 0 ; i < n ; i++){
            if(pagecount + arr[i] <= pages){
                pagecount += arr[i];
            }
            else{
                students++;
                pagecount = arr[i];
            }
        }
        return students;
    }
}
