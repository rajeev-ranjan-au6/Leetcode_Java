/**
 * Implement regular expression matching with support for '.' and '*'.
 *
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 *
 * The matching should cover the entire input string (not partial).
 *
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 *
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "a*") → true
 * isMatch("aa", ".*") → true
 * isMatch("ab", ".*") → true
 * isMatch("aab", "c*a*b") → true
 *
 */


class Solution {
    public boolean isMatch(String s, String p) {
        HashMap<String, HashMap<String, Boolean>> cache = new HashMap<>();
        return isMatchHelper(s,p,cache);
        
    }
    
    public boolean isMatchHelper(String s, String p, HashMap<String, HashMap<String, Boolean>> cache){
        if(cache.containsKey(s)){
            if(cache.get(s).containsKey(p)){
                return cache.get(s).get(p);
            }
        }
        if(s.length()==0 && p.length()==0) return true;
        if(s.length()==0 || p.length()==0){
            if(p.length()==0 || (p.length() != 0 && !p.contains("*"))) return false;
            
        }
        
        boolean foundMatch = false;
        if(s.length()==0){
            if(p.length()>1 && p.charAt(1)=='*') foundMatch = foundMatch || isMatchHelper(s,p.substring(2), cache);
        }
        else{
                if(s.charAt(0)==p.charAt(0) || p.charAt(0)=='.'){
                    foundMatch = foundMatch || isMatchHelper(s.substring(1), p.substring(1), cache);
                }

                if(p.length() > 1 && p.charAt(1)=='*'){
                    if(s.charAt(0)==p.charAt(0) || p.charAt(0)=='.'){
                        if(p.length()>1) {
                            foundMatch = foundMatch || isMatchHelper(s.substring(1), p.substring(2), cache);
                            foundMatch = foundMatch || isMatchHelper(s, p.substring(2), cache);
                        }
                        foundMatch = foundMatch || isMatchHelper(s.substring(1), p.substring(1), cache);
                        foundMatch = foundMatch || isMatchHelper(s.substring(1), p, cache);                 

                    }else{
                        if(p.length()>1) foundMatch = foundMatch || isMatchHelper(s, p.substring(2), cache);
                    }
                }            
        }
        
        if(cache.containsKey(s)){
            HashMap<String, Boolean> incache = cache.get(s);
            incache.put(p,foundMatch);
        }else{
            HashMap<String, Boolean> incache = new HashMap<>();
            incache.put(p,foundMatch);
            cache.put(s,incache);
        }
        return foundMatch;
    }
}

***************************************************************************************************

class Solution {
    int n, m;
    int[][] memo;
    public boolean isMatch(String s, String p) {
        if(s.equals(p)) return true;
        n = s.length();
        m = p.length();
        memo = new int[n + 1][m + 1];
        return match(0, 0, s, p);
    }
    
    public boolean match(int i, int j, String s, String p) {
        if(j == m) return i == n;
        if(i < n && j < m && memo[i][j] != 0) return memo[i][j] == 1;

        boolean ans;
        boolean firstMatch = (i < n && s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
        if(j < m - 1 && p.charAt(j + 1) == '*') ans =  match(i, j + 2, s, p) || (firstMatch && i < n && match(i + 1, j, s, p));
        else ans =  firstMatch && match(i + 1, j + 1, s, p);
        if(i < n && j < m)
            memo[i][j] = ans?1:-1;
        return ans;
    }
}

******************************************************************************************

class Solution {
    public boolean isMatch(String s, String p) {
        
        if(p.length()==0) return s.length()==0; // base case are we finished with the letters?
        
        if(p.length()>1 && p.charAt(1)=='*'){
            if(isMatch(s,p.substring(2))){ //0 repeat
                return true; 
            }
             //1 or more than 1 repeat
            if(s.length()>0 && (p.charAt(0)=='.' || s.charAt(0)==p.charAt(0)))
                return isMatch(s.substring(1),p);
        }
        else{
            if(s.length()>0 && (p.charAt(0)=='.' || s.charAt(0)==p.charAt(0)))
                return isMatch(s.substring(1),p.substring(1));
        }
        
        return false;
    }
}

****************************************************************

class Solution {
    Map<String,Boolean> map = new HashMap<>();
    
    public boolean isMatch(String s, String p) {
        
        if(p.length()==0) return s.length()==0; // base case are we finished with the letters in both the strings?
        
        String key = s+"#"+p;
        
        if(map.containsKey(key)) return map.get(key);
        
        Boolean result=false;
        
        if(p.length()>1 && p.charAt(1)=='*'){
            if(isMatch(s,p.substring(2))){ //0 repeat
				result = true;
                map.put(key,result);
                return result;
            }
             //1 or more than 1 repeat
            if(s.length()>0 && (p.charAt(0)=='.' || s.charAt(0)==p.charAt(0)))
                result = isMatch(s.substring(1),p);
        }
        else{
            if(s.length()>0 && (p.charAt(0)=='.' || s.charAt(0)==p.charAt(0)))
                result = isMatch(s.substring(1),p.substring(1)); //both match
        }
        map.put(key,result);
        return result;
    }
}
