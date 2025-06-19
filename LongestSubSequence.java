import java.util.*;
public class LongestSubSequence{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n value:");
        int n = sc.nextInt();
        System.out.println("Enter array elements:");
        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i]=sc.nextInt();
        }
        System.out.print("The Longest SubSequence of given array is : " + Sequence(arr, n));
    }
    //Approch 1 : Using Sort Based
    /*
    public static int Sequence(int arr[],int n){
        if(n==0) return 0;
        Arrays.sort(arr);
        int res=1;
        int cnt=1;
        for(int i = 1 ; i < n ; i++){
            if(arr[i] == arr[i-1]){
                continue;
            }
            if(arr[i] == arr[i-1]+1){
                cnt++;
            }
            else{
                cnt=1;
            }
            res=Math.max(res,cnt);
        }
        return res; 
    }
    */
    //Approch 2 : Using Set(HASHSET)
    public static int Sequence(int arr[],int n){
        if(n==0) return 0;
        int longest = 1;
        Set<Integer> set = new HashSet<>();
        for(int i = 0 ; i < n ; i++){
            set.add(arr[i]);
        }
        for(int it : set){
            if(!set.contains(it-1)){
                int cnt=1;
                int x=it;
                while(set.contains(x+1)){
                    x=x+1;
                    cnt=cnt+1;
                }
                longest=Math.max(longest,cnt);
            }
        }
        return longest;
    } 
}