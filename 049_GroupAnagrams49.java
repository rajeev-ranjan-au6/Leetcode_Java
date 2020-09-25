class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res=new ArrayList<List<String>>();
        List<String> s=new ArrayList<>();
        Collections.addAll(s,strs);
        while(s.size()!=0){
            List<String> temp=new ArrayList<>();
            temp.add(s.get(0));
            for(int i=1;i<s.size();){
                if(isAnagram(temp.get(0),s.get(i))){
                    temp.add(s.get(i));
                    s.remove(s.get(i));
                }else
                    i++;
            }
            res.add(temp);
            s.remove(temp.get(0));
        }
        
        return res;
    }
    
    public boolean isAnagram(String s1,String s2){
        if(s1.length()==0 && s2.length()==0)
            return true;
        if(s1.length()==0 || s2.length()==0 || s1.length()!=s2.length())
            return false;
        char[] a1=s1.toCharArray();
        char[] a2=s2.toCharArray();
        
        Arrays.sort(a1);
        Arrays.sort(a2);
        
        for (int i=0;i<a1.length;i++) 
            if (a1[i]!=a2[i]) 
                return false; 
  
        return true; 
    }
}

****************************************************************************************************

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        for(String s:strs){
            //String key = getAnagramKey(s);
            String key = getSortKey(s);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }
        //System.out.println(map);
        List<List<String>> res = new ArrayList<>();
        for(List<String> curr : map.values()){
            res.add(curr);
        }
        return res;
    }
    private String getSortKey(String s)
    {
        char[] temp = s.toCharArray();
        Arrays.sort(temp);
        return new String(temp);
    }
    private String getAnagramKey(String s)
    {
        Map<Character, Integer> map = new TreeMap<>();
        for(int i=0;i<s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
        }
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            sb.append(entry.getValue());
            sb.append(entry.getKey());
        }
        return sb.toString();
    }
}

***************************************************************
/**
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all
 * the original letters exactly once.
 *
 * Example 1:
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 * Example 2:
 * Input: strs = [""]
 * Output: [[""]]
 *
 * Example 3:
 * Input: strs = ["a"]
 * Output: [["a"]]
 *
 * Constraints:
 * 1 <= strs.length <= 104
 * 0 <= strs[i].length <= 100
 * strs[i] consists of lower-case English letters.
 */

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String enc = encode(strs[i]);
            if (groups.containsKey(enc)) {
                groups.get(enc).add(strs[i]);
            } else {
                groups.put(enc, new ArrayList<String>(Arrays.asList(strs[i])));
            }
        }

        List<List<String>> res = new ArrayList<>();
        for (String key : groups.keySet()) {
            res.add(groups.get(key));
        }

        return res;
    }

    private String encode(String str)  {
        Queue<Character> pq = new PriorityQueue<>();
        Map<Character, Integer> m = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (m.containsKey(c)) {
                m.put(c, m.get(c) + 1);
            } else {
                m.put(c, 1);
                pq.offer(c);
            }
        }

        String res = "";
        while (!pq.isEmpty()) {
            char c = pq.poll();
            res += c + "" + m.get(c);
        }
        return res;
    }
}

************************************************************************
public class Solution {
	public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(int i=0;i<strs.length;i++){
           String k= hash(strs[i]);
            if(!map.containsKey(k)) {
                map.put(k,new LinkedList<>());
            }  
			map.get(k).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }
    private String hash(String str) {
        int[] ch = new int[26];
        StringBuilder h = new StringBuilder();
        for(int i=0;i<str.length();i++){
            ch[str.charAt(i)-'a']+=1;
        }
        for(int i=0;i<ch.length;i++){
            if(ch[i]!=0){
                h.append(ch[i]);
                h.append((char)'a'+i);
            }
        }
        return h.toString();
    }
}




