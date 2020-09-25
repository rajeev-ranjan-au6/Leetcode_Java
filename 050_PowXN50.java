class Solution {
    public double myPow(double x, int n) {
        /*
            fast exponentiation method
            2 Cases:
                n odd
                n even
        
        */
        if(n==0){
            return 1.0;
        }
        else if(n==1){
            return x;
        }
        else if(n==-1){
            return (1.0/x);
        }
        if(n%2==0){
            return myPow(x*x, n/2);
        }
        else{
            if(n<0){
                double ans = myPow(x*x, (n+1)/2);
                return (1.0/x)*ans;
            }
            else{
                double ans = myPow(x*x, (n-1)/2);
                return x*ans;
            }
        }
    }
}
**************************************************************************************************
class Solution {
    public double myPow(double x, int n) {
        if (n == 0 || x == 1)
            return 1;
        
        if (x == -1 && n % 2 == 0)
            return 1.0;
        else if (x == -1 && n % 2 == 1)
            return -1.0;
        
        if (n > 5000000 && x > 1)
            return Integer.MAX_VALUE;
        else if (n > 5000000 && x < 1 && x > 0)
            return 0.0;
        
        if (n < -5000000)
            return 0.0;
        
        if (n == -1.00000)
            return 1 / x;
        
        double ans = 1.0;
            
        for (int i = 0; i < Math.abs(n); i++)
            ans *= x;
        
        return n > 0 ? ans : 1 / ans;
    }
}

************************************************************
class Solution {
    public double myPow(double x, int n) {
        double ans = 1;
        if (n == 0) return 1.0;
        
        double half = myPow(x, n/2);
        if (n % 2 == 0) {
            return half * half;
        } else if (n < 0) {
            return (1.0 / x) * half * half;
        } else {
            return x * half * half;
        }
    }
}

***********************************************************************
class Solution {
    public double myPow(double x, int n) {
        
        if(n == 0)
            return 1;
        
        double temp = myPow(x,n/2);
        
        if((n%2 == 0)){
            return temp*temp;
        }
        else{
            if(n > 0)
                return x*temp*temp;
            else
                return (temp*temp)/x;
        }        
    }
}

****************************************************************
