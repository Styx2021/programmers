import java.util.HashMap;

class Solution {
    static final String friends = "ACFJMNRT";
    String[] list;
    
    boolean Check(char[] collocate) {
        var point = new HashMap<Character, Integer>();
        for (int i = 0; i < collocate.length; ++i) {
            point.put(collocate[i], i);
        }
        
        for(String l : list) {
            char f1 = l.charAt(0);
            char f2 = l.charAt(2);
            Integer p1 = point.get(f1);
            Integer p2 = point.get(f2);
            int interval = Math.abs(p1-p2)-1;
            int c_interval = l.charAt(4) - '0';
            switch(l.charAt(3)) {
                case '=' : if(interval == c_interval) continue; else return false;
                case '>' : if(interval > c_interval) continue; else return false;
                case '<' : if(interval < c_interval) continue; else return false;
            }
        }
        return true;
    }
    
    int dfs(int index, char[] collocate) {
        if(index==collocate.length){
            return Check(collocate) ? 1 : 0;
        }
        char friend = friends.charAt(index);
        int cnt = 0;
        for(int i=0; i<collocate.length; ++i) {
            if(collocate[i]==0) {
                collocate[i] = friend;
                cnt += dfs(index+1, collocate);
                collocate[i] = 0;
            }
        }
        return cnt;
    }
    public int solution(int n, String[] data) {
        list = data;
        return dfs(0, new char[8]);
    }
}