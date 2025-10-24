import java.util.*;

public class finishTasks {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++)
            adj.add(new ArrayList<>());
        
        int[] indegree = new int[numCourses];
        for (int[] pre : prerequisites) {
            adj.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0)
                q.add(i);
        }
        
        int count = 0;
        while (!q.isEmpty()) {
            int curr = q.poll();
            count++;
            for (int next : adj.get(curr)) {
                indegree[next]--;
                if (indegree[next] == 0)
                    q.add(next);
            }
        }
        
        return count == numCourses;
    }

    public static void main(String[] args) {
        int[][] prereq1 = {{1, 0}, {0, 1}};
        System.out.println(canFinish(2, prereq1)); // false

        int[][] prereq2 = {{1, 0}};
        System.out.println(canFinish(2, prereq2)); // true
    }
}
