import java.util.*;
public class SortCharactersByFrequency{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String value: ");
        String s = sc.nextLine();
        System.out.println(frequencySort(s));
    }
    public static String frequencySort(String s) {
        //Create a HashMap
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch) + 1);
            }
            else{
                map.put(ch, 1);
            }
        }

        // HashMap to List
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());

        //Sort the list in decreasing order
        Collections.sort(list, (a,b) -> b.getValue() - a.getValue());

        //Build the Result and print
        StringBuilder str = new StringBuilder();

        for(Map.Entry<Character, Integer> entry : list){
            char ch = entry.getKey();
            int freq = entry.getValue();
            for(int i = 0 ; i < freq ; i++){
                str.append(ch);
            }
        } 
        return str.toString();
    }
}