class Solution {
    public boolean isMatch(String s, String p) { 
        int m = s.length(), n = p.length();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (p.charAt(i) == '*') count++;
        }
        if (count==0 && m != n) return false;
        else if (n - count > m) return false;
        
        while(p.contains("**")) p = p.replace("**","*");
        
        HashMap<String, HashMap<String,Boolean>> cache = new HashMap<>();        
        return isMatchHelper(s,p, cache);
        
    }
    
    public boolean isMatchHelper(String s, String p, HashMap<String, HashMap<String,Boolean>> cache){
        if(cache.containsKey(s)){
            HashMap<String, Boolean> incache = cache.get(s);
            if(incache.containsKey(p)) return incache.get(p);
        }
        if(s.length()==0){
            p = p.replace("*","");
        }
        if(s.length()==0 && p.length()==0) return true;
        if(s.length()==0 || p.length()==0) return false;
        if(s.charAt(0)!=p.charAt(0) && (p.charAt(0)!= '?' && p.charAt(0)!='*')) return false;
        
        boolean isMatch = false;
            if(p.charAt(0)==s.charAt(0) || p.charAt(0)=='?'){
                isMatch = isMatch || isMatchHelper(s.substring(0+1),p.substring(0+1),cache);
            }
            if(p.charAt(0)=='*'){
                isMatch = isMatch || isMatchHelper(s,"" + p.substring(0+1), cache);
            }        
            if(p.charAt(0)=='*'){
                isMatch = isMatch || isMatchHelper(s.substring(0+1),"*" + p.substring(0+1), cache);
            }
        
        if(cache.containsKey(s)){
            HashMap<String, Boolean> incache = cache.get(s);
            incache.put(p,isMatch);
        }else{
            HashMap<String, Boolean> incache = new HashMap<>();
            incache.put(p,isMatch);
            cache.put(s,incache);
        }
        
        return isMatch;        
    }
}

*****************************************************************************

class Solution {
	
	public boolean isMatch (String s, String p) {
		
		boolean[][] dp = new boolean[s.length () + 1][p.length () + 1];
		dp[0][0] = true;
		
		for (int i = 0; i < p.length () && p.charAt (i++) == '*';) {
			dp[0][i] = true;
		}
		
		for (int i = 1; i <= s.length (); i++) {
			for (int j = 1; j <= p.length (); j++) {
				if (s.charAt (i - 1) == p.charAt (j - 1) || p.charAt (j - 1) == '?') {
					dp[i][j] = dp[i - 1][j - 1];
				}
				else if (p.charAt (j - 1) == '*') {
					dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
				}
			}
		}
		
		return dp[s.length ()][p.length ()];
	}
}


************************************************************************************
class Solution {
    public boolean isMatch(String s, String p) {
        int ls = s.length();
        int lp = p.length();
        boolean[][] d = new boolean[ls + 1][lp + 1];
        int pIdx;
        int sIdx;
        
        for(int i = 0; i <= ls; i++){
            for(int j = 0; j <= lp; j++){
                sIdx = i - 1;
                pIdx = j - 1;
                if( i == 0 && j == 0){
                    d[i][j] = true;
                } else if( i == 0){
                    d[i][j] = (p.charAt(pIdx) == '*') && d[i][j - 1];
                } else if( j == 0){
                    d[i][j] = false;
                } else if(p.charAt(pIdx) == '*'){
                        d[i][j] = d[i][j - 1] | d[i - 1][j];
                } else if(p.charAt(pIdx) == '?' || s.charAt(sIdx) == p.charAt(pIdx)){
                        d[i][j] = d[i - 1][j - 1];
                }
            }
        }
        
        return d[ls][lp];
    }
}
