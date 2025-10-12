/* Given N cards arranged in a row, each card has an associated score denoted by the cardScore array.
Choose exactly k cards. In each step, a card can be chosen either from the beginning or the end of the row. 
The score is the sum of the scores of the chosen cards.
*/

import java.util.*;
public class MaximumPointsObtainFromCards {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n value : ");
        int n = sc.nextInt();
        System.out.println("Enter array elements : ");
        int cardPoints[] = new int[n];
        for(int i = 0; i < n; i++){
            cardPoints[i] = sc.nextInt();
        }
        System.out.println("Enter k value : ");
        int k = sc.nextInt();
        int result = maxScore(cardPoints, k);
        System.out.println("The Maximum Points that can be obtained from cards are  : " + result);
    }
    //  Brute Force 
    /*
    public static int maxScore(int[] cardPoints, int k) {
        int maxSum = 0;
        int n = cardPoints.length;
        for(int i = 0; i <= k; i++){
            int tempSum = 0;
            //  Add From Front
            for(int j = 0; j < i; j++){
                tempSum += cardPoints[j];
            }
            //  Add From Back
            for(int j = 0; j < k - i; j++){
                tempSum += cardPoints[n - 1 - j];
            }
            maxSum = Math.max(maxSum, tempSum);
        }
        return maxSum;
    }
    */
    
    //Optimal Approach
    public static int maxScore(int[] cardPoints, int k){
        int n = cardPoints.length;
        int total = 0;
        //  Add upto first k cards
        for(int i = 0; i < k; i++){
            total += cardPoints[i];
        }

        int maxPoints = total;
        for(int i = 0; i < k; i++){
            //  Remove from front
            total -= cardPoints[k - 1 - i];
            //  Add from back
            total += cardPoints[n - 1 - i];
            //  Return maxSum
            maxPoints = Math.max(maxPoints, total);
        }
        return maxPoints;
    }
}
