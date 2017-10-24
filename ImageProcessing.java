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
 	int [] [] rgbImage = Helper.read("charlie.png");
 	
 	
 	int[][] image = new int[0][0];
    double[][] grayImage = new double[0][0];

    int rgb = 0;
    int red = 0;
    int green = 0;
    int blue = 0;
    double gray = 0;
    double factor = 0;
    
    int intResult;
    double doubleResult;
    boolean boolResult;

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

    int resultat1;
    int resultat2;
    int resultat3;
    
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
    	
    	int Result = ImageProcessing.getRed(rgb);
    int Result2 = ImageProcessing.getGreen(rgb);	
    int Result3 = ImageProcessing.getBlue(rgb);
    	
    double gray = (Result + Result2 + Result3) / 3 ;
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
    	
    int 	intResult = ImageProcessing.getRGB(red, green, blue);
    	

    	 return intResult;
    }

    /**
     * Returns packed RGB components from given gray-scale value.
     * @param gray : a double 
     * @return a 32-bits RGB color
     * @see #getGray
     */
    public static int getRGB(double gray) {
    	// TODO implement me !
    	return -2; 
    }

    /**
     * Converts packed RGB image to gray-scale image.
     * @param image : a HxW integer array
     * @return a HxW double array
     * @see #encode
     * @see #getGray
     */
    public static double[][] toGray(int[][] image) {

    	// TODO implement me !
    	return new double[][]{};
    }

    /**
     * Converts gray-scale image to packed RGB image.
     * @param channels : a HxW double array
     * @return a HxW integer array
     * @see #decode
     * @see #getRGB(double)
     */
    public static int[][] toRGB(double[][] gray) {

    	// TODO implement me !
    	return new int[][]{};
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
