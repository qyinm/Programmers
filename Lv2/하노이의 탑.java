import java.util.*;
import java.util.stream.*;

class Solution {
    List<List<Integer>> temp;
    
    public int[][] solution(int n) throws Exception {
        int[][] answer = new int[(int)Math.pow(2, n) - 1][2];
        temp = new ArrayList<List<Integer>>();
        hanoi(n, 1, 3, 2);
        
        int idx = 0;
        for (List<Integer> t: temp) {
            answer[idx][0] = t.get(0);
            answer[idx][1] = t.get(1);
            idx++;
        }
        return answer;
    }
    
    public void hanoi(int n, int start, int end, int via) throws Exception {
        if (n == 1) {
            temp.add(List.of(start, end));
            return ;
        }
        
        hanoi(n-1, start, via, end);
        temp.add(List.of(start, end));
        hanoi(n-1, via, end, start);
    }
}