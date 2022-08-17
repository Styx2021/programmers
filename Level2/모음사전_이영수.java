class Solution {
    
    public String[] split;
    public int cnt = 0;
    public int answer = 0;
    
    public int solution(String word) {
        split = "AEIOU".split("");
        dfs("", word);
        
        return answer;
    }
    
    public void dfs(String str, String word) {
        if(str.length()==5||str.equals(word)) {
            if(str.equals(word)) answer = cnt;
            return;
        }
        
        for(int i=0; i<5; ++i) {
            cnt++;
            dfs(str+split[i],word);
        }
    }
}