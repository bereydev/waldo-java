package main;

/**
 * 
 * @author Name of the students
 *
 *         Where is Charlie Project
 *
 */
public final class Main {

	/*
	 * This class is incomplete!!
	 * 
	 * You are expected to write at least one testcase for each required method. You
	 * will find some examples of testcases below.
	 */

	public static void main(String[] args) {
		testGetRed();
		testGetGreen();
		testGetBlue();
		testGetGray();
		testGetRGB();
		testToGrayToRGBMatrix();
		testGrayscale();
		testFindNBest();
		testDistanceBasedSearch();
		testDistanceBasedSearchCanon();
		testNCCPatternEqualImage();
		testSimilarityPatternEqualImage();
		testSimilaritySimple();
		testSimilarityBasedSearch();
		findCharlie();
	}

	/*
	 * Tests for Class ImageProcessing
	 */
	public static void testGetRed() {
		int color = 0b11110000_00001111_01010101;
		int ref = 0b11110000;
		int red = ImageProcessing.getRed(color);
		if (red == ref) {
			System.out.println("Test passed");
		} else {
			System.out.println("Test failed. Returned value = " + red + " Expected value = " + ref);
		}
	}

	public static void testGetGreen() {
		int color = 0b11110000_00001111_01010101;
		int ref = 0b00001111;
		int green = ImageProcessing.getGreen(color);
		if (green == ref) {
			System.out.println("Test passed");
		} else {
			System.out.println("Test failed. Returned value = " + green + " Expected value = " + ref);
		}
	}

	public static void testGetBlue() {
		int color = 0b11110000_00001111_01010101;
		int ref = 0b01010101;
		int blue = ImageProcessing.getBlue(color);
		if (blue == ref) {
			System.out.println("Test passed");
		} else {
			System.out.println("Test failed. Returned value = " + blue + " Expected value = " + ref);
		}
	}

	public static void testGetGray() {
		int color = 0b11110000_00001111_01010101;
		double ref = 340 / 3.0;
		double gray = ImageProcessing.getGray(color);

		if (gray == ref) {
			System.out.println("Test passed");
		} else {
			System.out.println("Test failed. Returned value = " + gray + " Expected value = " + ref);
		}

	}

	public static void testGetRGB() {

		int blue = 0b01010101;
		int green = 0b00001111;
		int red = 0b11110000;
		int ref = 0b11110000_00001111_01010101;

		int rgb = ImageProcessing.getRGB(red, green, blue);

		if (rgb == ref) {
			System.out.println("Test passed");
		} else {
			System.out.println("Test failed. Returned value = " + rgb + " Expected value = " + ref);
		}

	}

	public static void testToGrayToRGBMatrix() {
		double[][] imageGray = ImageProcessing.toGray(Helper.read("images/charlie_beach.png"));
		int[][] imageRGB = ImageProcessing.matrixToRGBImage(imageGray, 0,255 );
		Helper.show(imageRGB, "Modified toGray --> toRGB image");
	}

	public static void testGrayscale() {
		System.out.println("Test Grayscale");
		int[][] image = Helper.read("images/food.png");
		double[][] gray = ImageProcessing.toGray(image);
		Helper.show(ImageProcessing.toRGB(gray), "test bw");
	}

	/*
	 * Tests for Class Collector
	 */

	public static void testFindNBest() {
		System.out.println("Test findNBest");
		double[][] t = new double[][] { { 20, 30, 10, 50, 32 }, { 28, 39, 51, 78, 91 } };
		int[][] coords = Collector.findNBest(10, t, true);
		for (int[] a : coords) {
			int r = a[0];
			int c = a[1];
			System.out.println("Row=" + r + " Col=" + c + " Val=" + t[r][c]);
		}
	}

	// TODO: complete with Bonus

	/*
	 * Tests for Class DistanceBasedSearch
	 */

	public static void testDistanceBasedSearch() {
		System.out.println("Test DistanceBasedSearch");
		int[][] food = Helper.read("images/food.png");
		int[][] onions = Helper.read("images/onions.png");
		double[][] distance = DistanceBasedSearch.distanceMatrix(onions, food);
		int[] p = Collector.findBest(distance, true);
		Helper.drawBox(p[0], p[1], onions[0].length, onions.length, food);
		Helper.show(food, "Found!");
	}
	
