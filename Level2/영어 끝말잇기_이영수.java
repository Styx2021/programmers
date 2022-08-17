import java.util.HashMap;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        
        HashMap<String, Integer> map = new HashMap<>();
        char lastWord = words[0].charAt(words[0].length()-1);
        
        map.put(words[0], 1);
        
        for(int i=1; i<words.length; ++i) {
            
            map.put(words[i], map.getOrDefault(words[i],0)+1);
            
            if(lastWord!=words[i].charAt(0) || map.get(words[i])>1) {
                answer[0] = (i%n)+1;
                answer[1] = (i/n)+1;
                break;
            } else {
                lastWord = words[i].charAt(words[i].length()-1);
            }
            
        }

        return answer;
    }
}