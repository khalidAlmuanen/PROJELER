package Proje;

import java.io.File;
import java.nio.file.Paths;
import java.util.Scanner;

public class ilkProje {
  

	public static void main(String [] args)
	{
		 Scanner in = new Scanner(System.in);
		int arr[][]= {{13,9,73},{4,2},{8}};
		
		for(int row = 0 ; row<arr.length; row++)
		{
			for(int col = 0 ; col < arr[row].length; col++)
				System.out.print(arr[row][col]+ " ");	
		}
		System.out.println();	
	}
}
	
