package Java.GreedyAlgo;
public class lexicograhical {
    public static String getSmallestString(int N, int K) {
        // start with all 'a'
        char[] res = new char[N];
        for (int i = 0; i < N; i++) {
            res[i] = 'a';
        }

        int remaining = K - N; // since each 'a' = 1
        int i = N - 1;

        while (remaining > 0 && i >= 0) {
            int add = Math.min(25, remaining); // at most we can add 25 (to reach 'z')
            res[i] = (char) (res[i] + add);
            remaining -= add;
            i--;
        }

        return new String(res);
    }

    public static void main(String[] args) {
        int N = 5, K = 42;
        System.out.println(getSmallestString(N, K)); // Output: aaamz
    }
}

