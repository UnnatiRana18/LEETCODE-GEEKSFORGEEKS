class Solution {
    static final int MOD = 1_000_000_007;

    public int[] sumAndMultiply(String s, int[][] queries) {

        int n = s.length();

        // Store non-zero digits and their original positions
        ArrayList<Integer> digits = new ArrayList<>();
        ArrayList<Integer> pos = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int d = s.charAt(i) - '0';
            if (d != 0) {
                digits.add(d);
                pos.add(i);
            }
        }

        int m = digits.size();

        // prefix sum of digits
        long[] prefixSum = new long[m + 1];

        // prefix number
        long[] prefixNum = new long[m + 1];

        // powers of 10
        long[] pow10 = new long[m + 1];
        pow10[0] = 1;

        for (int i = 0; i < m; i++) {
            prefixSum[i + 1] = prefixSum[i] + digits.get(i);
            prefixNum[i + 1] = (prefixNum[i] * 10 + digits.get(i)) % MOD;
            pow10[i + 1] = (pow10[i] * 10) % MOD;
        }

        int[] ans = new int[queries.length];

        for (int q = 0; q < queries.length; q++) {

            int l = queries[q][0];
            int r = queries[q][1];

            int left = lowerBound(pos, l);
            int right = upperBound(pos, r) - 1;

            // No non-zero digits
            if (left > right) {
                ans[q] = 0;
                continue;
            }

            int len = right - left + 1;

            long sum = prefixSum[right + 1] - prefixSum[left];

            long x = (prefixNum[right + 1]
                    - (prefixNum[left] * pow10[len]) % MOD
                    + MOD) % MOD;

            ans[q] = (int) ((x * (sum % MOD)) % MOD);
        }

        return ans;
    }

    // First index >= target
    private int lowerBound(ArrayList<Integer> arr, int target) {
        int l = 0, r = arr.size();
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr.get(mid) < target)
                l = mid + 1;
            else
                r = mid;
        }
        return l;
    }

    // First index > target
    private int upperBound(ArrayList<Integer> arr, int target) {
        int l = 0, r = arr.size();
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr.get(mid) <= target)
                l = mid + 1;
            else
                r = mid;
        }
        return l;
    }
}