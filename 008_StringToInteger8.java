/**
 * Implement atoi to convert a string to an integer.
 *
 * Hint: Carefully consider all possible input cases. If you want a challenge,
 * please do not see below and ask yourself what are the possible input cases.
 *
 * Notes: It is intended for this problem to be specified vaguely (ie, no given
 * input specs). You are responsible to gather all the input requirements up front.
 *
 * Requirements for atoi:
 * The function first discards as many whitespace characters as necessary until
 * the first non-whitespace character is found. Then, starting from this
 * character, takes an optional initial plus or minus sign followed by as many
 * numerical digits as possible, and interprets them as a numerical value.
 *
 * The string can contain additional characters after those that form the
 * integral number, which are ignored and have no effect on the behavior of
 * this function.
 *
 * If the first sequence of non-whitespace characters in str is not a valid
 * integral number, or if no such sequence exists because either str is empty
 * or it contains only whitespace characters, no conversion is performed.
 *
 * If no valid conversion could be performed, a zero value is returned. If the
 * correct value is out of the range of representable values,
 * INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
 *
 */

*****************************************************************************************

class Solution {
    public int myAtoi(String str) {
        str = str.trim();
        if (str.isEmpty() 
            || str.length() == 0 
            || Character.isAlphabetic(str.charAt(0))) {
            return 0;
        }
        boolean minus = false;
        if (str.charAt(0) == '-') {
            minus = true;
        }
        
        StringBuilder build = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            
            if (Character.isDigit(ch)) {
                build.append(ch);
                if (build.toString().equals("0")){
                    build = new StringBuilder();
                } 
            } else {
                if (i == 0 && (ch == '-' || ch == '+')) {
                    continue;
                } else {
                    break;
                }
            }   
        }
        
        if (build.length() == 0){
            return 0;
        } 
        
        if(build.length() > 12) {
            if (minus) {
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }
        }
        
        long number = Long.parseLong(build.toString());
        number = minus ? number * -1: number;
        
        if (number > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        
        if (number < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        
        return (int) number;
    }
}
***************************************************************************************************************
class Solution {
    public int myAtoi(String str) {
        if (str.isEmpty())
            return 0;
        
        int i = 0;
        while (i < str.length() && str.charAt(i) == ' ')
            i++;
        
        int sign = 1;
        if (i < str.length()) {
            if (str.charAt(i) == '-') {
                sign = -1;
                i++;
            } else if (str.charAt(i) == '+')
                i++;
        }
        
        int ans = 0;
        while (i < str.length() && str.charAt(i) > 47 && str.charAt(i) < 58) {
            if ((ans > Integer.MAX_VALUE / 10) ||
                (ans == Integer.MAX_VALUE / 10 && (str.charAt(i) - '0') > 7))
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            ans = (ans * 10) + (str.charAt(i++) - '0');
        }
        return ans * sign;
    }
}
