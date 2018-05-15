package generics;

import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GenericMethods {

	public static void launcApp(String path)
	{
		File file = new File(path);
		//first check if Desktop is supported by Platform or not
        if(!Desktop.isDesktopSupported()){
            System.out.println("Desktop is not supported");
            return;
        }
        
        Desktop desktop = Desktop.getDesktop();
        if(file.exists())
        {
        	System.out.println("File present\nOpening File.....");
        	try {
				desktop.open(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
        else
        {
        	System.out.println("File not present");
        }
	}
	
	public static String takeScreenshot(String fname)
	{
	
		String fileName ="";
		 try {
	            Robot robot = new Robot();
	            String format = "png";
	            fileName= Auto_Const.DIR_PATH+"/test_images/"+fname+"."+format;
	             
	            Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
	            BufferedImage screenFullImage = robot.createScreenCapture(screenRect);
	            ImageIO.write(screenFullImage, format, new File(fileName));
	             
	            System.out.println("A full screenshot saved!");
	        } catch (Exception ex) {
	            System.err.println(ex);
	        }
		 return fileName;
	}
	
	public static String partialScreenshot(String fname, double width, double height)
	{
		String fileName="";
		try {
            Robot robot = new Robot();
            String format = "png";
            fileName = Auto_Const.DIR_PATH+"/test_images/"+fname+"."+format;
             
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            
            Rectangle captureRect = new Rectangle((int)(screenSize.width*width), (int)(screenSize.height*height), screenSize.width / 5, screenSize.height / 3);
            BufferedImage screenFullImage = robot.createScreenCapture(captureRect);
            ImageIO.write(screenFullImage, format, new File(fileName));
             
            System.out.println("A partial screenshot saved!");
        } catch (Exception ex) {
            System.err.println(ex);
        }
		return fileName;
	}
}
