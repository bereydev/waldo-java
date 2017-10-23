package main;

public class DistanceBasedSearch {

	/**
	 * Computes the mean absolute error between two RGB pixels, channel by channel.
	 * @param patternPixel : a integer, the second RGB pixel.
	 * @param imagePixel : a integer, the first RGB pixel.
	 * @return a double, the value of the error for the RGB pixel pair. (an integer in [0, 255])
	 */
	public static double pixelAbsoluteError(int patternPixel, int imagePixel) {

    	// TODO implement me !
		return -2;
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

    	// TODO implement me !
		return -2; 
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

    	// TODO implement me !
		return new double[][]{}; 
	}
}
