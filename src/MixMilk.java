import java.io.*;
import java.util.*;

public class MixMilk {
    static final int N = 3;  // The number of buckets (which is 3)
    static final int TURN_NUM = 100;

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("mixmilk");

        // capacity[i] is the maximum capacity of bucket i
        int[] capacity = new int[N];
        // milk[i] is the current amount of milk in bucket i
        int[] milk = new int[N];
        for (int i = 0; i < N; i++) {
            capacity[i] = io.nextInt();
            milk[i] = io.nextInt();
        }

        long start = System.nanoTime();
        for (int i = 0; i < TURN_NUM; i++) {
            int bucket1 = i % N;
            int bucket2 = (i + 1) % N;

            /*
             * The amount of milk to pour is the minimum of the remaining milk
             * in bucket 1 and the available capacity of bucket 2
             */
            int amt =
                    Math.min(milk[bucket1], capacity[bucket2] - milk[bucket2]);

            milk[bucket1] -= amt;
            milk[bucket2] += amt;
        }
        for (int m : milk) { io.println(m); }
        long end = System.nanoTime();
        double time = (end - start) / 1000.0;

        System.out.println("Elapsed Time is :  " + time);


        io.close();
    }

    //BeginCodeSnip{Kattio}
    static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;
        // standard input
        public Kattio() { this(System.in, System.out); }
        public Kattio(InputStream i, OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }
        // USACO-style file input
        public Kattio(String problemName) throws IOException {
            super(problemName + ".out");
            r = new BufferedReader(new FileReader(problemName + ".in"));
        }
        // returns null if no more input
        public String next() {
            try {
                while (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(r.readLine());
                return st.nextToken();
            } catch (Exception e) { }
            return null;
        }
        public int nextInt() { return Integer.parseInt(next()); }
        public double nextDouble() { return Double.parseDouble(next()); }
        public long nextLong() { return Long.parseLong(next()); }
    }
    //EndCodeSnip
}