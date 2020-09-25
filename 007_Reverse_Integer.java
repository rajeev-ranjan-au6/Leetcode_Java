class Solution {
    public int reverse(int x) {
        if (x == 0) return 0;
        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE)
                return 0;
            x /= 10;
        }
        return (int) res;
    }
}

******************************************************************************

class Solution {
    public int reverse(int x) {
        int result = 0;
        int reminder = x;

        while (reminder != 0) {
            int lastDigit = reminder % 10;
            int nextRes = result * 10 + lastDigit;
            
            /*
                expression '(nextRes - lastDigit) / 10' should return us the current result
                if it's different - it means that we have an int overflow 
            */
            if ((nextRes - lastDigit) / 10 != result) {
                return 0;
            }

            result = nextRes;
            reminder /= 10;
        }
        
        return result;
    }
}

************************************************************************
class Solution {
    public int reverse(int x) {
        
        boolean isNegative = x<0;
        if(isNegative){
            x=x*-1;
        }
        
        long newNumber = 0;
        
        while(x>0){
            int lastDigitOfX = x%10;
            newNumber = (newNumber*10) + lastDigitOfX;
            x = x/10;
        }
        
        if(newNumber > Integer.MAX_VALUE){
            return 0;
        }
        
        if(isNegative){
            newNumber = newNumber*-1;
        }
        
        return (int)newNumber;
        
    }
}
