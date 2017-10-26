package main;
public final class ImageProcessing {
	
    /**
     * Returns red component from given packed color.
     * @param rgb : a 32-bits RGB color
     * @return an integer,  between 0 and 255
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
    	}else if (resultat > 255){
    		return 255;
    	}
    	return resultat;
    }
    
    /**
     * Returns green component from given packed color.
     * @param rgb : a 32-bits RGB color
     * @return an integer between 0 and 255
     * @see #getRed
     * @see #getBlue
     * @see #getRGB(int, int, int)
     */
    public static int getGreen(int rgb) {
    	int decal = rgb>>8;
    		 
    	     	int resultat = decal & 0xff;
    	     	if (resultat<0) {
    	     		return 0;
    	 		}else if (resultat > 255) {
    	 			return 255;
    	 		}
    	     	return resultat; 
    	      }		      

    

    /**
     * Returns blue component from given packed color.
     * @param rgb : a 32-bits RGB color
     * @return an integer between 0 and 255
     * @see #getRed
     * @see #getGreen
     * @see #getRGB(int, int, int)
     */
    public static int getBlue(int rgb) {
    	int resultat = rgb & 0xff;
    	    	if (resultat <0) {
    	     		return 0;
    			}else if (resultat > 255) {
    	 			return 255;
    	 		}
    	     	return resultat; 
    	      }		      

   
    /**
     * Returns the average of red, green and blue components from given packed color.
     * @param rgb : 32-bits RGB color
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
    	
    double gray = (red + green + blue) / 3 ;
        return gray;
    }

    /**
     * Returns packed RGB components from given red, green and blue components.
     * @param red : an integer 
     * @param green : an integer 
     * @param blue : an integer
     * @return a 32-bits RGB color
     * @see #getRed
     * @see #getGreen
     * @see #getBlue
     */
    public static int getRGB(int red, int green, int blue) {
    	
    int rgb = (red <<16) | (green << 8) | (blue);

    	 return rgb;
    }

    /**
     * Returns packed RGB components from given gray-scale value.
     * @param gray : a double 
     * @return a 32-bits RGB color
     * @see #getGray
     */
    public static int getRGB(double gray) {
    	int red = (int)gray/3;
    	int green = (int)gray/3;
    	int blue =(int)gray/3;
    	int rgb = (red <<16) | (green << 8) | (blue);
    	return rgb; 
    }

    /**
     * Converts packed RGB image to gray-scale image.
     * @param image : a HxW integer array
     * @return a HxW double array
     * @see #encode
     * @see #getGray
     */
   public static double[][] toGray(int[][] image) {

    	double [][] gray = new double [image.length][image[0].length];
        for (int row = 0; row < image.length; row++) {
    		for (int col = 0; col < image[row].length; col++) {    
    				gray [row][col] = getGray(image[row][col]);
    			}
	
			}
    	return gray;
    }
    /**
     * Converts gray-scale image to packed RGB image.
     * @param channels : a HxW double array
     * @return a HxW integer array
     * @see #decode
     * @see #getRGB(double)
     */
    public static int[][] toRGB(double[][] gray) {
    	
    	int [][] imageRgb = new int [gray.length][gray[0].length];
    	for (int row = 0; row < gray.length; row++) {
			for (int col = 0; col < gray[row].length; col++) {
				
				imageRgb [row][col] = getRGB(gray [row][col]);
			}
		}
    	return imageRgb;
    }

    
    /**
     * Convert an arbitrary 2D double matrix into a 2D integer matrix 
     * which can be used as RGB image
     * @param matrix : the arbitrary 2D double array to convert into integer
     * @param min : a double, the minimum value the matrix could theoretically contains
     * @param max : a double, the maximum value the matrix could theoretically contains
     * @return an 2D integer array, containing a RGB mapping of the matrix 
     */
    public static int[][] matrixToRGBImage(double[][] matrix, double min, double max) {
    	// TODO implement me !
    	return new int[][]{};
    }
}
