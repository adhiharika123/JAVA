/*
 * Problem Statement: There is only one row of fruit trees on the farm, oriented left to right. An integer array called fruits represents the trees, where fruits[i] denotes the kind of fruit produced by the ith tree.
The goal is to gather as much fruit as possible, adhering to the owner's stringent rules :

There are two baskets available, and each basket can only contain one kind of fruit. The quantity of fruit each basket can contain is unlimited.
Start at any tree, but as you proceed to the right, select exactly one fruit from each tree, including the starting tree. One of the baskets must hold the harvested fruits.
Once reaching a tree with fruit that cannot fit into any basket, stop.
Return the maximum number of fruits that can be picked.
*/

import java.util.*;
public class FruitsintoBasket{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n value : ");
        int n = sc.nextInt();
        System.out.println("Enter array elements : ");
        int fruits[] = new int[n];
        for(int i = 0; i < n; i++){
            fruits[i] = sc.nextInt();
        }
        int result = totalFruit(fruits);
        System.out.println("The maximum fruits it can be fit in given baskets are : " + result);
    }

    //  Brute Force 
    /*
    public static int totalFruit(int[] fruits) {
        int maxFruits = 0;
        for(int start = 0; start < fruits.length; start++){
            Map<Integer, Integer> basket = new HashMap<>();
            int currentCount = 0;
            for(int end = start; end < fruits.length; end++){
                //  Add to the basket
                basket.put(fruits[end], basket.getOrDefault(fruits[end], 0) + 1);
                // If basket size exceeded -> break
                if(basket.size() > 2){
                    break;
                }
                currentCount++;
            }
            maxFruits = Math.max(maxFruits, currentCount); 
        }
        return maxFruits;
    }
    */

    //  Optimal Approch
    public static int totalFruit(int[] fruits){
        int maxFruits = 0;
        int left = 0;
        Map<Integer, Integer> basket = new HashMap<>();
        for(int right = 0; right < fruits.length; right++){
            basket.put(fruits[right], basket.getOrDefault(fruits[right], 0) + 1);
            while(basket.size() > 2){
                basket.put(fruits[left], basket.get(fruits[left]) - 1);
                if(basket.get(fruits[left]) == 0)
                {
                    basket.remove(fruits[left]);
                }
                left++;
            }
            maxFruits = Math.max(maxFruits, right - left + 1);
        }
        return maxFruits;
    }
}