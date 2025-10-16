/*
 * 
 */

import java.util.*;
public class TaskScheduler{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n value : ");
        int n = sc.nextInt();
        System.out.println("Enter character elemnts : ");
        char tasks[] = new char[n];
        for(int i = 0; i < n; i++){
            tasks[i] = sc.next().charAt(0);
        }
        System.out.println("Enter n intervals : ");
        int intervals = sc.nextInt();
        int result = leastInterval(tasks,intervals);
        System.out.println("The minimum number of CPU intervals required to complete all tasks " + result);
    }
    public static int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> freq = new HashMap<>();
        //  Count frequencies of each Character
        for(char task : tasks){
            freq.put(task, freq.getOrDefault(task,0) + 1);
        }
        // Create a Max Heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int count : freq.values()){
            maxHeap.add(count);
        }
        int time = 0;

        while(!maxHeap.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int cycle = n + 1;
            int i = 0;
            while(i < cycle && !maxHeap.isEmpty()){
                int count = maxHeap.poll();
                count--;

                if(count > 0){
                    temp.add(count);
                }
                time++;
                i++;
            }

            //  Push remaining th heap
            for(int rem : temp){
                maxHeap.add(rem);
            }
            //  If heap is not empty, add idle time
            if(!maxHeap.isEmpty()){
                time += (cycle - i);
            }
        }
        return time;
    }
} 