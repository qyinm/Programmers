import java.util.*;

class Solution {
    int[][] graph;
    int[] visited;
    int sw;
    int ans = 987654321;
    int[] temp;
    public int solution(int n, int[][] wires) {
        
        for (int i = 1; i <= wires.length; i++) {
            graph = new int[n+1][n+1];
            visited = new int[n+1];
            temp = new int[2];    
            sw = 0;
            for (int j = 1; j <= wires.length; j++) {
                if (i == j) {
                    continue;
                }
                graph[wires[j-1][0]][wires[j-1][1]] = 1;
                graph[wires[j-1][1]][wires[j-1][0]] = 1;
            }
            
            for (int j = 1; j <= n; j++) {
                if (visited[j] == 1) continue;
                visited[j] = 1;
                dfs(j, n);
                sw++;
            }
            ans = Math.min(Math.abs(temp[0] - temp[1]), ans);
        }
        
        int answer = ans;
        return answer;
    }
    
    public void dfs(int idx, int n) {
        temp[sw] += 1;
        for (int i = 1; i <= n; i++) {
            if (graph[idx][i] == 0) continue;
            if (visited[i] == 1)    continue;
            visited[i] = 1;
            dfs(i, n);
        }
        
        return;
    }
}