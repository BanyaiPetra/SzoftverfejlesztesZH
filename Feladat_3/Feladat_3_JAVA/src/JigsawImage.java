/* JigsawImage.java
 * @author: Madan Chaudhary
 * @blog: javaxp.com
 * */

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO; //This class will write the BMP image as JPG


public class JigsawImage {

	public static void main(String[] args) {
	try {
			
		//Provide number of rows and column
		int row = 10;
		int col = 10;

		for (int foldernumber  = 1;  foldernumber <= 1 ; foldernumber++) {

			BufferedImage originalImgage = ImageIO.read(new File("F:/SW_fejlesztes/SzoftverfejlesztesZH/sg500/"+foldernumber+"/01.jpg"));
			//total width and total height of an image
			int tWidth = originalImgage.getWidth();
			int tHeight = originalImgage.getHeight();

			System.out.println("Image Dimension: " + tWidth + "x" + tHeight);
			
			//width and height of each piece
			int eWidth = tWidth / col;
			int eHeight = tHeight / row;

			int x = 0;
			int y = 0;

			for (int i = 0; i < row; i++) {
				y = 0;
				for (int j = 0; j < col; j++) {
					try {
						System.out.println("creating piece: "+i+" "+j);
						
						BufferedImage SubImgage = originalImgage.getSubimage(y, x, eWidth, eHeight);
						File outputfile = new File("F:/SW_fejlesztes/SzoftverfejlesztesZH/sg500/"+foldernumber+"/01_"+i+j+".jpg");
						ImageIO.write(SubImgage, "jpg", outputfile);
						
						y += eWidth;
				
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				x += eHeight;
			}
		}
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	}
}
