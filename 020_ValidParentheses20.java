class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();boolean check =false;
        for(int i = 0 ; i < s.length(); i++){
            if(stack.isEmpty()){
            if(s.charAt(i) == ']' || s.charAt(i) == ')' || s.charAt(i) == '}'){
                check = false;
        		return check;
               }
            }
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[' ){
                stack.push(s.charAt(i));
                continue;
            }
            else{
                char ch = s.charAt(i);
        switch(ch){
                
//            -------------------------------------     
            case ']':
                if(!stack.isEmpty()){
                if(stack.pop() == '['){
                	check = true;
                }
            else{
            	check = false;
            	return check;
            }
                }
                break;
                
//              --------------------------------   
                
            case '}':
                if(!stack.isEmpty()){
                if(stack.pop ()== '{'){
                    check = true;
                }
        
            else{
            	check = false;
            	return check;
            }
                }
                break;
//          ---------------------------       
                
            case ')':
                if(!stack.isEmpty()){
                if(stack.pop() == '('){
                	check = true;
                }
    
                else{
                	check = false;
                	return check;
                }
                }
                    break;       
//       ---------------------------------  
        
        }}}
        if(!stack.isEmpty()) {
        	check = false;
        }
                return check;
        
    }
}


****************************************************************************************

class Solution {
    public boolean isValid(String str) {
        
		if(str == null || str.equals("") || str.length() == 1) {
            return false;
        }
		
        Stack<Character> s = new Stack<Character>();
		
		char[] chars = str.toCharArray();
        for(int i=0; i< chars.length; i++) {
            char c = chars[i];
			
            if(c == '(' || c == '[' || c == '{') {
                s.push(c);
                continue;
            }
            
            if(s.isEmpty()) {
                return false;
            }
            
            if(c == ')') {
                char top = s.peek();
				if(top == '[' || top == '{') {
                    return false;
                }
            } else if(c == ']') {
                char top = s.peek();
                if(top == '(' || top == '{') {
                    return false;
                }
            } else if(c == '}') {
                char top = s.peek();
                if(top == '(' || top == '[') {
                    return false;
                }
            }
            s.pop();
        }
		
        return s.isEmpty();
    }
}

*********************************************************************************

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<Character>();
        if(s.length() ==1) return false;
        for(int i=0; i<s.length(); i++){
            char inChar = s.charAt(i);
            if(inChar=='{'||inChar=='['||inChar=='('){
                st.push(inChar);
            }else if(inChar==')'){
                boolean val = handleClosing(st,'(');
                if(val ==false){
                    return false;
                }
            }
            else if(inChar=='}'){
                boolean val = handleClosing(st,'{');
                if(val ==false){
                    return false;
                }
            }
            else if(inChar==']'){
                boolean val = handleClosing(st,'[');
                if(val ==false){
                    return false;
                }
            }

        }
               return st.isEmpty();
    }
    public static boolean handleClosing(Stack<Character> st,char corres ){
        if(st.size()==0){
            return false;
        }
        else if(st.peek()!=corres){
            return false;
        }else{
            st.pop();
            return true;
        }
    }
}

*********************************************************************************************

class Solution {
    public boolean isValid(String s) {
        Stack<Character> brackets = new Stack<Character>();
        int length = s.length();
        for (int i=0;i<length;i++){
            switch (s.charAt(i)){
                case '(':
                    brackets.push('(');
                    break;
                case '{':
                    brackets.push('{');
                    break;
                case '[':
                    brackets.push('[');
                    break;
                case ')':
                    if(brackets.empty() || brackets.peek() != '(')
                        return false;
                    brackets.pop();
                    break;
                case '}':
                    if(brackets.empty() || brackets.peek() != '{')
                        return false;
                    brackets.pop();
                    break;
                case ']':
                    if(brackets.empty() || brackets.peek() != '[')
                        return false;
                    brackets.pop();
                    break;
            }
            
        }
        return brackets.empty();
       
    }
}
