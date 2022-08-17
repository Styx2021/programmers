import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Deque<int[]> que = new LinkedList<>();
        
        boolean flag = false;
        
        for(int i=0; i<priorities.length; ++i) {
            que.offer(new int[]{priorities[i], i});    
        }
        
        int[] list = new int[priorities.length];
        int cnt = 0;
        
        while(!que.isEmpty()) {
            int[] peek = que.peek();
            
            for(int[] pri : que) {
                if(pri[0] > peek[0])
                    flag = true;
            }
            
            if(flag) {
                int[] temp = que.poll();
                que.offer(temp);
                flag = false;
            } else {
                list[cnt++] = que.poll()[1];
            }
        }
        
        for(int i=0; i<priorities.length; ++i) {
            if(list[i] == location) answer = i+1;
        }
        
        return answer;
    }
}