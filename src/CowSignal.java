import java.io.*;
import java.util.StringTokenizer;

public class CowSignal {
    static final String PROB_NAME = "cowsignal";

    public static void main(String[] args) throws IOException {
        // input with buffer
        BufferedReader br = new BufferedReader(new FileReader(PROB_NAME + ".in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(PROB_NAME + ".out")));
        StringTokenizer st = new StringTokenizer(br.readLine());


        // take in input
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        // K is the expanding multiplier

        // algorithm
        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            // for each row, we want to print it k times
            for (int internalRow = 0; internalRow < K; internalRow++) {
                // for each character, theres N characters per row, so we loop
                for (int j = 0; j < N; j++) {
                    // for each character, we print K times yet again
                    for (int print = 0; print < K; print++) {
                        pw.print(str.charAt(j));
                    }
                }
                pw.println();
            }
        }

        // output


        br.close();
        pw.close();
    }
}
