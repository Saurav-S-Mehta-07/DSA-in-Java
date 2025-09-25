package Java.GreedyAlgo;

import java.util.*;

public class ActivitySelection{

    static class Activity {
        int st, ed;
        Activity(int st, int ed) {
            this.st = st;
            this.ed = ed;
        }
    }

    public static void maxAct(int[] start, int[] end) {
        int n = start.length;

        // Step 1: Store activities with start & end
        List<Activity> activities = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            activities.add(new Activity(start[i], end[i]));
        }

        // Step 2: Sort activities by end time
        activities.sort(Comparator.comparingInt(a -> a.ed));

        // Step 3: Greedy selection
        int count = 1;
        int lastEnd = activities.get(0).ed;

        for (int i = 1; i < n; i++) {
            if (activities.get(i).st >= lastEnd) {
                count++;
                lastEnd = activities.get(i).ed;
            }
        }

        System.out.println("Maximum activities: " + count);
    }

    public static void main(String[] args) {
        int start[] = {1, 3, 0, 5, 8, 5};
        int end[]   = {2, 4, 6, 7, 9, 9};

        maxAct(start, end);
    }
}
