package main;

import java.util.ArrayList;

public class Collector {

	/**
	 * Find the row, column coordinates of the best element (biggest or smallest) for the given matrix
	 * @param matrix : an 2D array of doubles
	 * @param smallestFirst : a boolean, indicates if the smallest element is the best or not (biggest is then the best)
	 * @return an array of two integer coordinates, row first and then column
	 */
public static int[] findBest(double[][] matrix, boolean smallestFirst) {
	
		double smallest  = Double.POSITIVE_INFINITY;
		double biggest  = Double.NEGATIVE_INFINITY;
		int [] bestPosition = new int [2];
		
		if (smallestFirst) {
			for(int row = 0; row < matrix.length ; row++ ) {
				for(int col = 0 ; col < matrix[row].length ; col++ ) {
				
					double numberToCompare = matrix[row][col] ;				
					if (numberToCompare < smallest) {
						bestPosition [0] = row  ; 
						bestPosition[1] = col ;
						smallest = matrix[row][col];
					}
				}
			}	
		}else {
			for(int row = 0; row < matrix.length ; row++ ) {
				for(int col = 0 ; col < matrix[row].length ; col++ ) {
				
					double numberToCompare = matrix[row][col] ;				
					if (numberToCompare > biggest) {
						bestPosition [0] = row  ; 
						bestPosition[1] = col ;
						biggest = matrix[row][col];
					}
					
				}
			}	
		}
		return  bestPosition ;
		
	}


	
	/**
	 * Find the row, column coordinate-pairs of the n best (biggest or smallest) elements of the given matrix
	 * @param n : an integer, the number of best elements we want to find 
	 * @param matrix : an 2D array of doubles
	 * @param smallestFirst : a boolean,  indicates if the smallest element is the best or not (biggest is the best)
	 * @return an array of size n containing row, column-coordinate pairs
	 */
	public static int[][] findNBest(int n, double[][] matrix, boolean smallestFirst) {
		
		double smallest  = Double.POSITIVE_INFINITY;
		double biggest  = Double.NEGATIVE_INFINITY;
		int [][] nBestPosition = new int [n][2];
		
		for (int i = 0; i < n; i++) {
			
		
		if (smallestFirst) {
			for(int row = 0; row < matrix.length ; row++ ) {
				for(int col = 0 ; col < matrix[row].length ; col++ ) {
				
					double numberToCompare = matrix[row][col] ;				
					if (numberToCompare < smallest) {
					nBestPosition[i][0]= row ;
					nBestPosition[i][1]= col ;
					smallest = matrix[row][col];
					matrix[row][col] = Double.POSITIVE_INFINITY;
					
					}
				}
			}	
		}else {
			for(int row = 0; row < matrix.length ; row++ ) {
				for(int col = 0 ; col < matrix[row].length ; col++ ) {
				
					double numberToCompare = matrix[row][col] ;				
					if (numberToCompare > biggest) {
						nBestPosition[i][0]= row ;
					    nBestPosition[i][1]= col ;
						biggest = matrix[row][col];
						matrix [row][col] = Double.NEGATIVE_INFINITY;
					}
					
				}
			}	
		}
		return nBestPosition;
		}
	}
	
	

	/**
	 * BONUS 
	 * Notice : Bonus points are underpriced ! 
	 * 
	 * Sorts all the row, column coordinates based on their pixel value
	 * Hint : Use recursion !
	 * @param matrix : an 2D array of doubles
	 * @return A list of points, each point is an array of length 2.
	 */
	public static ArrayList<int[]> quicksortPixelCoordinates(double[][] matrix) {

		// TODO implement me correctly for "underpriced" bonus!
		return new ArrayList<int[]>();
	}

	
	/**
	 * BONUS
	 * Notice : Bonus points are underpriced !
	 * 
	 * Use a quick sort to find the row, column coordinate-pairs of the n best (biggest or smallest) elements of the given matrix
	 * Hint : return the n first or n last elements of a sorted ArrayList  
	 * @param n : an integer, the number of best elements we want to find 
	 * @param matrix : an 2D array of doubles
	 * @param smallestFirst : a boolean, indicate if the smallest element is the best or not (biggest is the best)
	 * @return an array of size n containing row, column-coordinate pairs
	 */
	public static int[][] findNBestQuickSort(int n, double[][] matrix, boolean smallestFirst) {

    	// TODO implement me correctly for underpriced bonus!
		return new int[][]{};
	}
}
