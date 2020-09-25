class Solution {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        Trie trie = new Trie();
        String searchString = null;
        for (String word : strs) {
            if (searchString == null) {
                searchString = word;
            } else if (searchString.length() > word.length()) {
                searchString = word;
            }
            trie.insert(word);
        }
        return trie.longestCommonPrefix(searchString);
    }
}

class Trie {
    public static class TrieNode {
        Map<Character, TrieNode> map;
        boolean isWord;

        public TrieNode() {
            map = new HashMap<>();
            isWord = false;
        }
    }

    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            TrieNode newNode = current.map.get(word.charAt(i));
            if (newNode == null) {
                newNode = new TrieNode();
                current.map.put(word.charAt(i), newNode);
            }
            current = newNode;
        }
        current.isWord = true;
    }

    public String longestCommonPrefix(String word) {
        TrieNode current = root;
        if (current.map.size() > 1) return "";
        String longestCommonPrefix = "";
        for (int i = 0; i < word.length(); i++) {
            TrieNode newNode = current.map.get(word.charAt(i));
            if (newNode == null || newNode.map.size() > 1) return longestCommonPrefix + word.charAt(i);
            else {
                longestCommonPrefix += word.charAt(i);
                current = newNode;
            }
        }
        return longestCommonPrefix;
    }

}

*********************************************************************

class Solution {
    
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        int count = lengthOfLongestCommonPrefix(strs);
        return strs[0].substring(0, count);
    }
    
    private int lengthOfLongestCommonPrefix(String[] strs){
        int count = 0;
        for(int i = 0 ; i < strs[0].length(); i++){
            boolean same = true;
            char ch = ' ';
            for(int j = 0; j < strs.length; j++){
                if(i >= strs[j].length()){
                    return count;
                }
                if(j == 0){
                    ch = strs[j].charAt(i);
                    continue;
                }
                if(ch != strs[j].charAt(i)){
                    same = false;
                }
            }
            
            if(same){
                count ++;
            }
            else{
                break;
            }
        }
        return count;
    }
}

*************************************************************************

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0)
            return "";
        boolean flag = true;
        int count = 0;
        int smallestLen = strs[0].length();
        for(int i=1;i<strs.length;i++)
        {
            if(strs[i].length()<smallestLen)
                smallestLen = strs[i].length();
        }
        for(int i=0;i<smallestLen;i++)
        {
            char c = strs[0].charAt(i);
            for(int j=1;j<strs.length;j++)
            {
                if(strs[j].charAt(i)==c)
                    flag=true;
                else
                {
                    flag=false;
                    break;
                }
            }
            if(flag==true)
                count++;
            else
                break;
        }
        if(count==0)
            return "";
        return strs[0].substring(0,count);
    }
}
