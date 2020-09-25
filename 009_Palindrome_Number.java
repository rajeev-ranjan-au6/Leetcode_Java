class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) 
            return false;
        int temp = x;
        int len = 0;
        while (temp != 0) {
            temp /= 10;
            len ++;
        }
        temp = x;
        int left, right;
        for (int i = 0; i < len / 2; i++) {
            right = temp % 10;
            left = temp / (int) Math.pow(10, len - 2 * i - 1);
            left = left % 10;
            if (left != right)
                return  false;
            temp /= 10;
        }
        return true;
    }
}
******************************************
class Solution {
public boolean isPalindrome(int x) {
int rev=0;
int d=1;
int temp=x;
if(x<0)
return false;
while(x!=0){
d=x%10;
rev=(rev*10)+d;
x/=10;
}
if(rev!=temp){
return false;
}
return true;
}
}

*******************************************
class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        
        long revnum = 0;
        int y = x;
        while(x != 0){
            int digit = x % 10;
            if(revnum > Integer.MAX_VALUE){
                return false;
            }
            revnum = revnum * 10 + digit;
            x = x / 10;
        }
        
        if((int)revnum == y){
            return true;
        }
        
        return false;
    }
}
