class Solution {

    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static boolean[][] visit;
    public static int static_m;
    public static int static_n;
    public static int[][] static_picture;
    public static int max = 0;

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        static_m = m;
        static_n = n;
        static_picture = picture;
        visit = new boolean[m][n];

        for(int i=0; i<m; i++) {

            for(int j=0; j<n; j++) {

                if(!visit[i][j] && picture[i][j]!=0) {

                    numberOfArea++;
                    dfs(i, j, picture[i][j]);
                    maxSizeOfOneArea = max > maxSizeOfOneArea ? max : maxSizeOfOneArea;
                    max = 0;

                }

            }

        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;

        return answer;
    }

    static void dfs(int x, int y, int p) {

        if(x<0 || y<0 || x>=static_m || y>=static_n 
           || static_picture[x][y]!=p || static_picture[x][y]==0 || 
           visit[x][y]==true) return;

        visit[x][y] = true;
        max++;

        for(int i=0; i<4; i++) {

            dfs(x+dx[i], y+dy[i], static_picture[x][y]);

        }

    }
}
