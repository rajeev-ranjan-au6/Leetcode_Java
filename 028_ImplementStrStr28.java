class Solution {
    public int strStr(String haystack, String needle) {
        
        if(needle.length() == 0) return 0;
        
        int[] p = buildPrefixTree(needle);
        
        int j=0;
        
        for(int i=0; i < haystack.length(); i++){
            
            while(j > 0 && haystack.charAt(i) != needle.charAt(j))
                j = p[j-1];
            
            if(haystack.charAt(i) == needle.charAt(j)){
                j++; 
            }
            
            if(j == needle.length()) return i-j+1;    
        }
        
        
        return -1;
    }

    private int[] buildPrefixTree(String s){
        
        int[] p = new int[s.length()];
        
        int j=0;
        
        for(int i=1; i < s.length(); i++){
            
            while(j > 0 && s.charAt(i) != s.charAt(j))
                j = p[j-1];
            
            if(s.charAt(i) == s.charAt(j))
                j++;
            
            p[i] = j;
        }
        
        return p;
        
    }
}

*************************************************************************************************************
class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) return -1;
        int pos = 0, auxPos = 0, needlePos = 0, vectorPos = 0, HL = haystack.length(), NL = needle.length(), ret = 0, vectorLimit = HL-NL;
        //ret is the start of what we believe is the substring needle in haystack
        if (NL == 0) return 0;
        if (NL > HL) return -1;
        int[] vector = new int[vectorLimit]; //vector stores those characters we see in-middle analysis which at the same time match the start of it
        while (pos < HL) {
            
            //We store those positions where needle may start.
            //This way, if we don't find the substring needle, we can backtrack so it starts in a new already checked pos
			//We ignore pos = 0 because it's the first character we start the analysis from, so there is no need to backtrack to it
            if (vectorPos < vectorLimit && pos != 0 && haystack.charAt(pos) == needle.charAt(0)) vector[vectorPos++] = pos;
            
            //If a character matches in the linear-sequenced analysis of needle, we will check the next char of it
            if (haystack.charAt(pos) == needle.charAt(needlePos)) {
                needlePos++;
                if (needlePos == NL) return ret;
            }
            
            else {
                
                //If there are any other positions where I can backtrack to...
                if (vectorPos > 0) {
                    vectorPos--;
                    pos = vector[vectorPos]; //This position is alreay checked, line 36 will move us to the next character
                    ret = pos;  //ret is the start of what we believe is the substring needle in haystack
                    needlePos = 1; //Since position 0 of needle is already checked
                }
                else {
                    pos = auxPos; //We go back to the forgotten position from which we started backtracking (see line 37)
                    ret = pos+1;  //auxPos is actually an already checked position (we backtrack when comparison between strings breaks), so the position we may return will be the next one. If we get to this portion of code, it means that there are no already-visited chars thay may start the substring needle, only new characters from haystack
                    if (needlePos != 0) needlePos = 0;
                }
            }
            pos++; // <-- line 36, we always move the position of haystack
            auxPos = pos; // <-- line 37, since we may backtrack in the future, we need to store the forgotten value of position (auxPos), so we don't repeat steps and go back to it
        }
        return -1;
    }
}

**********************************************************************************************
class Solution {
    public int strStr(String haystack, String needle) {
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            if (haystack.substring(i,i + needle.length()).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}
********************************************************************************
class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length()>haystack.length())
            return -1;
        else if(needle.equals(haystack) || needle.length()==0)
            return 0;
        int j=0,i=0,n=haystack.length(),m=needle.length();
        while(j+m<=n)
        {   
            i=0;
            char ch=needle.charAt(i);
            while(j<n && haystack.charAt(j)!=ch)
                j++;
            if(j==n)
                return -1;
            int k=0;
            if(j+m>n)
                return -1;
            while(haystack.charAt(j)==needle.charAt(i))
            {
				//incase starting character is again in the partial matched substring store it in k
                if(i!=0 && haystack.charAt(j)==ch)
                {
                    ch='A';
                    k=j;
                }
                i++;
                j++;
                if(i==m)
                    return j-i;
                else if(j==n)
                    break;
            }
            if(k!=0)
                j=k;
        }
        return -1;
    }
}
