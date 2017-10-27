package main;

public class SimilarityBasedSearch {

	/**
	 * Computes the mean value of a gray-scale image given as a 2D array 
	 * @param image : a 2D double array, the gray-scale Image
	 * @return a double value between 0 and 255 which is the mean value
	 */
	public static double mean(double[][] image) {
		
		// TODO implement me !
		return -2; 
	}

	
	/**
	 * Computes the Normalized Cross Correlation of a gray-scale pattern if positioned
	 * at the provided row, column-coordinate in a gray-scale image
	 * @param row : a integer, the row-coordinate of the upper left corner of the pattern in the image.
	 * @param column : a integer, the column-coordinate of the upper left corner of the pattern in the image.
	 * @param pattern : an 2D array of doubles, the gray-scale pattern to find
	 * @param image : an 2D array of double, the gray-scale image where to look for the pattern
	 * @return a double, the Normalized Cross Correlation value at position (row, col) between the pattern and the part of
	 * the base image that is covered by the pattern, if the pattern is shifted by x and y.
	 * should return -1 if the denominator is 0
	 */
	public static double normalizedCrossCorrelation(int row, int col, double[][] pattern, double[][] image) {
		
		double sommeXPattern = 0;
		double sommeYPattern = 0;
		double sommeXImage = 0;
		double sommeYImage = 0 ;
		double moyenneXImage ;
		double moyenneYImage ;
		double moyenneXPattern ;
		double moyenneYPattern ;
		double coeffImage;
		double coeffPattern;
				
		for ( row = 0; row < pattern.length; row++) {
			for ( col = 0; col < pattern[row].length; col++) {
				
				int x = row;
				int y = col;
				
				sommeXPattern += x;
				moyenneXPattern = ((1 / row) * sommeXPattern);
				
				sommeYPattern += y;
				moyenneYPattern = ((1 / row) * sommeYPattern);
				
				sommeXImage += x;
		        moyenneXImage = ((1 / row) * sommeXImage);
				
				sommeYImage += y;
				moyenneYImage = ((1 / row) * sommeYImage);
				
				coeffPattern = ((row - moyenneXPattern ) * (col - moyenneYPattern)) / (Math.sqrt(Math.pow(row - moyenneXPattern , 2)) * (Math.pow(col - moyenneYPattern  , 2)));
				coeffImage = ((row - moyenneXImage ) * (col - moyenneYImage)) / (Math.sqrt(Math.pow(row - moyenneXImage, 2)) * (Math.pow(col - moyenneYImage , 2 )));
				
				
				
				
			}
			
		}
		return -2; 
	}

	
	/**
	 * Compute the similarityMatrix between a gray-scale image and a gray-scale pattern
	 * @param pattern : an 2D array of doubles, the gray-scale pattern to find
	 * @param image : an 2D array of doubles, the gray-scale image where to look for the pattern
	 * @return a 2D array of doubles, containing for each pixel of a original gray-scale image, 
	 * the similarity (normalized cross-correlation) between the image's window and the pattern
	 * placed over this pixel (upper-left corner)
	 */
	public static double[][] similarityMatrix(double[][] pattern, double[][] image) {
		
		// TODO implement me !
		return new double[][]{}; 
	}

}
