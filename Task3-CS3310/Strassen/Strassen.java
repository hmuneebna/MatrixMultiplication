//Husam Muneeb
//CS3310
//Task 3
//March 6,2020


//Strassen Class that executes the algorithm 
public class Strassen {
    public static int[][] Strassen(int[][] a, int[][] b) {
        
        int n = a.length;
        int[][] c = new int[n][n]; 
        //if n is equal to 1 then each matrix will have a size of 0 
        if (n==1) {
            c[0][0] = (a[0][0]) * (b[0][0]);
        }
        
        else {
        	// splitting each section of the matrices according to Strassens Algorithm
            int[][] a11 = new int[n/2][n/2]; 
            int[][] a12 = new int[n/2][n/2];
            int[][] a21 = new int[n/2][n/2];
            int[][] a22 = new int[n/2][n/2];
            int[][] b11 = new int[n/2][n/2];
            int[][] b12 = new int[n/2][n/2];
            int[][] b21 = new int[n/2][n/2];
            int[][] b22 = new int[n/2][n/2];

            //partition matrix into 4 parts
            partition(a,a11,0,0);
            partition(a,a12,0,n/2);
            partition(a,a21,n/2,0);
            partition(a,a22,n/2,n/2);
            
            partition(b,b11,0,0);
            partition(b,b12,0,n/2);
            partition(b,b21,n/2,0);
            partition(b,b22,n/2,n/2);       
            
            //Formula's adding and subtracting matrices
            int[][] P1 = Strassen(add(a11, a22), add(b11,b22));
            int[][] P2 = Strassen(add(a21, a22), b11);
            int[][] P3 = Strassen(a11, subtract(b12, b22));
            int[][] P4 = Strassen(a22, subtract(b21, b11));
            int[][] P5 = Strassen(add(a11, a12), b22);
            int[][] P6 = Strassen(subtract(a21, a11), add(b11, b12));
            int[][] P7 = Strassen(subtract(a12, a22), add(b21, b22));

            int[][] c11 = add(subtract(add(P1, P4), P5), P7);
            int[][] c12 = add(P3, P5);
            int[][] c21 = add(P2, P4);
            int[][] c22 = add(subtract(add(P1, P3), P2), P6);
            //Combine all the results 
            Combine(c11,c,0,0);
            Combine(c12,c,0,n/2);
            Combine(c21,c,n/2,0);
            Combine(c22,c,n/2,n/2);
          
        }
        return c;
    }
    
    
    //Method for adding the matrices 
    public static int[][] add(int[][] a, int[][] b)
    {
        int n = a.length;
        int[][] c = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                c[i][j] = a[i][j] + b[i][j];
            }
        }
        return c;
    }
    //Method for subtracting Matrices 
    public static int[][] subtract(int[][] a, int[][] b){
        int n = a.length;
        int[][] c = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                c[i][j] = a[i][j] - b[i][j];
            }
        }
        return c;
    }
    //method for partitioning the arrays 
    public static void partition(int[][] bigmatrix, int[][] submatrix, int a, int b)
    {
        for(int i = 0, j = a; i < submatrix.length; i++, j++)
            for(int k = 0, l = b; k < submatrix.length; k++, l++)
                submatrix[i][k] = bigmatrix[j][l];
    }
    //method to Combine submatrices into the original matrix
    public static void Combine(int[][] submatrix, int[][] bigmatrix, int a, int b)
    {
        for(int i = 0, j = a; i < submatrix.length; i++, j++)
            for(int k = 0, l = b; k < submatrix.length; k++, l++)
                bigmatrix[j][l] = submatrix[i][k];
    }

}