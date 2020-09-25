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

************************************************************************************

class Solution {
   public boolean isValidSudoku(char[][] board) {
        List<boolean[]> subBoxCheckList = fillBooleanList(3);
        List<boolean[]> colmsCheckList = fillBooleanList(9);
        boolean[] row;

        for(int i = 0; i < board.length; i++){
            row = new boolean[10];
            for(int j = 0; j < board.length; j++){
                if(board[i][j] != '.') {
                    if(row[board[i][j] - 48]) {
                        return false;
                    }
                    else row[board[i][j] - 48] = true;

                    if(colmsCheckList.get(j)[board[i][j] - 48]) {
                        return false;
                    }
                    else colmsCheckList.get(j)[board[i][j] - 48] = true;

                    int subBoxIndex = (j / 3);
                    if(subBoxCheckList.get(subBoxIndex)[board[i][j] - 48]) {
                        return false;
                    }
                    else {
                        subBoxCheckList.get(subBoxIndex)[board[i][j] - 48] = true;
                    }
                }
            }
            if((i + 1) % 3 == 0) subBoxCheckList = fillBooleanList(3);
        }
        return true;
    }

    private List<boolean[]> fillBooleanList(int size){
        List<boolean[]> list = new ArrayList<>();
        while(size != 0){
            list.add(new boolean[10]);
            size--;
        }
        return list;
    }
}

***************************************************************

class Solution {
public boolean isValidSudoku(char[][] board) {

    HashSet<Character> rowSet = new HashSet<>();
    HashSet<Character> colSet = new HashSet<>();
    HashSet<String> boxSet = new HashSet<>();
    
    for (int rowCnt = 0; rowCnt < board.length; rowCnt++) {
        
        for (int colCnt = 0; colCnt < board[rowCnt].length; colCnt++) {
            
            if (board[rowCnt][colCnt] != '.') {
                if (!rowSet.contains(board[rowCnt][colCnt])) 
                    rowSet.add(board[rowCnt][colCnt]);
                else 
                    return false;
                
                if (!boxSet.contains(rowCnt/3 + "-" + colCnt/3 + "-" + board[rowCnt][colCnt]))
                    boxSet.add(rowCnt/3 + "-" + colCnt/3 + "-" + board[rowCnt][colCnt]);
                else 
                    return false;
            }
            
            if (board[colCnt][rowCnt] != '.') {
                if (colSet.contains(board[colCnt][rowCnt])) 
                    return false;
                else 
                    colSet.add(board[colCnt][rowCnt]);
            }
            
        }
        rowSet.clear();
        colSet.clear();
    }
    return true;
}
}

******************************************************

