package Graphs;
import java.util.*;

class WordLadder {
    
    static boolean isOneCharDiff(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) count++;
            if (count > 1) return false;
        }
        return count == 1;
    }

    static int wordLadderLength(String start, String target, Set<String> dict) {
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        Map<String, Integer> level = new HashMap<>();
        level.put(start, 1);

        while (!queue.isEmpty()) {
            String word = queue.poll();
            int currLevel = level.get(word);

            if (word.equals(target)) return currLevel;

            List<String> toRemove = new ArrayList<>();
            for (String next : dict) {
                if (isOneCharDiff(word, next)) {
                    queue.add(next);
                    level.put(next, currLevel + 1);
                    toRemove.add(next); // mark visited
                }
            }
            dict.removeAll(toRemove); // avoid revisiting
        }
        return 0; // target not reachable
    }

    public static void main(String[] args) {
        Set<String> dict = new HashSet<>(Arrays.asList("POON", "PLEE", "SAME", "POIE", "PLEA", "PLIE", "POIN"));
        String start = "TOON";
        String target = "PLEA";

        int length = wordLadderLength(start, target, dict);
        if (length == 0) System.out.println("No transformation possible.");
        else System.out.println("Length of shortest chain: " + length);
    }
}
