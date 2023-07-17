import java.util.stream.*;
import java.util.*;
class Solution {
    int[] chess;
    int answer = 0;
    int m;
    public int solution(int n) {
        chess = new int[n];
        m = n;
        nqueen(0);
        
        return answer;
    }
    
    public boolean validation(int idx, int val) {
        for (int i = 0; i < idx; i++) {
            int dis = idx - i;
            if (chess[i] + dis * -1 == val || chess[i] + dis == val || chess[i] == val) {
                return false;
            }
        }
        return true;
    }
    
    public void nqueen(int idx) {

        if (idx == m) {
            answer += 1;
            return;
        }
        for (int i = 0; i < m; i++) {
            if (validation(idx, i)) {
                chess[idx] = i;
                nqueen(idx + 1);
            }
        }
    }
}