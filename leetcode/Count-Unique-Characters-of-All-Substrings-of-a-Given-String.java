 public int uniqueLetterString(String S) {
     // dp approach, O(N) - one pass, O(1) fixed dp array size
        int res = 0;
        if (S == null || S.length() == 0)
            return res;
        // dp arrays to store last postion and
        // contribution count using asscii value
        int[] showLastPosition = new int[128];
        int[] contribution = new int[128];
        int cur = 0;
        for (int i = 0; i < S.length(); i++) {
            char x = S.charAt(i);
            cur -= contribution[x]; // removing contribution of last 
occurence of ith char
            contribution[x] = (i - (showLastPosition[x] - 1)); // reset 
the contribution of ith char
            cur += contribution[x]; // add the contribution of ith char
            showLastPosition[x] = i + 1; // update the last occurence of 
ith char
            res += cur;
        }
        return res;
    }
