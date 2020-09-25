class Solution {
    String [] ones = {"","I","II","III","IV","V","VI","VII","VIII","IX"};
    
    String thousands[] = {"","M","MM","MMM"};
    
    String hundreds[] = {"","C","CC","CCC","CD","D","DC","DCC", "DCCC", "CM"};
        
    String tens[] = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
    
    public String intToRoman(int num) {
        String ans = "";
        if(num/1000>0){
            ans = ans+thousands[num/1000];
            num=num%1000;
        }
        if(num/100>0){
            ans= ans + hundreds[num/100];
            num=num%100;
        }
        if(num/10>0){
            ans = ans+tens[num/10];
            num = num%10;
        }
        if(num>0){
            ans = ans+ones[num];
        }
        return ans;
    }
}

**********************************************************************************************
class Solution {
    int[] num = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
    String[] sym = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
    int i = 12;
    public String intToRoman(int n) {
        String res = "";
        while (n > 0) {
            int div = n/num[i];
            n %= num[i];
            while (div > 0) {
                res += sym[i];
                div--;
            }
            i--;
        }
        return res;
    }
}
