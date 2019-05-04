package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TaskScheduler {
    /*
    Input: tasks = ["A","A","A","B","B","B"], n = 2
Output: 8
Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
    * */
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Wrapper> q = new PriorityQueue((o1, o2) -> {
            return ((Wrapper)o1).data - ((Wrapper)o2).data;
        });
        Map<Character, Integer> freqMap = new HashMap<>();
        for(char c : tasks){
            if(freqMap.get(c) != null){
                freqMap.put(c, freqMap.get(c)+1);
            }else{
                freqMap.put(c, 1);
            }
        }
        freqMap.entrySet().stream().forEach(entry-> q.offer(new Wrapper(entry.getKey(),entry.getValue())));
        int count = 0;
        while(!q.isEmpty()){
            int i=0;
            List<Wrapper> temp = new ArrayList<>();
            while (i++ < n+1){
                if(!q.isEmpty()) {
                    Wrapper poll = q.poll();
                    poll.freq--;
                    System.out.print(poll.data+",");
                    if (poll.freq > 0) {
                        temp.add(poll);
                    }
                } else if(temp.size() == 0){
                    break;
                }else{
                    System.out.print("IDLE,");
                }
                count++;
            }
            if(temp.size() > 0){
                temp.stream().forEach(item -> q.offer(item));
            }
        }
        return count;
    }

    public static void main(String[] args) {

        char []input = {'A','A','A','B','B','B','C','C','D'};
        int n =3;
        System.out.println(new TaskScheduler().leastInterval(input, n));
    }
    class Wrapper {
        public char data;
        public int freq;

        public Wrapper(char c, int f) {
            data = c;
            freq = f;
        }
    }
}
