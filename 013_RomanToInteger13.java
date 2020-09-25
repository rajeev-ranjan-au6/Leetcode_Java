class Solution {
    public int romanToInt(String s) {
        int current = 0, previous = 0, sum = 0;
        
        for(int i = 0; i < s.length(); i++){
            
            switch(s.charAt(i)){
                case 'I': 
                    current = 1;
                    break;
                case 'V':
                    current = 5;
                    break;
                case 'X':
                    current = 10;
                    break;
                case 'L':
                    current = 50;
                    break;
                case 'C':
                    current = 100;
                    break;
                case 'D':
                    current = 500;
                    break;
                case 'M':
                    current = 1000;
                    break;        
            }
             
            if(i != 0){
               if(current > previous){
                   sum = sum - previous;
               }
                else{
                    sum = sum + previous;
                }
            }
           
                previous = current;
           if(i == s.length() - 1){
               sum = sum + previous;
           }
            
            
        }
        return sum;
    }
}

******************************************************************************

class Solution {
    public int romanToInt(String s) {
        
        int out = 0;
        
        int i = 0;
        int S = s.length();
        
        char lastC = ' ';
        
        while(i < S){
            char c = s.charAt(i);
            
            if(c == 'M') {
                if(lastC == 'C') out += 800;
                else out += 1000;
            }
            if(c == 'D'){
                if(lastC == 'C') out += 300;
                else out += 500;
            }
            if(c == 'C')
            {
                if(lastC == 'X') out += 80;
                else out += 100;
            }
            if(c == 'L')
            {
                if(lastC == 'X') out += 30;
                else out += 50;
            }
            if(c == 'X')
            {
                if(lastC == 'I') out += 8;
                else out += 10;
            }
            if(c == 'V')
            {
                if(lastC == 'I') out += 3;
                else out += 5;
            }
            if(c == 'I')
            {
               out++;
            }
            
            lastC = c;
            i++;
        }
        
        return out;
    }
}

****************************************************************

 class Solution {
    public int romanToInt(String s) {
    int output = 0;
    int now =0;
    int previous =0;
        
    for(int i = 0; i<s.length(); i++){
        switch(s.charAt(i)){
            case 'M':
                now = 1000;
                break;
            case 'D':
                now =500;
                break;
            case  'C':
                now =100;
                break;
            case 'L':
                now =50;
                break;
            case 'X':
                now =10;
                break;
            case 'V':
                now =5;
                break;
            case 'I':
                now =1;
                break;
        }
        
        
     output += now;       
     if (previous < now){
         output -= 2*previous;
     }
        
        
     previous = now;   
    }    
        
        
     return output;   
    } 

}
