//Husam Muneeb
//CS3310
//March 6,2020

import java.util.Scanner;
import java.util.Random;
public class Classical {
	public static void main(String[] args)
	{
		 Scanner kb= new Scanner(System.in); //Scanner Variable 
		 Random r=new Random();				 //Randomizing the integers variable 
		 System.out.println("Enter a size: ");
		 int n=kb.nextInt();     //User Input, n=user input  
		 boolean input = isPowerOfTwo(n);
		 while(input == false) {
	            System.out.println("n is not a power of 2, please try again: ");
	            n = kb.nextInt();
	            input = isPowerOfTwo(n);
	        }

		 int A[][]=new int[n][n];		//Matrix A is size n x n
		 int B[][]=new int[n][n];		//Matrix B is size n x n
		 int C[][]= new int[n][n];		//Matrix C is also n x n although its the resulting matrix 
		
		 int i,j,k;						// Initializing i,j,k
		 int max=10;  					//Max=10
		 int min=1;						//Min=1
		 long startTime = System.currentTimeMillis();
		 for(i=0;i<n;i++) {				//The loop will begin if the integer inputted is bigger than 0, 0 to n
			 for ( j=0 ; j <n ; j++)
			 { 
				 A[i][j]=r.nextInt(max-min)+min;		//Randomize the integer elements in matrix A, formula for matrix multiplication
				 B[i][j]=r.nextInt(max-min)+min;		//Randomize the integer elements in matrix B, formula for matrix multiplication	
				 
				 C[i][j] = A[i][1] * B[1][j];   //The resulting Matrix A[i][j]xB[i][j]=C[i][j]
				 	for ( k=0 ; k < n ; k++) 
				 	{
			              C[i][j] = C[i][j] + A[i][k] * B[k][j] ;  //Resulting Matrix after multiplication
				 	}
				 	System.out.print(C[i][j]+" ");		//Printing the resulting Matrix C[i][j]
			 }
			 System.out.println();						//After the row is completed, print next line.
		 }
		 long endTime = System.currentTimeMillis();
		 
		 System.out.println("\nTime it took to calculate using traditional method\n" + 
                 (endTime-startTime) + " milliseconds");
		 
				 
	}
	private static boolean isPowerOfTwo(int n) 
    { 
        return (int)(Math.ceil((Math.log(n) / Math.log(2))))  
            == (int)(Math.floor(((Math.log(n) / Math.log(2))))); 
    } 
}

