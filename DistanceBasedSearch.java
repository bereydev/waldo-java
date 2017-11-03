package main;

public class DistanceBasedSearch {

	/**
	 * Computes the mean absolute error between two RGB pixels, channel by channel.
	 * 
	 * @param patternPixel: a integer, the second RGB pixel. Requirement: none, any integer
	 * @param imagePixel: a integer, the first RGB pixel. Requirement: none, any integer
	 * @return a double, the value of the error for the RGB pixel pair. (an integer
	 *         in [0, 255])
	 */
	public static double pixelAbsoluteError(int patternPixel, int imagePixel) {

		double absoluteError = 0;
		absoluteError += Math.abs(ImageProcessing.getRed(patternPixel) - ImageProcessing.getRed(imagePixel));
		absoluteError += Math.abs(ImageProcessing.getGreen(patternPixel) - ImageProcessing.getGreen(imagePixel));
		absoluteError += Math.abs(ImageProcessing.getBlue(patternPixel) - ImageProcessing.getBlue(imagePixel));
		absoluteError /= 3;

		return absoluteError;
	}

	/**
	 * Computes the mean absolute error loss of a RGB pattern if positioned at the
	 * provided row, column-coordinates in a RGB image
	 * 
	 * @param row: a integer, the row-coordinate of the upper left corner of the pattern in the image. 
	 * Requirement: row must be greater than or equals to 0 and smaller than the difference of the row number of the image +1 and the row number of the pattern 
	 * @param column: a integer, the column-coordinate of the upper left corner of the pattern in the image. 
	 * Requirement: column must be greater than or equal to 0 and smaller than the difference of the column number of the image +1 and the column number of the pattern
	 * @param pattern: an 2D array of integers, the RGB pattern to find. 
	 * Requirement: pattern has to be an array greater than 1 by 1
	 * @param image: an 2D array of integers, the RGB image where to look for the pattern. 
	 * Requirement: image has to be an array greater than 1 by 1
	 * @return a double, the mean absolute error
	 * @return a double, mean absolute error value at position (row, col) between
	 *         the pattern and the part of the base image that is covered by the
	 *         pattern, if the pattern is shifted by x and y. should return -1 if
	 *         the denominator is -1
	 */
	public static double meanAbsoluteError(int row, int col, int[][] pattern, int[][] image) {
		
		assert pattern.length > 0 && pattern[0].length > 0;
		assert image.length > 0 && image[0].length > 0;
		assert row >= 0 && row <= (image.length-pattern.length+1);
		assert col >= 0 && col <= (image[0].length-pattern[0].length+1);

		double meanAbsoluteError = 0;
		int nbPixels = pattern.length * pattern[0].length;
		for (int i = 0; i < pattern.length; i++) {
			for (int j = 0; j < pattern[0].length; j++) {
				meanAbsoluteError += pixelAbsoluteError(pattern[i][j], image[row + i][col + j]);
			}
		}
		meanAbsoluteError /= nbPixels;

		return meanAbsoluteError;
	}

	/**
	 * Compute the distanceMatrix between a RGB image and a RGB pattern
	 * 
	 * @param pattern: an 2D array of integers, the RGB pattern to find
	 * Requirement: pattern has to be an array greater than 1 by 1
	 * @param image: an 2D array of integers, the RGB image where to look for the pattern
	 * Requirement: image has to be an array greater than 1 by 1
	 * @return a 2D array of doubles, containing for each pixel of a original RGB
	 *         image, the distance (meanAbsoluteError) between the image's window
	 *         and the pattern placed over this pixel (upper-left corner)
	 */
	public static double[][] distanceMatrix(int[][] pattern, int[][] image) {
		
		assert pattern.length > 0 && pattern[0].length > 0;
		assert image.length > 0 && image[0].length > 0;
		
		double[][] distanceMatrix = new double[image.length - pattern.length + 1][image[0].length - pattern[0].length+ 1];
		for (int row = 0; row < distanceMatrix.length; row++) {
			for (int col = 0; col < distanceMatrix[0].length; col++) {
				distanceMatrix[row][col] = meanAbsoluteError(row, col, pattern, image);
			}
		}
		return distanceMatrix;
	}
	
}

