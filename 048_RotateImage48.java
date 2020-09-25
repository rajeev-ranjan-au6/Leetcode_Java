class Solution {
public void rotate(int[][] matrix) {
for(int i=0;i<matrix.length;i++)
{
for(int j=i+1;j<matrix.length;j++)
{
int temp=matrix[i][j];
matrix[i][j]=matrix[j][i];
matrix[j][i]=temp;
}
}
for(int i=0;i<matrix.length;i++)
{
int low=0,high=matrix.length-1;
while(low<high)
{
int temp=matrix[i][low];
matrix[i][low]=matrix[i][high];
matrix[i][high]=temp;
low++;
high--;

        }
    }
}
}

************************************************************

class Solution {
    public void rotate(int[][] matrix) {
        int temp;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        int h_ptr = 0, t_ptr = matrix.length - 1;
        for (int i = 0; i < matrix.length; i++) {
            while (h_ptr < t_ptr) {
                temp = matrix[i][h_ptr];
                matrix[i][h_ptr] = matrix[i][t_ptr];
                matrix[i][t_ptr] = temp;
                h_ptr++;
                t_ptr--;
            }
            h_ptr = 0;
            t_ptr = matrix.length - 1;
        }
    }
}

****************************************************************

/*
    Video explanation: https://youtu.be/6SohPBdwU94
*/
class Solution {

	/*
	[1,2,3],
	[4,5,6],
	[7,8,9]

	mirror around secondary diagonal   

	[9, 6, 3],
	[8, 5, 2],
	[7, 4, 1]

	mirror horizontally around middle line

	[7, 4, 1],
	[8, 5, 2],
	[9, 6, 3]
	*/

	/*
	[ 5, 1, 9,11],
	[ 2, 4, 8,10],
	[13, 3, 6, 7],
	[15,14,12,16]

	mirror around secondary diagonal 

	[16, 7, 10, 11],
	[12, 6,  8,  9],
	[14, 3,  4,  1],
	[15, 13, 2,  5]

	mirror horizontally around middle line

	...
	
	*/

	public void rotate(int[][] matrix) {
		mirrorSecondaryDiagonal(matrix);
		mirrorHorizontally(matrix);
	}

	private static void mirrorSecondaryDiagonal(int[][] matrix) {
        // flip second diagonaly
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix.length - i - 1; j++) {
				int current = matrix[i][j];
				matrix[i][j] = matrix[matrix.length - j - 1][matrix.length - i - 1];
				matrix[matrix.length - j - 1][matrix.length - i - 1] = current;
			}
		}
	}
    // flip horizontally
	private static void mirrorHorizontally(int[][] matrix) {
		for(int i = 0; i < matrix.length / 2; i++) {
			for(int j = 0; j < matrix.length; j++) {
				int current = matrix[i][j];
				matrix[i][j] = matrix[matrix.length - i - 1][j];
				matrix[matrix.length - i - 1][j] = current;
			}
		}

	}
}

************************************************************************

class Solution {
    public void rotate(int[][] matrix) {
        int rowUpper = 0;
        int rowLower = matrix.length - 1;
        int colLeft = 0;
        int colRight = matrix.length - 1;
        while(rowUpper<rowLower && colLeft<colRight) {
        	rotate(matrix, rowUpper, rowLower, colLeft, colRight);
        	rowUpper++;
        	rowLower--;
        	colLeft++;
        	colRight--;
        }
    }
	
	public static void rotate(int[][] matrix, int rowUpper, int rowLower, int colLeft, int colRight) {
		int k=0;
		for(int i=colLeft; i<colRight; i++) {
			int tmp1 = matrix[rowUpper+k][colRight];
			matrix[rowUpper+k][colRight] = matrix[rowUpper][i];
			int tmp2 = matrix[rowLower][colRight-k];
			matrix[rowLower][colRight-k] = tmp1;
			tmp1 = matrix[rowLower-k][colLeft];
			matrix[rowLower-k][colLeft] = tmp2;
			matrix[rowUpper][i] = tmp1;
			k++;
		}
	}
}

*****************************************************

class Solution {
    
    public int[] reverse(int[] array) {
        
        int n = array.length;
        int[] b = new int[n]; 
        int j = n; 
        for (int i = 0; i < n; i++) { 
            b[j - 1] = array[i]; 
            j = j - 1; 
        }
        
        return b;
    }
    
    public void rotate(int[][] matrix) {
        
        int N = matrix.length;
        int M = matrix[0].length;
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < M; j++) { 
                 int temp = matrix[i][j]; 
                 matrix[i][j] = matrix[j][i]; 
                 matrix[j][i] = temp; 
            }
        }    
        
        for(int i=0; i<N; i++) {
            matrix[i] = reverse(matrix[i]);
        }
    }
}
