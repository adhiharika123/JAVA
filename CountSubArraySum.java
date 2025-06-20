import java.util.*;
public class CountSubArraySum{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter n value: ");
		int n = sc.nextInt();
		System.out.println("Enter k value : ");
		int k = sc.nextInt();
		System.out.println("Enter array elements: ");
		int arr[] = new int[n];
		for(int i = 0 ; i < n ; i++){
			arr[i]=sc.nextInt();
		}
		System.out.print("The Count of SubArray Sum is : " + Count(arr, n, k));
	}
	public static int Count(int arr[], int n, int k ){
		int count=0;
		for(int i = 0 ; i < n ; i++){
			int sum = 0;
			for(int j = i ; j < n ; j++){
				sum += arr[j];
				if(sum == k){
					count++;
				}	
			}
		}
		return count;
	}

}
