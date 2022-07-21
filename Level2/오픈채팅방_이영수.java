import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        String[] answer;
        String[] recordSplit = new String[3];
        HashMap<String, String> user = new HashMap<>();
        int answerCnt = 0;

        for(int i=0; i<record.length; i++) {

            recordSplit = record[i].split(" ");

            if(recordSplit[0].equals("Enter")) {

                user.put(recordSplit[1], recordSplit[2]);
                answerCnt++;

            }else if(recordSplit[0].equals("Change")) {

                user.put(recordSplit[1], recordSplit[2]);

            }else {

                answerCnt++;

            }

        }

        answer = new String[answerCnt];
        answerCnt = 0;

        for(int i=0; i<record.length; i++) {

            recordSplit = record[i].split(" ");

            if(recordSplit[0].equals("Enter")) {

                answer[answerCnt++] = user.get(recordSplit[1])+"님이 들어왔습니다.";

            }else if(recordSplit[0].equals("Leave")) {

                answer[answerCnt++] = user.get(recordSplit[1])+"님이 나갔습니다.";

            }

        }

        return answer;
    }
}
