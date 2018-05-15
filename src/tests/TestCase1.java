package tests;

import java.awt.event.KeyEvent;
import java.util.Iterator;

import javax.swing.plaf.synth.Region;

import org.sikuli.script.Finder;
import org.sikuli.script.Match;
import org.testng.Assert;
import org.testng.annotations.Test;

import generics.Auto_Const;
import generics.BaseTest;
import generics.GenericMethods;

public class TestCase1 extends BaseTest{
	
	@Test
	public void test1() 
	{
		try {
			s.wait("./images/image_rect.png");
			s.find("./images/image_rect.png");
			s.wait("./images/image_tri.png");
			s.find("./images/image_tri.png");
		}
		catch (Exception e) {
			Assert.fail();
		}
	}
	
	@Test
	public void test2() 
	{
		try {
			String path1=GenericMethods.partialScreenshot("rectangle", 0.35, 0.30);
			String path2=GenericMethods.partialScreenshot("triangle", 0.53, 0.30);
			rob.keyPress(KeyEvent.VK_PAGE_DOWN);
			rob.keyRelease(KeyEvent.VK_PAGE_DOWN);
			s.wait(path1);
			s.find(path1);
			s.wait(path2);
			s.find(path2);
		}
		catch (Exception e) {
			e.getStackTrace();
			Assert.fail();
		}
	}
	
	@Test
	public void test3() 
	{
		try {
			String path1=GenericMethods.partialScreenshot("rectangle", 0.35, 0.30);
			String path2=GenericMethods.partialScreenshot("triangle", 0.53, 0.30);
			GenericMethods.launcApp(Auto_Const.FILE_PATH+"test2.pptx");
			s.wait(path1);
			s.find(path1);
			s.wait(path2);
			s.find(path2);
		}
		catch (Exception e) {
			Assert.fail();
		}
	}
	
	@Test
	public void test4() 
	{
		int count=0;
		try {
//			GenericMethods.launcApp(Auto_Const.FILE_PATH+"test3.pptx");
//			Thread.sleep(3000);
//			String path1=GenericMethods.partialScreenshot("circle1", 0.50, 0.40);
			GenericMethods.launcApp(Auto_Const.FILE_PATH+"test4.pptx");
//			Thread.sleep(3000);
			s.wait("./images/image_star.png");
			System.out.println("Image found");
			s.find("./images/image_star.png");
			System.out.println("Verified");
			Iterator<Match> it = s.findAll("./images/image_star.png");
			while(it.hasNext()){
				System.out.println("Entered while");
				count++;
			}
			System.out.println(count);
		}
		catch (Exception e) {
			e.getStackTrace();
			Assert.fail();
		}
	}

}
