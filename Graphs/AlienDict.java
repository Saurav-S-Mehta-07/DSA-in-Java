package Graphs;
import java.util.*;

public class AlienDict {
    
    public static String findOrder(String[] dict, int N, int K) {
        // Step 1: Build graph
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < K; i++)
            adj.add(new ArrayList<>());
        
        for (int i = 0; i < N - 1; i++) {
            String s1 = dict[i];
            String s2 = dict[i + 1];
            int len = Math.min(s1.length(), s2.length());
            for (int j = 0; j < len; j++) {
                if (s1.charAt(j) != s2.charAt(j)) {
                    adj.get(s1.charAt(j) - 'a').add(s2.charAt(j) - 'a');
                    break;
                }
            }
        }

        // Step 2: Topological Sort (Kahn’s Algorithm)
        int[] indegree = new int[K];
        for (int i = 0; i < K; i++) {
            for (int it : adj.get(i))
                indegree[it]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < K; i++)
            if (indegree[i] == 0)
                q.add(i);

        StringBuilder order = new StringBuilder();
        while (!q.isEmpty()) {
            int node = q.poll();
            order.append((char) (node + 'a'));
            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0)
                    q.add(it);
            }
        }

        return order.toString();
    }

    // Driver for testing
    public static void main(String[] args) {
        String[] dict1 = {"caa", "aaa", "aab"};
        System.out.println(findOrder(dict1, 3, 3));  // Possible output: cab

        String[] dict2 = {"baa", "abcd", "abca", "cab", "cad"};
        System.out.println(findOrder(dict2, 5, 4));  // Possible output: bdac
    }
}
