package generics;

import java.awt.AWTException;
import java.awt.Desktop;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import org.sikuli.script.Screen;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

@Listeners(generics.MyListener.class)
public class BaseTest {
	
	public Screen s;
	public Robot rob;
	
	public static ExtentReports extent;
	public static ExtentTest logger;
	
	
	@BeforeClass
	public void startTest()
	{
		extent=new ExtentReports(Auto_Const.REPORTS_PATH+"test.html", true);
		File file = new File(Auto_Const.FILE_PATH+"test1.pptx");
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
        s=new Screen();
        try {
			rob=new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
	
	@BeforeMethod(alwaysRun=true)
	public void report(java.lang.reflect.Method method)
	{
		logger=extent.startTest(this.getClass().getSimpleName()+"_"+method.getName());
	}
	
	@AfterClass
	public void endTest()
	{
		extent.flush();
//		extent.close();
		Robot rob;
		try {
			rob = new Robot();
			rob.keyPress(KeyEvent.VK_ALT);
			rob.keyPress(KeyEvent.VK_F4);
			rob.keyRelease(KeyEvent.VK_ALT);
			rob.keyRelease(KeyEvent.VK_ALT);
		} catch (AWTException e) {
			e.printStackTrace();
		}
		
	}
	
	@AfterSuite
	public void reports()
	{
		File file = new File(Auto_Const.REPORTS_PATH+"test.html");
		Desktop desktop = Desktop.getDesktop();
		try {
			desktop.open(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
