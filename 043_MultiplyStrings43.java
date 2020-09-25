class Solution {
    public String multiply(String num1, String num2) {
        int n2 = num2.length();
        int n1 = num1.length();
       
        if(num1.charAt(0)=='0' || num2.charAt(0)=='0') return "0";
        
        StringBuilder[] str = new StringBuilder[n2];
        char[] arr_num1 = num1.toCharArray();
        
        for(int i=n2-1, k=0; i>=0; i--,k++){
            str[k] = mult(arr_num1, toInt(num2.charAt(i)),k);
        }
    
        if(str.length == 1) return str[0].toString();
        
        StringBuilder curr = str[0];
        
        for(int i=1;i<str.length;i++){
            curr = add(curr,str[i]);
        }
        return curr.toString();
    }
    
    
    StringBuilder add(StringBuilder a, StringBuilder b){
        int n1 = a.length()-1, n2 = b.length()-1;
        int carry = 0;
        StringBuilder sb = new StringBuilder("");
        
        while(n1>=0 && n2>=0){
            int num = toInt(a.charAt(n1)) + toInt(b.charAt(n2)) + carry;
            if(num / 10 == 0) carry = 0;
            else{ num = num % 10; carry = 1; }
            sb.append(num);
            n1--; n2--; 
        }
        
        while(n1>=0){
            int num = toInt(a.charAt(n1)) + 0 + carry;
            if(num / 10 == 0) carry = 0;
            else{ num = num % 10; carry = 1; }
            sb.append(num);
            n1--; 
        }
        
        while(n2>=0){
            int num = 0 + toInt(b.charAt(n2)) + carry;
            if(num / 10 == 0) carry = 0;
            else{ num = num % 10; carry = 1; }
            sb.append(num);
            n2--; 
        }
        if(carry>0) sb.append(carry);
        return sb.reverse();
    }
                                  
    StringBuilder mult(char[] num1, int n, int numZeros){
        StringBuilder sb = new StringBuilder("");
        while(numZeros-- > 0) sb.append("0");
        int carry = 0, i = num1.length-1;
        while(i>=0){
            int num = toInt(num1[i]) * n + carry;   //multiply single digit
            if(num / 10 == 0) carry = 0;
            else{
                carry = num / 10;
                num = num % 10;
            }
            sb.append(num); i--;
        }
        if(carry > 0) sb.append(carry);
        return sb.reverse();
    }
    
    int toInt(char ch){
        return ch-48;
    }
}

*************************************************
class Solution {
    public String multiply(String num1, String num2) {
       // we can add num1 and num2 using one digit at a time
        int m=num1.length();
        int n=num2.length();
        int [] prod=new int[m+n];
        // code for calculating prod array
        for(int i=m-1;i>=0;i--)
        {
            for(int j=n-1;j>=0;j--)
            {
                int index=i+j+1;//this is simple, just give it a thought(playing with indexes)
                int val=(num1.charAt(i)-'0')* (num2.charAt(j)-'0');
                int sum=val+prod[index];// adding the previous number also
                prod[index]=sum%10;// storing the result in prod 
                prod[index-1]+=sum/10; //forwarding the carry
            }
        }
		// convert result prod array to string 
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<prod.length;i++)
        {
            if(prod[i]==0 && ans.length()==0) continue;
            ans.append(prod[i]);
        }
        
        return ans.length()==0?"0":ans.toString();
    }
}
*************************************************************

class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        int[] a1 = s2a(num1);
        int[] a2 = s2a(num2);
        int[] res = new int[a1.length + a2.length];
        int extra_v = 0;
        for (int i = a1.length - 1; i>=0; i--) {
            for (int j = a2.length - 1; j>=0; j--) {
                int index = a2.length - j - 1 + a1.length - i - 1;
                int v = a1[i] * a2[j] + extra_v + res[index];
                res[index] = v % 10;
                extra_v = v / 10;
            }
            if (extra_v > 0) {
                res[a2.length + a1.length - i - 1] = extra_v;
                extra_v = 0;
            }
        }
        StringBuilder sb = new StringBuilder();
        boolean start = false;
        for (int i = res.length - 1; i >= 0; i--) {
            if (start || res[i] != 0) start = true;
            if (start) {
                sb.append((char) (res[i] + '0'));
            }
        }
        return sb.toString();
    }
    
    private int[] s2a(String num) {
        int[] array = new int[num.length()];
        for (int i = num.length() - 1; i >=0; i--) {
            array[i] = num.charAt(i) - '0';
        }
        return array;
    }
}
