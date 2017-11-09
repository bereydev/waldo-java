package main;

public final class ImageProcessing {

	/**
	 * Returns red component from given packed color.
	 * 
	 * @param rgb: a 32-bits RGB color. Requirement: none, any integer
	 * @return an integer, between 0 and 255
	 * @see #getGreen
	 * @see #getBlue
	 * @see #getRGB(int, int, int)
	 */

	public static int getRed(int rgb) {

		int decal;
		decal = rgb >> 16;
		int resultat = decal & 0xff;
		if (resultat < 0) {
			return 0;
		} else if (resultat > 255) {
			return 255;
		}
		return resultat;
	}

	/**
	 * Returns green component from given packed color.
	 * 
	 * @param rgb: a 32-bits RGB color. Requirement: none, any integer
	 * @return an integer between 0 and 255
	 * @see #getRed
	 * @see #getBlue
	 * @see #getRGB(int, int, int)
	 */
	public static int getGreen(int rgb) {
		int decal = rgb >> 8;

		int resultat = decal & 0xff;
		if (resultat < 0) {
			return 0;
		} else if (resultat > 255) {
			return 255;
		}
		return resultat;
	}

	/**
	 * Returns blue component from given packed color.
	 * 
	 * @param rgb: a 32-bits RGB color. Requirement: none, any integer
	 * @return an integer between 0 and 255
	 * @see #getRed
	 * @see #getGreen
	 * @see #getRGB(int, int, int)
	 */
	public static int getBlue(int rgb) {
		int resultat = rgb & 0xff;
		if (resultat < 0) {
			return 0;
		} else if (resultat > 255) {
			return 255;
		}
		return resultat;
	}

	/**
	 * Returns the average of red, green and blue components from given packed
	 * color.
	 * 
	 * @param rgb: 32-bits RGB color. Requirement: none, any integer
	 * @return a double between 0 and 255
	 * @see #getRed
	 * @see #getGreen
	 * @see #getBlue
	 * @see #getRGB(int)
	 */
	public static double getGray(int rgb) {

		int red = getRed(rgb);
		int green = getGreen(rgb);
		int blue = getBlue(rgb);

		double gray = (red + green + blue) / 3.0;
		return gray;
	}

	/**
	 * Returns packed RGB components from given red, green and blue components.
	 * 
	 * @param red: an integer. Requirement: none, any integer
	 * @param green: an integer. Requirement: none, any integer
	 * @param blue: an integer. Requirement: none, any integer
	 * @return a 32-bits RGB color
	 * @see #getRed
	 * @see #getGreen
	 * @see #getBlue
	 */
	public static int getRGB(int red, int green, int blue) {
		if (red < 0) {
			red = 0;
		} else if (red > 255) {
			red = 255;
		}
		if (green < 0) {
			green = 0;
		} else if (green > 255) {
			green = 255;
		}
		if (blue < 0) {
			blue = 0;
		} else if (blue > 255) {
			blue = 255;
		}

		int rgb = (red << 16) | (green << 8) | (blue);

		return rgb;
	}

	/**
	 * Returns packed RGB components from given gray-scale value.
	 * 
	 * @param gray: a double. Requirement: none, any double
	 * @return a 32-bits RGB color
	 * @see #getGray
	 */
	public static int getRGB(double gray) {
		
		if (gray < 0) {
			gray = 0;
		} else if (gray > 255) {
			gray = 255;
		}
		int red = (int) gray;
		int green = (int) gray;
		int blue = (int) gray;
		int rgb = (red << 16) | (green << 8) | (blue);
		return rgb;
	}

	/**
	 * Converts packed RGB image to gray-scale image.
	 * 
	 * @param image: a HxW integer array. Requirement: image has to be an array of greater than 1 by 1  
	 * @return a HxW double array
	 * @see #encode
	 * @see #getGray
	 */
	public static double[][] toGray(int[][] image) {
		
		assert image.length > 0 && image[0].length > 0;

		double[][] gray = new double[image.length][image[0].length];
		for (int row = 0; row < image.length; row++) {
			for (int col = 0; col < image[0].length; col++) {
				gray[row][col] = getGray(image[row][col]);
			}

		}
		return gray;
	}

	/**
	 * Converts gray-scale image to packed RGB image.
	 * 
	 * @param channels: a HxW double array. Requirement: gray has to be an array greater than 1 by 1 
	 * @return a HxW integer array
	 * @see #decode
	 * @see #getRGB(double)
	 */
	public static int[][] toRGB(double[][] gray) {
		
		assert gray.length > 0 && gray[0].length > 0;
		
		int[][] imageRgb = new int[gray.length][gray[0].length];
		for (int row = 0; row < gray.length; row++) {
			for (int col = 0; col < gray[0].length; col++) {

				imageRgb[row][col] = getRGB(gray[row][col]);
			}
		}
		return imageRgb;
	}

	/**
	 * Convert an arbitrary 2D double matrix into a 2D integer matrix which can be
	 * used as RGB image
	 * 
	 * @param matrix: the arbitrary 2D double array to convert into integer. Requirement: matrix has to be an array greater than 1 by 1
	 * @param min: a double, the minimum value the matrix could theoretically contains. Requirement: none, any integer
	 * @param max: a double, the maximum value the matrix could theoretically contains. Requirement: none, any integer
	 * @return an 2D integer array, containing a RGB mapping of the matrix
	 */
	public static int[][] matrixToRGBImage(double[][] matrix, double min, double max) {
		
		assert matrix.length > 0 && matrix[0].length > 0;
		
		double[][] copyOfMatrix = copyMatrix(matrix);
		
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[0].length; col++) {
				copyOfMatrix[row][col] = (matrix[row][col] - min) / (max - min) * 255;
			}

		}
		int[][] imageRgb = toRGB(copyOfMatrix);

		return imageRgb;
	}
	/**
	 * Copy the 2D array matrix in an other 2D array of the same size called copyMatrix	  
	 * @param matrix : the arbitrary 2D double array to copy in a double array. Requirement: matrix has to be an array greater than 1 by 1
	 * @return a 2D double array
	 */
	public static double[][] copyMatrix(double[][] matrix){
		
		assert matrix.length > 0 && matrix[0].length > 0;
		
		double[][] copyMatrix = new double [matrix.length][matrix[0].length];
		
		for (int row = 0; row < copyMatrix.length; row++) {
			for (int col = 0; col < copyMatrix[0].length; col++) {
				copyMatrix[row][col] = matrix[row][col];
			}
		}
		return copyMatrix;
	}
}
