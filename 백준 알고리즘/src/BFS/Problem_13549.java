package BFS;

import java.io.*;
import java.util.StringTokenizer;

public class Problem_13549 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[k + 1];

        for (int i = 0; i <= k; i++) {
            if (i <= n) {
                arr[i] = n - i;
            } else {
                if (i % 2 == 0) {
                    arr[i] = Math.min(arr[i / 2], arr[i - 1] + 1);
                } else {
                    arr[i] = Math.min(arr[(i + 1) / 2] + 1, arr[i - 1] + 1);
                }
            }
        }

        bw.write(arr[k] + "\n");
        br.close();
        bw.close();
    }
}
