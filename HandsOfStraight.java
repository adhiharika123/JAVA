/* Alice has some number of cards and she wants to rearrange the cards 
into groups so that each group is of size groupSize, and consists of 
groupSize consecutive cards.

Given an integer array hand where hand[i] is the value written on the 
ith card and an integer groupSize, return true if she can rearrange 
the cards, or false otherwise. */

import java.util.*;
public class HandsOfStraight{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n value : ");
        int n = sc.nextInt();
        System.out.println("Enter array elemnts : ");
        int hand[] = new int[n];
        for(int i = 0; i < n; i++){
            hand[i] = sc.nextInt();
        }
        System.out.println("Enter group size : ");
        int groupSize = sc.nextInt();
        boolean result = isNStraightHand(hand, groupSize);
        System.out.println(result);
    }
    public static boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) return false;
        TreeMap<Integer, Integer> freq = new TreeMap<>();
        for(int card : hand){
            freq.put(card, freq.getOrDefault(card, 0) + 1);
        }
        while(!freq.isEmpty()){
            int start = freq.firstKey();
            int count = freq.get(start);
            for(int i = 0; i < groupSize; i++){
                int card = start + i;
                if(!freq.containsKey(card) || freq.get(card) < count) return false;
                
                if(freq.get(card) == count) freq.remove(card);
                else freq.put(card, freq.get(card) - count);
            }
        }
        return true;
    }
}