class Solution {
    public boolean isValidSudoku(char[][] board) {   
	//check rows and columns
		for (int i = 0; i < board.length; i++) {
			HashSet<Character> h = new HashSet<>();
			HashSet<Character> hh = new HashSet<>();
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] != '.' && h.contains(board[i][j])) {
					return false;
				}
				if (board[j][i] != '.' && hh.contains(board[j][i])) {
					return false;
				}
				h.add(board[i][j]);
				hh.add(board[j][i]);
			}
		}
		//check 3*3 matric
		for (int k = 0; k < board.length; k = k + 3)
			for (int l = 0; l < board.length; l = l + 3) {
				if (!check(board, k, l)) {
					return false;
				}
			}

		return true;
    }
   public boolean check(char[][] chh, int row, int col) {
		HashSet<Character> h = new HashSet<>();

		for (int i = 0 + row; i < 3 + row; i++) {
			for (int j = 0 + col; j < 3 + col; j++) {
				if (chh[i][j] != '.' && h.contains(chh[i][j])) {
					return false;
				}
				h.add(chh[i][j]);
			}
		}
		return true;
	}   
}

*************************************************************************************
class Solution {
    
    public boolean subboxcheck(char[][] board, int i, int j)  //This function is to check if same value is present multiple times in a sub-box
    {
        HashSet<Integer> set = new HashSet<>();
        for(int l=i;l<i+3;l++)
        {
            for(int k = j ;k<j+3;k++)
            {
                if(board[l][k]!='.')
                {
                    if(!set.contains(Character.getNumericValue(board[l][k])))
                    {
                        set.add(Character.getNumericValue(board[l][k]));
                    }
                    else
                        return false;
                }
            }
        }
        return true;
    }
    public boolean isValidSudoku(char[][] board) {
        HashMap<Character, List<Integer>> rows = new HashMap<>();
        HashMap<Character, List<Integer>> cols = new HashMap<>();
        
        for(int i=0;i<9;i-=-1)   //This loop is to check if a number is present in either same row or same column
        {
            for(int j=0;j<9;j-=-1)
            {
                if(board[i][j]!='.')
                {
                    if(!rows.containsKey(board[i][j]))
                    {
                        rows.put(board[i][j], new ArrayList<Integer>());
                        cols.put(board[i][j], new ArrayList<Integer>());
                    }
                    
                    if(rows.get(board[i][j]).size()>0 && cols.get(board[i][j]).size()>0)
                    {
                        if(!rows.get(board[i][j]).contains(i) && !cols.get(board[i][j]).contains(j))
                        {
                            rows.get(board[i][j]).add(i);
                            cols.get(board[i][j]).add(j);
                        }
                        else
                            return false;
                        
                    }
                    else
                    {
                        rows.get(board[i][j]).add(i);
                        cols.get(board[i][j]).add(j);
                    }
                }
            }
        }
        
        for(int i=0;i<9;i+=3)
        {
            for(int j=0;j<9;j+=3)
            {
               boolean bool = subboxcheck(board,i,j);
                if(!bool)
                {
                    return false;
                }
            }
        }
        return true;
    }
}

*************************************************************************************
class Solution {
    public boolean isValidSudoku(char[][] board) {
        // possible rows[],cols[],boxes[]
        // data intialization
        HashMap<Integer,Integer> rows[]=new HashMap[9];
        HashMap<Integer,Integer> cols[]=new HashMap[9];
        HashMap<Integer,Integer> boxes[]=new HashMap[9];
        for(int i=0;i<9;i++){
            rows[i]=new HashMap();
            cols[i]=new HashMap();
            boxes[i]=new HashMap();
        }
        
        
        // we have totatl 9 boxes so to iterate over each induivdual box  we have -> box=(i/3)*3+j/3
        // validate on each box if there is multiple entries for sma enumber then return false;
        
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                char num=board[i][j];
                if(num!='.'){
                    int n=(int)num;
                    int box_index=(i/3)*3+(j/3);
                    
                    // keep the track of current cell value i.e. n
                    rows[i].put(n,rows[i].getOrDefault(n,0)+1);
                    cols[j].put(n,cols[j].getOrDefault(n,0)+1);
                    boxes[box_index].put(n,boxes[box_index].getOrDefault(n,0)+1);
                    
                    if(rows[i].get(n)>1||cols[j].get(n)>1||boxes[box_index].get(n)>1)
                        return false;
                    
                }
            }
        }
        return true;
    }
}

