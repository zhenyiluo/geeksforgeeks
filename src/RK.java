import java.io.PrintWriter;

public class RK {
    public static final int MOD = 101;
    public static final int D = 256;

    public static void main(String[] args) {
        PrintWriter pw = new PrintWriter(System.out);
        solve(pw);
        pw.flush();
        pw.close();
    }

    private static void solve(PrintWriter pw) {
        String s = "Lorem ipsum dolor sit amet";
        String p = "ipsum";
        if (s.length() < p.length()) {
            pw.println(-1);
            return;
        }
        int hashCodeP = calc(p, p.length());
        int hashCodeS = calc(s, p.length());
        int n = s.length();
        int m = p.length();
        int H = 1;
        for (int i = 0; i < m - 1; i++) {
            H = (D * H) % MOD;
        }
        for (int i = 0; i <= n - m; i++) {
            if (hashCodeP == hashCodeS) {
                if (s.substring(i, i + p.length()).equals(p)) {
                    pw.println(i);
                    return;
                }
            }
            if (i < n - m) {
                hashCodeS = (D * (hashCodeS - H * s.charAt(i)) + s
                        .charAt(i + m)) % MOD;
                if (hashCodeS < 0) {
                    hashCodeS += MOD;
                }
            }
        }
        pw.println(-1);
    }

    private static int calc(String s, int len) {
        int ret = 0;
        for (int i = 0; i < len; i++) {
            ret = (ret * D + s.charAt(i)) % MOD;
        }
        return ret;
    }
}
