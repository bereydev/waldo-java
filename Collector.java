package main;

import java.util.ArrayList;

public class Collector {

	/**
	 * Find the row, column coordinates of the best element (biggest or smallest)
	 * for the given matrix
	 * 
	 * @param matrix: an 2D array of doubles
	 * Requirement: matrix has to be an array greater than 1 by 1
	 * @param smallestFirst: a boolean, indicates if the smallest element is the best or not (biggest is then the best).
	 * Requirement: none, true or false would work
	 * @return an array of two integer coordinates, row first and then column
	 */
	public static int[] findBest(double[][] matrix, boolean smallestFirst) {
		
		assert matrix.length > 0 && matrix[0].length > 0;
		
		double reference;
		int[] bestPosition = new int[2];
		
		if (smallestFirst) {
			reference = Double.POSITIVE_INFINITY;
			for (int row = 0; row < matrix.length; row++) {
				for (int col = 0; col < matrix[0].length; col++) {

					double numberToCompare = matrix[row][col];
					if (numberToCompare < reference) {
						bestPosition[0] = row;
						bestPosition[1] = col;
						reference = matrix[row][col];
					}
				}
			}
			
		} else {
			reference = Double.NEGATIVE_INFINITY;
			for (int row = 0; row < matrix.length; row++) {
				for (int col = 0; col < matrix[0].length; col++) {

					double numberToCompare = matrix[row][col];
					if (numberToCompare > reference) {
						bestPosition[0] = row;
						bestPosition[1] = col;
						reference = matrix[row][col];
					}
				}
			}
		}

		
		
		
		return bestPosition;

	}

	/**
	 * Find the row, column coordinate-pairs of the n best (biggest or smallest)
	 * elements of the given matrix
	 * 
	 * @param n: an integer, the number of best elements we want to find
	 * Requirement: n has to be greater than 0
	 * @param matrix: an 2D array of doubles
	 * Requirement: matrix has to be an array greater than 1 by 1
	 * @param smallestFirst: a boolean, indicates if the smallest element is the best or not (biggest is the best).
	 * Requirement: none, true or false would work
	 * @return an array of size n containing row, column-coordinate pairs
	 */
	public static int[][] findNBest(int n, double[][] matrix, boolean smallestFirst) {
		
		assert n>0;
		assert matrix.length > 0 && matrix[0].length > 0;
		
		double[][] copyOfMatrix = ImageProcessing.copyMatrix(matrix);

		int[][] nBestPosition = new int[n][];

		for (int row = 0; row < n; row++) {
			nBestPosition[row] = findBest(copyOfMatrix, smallestFirst);
			
			if (smallestFirst) {
				copyOfMatrix[nBestPosition[row][0]][nBestPosition[row][1]] = Double.POSITIVE_INFINITY;
			} else {
				copyOfMatrix[nBestPosition[row][0]][nBestPosition[row][1]] = Double.NEGATIVE_INFINITY;
			}

		}
		return nBestPosition;
	}

	/**
	 * BONUS Notice : Bonus points are underpriced !
	 * 
	 * Sorts all the row, column coordinates based on their pixel value Hint : Use
	 * recursion !
	 * 
	 * @param matrix
	 *            : an 2D array of doubles
	 * @return A list of points, each point is an array of length 2.
	 */
	public static ArrayList<int[]> quicksortPixelCoordinates(double[][] matrix) {

	
		return new ArrayList<int[]>();
	}

	/**
	 * BONUS Notice : Bonus points are underpriced !
	 * 
	 * Use a quick sort to find the row, column coordinate-pairs of the n best
	 * (biggest or smallest) elements of the given matrix Hint : return the n first
	 * or n last elements of a sorted ArrayList
	 * 
	 * @param n
	 *            : an integer, the number of best elements we want to find
	 * @param matrix
	 *            : an 2D array of doubles
	 * @param smallestFirst
	 *            : a boolean, indicate if the smallest element is the best or not
	 *            (biggest is the best)
	 * @return an array of size n containing row, column-coordinate pairs
	 */
	public static int[][] findNBestQuickSort(int n, double[][] matrix, boolean smallestFirst) {

	
		return new int[][] {};
	}
}
