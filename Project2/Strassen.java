
public class Strassen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[][]= {{1,0,0}, {0,5,0}, {0,0,9}};
		int B[][]= {{1,0,0}, {0,5,0}, {0,0,9}};
		int Result[][]=Strassen(A, B);
		int length=Result.length;
		System.out.println("The resultant matrix of multliplying A and B: ");
		for (int i=0; i<length; i++)
		{
			for (int j=0; j<length; j++)
			{
				System.out.printf("%7d", Result[i][j]);
			}
			System.out.println();
		}
	}
	
	static int[][] Strassen(int A[][], int B[][])
	{
		int length=A.length, newLength=length; 
		int[][] newA= {}, newB={}, C, realC=new int[length][length];
		boolean flag=false;
		if (length==1)
		{
			realC[0][0]=A[0][0]*B[0][0];
			return realC;
		} 
		else if (!isPowerOfTwo(length))
		{
			flag=true;
			do
			{
				newLength++;
			} while(!isPowerOfTwo(newLength));
			
			newA=new int[newLength][newLength];
			newB=new int[newLength][newLength];
			for (int i=0; i<length; i++)
				for (int j=0; j<length; j++)
				{
					newA[i][j]=A[i][j];
					newB[i][j]=B[i][j];
				}
		}
		int[][] A11 = new int[newLength / 2][newLength / 2];
        int[][] A12 = new int[newLength / 2][newLength / 2];
        int[][] A21 = new int[newLength / 2][newLength / 2];
        int[][] A22 = new int[newLength / 2][newLength / 2];
        int[][] B11 = new int[newLength / 2][newLength / 2];
        int[][] B12 = new int[newLength / 2][newLength / 2];
        int[][] B21 = new int[newLength / 2][newLength / 2];
        int[][] B22 = new int[newLength / 2][newLength / 2];
		
        if (flag)
        {
	        split(newA, A11, 0, 0);
	        split(newA, A12, 0, newLength / 2);
	        split(newA, A21, newLength / 2, 0);
	        split(newA, A22, newLength / 2, newLength / 2);
	        split(newB, B11, 0, 0);
	        split(newB, B12, 0, newLength / 2);
	        split(newB, B21, newLength / 2, 0);
	        split(newB, B22, newLength / 2, newLength / 2);
        }
        else
        {
        	split(A, A11, 0, 0);
	        split(A, A12, 0, newLength / 2);
	        split(A, A21, newLength / 2, 0);
	        split(A, A22, newLength / 2, newLength / 2);
	        split(B, B11, 0, 0);
	        split(B, B12, 0, newLength / 2);
	        split(B, B21, newLength / 2, 0);
	        split(B, B22, newLength / 2, newLength / 2);
        }
        
        int[][] P1=  Strassen(add(A11, A22), add(B11, B22));
        int[][] P2 = Strassen(add(A21, A22), B11);
        int[][] P3 = Strassen(A11, sub(B12, B22));
        int[][] P4 = Strassen(A22, sub(B21, B11));
        int[][] P5 = Strassen(add(A11, A12), B22);
        int[][] P6 = Strassen(sub(A21, A11), add(B11, B12));
        int[][] P7 = Strassen(sub(A12, A22), add(B21, B22));
        
        int[][] C11 = add(sub(add(P1, P4), P5), P7);
        int[][] C12 = add(P3, P5);
        int[][] C21 = add(P2, P4);
        int[][] C22 = add(sub(add(P1, P3), P2), P6);
        C=new int[newLength][newLength];

        join(C11, C, 0, 0);
        join(C12, C, 0, newLength / 2);
        join(C21, C, newLength / 2, 0);
        join(C22, C, newLength / 2, newLength / 2);
        
        if (flag)
        {
        	for (int i=0; i<length; i++)
				for (int j=0; j<length; j++)
					realC[i][j]=C[i][j];
        	return realC;
        }
        return C;
	}
    static boolean isPowerOfTwo(int n)
    {
        if (n == 0)
            return false;
 
        while (n != 1) {
            if (n % 2 != 0)
                return false;
            n = n / 2;
        }
        return true;
    }
    static void split(int[][] bigMatrix, int[][] splitedMatrx, int iB, int jB)
    {
        for (int i1 = 0, i2 = iB; i1 < splitedMatrx.length; i1++, i2++)
            for (int j1 = 0, j2 = jB; j1 < splitedMatrx.length; j1++, j2++)
            	splitedMatrx[i1][j1] = bigMatrix[i2][j2];
    }
    public static int[][] add(int[][] A, int[][] B)
    {
        int n = A.length;
        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                C[i][j] = A[i][j] + B[i][j];
        return C;
    }
    public static int[][] sub(int[][] A, int[][] B)
    {
        int n = A.length;
        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                C[i][j] = A[i][j] - B[i][j];
        return C;
    }
    public static void join(int[][] C, int[][] P, int iB, int jB)
    
    {
        for (int i1 = 0, i2 = iB; i1 < C.length; i1++, i2++)
            for (int j1 = 0, j2 = jB; j1 < C.length; j1++, j2++)
                P[i2][j2] = C[i1][j1];
    }
}
