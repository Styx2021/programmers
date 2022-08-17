import java.util.*;

class Solution {
    
    static HashMap<String, Integer> map = new HashMap<>();
    
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        
        for(int i=0; i<orders.length; i++) {
            String[] order_split = orders[i].split("");
            Arrays.sort(order_split);
            
            for(int j=0; j<order_split.length-1; j++) {
                
                for(int k=0; k<course.length; k++) {
                    dfs(order_split, j, 1, course[k], order_split[j]); 
                }    
                
            }
            
        }
        
        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list, new Comparator<String>() {
            
            public int compare(String o1, String o2) {
                return map.get(o2) - map.get(o1);
            }
        });
        
        List<String> result = new ArrayList<>();
        for(int i=0; i<course.length; i++) {
            int max = 0;
            
            for(String courseMenu : list) {
                if(map.get(courseMenu) > 1 && courseMenu.length() == course[i]) {
                    if(map.get(courseMenu) >= max) {
                        result.add(courseMenu);
                        max = map.get(courseMenu);
                    }
                }
                
            }    
            
        }
        
        Collections.sort(result);
        
        answer = new String[result.size()];
        result.toArray(answer);
        
        return answer;
    }
    
    static void dfs(String[] orders_split, int idx, int depth, int courseLen, String menu) {
        if(depth == courseLen) {
            map.put(menu, map.getOrDefault(menu, 0)+1);
        }
        
        for(int i = idx+1; i<orders_split.length; i++) {
            dfs(orders_split, i, depth+1, courseLen, menu+orders_split[i]);
        }
        
        
    }
}