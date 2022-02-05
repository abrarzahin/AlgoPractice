class Solution {
    /*
    */
    // DP
     public static List<String> findAllConcatenatedWordsInADict(String[] 
words) {
         
        List<String> result = new ArrayList<>();
        Set<String> preWords = new HashSet<>();
         // //sort the array in asc order of word length, since longer 
words are formed by shorter words
        Arrays.sort(words, (a,b) -> a.length() - b.length());
        
         
        for (int i = 0; i < words.length; i++) {
            if (canForm(words[i], preWords)) {
                result.add(words[i]);
            }
            preWords.add(words[i]);
        }
        
        return result;
    }
	
    private static boolean canForm(String word, Set<String> dict) {
        if (dict.isEmpty()) return false;
	boolean[] dp = new boolean[word.length() + 1];
	dp[0] = true;
	for (int i = 1; i <= word.length(); i++) {
	    for (int j = 0; j < i; j++) {
		if (!dp[j]) continue;
		if (dict.contains(word.substring(j, i))) {
		    dp[i] = true;
		    break;
		}
	    }
	}
	return dp[word.length()];
    }
}
