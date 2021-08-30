import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ShowPicture {
	 
	 private static BufferedImage img;

     public static void init(String path) {
         try {
             img = ImageIO.read(ShowPicture.class.getResource(path));
             
         } catch (IOException e) {
        	 //e.printStackTrace();
         }
     }

     public static void paint(String path, Graphics g) {
       init(path);
       
       g.drawImage(img, 8, 250, null);
     }

	
	  
 }
 
//}

