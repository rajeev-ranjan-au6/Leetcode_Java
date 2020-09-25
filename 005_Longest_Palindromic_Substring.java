class Solution {
    public String longestPalindrome(String s) {
        /*
        * Calculate all palindromic strings that ended at index i
        * Assume that we have a list of integers corresponding to the length of palindromic strings which ended with i - 1 th
        * If the length of 1 palindromic string is L and s[i] == s[i - L - 1] => we have new string that ended with ith, and its length is L + 2
        * Consider the s[i - 1] and s[i - 2] to make 2-char and 3-char strings. 
        */
        if (s.length() == 0) return "";
        int maxLength = 1;
        int endIdx = 0;
        List<Integer> preResult = new ArrayList<>();
        
        int sizeList = 0;
        for (int i = 1; i < s.length(); i++){
            int k = 0;
            // Consider all strings that ended with (i-1)th
            for (int j = 0; j < sizeList; j ++ ){
                if ( preResult.size()>0 && i - preResult.get(j) -1 >= 0 && s.charAt(i) == s.charAt(i-preResult.get(j)-1)){ 
                    set(preResult, k ,preResult.get(j) + 2);
                    k++;
                }
            }
            if (i > 1 && s.charAt(i) == s.charAt(i-2)){ // make 3-char string
                set(preResult, k, 3);
                k++;
            }
            if (s.charAt(i) == s.charAt(i-1)){ // make 2-char string
                set(preResult, k, 2);
                k++;
            }
            sizeList = k;
            if (sizeList > 0 && maxLength < preResult.get(0)){
                    maxLength = preResult.get(0);
                    endIdx = i;
            }
        }
        return s.substring(endIdx - maxLength + 1,endIdx + 1);
    }
    
    private void set(List<Integer> a, int index, int value){
        if (index >= a.size()){
            a.add(value);
        } else {
            a.set(index, value);
        }
    }
}

****************************************************************************************
class Solution {
    public String longestPalindrome(String s) {
        int i = 0, j = 0, max = 0;
        String ans = "";
        while (i < s.length()) {
            j = i;
			// Traversal optimization: 
			// Propagation from "center" from the sides of grouped same characters
            while (j < s.length()-1 && s.charAt(i) == s.charAt(j+1)) {
                j++;
            }
            int left = i, nexti = j+1;
            while (left > 0 && j < s.length()-1 && s.charAt(left-1) == s.charAt(j+1)) {
                left--;
                j++;
            }
            if (j-left+1 > max){
                max = j-left+1;
                ans = s.substring(left, j+1);
            }
            i = nexti;
        }
        return ans;
    }
}

****************************************************************************************************
    // ManachersAlgorithm
    // https://en.wikipedia.org/wiki/Longest_palindromic_substring
    // public String longestPalindrome(String s) {
    //     if (s==null || s.length()==0)
    //         return "";

    //     char[] s2 = addBoundaries(s.toCharArray());
    //     int[] p = new int[s2.length];
    //     int c = 0, r = 0; // Here the first element in s2 has been processed.
    //     int m = 0, n = 0; // The walking indices to compare if two elements are the same
    //     for (int i = 1; i<s2.length; i++) {
    //         if (i>r) {
    //             p[i] = 0; m = i-1; n = i+1;
    //         } else {
    //             int i2 = c*2-i;
    //             if (p[i2]<(r-i)) {
    //                 p[i] = p[i2];
    //                 m = -1; // This signals bypassing the while loop below.
    //             } else {
    //                 p[i] = r-i;
    //                 n = r+1; m = i*2-n;
    //             }
    //         }
    //         while (m>=0 && n<s2.length && s2[m]==s2[n]) {
    //             p[i]++; m--; n++;
    //         }
    //         if ((i+p[i])>r) {
    //             c = i; r = i+p[i];
    //         }
    //     }
    //     int len = 0; c = 0;
    //     for (int i = 1; i<s2.length; i++) {
    //         if (len<p[i]) {
    //             len = p[i]; c = i;
    //         }
    //     }
    //     char[] ss = Arrays.copyOfRange(s2, c-len, c+len+1);
    //     return String.valueOf(removeBoundaries(ss));
    // }

    // private static char[] addBoundaries(char[] cs) {
    //     if (cs==null || cs.length==0)
    //         return "||".toCharArray();

    //     char[] cs2 = new char[cs.length*2+1];
    //     for (int i = 0; i<(cs2.length-1); i = i+2) {
    //         cs2[i] = '|';
    //         cs2[i+1] = cs[i/2];
    //     }
    //     cs2[cs2.length-1] = '|';
    //     return cs2;
    // }

    // private static char[] removeBoundaries(char[] cs) {
    //     if (cs==null || cs.length<3)
    //         return "".toCharArray();

    //     char[] cs2 = new char[(cs.length-1)/2];
    //     for (int i = 0; i<cs2.length; i++) {
    //         cs2[i] = cs[i*2+1];
    //     }
    //     return cs2;
    // }
}
