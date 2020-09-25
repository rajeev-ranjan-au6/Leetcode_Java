class Solution {
     private List<String> bfs(int[] numbers, int n, String[] table) {
         if (n == 0) {
            return Collections.emptyList();
         }
         List<String> result = new ArrayList<>();
         Queue<String> queue = new ArrayDeque<>();
         queue.offer("");
         while (!queue.isEmpty()) {
             String current = queue.poll();
             if (current.length() == n) {
                 result.add(current);
             }
             else {
                 for (char letter : table[numbers[current.length()]].toCharArray()) {
                     queue.offer(current + letter);
                 }
             }
         }
         return result;
    }
    
    public List<String> letterCombinations(String digits) {
        String[] table = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        int n = digits.length();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i ++) {
            char k = digits.charAt(i);
            numbers[i] = Character.getNumericValue(k);
        }
        return bfs(numbers, n, table);
    }
}

****************************************************************************************************************

class Solution {
    public static final String[] codes = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) {
            return result;
        }
        
        char[] partial = new char[digits.length()];
        int start = 0;
        
        permHelper(digits, start, partial, result);
        
        return result;
    }
    
    public void permHelper(String input, int idx, char[] partial, List<String> result) {
        if (idx == input.length()) {
            result.add(new String(partial));
        } else {
            for (int i = 0; i < codes[input.charAt(idx) - '0'].length(); i++) {
                String in = codes[input.charAt(idx) - '0'];
                partial[idx] = in.charAt(i);
                permHelper(input, idx + 1, partial, result);
            }
        }
    }    
}

***********************************************************************************************************

class Solution {
    private static char[][] phone; 
    
    static {
        phone = new char[8][];
        phone['2' - '2'] = "abc".toCharArray();
        phone['3' - '2'] = "def".toCharArray();
        phone['4' - '2'] = "ghi".toCharArray();
        phone['5' - '2'] = "jkl".toCharArray();
        phone['6' - '2'] = "mno".toCharArray();
        phone['7' - '2'] = "pqrs".toCharArray();
        phone['8' - '2'] = "tuv".toCharArray();
        phone['9' - '2'] = "wxyz".toCharArray(); 
    }
    
    public List<String> letterCombinations(String digits) {
        List<String> output = new ArrayList<>();
        char[] input = digits.toCharArray();
        if (input.length == 0) {
            return output;
        }
        backtrack(input, 0, new char[input.length], output);
        return output;
    }
    
    private void backtrack(char[] input, int pos, char[] path, List<String> output) {
        if (pos == input.length) {
            output.add(new String(path));
        } else {
            char[] phoneDigs = phone[input[pos] - '2'];
            for (char dig: phoneDigs) {
                path[pos] = dig;
                backtrack(input, pos + 1, path, output);
            }
        }
    }
}
