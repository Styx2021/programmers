import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        Deque<Integer> bridge = new LinkedList<>();
        int bridge_weight = 0;
        
        for(int t : truck_weights) {
            
            while(true) {
                
                if(bridge.size()==0){
                    bridge.offer(t);
                    bridge_weight += t;
                    answer++;
                    break;
                }
                else if(bridge.size()==bridge_length) {
                        bridge_weight -= bridge.poll();
                }
                else {
                    if(bridge_weight+t>weight) {
                        bridge.offer(0);
                        answer++;
                    }
                else {
                    bridge.offer(t);
                    bridge_weight += t;
                    answer++;
                    break;
                }
            }
        }        
    }
       
        return answer + bridge_length;
    }
}