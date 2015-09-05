/*
 * BoyerMoore algorithm, only bad character skip array is implemented here.
 */
public class BM {
    
    private static final int R = 256;
    private static int[] right; // bad-character skip array
    private static String pat;
    public static void main(String[] args){
        String s = "matcjstring to match";
        String p = "match";
        solve(s, p);
    }
    
    private static void solve(String s, String p){
        pat = p;
        right = new int[R];
        for(int i = 0; i < R; i++){
            right[i] = -1;
        }
        for(int i = 0; i < pat.length(); i++){
            right[pat.charAt(i)] = i;
        }
        
        System.out.println(search(s));
    }
    
    private static int search(String s){
        int m = pat.length();
        int n = s.length();
        int skip;
        for(int i = 0; i <= n -m; i += skip){
            skip = 0;
            for(int j = m-1; j >= 0; j--){
                if(pat.charAt(j) != s.charAt(i+j)){
                    skip = Math.max(1, j - right[s.charAt(i+j)]);
                    break;
                }
                if(skip == 0){
                    return i;
                }
            }
        }
        return -1;
    }
}
