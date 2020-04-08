//Husam Muneeb
//CS 3310
//March 6,2020
import java.util.Scanner;
import java.util.Random;

public class MatrixMultiplication { 
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        Random r = new Random();
        
        System.out.println("Please enter size: ");
        int n = kb.nextInt();
        
        boolean input = isPowerOfTwo(n);   
        
        //While loop to make sure that user input is a power of 2
        while(input == false) {
            System.out.println("n is not a power of 2, try again: ");
            n = kb.nextInt();
            input = isPowerOfTwo(n);
        }
        
        int[][] a = new int[n][n]; 
        int[][] b = new int[n][n];
        
        //Randomizing the integers for the first matrix 
        System.out.println("Matrix 1: ");
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++) {
		a[i][j] = r.nextInt(50)+1;
		System.out.print(a[i][j] + " ");
            }			
            System.out.println();
	}
      //generating random integers for the second matrix same dimension
        System.out.println("\n Matrix 2: ");        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++) {
		b[i][j] = r.nextInt(50)+1;
		System.out.print(b[i][j] + " ");
            }			
            System.out.println();
	}        
        
        System.out.println();
        
        //Result is where we will store result using strassen method
        int[][] Result = new int[n][n];
        
        long startTime = System.currentTimeMillis();   //Start timer when it uses Strassen's Method
        Result = Strassen.Strassen(a, b);   //Calls Strassen Class 
        long endTime = System.currentTimeMillis();  // End timer after its done with its multiplication
               
        System.out.println("Resulting Matrix using Strassen's Algorithm:");
        for(int i=0; i<n ; i++){
            for(int j=0; j<n ; j++)
            {               
                for(int k=0;k<n;k++)
                {    
                    
                }
                System.out.print(Result[i][j]+ " ");
            }
            System.out.println();           
        }
        System.out.println("\n Time it took to calculate using Strassen method\n" + 
                (endTime-startTime) + " milliseconds");
    }       
    
    //method to make sure user's input is a power of 2.
    private static boolean isPowerOfTwo(int n) 
    { 
        return (int)(Math.ceil((Math.log(n) / Math.log(2))))  
            == (int)(Math.floor(((Math.log(n) / Math.log(2))))); 
    } 


}