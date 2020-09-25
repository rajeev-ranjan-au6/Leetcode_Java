class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList();
        traverse(0,0,n,"",list);
        return list;
    }
    void traverse(int op, int cp, int n, String prefix, List<String> list){
        if((op+cp)/2 == n){
            list.add(prefix);
            return;
        }
        if(op<n) traverse(op+1, cp, n, prefix+"(",list);
        if(cp<n && cp<op) traverse(op,cp+1,n, prefix+")",list);
    }
}

****************************************************************************************

class Solution {
    List<String> ans = new ArrayList<String>();
    public List<String> generateParenthesis(int n) {
        generate(n, 0, new StringBuilder());
        return ans;
    }
    
    public void generate(int n, int openBrackets, StringBuilder sb){
        if(openBrackets == 0 && n == 0){
            String temp = sb.toString();
            ans.add(temp);
            return;
        }
        
        if(openBrackets != 0){
            sb.append(')');
            generate(n, openBrackets-1, sb);
            sb.setLength(sb.length() - 1);
        }
        
        if(n != 0){
            sb.append('(');
            generate(n-1, openBrackets+1, sb);
            sb.setLength(sb.length() - 1);
        }
    }
}


*************************************************************************************
class Solution {
    public List<String> generateParenthesis(int n) {
        int open = n ;
        int close = n;
        String output = "";
        ArrayList<String> list = new ArrayList<>();
        solve(open,close,output,list);
        return list;
    }
    
    public void solve(int open,int close,String output,ArrayList<String> list)
    {
        if(open == 0 && close == 0)
        {
            list.add(output);
            return;
        }
        
        if(open != 0)
        {
            String output1 = output + "(" ;
            solve(open-1,close,output1,list);
        }
        
        if(close > open)
        {
            String output2 = output + ")";
            solve(open,close-1,output2,list);
        }
    }
}


********************************************************************************

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(n, n, "", res);
        return res;
    }
    
    private void dfs(int l, int r, String cur,  List<String> res) {
        if(l == 0 && r == 0){
            res.add(cur);
            return;
        }
        if(l > 0) dfs(l-1, r, cur+"(", res);
        if(r > l) dfs(l, r-1, cur+")", res);
    }
}