	public static void testDistanceBasedSearchCanon() {
		System.out.println("Test DistanceBasedSearchCanon");
		int[][] circuit = Helper.read("images/image.png");
		int[][] circuitLight = Helper.read("images/image-light.png");
		int[][] circuitDark = Helper.read("images/image-dark.png");
		int[][] canon = Helper.read("images/pattern.png");
		double[][] distance = DistanceBasedSearch.distanceMatrix(canon, circuit);
		double[][] distanceLight = DistanceBasedSearch.distanceMatrix(canon, circuitLight);
		double[][] distanceDark = DistanceBasedSearch.distanceMatrix(canon, circuitDark);
		
		int[] p = Collector.findBest(distance, true);
		Helper.drawBox(p[0], p[1], canon[0].length, canon.length, circuit);
		Helper.show(circuit, "Found the pattern!");
		
		int[] q = Collector.findBest(distanceLight, true);
		Helper.drawBox(q[0], q[1], canon[0].length, canon.length, circuitLight);
		Helper.show(circuitLight, "Not found ! Proof of the limit of the Distance Based Search!");
		
		int[] r = Collector.findBest(distanceDark, true);
		Helper.drawBox(r[0], r[1], canon[0].length, canon.length, circuitDark);
		Helper.show(circuitDark, "Not found ! Proof of the limit of the Distance Based Search!");
	}
	
	

	/*
	 * Tests for Class SimilarityBasedSearch
	 */
	public static void testNCCPatternEqualImage() { 
		System.out.println("Test NCCPatternEqualImage");
		  double[][] pattern = {{ 0,   0, 0 },
		                       { 0, 255, 0 },
		                       { 0,   0, 0 }};
		  double similarity = SimilarityBasedSearch.normalizedCrossCorrelation(0, 0, pattern, pattern);
		  if (similarity == 1.0) {
		    System.out.println("PASSED");      
		  } else {
		    System.out.println("ERROR: expected value 1.0 but was " + similarity);
		  }
		}
	
	public static void testSimilarityPatternEqualImage() { 
		System.out.println("Test SimilarityPatternEqualImageh");
		  double[][] pattern = {{ 0, 255}};
		  double[][] similarity = SimilarityBasedSearch.similarityMatrix(pattern, pattern);
		  if (similarity.length == 1) {
		    if (similarity[0][0] == 1.0) {
		      System.out.println("PASSED");
		    } else {
		      System.out.println("ERROR: expected value 1.0 but was " + similarity[0][0]);       
		    }
		  } else {
		    System.out.println("ERROR: expected length 1 but was " + similarity.length);       
		  }
		}
	
	public static void testSimilaritySimple() {
		System.out.println("Test SimilaritySimple");
		  double[][] image = {{ 3, 2, 2, 2 },
		                      { 0, 3, 0, 0 }};
		  double[][] pattern = {{ 0, 3, 0}};
		  double[][] similarity = SimilarityBasedSearch.similarityMatrix(pattern, image);
		 
		  if (similarity.length == 2 && similarity[0].length == 2) {
		    if (similarity[0][0] == -0.5 && similarity[0][1] == -1.0 &&
		        similarity[1][0] ==  1.0 && similarity[1][1] == -0.5) {
		      System.out.println("PASSED");
		    } else {
		      System.out.println("ERROR: wrong values");
		      for (int row = 0; row < similarity.length; row++) {
		    	  for (int col = 0; col < similarity[0].length; col++) {
					double display = similarity[row][col];
					System.out.println(display);
				}
				
			}
		    }
		  } else {
		    System.out.println("ERROR: incorrect size");       
		  }
		}

	public static void testSimilarityBasedSearch() {
		System.out.println("Test SimilarityBasedSearch");
		int[][] food = Helper.read("images/food.png");
		int[][] onions = Helper.read("images/onions.png");
		double[][] foodGray = ImageProcessing.toGray(food);
		double[][] onionsGray = ImageProcessing.toGray(onions);
		double[][] similarity = SimilarityBasedSearch.similarityMatrix(onionsGray, foodGray);
		int[][] best = Collector.findNBest(8, similarity, false);
		for (int[] a : best) {
			int r = a[0];
			int c = a[1];
			Helper.drawBox(r, c, onions[0].length, onions.length, food);
		}
		Helper.show(food, "Found again!");
	}

	public static void findCharlie() {
		System.out.println("Find Charlie");
		int[][] beach = Helper.read("images/charlie_beach.png");
		int[][] charlie = Helper.read("images/charlie.png");
		double[][] beachGray = ImageProcessing.toGray(beach);
		double[][] charlieGray = ImageProcessing.toGray(charlie);

		System.out.println("Compute Similarity Matrix: expected time about 2 min");
		double[][] similarity = SimilarityBasedSearch.similarityMatrix(charlieGray, beachGray);

		System.out.println("Find N Best");
		int[] best = Collector.findBest(similarity, false);
		double max = similarity[best[0]][best[1]];

		Helper.show(ImageProcessing.matrixToRGBImage(similarity, -1, max), "Similarity");

		Helper.drawBox(best[0], best[1], charlie[0].length, charlie.length, beach);
		System.out.println("drawBox at (" + best[0] + "," + best[1] + ")");
		Helper.show(beach, "Found again!");
	}

	
}
