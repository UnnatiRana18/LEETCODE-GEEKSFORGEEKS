class Solution {

    public String minWindow(String s, String t) {

        if (s.length() < t.length()) {
            return "";
        }

        int[] freq = new int[128];

        // Store frequency of characters in t
        for (char c : t.toCharArray()) {
            freq[c]++;
        }

        int left = 0;
        int count = 0;

        int minLength = Integer.MAX_VALUE;
        int start = 0;

        for (int right = 0; right < s.length(); right++) {

            char c = s.charAt(right);

            // Character is needed
            if (freq[c] > 0) {
                count++;
            }

            freq[c]--;

            // Window contains all characters of t
            while (count == t.length()) {

                // Update answer
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    start = left;
                }

                char leftChar = s.charAt(left);

                freq[leftChar]++;

                // We removed a required character
                if (freq[leftChar] > 0) {
                    count--;
                }

                left++;
            }
        }

        if (minLength == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(start, start + minLength);
    }
}