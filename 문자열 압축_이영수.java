class Solution {
    public int solution(String s) {
        int answer = 0;
        int[] compression = new int[s.length()];

        for(int i=1; i<=s.length()/2; i++) {

            String pattern = s.substring(0, i);
            int p_cnt = 1;

            String result = "";

            for(int j=i; j<=s.length(); j+=i) {

                String next = s.substring(j, (j+i > s.length() ? s.length() : j + i));

                if(pattern.equals(next)) {

                    p_cnt++;

                }else {

                    if(p_cnt!=1) {

                        result = result.concat(p_cnt+pattern);

                    }else {

                        result = result.concat(pattern);

                    }
                    pattern = next;
                    p_cnt = 1;

                }

            }
            result = result.concat(pattern);
            compression[i] = result.length();

        }

        int min = s.length();

        for(int leng : compression) {
            min = (leng < min) && leng !=0 ? leng : min;
        }

        answer = min;

        return answer;
    }
}