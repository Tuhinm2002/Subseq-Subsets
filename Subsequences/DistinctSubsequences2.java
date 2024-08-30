class Solution {
    public int distinctSubseqII(String s) {
        String p = "";
        ArrayList<String> arr = new ArrayList<>();
        int[] dp = new int[s.length()];
        for(int n: dp){
            Arrays.fill(dp,-1);
        }
        return subseq(s,0,dp);
        // System.out.println(arr);
        // return ((arr.size()-1) % ((int)Math.pow(10,9) + 7));
    }

    public int subseq(String s,int idx,int[] dp){
        if(idx >= s.length()){
            return 0;
        }

        if(dp[idx] != -1)
        return dp[idx];

        Set<Character> set = new HashSet<>();
        int res = 0;
        for(int j = idx;j<s.length();j++){
            if(set.contains(s.charAt(j))){
                continue;
            }
            set.add(s.charAt(j));
            res = (1 + subseq(s,j+1,dp) % ((int)Math.pow(10,9)+7) + res % ((int)Math.pow(10,9)+7) ) % ((int)Math.pow(10,9)+7);
        }

        return dp[idx] = res;
    }
}
