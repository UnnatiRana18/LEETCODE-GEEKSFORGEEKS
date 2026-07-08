class Solution {
    static final int MOD = 1000000007;

    public int[] sumAndMultiply(String s, int[][] queries) {

        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> digit = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '0') {
                pos.add(i);
                digit.add(s.charAt(i) - '0');
            }
        }

        int m = digit.size();

        long[] sum = new long[m + 1];
        long[] num = new long[m + 1];
        long[] pow = new long[m + 1];
        pow[0] = 1;

        for (int i = 0; i < m; i++) {
            sum[i + 1] = sum[i] + digit.get(i);
            num[i + 1] = (num[i] * 10 + digit.get(i)) % MOD;
            pow[i + 1] = (pow[i] * 10) % MOD;
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int l = Collections.binarySearch(pos, queries[i][0]);
            if (l < 0) l = -l - 1;

            int r = Collections.binarySearch(pos, queries[i][1]);
            if (r < 0) r = -r - 2;

            if (l > r) continue;

            long x = (num[r + 1] - num[l] * pow[r - l + 1] % MOD + MOD) % MOD;
            long s1 = sum[r + 1] - sum[l];

            ans[i] = (int) (x * s1 % MOD);
        }

        return ans;
    }
}