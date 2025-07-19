import java.util.Scanner;

public class SumofBeautyofAllSubStrings {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String :");
        String s = sc.nextLine();
        System.out.println("The substrings with non-zero beauty are " + beautySum(s));
    }
    //Beauty = Most frequent character - Least frequent character
    public static int beautySum(String s) {
        int n = s.length();
        int totalBeauty = 0;

        //Generate frequency for each characters
        for(int i = 0 ; i < n ; i++){
            int freq[] = new int[26];

            for(int j = i ; j < n ; j++){
                char ch = s.charAt(j);
                freq[ch - 'a']++;

                //Calculate Beauty = Max - Min
                int maxFreq = 0;
                int minFreq = Integer.MAX_VALUE;
                for(int k = 0; k <26 ; k++){
                    if(freq[k] > 0){
                        maxFreq = Math.max(maxFreq, freq[k]);
                        minFreq = Math.min(minFreq, freq[k]);
                    }
                }
                totalBeauty += (maxFreq - minFreq);
            }
        }
        return totalBeauty;
    } 
}
