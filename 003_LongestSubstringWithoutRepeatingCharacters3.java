/**
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Examples:
 *
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 *
 * Given "bbbbb", the answer is "b", with the length of 1.
 *
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the
 * answer must be a substring, "pwke" is a subsequence and not a substring.
 */
****************************************************************************************
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet();
        
        int count = 0;
        int maxCount = 0;
        int i = 0;
        
        while( i < s.length()){
            if(!set.contains(s.charAt(i))){
                set.add(s.charAt(i));
                count++;
            }
            else{
                maxCount = Math.max(count, maxCount);
                count = 0;
                i -= set.size();
                set.clear();
            }
            i++;
        }
        return Math.max(count, maxCount);
    }
}
****************************************************************************************

