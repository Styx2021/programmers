import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        Stack<String> stack = new Stack<>();
        String[] arr;
        boolean flag = false;
        
        for(int i=0; i<s.length(); ++i) {
            arr = s.split("");
            for(int c=0; c<i; ++c) {
                String first = arr[0];
                for(int j=0; j<arr.length-1; ++j) {
                    arr[j] = arr[j+1];
                }
                arr[arr.length-1] = first;
            }
            // System.out.println(Arrays.toString(arr));
            for(int k=0; k<arr.length; ++k) {
                switch(arr[k]) {
                    case "[": stack.push("["); continue;
                    case "(": stack.push("("); continue;
                    case "{": stack.push("{"); continue;
                    case "]": if(stack.empty()) {
                        flag = true;
                        break;
                    }else {
                        if(stack.contains("[")){
                            stack.pop();
                            continue;
                        } else {
                            flag = true;
                            break;
                        }
                    }
                    case ")": if(stack.empty()) {
                        flag = true;
                        break;
                    }else {
                        if(stack.contains("(")){
                            stack.pop();
                            continue;
                        } else {
                            flag = true;
                            break;
                        }
                    }
                    case "}": if(stack.empty()) {
                        flag = true;
                        break;
                    }else {
                        if(stack.contains("{")){
                            stack.pop();
                            continue;
                        } else {
                            flag = true;
                            break;
                        }
                    }
                    default: break;
                }
            }
            
            if(stack.empty() && flag == false){
                answer++;
            } else {
                flag = false;
                stack.clear();
            }
        }
        return answer;
    }
}