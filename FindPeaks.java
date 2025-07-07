import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindPeaks {
    public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter n value: ");
		int n = sc.nextInt();
		System.out.println("Enter array elements: ");
		int mountain[] = new int[n];
		for(int i = 0 ; i < n ; i++){
			mountain[i]=sc.nextInt();
		}
		System.out.print("The Peaks are : " + findPeaks(mountain));
	}
    public static List<Integer> findPeaks(int[] mountain) {
        List<Integer> peaks = new ArrayList<>();
        for(int i = 1 ; i < mountain.length - 1; i++){
            if(mountain[i] > mountain[i-1] && mountain[i] > mountain[i+1]){
                peaks.add(i);
            }
        }
        return peaks;
    }
}
