package main;

public class DistanceBasedSearch {

	/**
	 * Computes the mean absolute error between two RGB pixels, channel by channel.
	 * @param patternPixel : a integer, the second RGB pixel.
	 * @param imagePixel : a integer, the first RGB pixel.
	 * @return a double, the value of the error for the RGB pixel pair. (an integer in [0, 255])
	 */
	public static double pixelAbsoluteError(int patternPixel, int imagePixel) {
		
						double absoluteError = 0;
						absoluteError += Math.abs(ImageProcessing.getRed(patternPixel) - ImageProcessing.getRed(imagePixel ));	
						absoluteError += Math.abs(ImageProcessing.getGreen(patternPixel) - ImageProcessing.getGreen(imagePixel ));		
						absoluteError += Math.abs(ImageProcessing.getBlue(patternPixel) - ImageProcessing.getBlue(imagePixel ));	
						absoluteError/=3;
						
						return absoluteError;			
		  	}		  	
		  		  


	/**
	 * Computes the mean absolute error loss of a RGB pattern if positioned
	 * at the provided row, column-coordinates in a RGB image
	 * @param row : a integer, the row-coordinate of the upper left corner of the pattern in the image.
	 * @param column : a integer, the column-coordinate of the upper left corner of the pattern in the image.
	 * @param pattern : an 2D array of integers, the RGB pattern to find
	 * @param image : an 2D array of integers, the RGB image where to look for the pattern
	 * @return a double, the mean absolute error
	 * @return a double, mean absolute error value at position (row, col) between the pattern and the part of
	 * the base image that is covered by the pattern, if the pattern is shifted by x and y.
	 * should return -1 if the denominator is -1
	 */
	public static double meanAbsoluteError(int row, int col, int[][] pattern, int[][] image) {
		
		double meanAbsoluteError = 0;
		int nbElements = 0;
		for (int i = 0; i < pattern.length; i++) {
			for (int j = 0; j < pattern[i].length; j++) {
				meanAbsoluteError += pixelAbsoluteError(pattern[i][j],image[row+i][col+j]);
				nbElements += 1;
			}
		}
		meanAbsoluteError /= nbElements;

		return meanAbsoluteError; 
	}

	/**
	 * Compute the distanceMatrix between a RGB image and a RGB pattern
	 * @param pattern : an 2D array of integers, the RGB pattern to find
	 * @param image : an 2D array of integers, the RGB image where to look for the pattern
	 * @return a 2D array of doubles, containing for each pixel of a original RGB image, 
	 * the distance (meanAbsoluteError) between the image's window and the pattern
	 * placed over this pixel (upper-left corner) 
	 */
	public static double[][] distanceMatrix(int[][] pattern, int[][] image) {
		double [][] distanceMatrix = new double [image.length-pattern.length+1][image[0].length-pattern[0].length+1];
		for (int row = 0; row < distanceMatrix.length; row++) {
			for (int col = 0; col < distanceMatrix.length; col++) {
				distanceMatrix[row][col] = meanAbsoluteError(row,col,pattern,image);
			}
		}
				
    	// TODO implement me!
		return distanceMatrix; 
	}
}
