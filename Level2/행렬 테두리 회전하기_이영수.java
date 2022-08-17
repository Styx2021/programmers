class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] map = new int[rows+1][columns+1];
        int n = 1;
        
        for(int i=1; i<=rows; ++i) {
            for(int j=1; j<=columns; ++j) {
                map[i][j] = n++;
            }
        }

        for(int i=0; i<queries.length; ++i) {
            
            int x1 = queries[i][0];
            int y1 = queries[i][1];
            int x2 = queries[i][2];
            int y2 = queries[i][3];
            
            int first = map[x1][y1];
            int min = first;
            
            for(int j=x1; j<x2; ++j) {
                map[j][y1] = map[j+1][y1];
                min = min < map[j][y1] ? min : map[j][y1];
            }
            
            for(int j=y1; j<y2; ++j) {
                map[x2][j] = map[x2][j+1];
                min = min < map[x2][j] ? min : map[x2][j];
            }
            
            for(int j=x2; j>x1; --j) {
                map[j][y2] = map[j-1][y2];
                min = min < map[j][y2] ? min : map[j][y2];
            }
            
            for(int j=y2; j>y1; --j) {
                map[x1][j] = map[x1][j-1];
                min = min < map[x1][j] ? min : map[x1][j];
            }
            
            map[x1][y1+1] = first;
            answer[i] = min;
        }
        
        return answer;
    }
}